package com.ayutaki.chinjufumod.init.woods;

import java.util.Random;

import com.ayutaki.chinjufumod.init.ASDecoModWoods;
import com.ayutaki.chinjufumod.init.woods.treegen.WorldGenTreeIchoh;
import com.ayutaki.chinjufumod.init.woods.treegen.WorldGenTreeIchohBig;

import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;

public class BlockIchoh_nae extends BlockBush implements IGrowable {

	/* 成長の段階を持たせる */
	public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);

	public BlockIchoh_nae() {

		this.setSoundType(SoundType.WOOD);
		this.setHardness(0.5F);
		this.setResistance(1.0F);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0.1D, 0.0D, 0.1D, 0.9D, 0.8D, 0.9D);
	}

	/* 成長させるかどうか */
	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		return true;
	}

	/* 成長の中身 */
	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {

		if (state.getValue(STAGE).intValue() == 0) {
			worldIn.setBlockState(pos, state.cycleProperty(STAGE), 4);
		}

		else {
			generateTree(worldIn, pos, state, rand);
		}
	}

	/* 明かりと時間経過で成長する */
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {

		if (!worldIn.isRemote) {
			super.updateTick(worldIn, pos, state, rand);

			if (worldIn.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0) {
				grow(worldIn, rand, pos, state);
			}
		}
	}

	/* 苗木から WorldGenTree を使って木を生成する */
	public void generateTree(World worldIn, BlockPos pos, IBlockState state, Random rand) {

		if (!TerrainGen.saplingGrowTree(worldIn, rand, pos)) return;

		/* 木の大きさを変えない場合
		 * WorldGenerator worldgenerator = new WorldGenTreeSakura(true);*/

		/* 確率で大木になる Intの数字が母数、：の左が分子 */
		WorldGenerator worldgenerator =
				(WorldGenerator)(rand.nextInt(20) == 0 ? new WorldGenTreeIchohBig(true) : new WorldGenTreeIchoh(true));

		worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 4);

		worldgenerator.generate(worldIn, rand, pos);
	}

	/* 骨粉に対する反応 */
	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return worldIn.rand.nextFloat() < 0.45D;
	}

	/* デフォルトのメタデータ値を呼び出し */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(STAGE, Integer.valueOf((meta & 8) >> 3));
	}

	/* メタデータ値を拾う */
	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | state.getValue(STAGE).intValue() << 3;
		return i;
	}

	/* メタデータ値として STAGE を設ける */
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {STAGE});
	}

	/* 直下ブロックによる設置判定 */
	@Override
	protected boolean canSustainBush(IBlockState state) {
		return state.getBlock() == Blocks.GRASS || state.getBlock() == Blocks.DIRT || state
				.getBlock() == Blocks.FARMLAND || state.getBlock() == ASDecoModWoods.FALL_LEAF;
	}

	/* 描画関連 */
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
}
