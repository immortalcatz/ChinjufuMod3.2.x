package com.ayutaki.chinjufumod.init.furnace;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.init.ASDecoModKitchen;
import com.ayutaki.chinjufumod.init.ChinjufuModSchool;
import com.ayutaki.chinjufumod.tileentity.TileEntityKitOven;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockKitchen_Oven extends BlockContainer {

	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	private final boolean isBurning;
	private static boolean keepInventory;

	public BlockKitchen_Oven(boolean isBurning, String name) {
		super(Material.WOOD);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);

		this.setSoundType(SoundType.METAL);
		this.setHardness(1.0F);
		this.setResistance(10.0F);

		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		this.isBurning = isBurning;

		if (isBurning) {
			this.setLightLevel(15.0F * 14);
		}
	}

	/* 燃焼中に上を歩くとダメージを受ける */
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {

		if (isBurning) {

			if (!entityIn.isImmuneToFire() && entityIn instanceof EntityLivingBase && !EnchantmentHelper
					.hasFrostWalkerEnchantment((EntityLivingBase)entityIn)) {

				entityIn.attackEntityFrom(DamageSource.HOT_FLOOR, 1.0F);
			}
		super.onEntityWalk(worldIn, pos, entityIn);
		}
	}

	/**
	 * Get the Item that this Block should drop when harvested.
	 */
	@Nullable
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(ASDecoModKitchen.KIT_OVEN);
	}

	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		this.setDefaultFacing(worldIn, pos, state);
	}

	private void setDefaultFacing(World worldIn, BlockPos pos, IBlockState state) {
		if (!worldIn.isRemote) {
			IBlockState iblockstate = worldIn.getBlockState(pos.north());
			IBlockState iblockstate1 = worldIn.getBlockState(pos.south());
			IBlockState iblockstate2 = worldIn.getBlockState(pos.west());
			IBlockState iblockstate3 = worldIn.getBlockState(pos.east());
			EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);

			if (enumfacing == EnumFacing.NORTH && iblockstate.isFullBlock() && !iblockstate1.isFullBlock()) {
				enumfacing = EnumFacing.SOUTH;
			}
			else if (enumfacing == EnumFacing.SOUTH && iblockstate1.isFullBlock() && !iblockstate.isFullBlock()) {
				enumfacing = EnumFacing.NORTH;
			}
			else if (enumfacing == EnumFacing.WEST && iblockstate2.isFullBlock() && !iblockstate3.isFullBlock()) {
				enumfacing = EnumFacing.EAST;
			}
			else if (enumfacing == EnumFacing.EAST && iblockstate3.isFullBlock() && !iblockstate2.isFullBlock()) {
				enumfacing = EnumFacing.WEST;
			}

			worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
		}
	}

	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {

		if (this.isBurning) {

			if (rand.nextDouble() < 0.1D) {
				worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D,
						SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
			}
		}
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
		int i = pos.getX();
		int j = pos.getY();
		int k = pos.getZ();

		switch (enumfacing) {

		case EAST:
			if (worldIn.getBlockState(new BlockPos(i + 1 , j, k)).getBlock() == Blocks.AIR) {

				if (worldIn.getBlockState(new BlockPos(i - 1 , j, k)).getBlock() == Blocks.AIR || worldIn
						.getBlockState(new BlockPos(i - 1, j, k)).getBlock() == ChinjufuModSchool.STOVECHIMNEY_joint) {

					TileEntity tileentity = worldIn.getTileEntity(pos);

					if (tileentity instanceof TileEntityKitOven) {
						playerIn.displayGUIChest((TileEntityKitOven)tileentity);
						playerIn.addStat(StatList.FURNACE_INTERACTION);
					}
				}
			}
			else {
				return true;
			}

		case NORTH:
		default:
			if (worldIn.getBlockState(new BlockPos(i , j, k - 1)).getBlock() == Blocks.AIR) {

				if (worldIn.getBlockState(new BlockPos(i , j, k + 1)).getBlock() == Blocks.AIR || worldIn
						.getBlockState(new BlockPos(i, j, k + 1 )).getBlock() == ChinjufuModSchool.STOVECHIMNEY_joint) {

					TileEntity tileentity = worldIn.getTileEntity(pos);

					if (tileentity instanceof TileEntityKitOven) {
						playerIn.displayGUIChest((TileEntityKitOven)tileentity);
						playerIn.addStat(StatList.FURNACE_INTERACTION);
					}
				}
			}
			else {
				return true;
			}

		case SOUTH:
			if (worldIn.getBlockState(new BlockPos(i , j, k + 1)).getBlock() == Blocks.AIR) {

				if (worldIn.getBlockState(new BlockPos(i , j, k - 1)).getBlock() == Blocks.AIR || worldIn
						.getBlockState(new BlockPos(i, j, k - 1 )).getBlock() == ChinjufuModSchool.STOVECHIMNEY_joint) {

					TileEntity tileentity = worldIn.getTileEntity(pos);

					if (tileentity instanceof TileEntityKitOven) {
						playerIn.displayGUIChest((TileEntityKitOven)tileentity);
						playerIn.addStat(StatList.FURNACE_INTERACTION);
					}
				}
			}
			else {
				return true;
			}

		case WEST:
			if (worldIn.getBlockState(new BlockPos(i - 1 , j, k)).getBlock() == Blocks.AIR) {

				if (worldIn.getBlockState(new BlockPos(i + 1 , j, k)).getBlock() == Blocks.AIR || worldIn
						.getBlockState(new BlockPos(i + 1, j, k)).getBlock() == ChinjufuModSchool.STOVECHIMNEY_joint) {

					TileEntity tileentity = worldIn.getTileEntity(pos);

					if (tileentity instanceof TileEntityKitOven) {
						playerIn.displayGUIChest((TileEntityKitOven)tileentity);
						playerIn.addStat(StatList.FURNACE_INTERACTION);
					}
				}
			}
			else {
				return true;
			}

			return true;
		}
	}

	public static void setState(boolean active, World worldIn, BlockPos pos) {
		IBlockState iblockstate = worldIn.getBlockState(pos);
		TileEntity tileentity = worldIn.getTileEntity(pos);
		keepInventory = true;

		if (active) {
			worldIn.setBlockState(pos, ASDecoModKitchen.LIT_KITOVEN.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
			worldIn.setBlockState(pos, ASDecoModKitchen.LIT_KITOVEN.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
		}
		else {
			worldIn.setBlockState(pos, ASDecoModKitchen.KIT_OVEN.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
			worldIn.setBlockState(pos, ASDecoModKitchen.KIT_OVEN.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
		}

		keepInventory = false;

		if (tileentity != null) {
			tileentity.validate();
			worldIn.setTileEntity(pos, tileentity);
		}
	}

	/**
	 * Returns a new instance of a block's tile entity class. Called on placing the block.
	 */
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityKitOven();
	}

	/**
	 * Called by ItemBlocks just before a block is actually set in the world, to allow for adjustments to the
	 * IBlockstate
	 */
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}

	/**
	 * Called by ItemBlocks after a block is set in the world, to allow post-place logic
	 */
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);

		if (stack.hasDisplayName()) {
			TileEntity tileentity = worldIn.getTileEntity(pos);

			if (tileentity instanceof TileEntityKitOven) {
				((TileEntityKitOven)tileentity).setCustomInventoryName(stack.getDisplayName());
			}
		}
	}

	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {

		if (!keepInventory) {
			TileEntity tileentity = worldIn.getTileEntity(pos);

			if (tileentity instanceof TileEntityKitOven) {
				InventoryHelper.dropInventoryItems(worldIn, pos, (TileEntityKitOven)tileentity);
				worldIn.updateComparatorOutputLevel(pos, this);
			}
		}

		super.breakBlock(worldIn, pos, state);
	}

	public boolean hasComparatorInputOverride(IBlockState state) {
		return true;
	}

	public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos) {
		return Container.calcRedstone(worldIn.getTileEntity(pos));
	}

	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(ASDecoModKitchen.KIT_OVEN);
	}

	/**
	 * The type of render function called. 3 for standard block models, 2 for TESR's, 1 for liquids, -1 is no render
	 */
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

	/**
	 * Convert the given metadata into a BlockState for this Block
	 */
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing enumfacing = EnumFacing.getFront(meta);

		if (enumfacing.getAxis() == EnumFacing.Axis.Y) {
			enumfacing = EnumFacing.NORTH;
		}

		return this.getDefaultState().withProperty(FACING, enumfacing);
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	public int getMetaFromState(IBlockState state) {
		return ((EnumFacing)state.getValue(FACING)).getIndex();
	}

	/**
	 * Returns the blockstate with the given rotation from the passed blockstate. If inapplicable, returns the passed
	 * blockstate.
	 */
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
	}

	/**
	 * Returns the blockstate with the given mirror of the passed blockstate. If inapplicable, returns the passed
	 * blockstate.
	 */
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
	}

	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { FACING });
	}

	/* 描画の処理 */
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World playerIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.tile.block_kit_oven.name", meta));
	}

}
