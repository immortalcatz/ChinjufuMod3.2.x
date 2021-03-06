package com.ayutaki.chinjufumod.init;

import java.util.LinkedList;
import java.util.List;

import com.ayutaki.chinjufumod.init.garden.BlockChouzuAnd_1;
import com.ayutaki.chinjufumod.init.garden.BlockChouzuAnd_2;
import com.ayutaki.chinjufumod.init.garden.BlockChouzuAnd_3;
import com.ayutaki.chinjufumod.init.garden.BlockChouzuAnd_4;
import com.ayutaki.chinjufumod.init.garden.BlockChouzuAnd_kara;
import com.ayutaki.chinjufumod.init.garden.BlockChouzuDio_1;
import com.ayutaki.chinjufumod.init.garden.BlockChouzuDio_2;
import com.ayutaki.chinjufumod.init.garden.BlockChouzuDio_3;
import com.ayutaki.chinjufumod.init.garden.BlockChouzuDio_4;
import com.ayutaki.chinjufumod.init.garden.BlockChouzuDio_kara;
import com.ayutaki.chinjufumod.init.garden.BlockChouzuGra_1;
import com.ayutaki.chinjufumod.init.garden.BlockChouzuGra_2;
import com.ayutaki.chinjufumod.init.garden.BlockChouzuGra_3;
import com.ayutaki.chinjufumod.init.garden.BlockChouzuGra_4;
import com.ayutaki.chinjufumod.init.garden.BlockChouzuGra_kara;
import com.ayutaki.chinjufumod.init.garden.BlockChouzubachi_1;
import com.ayutaki.chinjufumod.init.garden.BlockChouzubachi_2;
import com.ayutaki.chinjufumod.init.garden.BlockChouzubachi_3;
import com.ayutaki.chinjufumod.init.garden.BlockChouzubachi_4;
import com.ayutaki.chinjufumod.init.garden.BlockChouzubachi_kara;
import com.ayutaki.chinjufumod.init.garden.BlockIshitourou;
import com.ayutaki.chinjufumod.init.garden.BlockIshitourou_and;
import com.ayutaki.chinjufumod.init.garden.BlockIshitourou_dio;
import com.ayutaki.chinjufumod.init.garden.BlockIshitourou_gra;
import com.ayutaki.chinjufumod.init.garden.BlockLongAcacia;
import com.ayutaki.chinjufumod.init.garden.BlockLongBirch;
import com.ayutaki.chinjufumod.init.garden.BlockLongDarkoak;
import com.ayutaki.chinjufumod.init.garden.BlockLongJungle;
import com.ayutaki.chinjufumod.init.garden.BlockLongOak;
import com.ayutaki.chinjufumod.init.garden.BlockLongSpruce;
import com.ayutaki.chinjufumod.init.garden.BlockLongtourou;
import com.ayutaki.chinjufumod.init.garden.BlockLongtourou_and;
import com.ayutaki.chinjufumod.init.garden.BlockLongtourou_dio;
import com.ayutaki.chinjufumod.init.garden.BlockLongtourou_gra;
import com.ayutaki.chinjufumod.init.garden.BlockLowTree;
import com.ayutaki.chinjufumod.init.garden.BlockSudare_1;
import com.ayutaki.chinjufumod.init.garden.BlockSudare_2;
import com.ayutaki.chinjufumod.init.garden.BlockSudare_3;
import com.ayutaki.chinjufumod.init.garden.Lit_Ishitourou;
import com.ayutaki.chinjufumod.init.garden.Lit_Ishitourou_and;
import com.ayutaki.chinjufumod.init.garden.Lit_Ishitourou_dio;
import com.ayutaki.chinjufumod.init.garden.Lit_Ishitourou_gra;
import com.ayutaki.chinjufumod.init.garden.Lit_Longtourou;
import com.ayutaki.chinjufumod.init.garden.Lit_Longtourou_and;
import com.ayutaki.chinjufumod.init.garden.Lit_Longtourou_dio;
import com.ayutaki.chinjufumod.init.garden.Lit_Longtourou_gra;
import com.ayutaki.chinjufumod.main.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ASDecoModGarden {

	public static Block SUDARE_1, SUDARE_2, SUDARE_3;

	public static Block ISHITOUROU_stone, ISHITOUROU_and, ISHITOUROU_dio, ISHITOUROU_gra;
	public static Block LIT_ISHITOUROU_stone, LIT_ISHITOUROU_and, LIT_ISHITOUROU_dio, LIT_ISHITOUROU_gra;
	public static Block LONGTOUROU_stone, LONGTOUROU_and, LONGTOUROU_dio, LONGTOUROU_gra;
	public static Block LIT_LONGTOUROU_stone, LIT_LONGTOUROU_and, LIT_LONGTOUROU_dio, LIT_LONGTOUROU_gra;

	public static Block CHOUZUBACHI_1, CHOUZUBACHI_2, CHOUZUBACHI_3, CHOUZUBACHI_4, CHOUZUBACHI_kara;
	public static Block CHOUZU_AND_1, CHOUZU_AND_2, CHOUZU_AND_3, CHOUZU_AND_4, CHOUZU_AND_kara;
	public static Block CHOUZU_DIO_1, CHOUZU_DIO_2, CHOUZU_DIO_3, CHOUZU_DIO_4, CHOUZU_DIO_kara;
	public static Block CHOUZU_GRA_1, CHOUZU_GRA_2, CHOUZU_GRA_3, CHOUZU_GRA_4, CHOUZU_GRA_kara;

	public static Block ACACIA_top, ACACIA_bot, BIRCH_top, BIRCH_bot, DARKOAK_top, DARKOAK_bot,
						JUNGLE_top, JUNGLE_bot, OAK_top, OAK_bot, SPRUCE_top, SPRUCE_bot;

	public static Block ACACIA_low, BIRCH_low, DARKOAK_low, JUNGLE_low, OAK_low, SPRUCE_low;


	public static void init() {

		SUDARE_1 = new BlockSudare_1().setRegistryName("block_sudare_1").setUnlocalizedName("block_sudare_1").setCreativeTab(ChinjufuModTabs.tab_cmodwadeco);
		SUDARE_2 = new BlockSudare_2().setRegistryName("block_sudare_2").setUnlocalizedName("block_sudare_2");
		SUDARE_3 = new BlockSudare_3().setRegistryName("block_sudare_3").setUnlocalizedName("block_sudare_3");

		ISHITOUROU_stone = new BlockIshitourou().setRegistryName("block_ishitourou_stone").setUnlocalizedName("block_ishitourou_stone").setCreativeTab(ChinjufuModTabs.tab_cmodwadeco);
		ISHITOUROU_and = new BlockIshitourou_and().setRegistryName("block_ishitourou_and").setUnlocalizedName("block_ishitourou_and").setCreativeTab(ChinjufuModTabs.tab_cmodwadeco);
		ISHITOUROU_dio = new BlockIshitourou_dio().setRegistryName("block_ishitourou_dio").setUnlocalizedName("block_ishitourou_dio").setCreativeTab(ChinjufuModTabs.tab_cmodwadeco);
		ISHITOUROU_gra = new BlockIshitourou_gra().setRegistryName("block_ishitourou_gra").setUnlocalizedName("block_ishitourou_gra").setCreativeTab(ChinjufuModTabs.tab_cmodwadeco);
		LIT_ISHITOUROU_stone = new Lit_Ishitourou().setRegistryName("lit_ishitourou_stone").setUnlocalizedName("lit_ishitourou_stone");
		LIT_ISHITOUROU_and = new Lit_Ishitourou_and().setRegistryName("lit_ishitourou_and").setUnlocalizedName("lit_ishitourou_and");
		LIT_ISHITOUROU_dio = new Lit_Ishitourou_dio().setRegistryName("lit_ishitourou_dio").setUnlocalizedName("lit_ishitourou_dio");
		LIT_ISHITOUROU_gra = new Lit_Ishitourou_gra().setRegistryName("lit_ishitourou_gra").setUnlocalizedName("lit_ishitourou_gra");
		LONGTOUROU_stone = new BlockLongtourou().setRegistryName("block_longtourou_stone").setUnlocalizedName("block_longtourou_stone").setCreativeTab(ChinjufuModTabs.tab_cmodwadeco);
		LONGTOUROU_and = new BlockLongtourou_and().setRegistryName("block_longtourou_and").setUnlocalizedName("block_longtourou_and").setCreativeTab(ChinjufuModTabs.tab_cmodwadeco);
		LONGTOUROU_dio = new BlockLongtourou_dio().setRegistryName("block_longtourou_dio").setUnlocalizedName("block_longtourou_dio").setCreativeTab(ChinjufuModTabs.tab_cmodwadeco);
		LONGTOUROU_gra = new BlockLongtourou_gra().setRegistryName("block_longtourou_gra").setUnlocalizedName("block_longtourou_gra").setCreativeTab(ChinjufuModTabs.tab_cmodwadeco);
		LIT_LONGTOUROU_stone = new Lit_Longtourou().setRegistryName("lit_longtourou_stone").setUnlocalizedName("lit_longtourou_stone");
		LIT_LONGTOUROU_and = new Lit_Longtourou_and().setRegistryName("lit_longtourou_and").setUnlocalizedName("lit_longtourou_and");
		LIT_LONGTOUROU_dio = new Lit_Longtourou_dio().setRegistryName("lit_longtourou_dio").setUnlocalizedName("lit_longtourou_dio");
		LIT_LONGTOUROU_gra = new Lit_Longtourou_gra().setRegistryName("lit_longtourou_gra").setUnlocalizedName("lit_longtourou_gra");

		CHOUZUBACHI_1 =new BlockChouzubachi_1().setRegistryName("block_chouzubachi_1").setUnlocalizedName("block_chouzubachi_1");
		CHOUZUBACHI_2 =new BlockChouzubachi_2().setRegistryName("block_chouzubachi_2").setUnlocalizedName("block_chouzubachi_2");
		CHOUZUBACHI_3 =new BlockChouzubachi_3().setRegistryName("block_chouzubachi_3").setUnlocalizedName("block_chouzubachi_3");
		CHOUZUBACHI_4 =new BlockChouzubachi_4().setRegistryName("block_chouzubachi_4").setUnlocalizedName("block_chouzubachi_4");
		CHOUZUBACHI_kara =new BlockChouzubachi_kara().setRegistryName("block_chouzubachi_kara").setUnlocalizedName("block_chouzubachi_kara").setCreativeTab(ChinjufuModTabs.tab_cmodwadeco);
		CHOUZU_AND_1 =new BlockChouzuAnd_1().setRegistryName("block_chouzu_and_1").setUnlocalizedName("block_chouzu_and_1");
		CHOUZU_AND_2 =new BlockChouzuAnd_2().setRegistryName("block_chouzu_and_2").setUnlocalizedName("block_chouzu_and_2");
		CHOUZU_AND_3 =new BlockChouzuAnd_3().setRegistryName("block_chouzu_and_3").setUnlocalizedName("block_chouzu_and_3");
		CHOUZU_AND_4 =new BlockChouzuAnd_4().setRegistryName("block_chouzu_and_4").setUnlocalizedName("block_chouzu_and_4");
		CHOUZU_AND_kara =new BlockChouzuAnd_kara().setRegistryName("block_chouzu_and_kara").setUnlocalizedName("block_chouzu_and_kara").setCreativeTab(ChinjufuModTabs.tab_cmodwadeco);
		CHOUZU_DIO_1 =new BlockChouzuDio_1().setRegistryName("block_chouzu_dio_1").setUnlocalizedName("block_chouzu_dio_1");
		CHOUZU_DIO_2 =new BlockChouzuDio_2().setRegistryName("block_chouzu_dio_2").setUnlocalizedName("block_chouzu_dio_2");
		CHOUZU_DIO_3 =new BlockChouzuDio_3().setRegistryName("block_chouzu_dio_3").setUnlocalizedName("block_chouzu_dio_3");
		CHOUZU_DIO_4 =new BlockChouzuDio_4().setRegistryName("block_chouzu_dio_4").setUnlocalizedName("block_chouzu_dio_4");
		CHOUZU_DIO_kara =new BlockChouzuDio_kara().setRegistryName("block_chouzu_dio_kara").setUnlocalizedName("block_chouzu_dio_kara").setCreativeTab(ChinjufuModTabs.tab_cmodwadeco);
		CHOUZU_GRA_1 =new BlockChouzuGra_1().setRegistryName("block_chouzu_gra_1").setUnlocalizedName("block_chouzu_gra_1");
		CHOUZU_GRA_2 =new BlockChouzuGra_2().setRegistryName("block_chouzu_gra_2").setUnlocalizedName("block_chouzu_gra_2");
		CHOUZU_GRA_3 =new BlockChouzuGra_3().setRegistryName("block_chouzu_gra_3").setUnlocalizedName("block_chouzu_gra_3");
		CHOUZU_GRA_4 =new BlockChouzuGra_4().setRegistryName("block_chouzu_gra_4").setUnlocalizedName("block_chouzu_gra_4");
		CHOUZU_GRA_kara =new BlockChouzuGra_kara().setRegistryName("block_chouzu_gra_kara").setUnlocalizedName("block_chouzu_gra_kara").setCreativeTab(ChinjufuModTabs.tab_cmodwadeco);

		ACACIA_top = new BlockLongAcacia(Material.WOOD, true).setRegistryName("block_longacacia_top").setUnlocalizedName("block_longacacia_top");
		ACACIA_bot = new BlockLongAcacia(Material.WOOD, false).setRegistryName("block_longacacia_bot").setUnlocalizedName("block_longacacia_bot").setCreativeTab(ChinjufuModTabs.tab_cmodwadeco);
		BIRCH_top = new BlockLongBirch(Material.WOOD, true).setRegistryName("block_longbirch_top").setUnlocalizedName("block_longbirch_top");
		BIRCH_bot = new BlockLongBirch(Material.WOOD, false).setRegistryName("block_longbirch_bot").setUnlocalizedName("block_longbirch_bot").setCreativeTab(ChinjufuModTabs.tab_cmodwadeco);
		DARKOAK_top = new BlockLongDarkoak(Material.WOOD, true).setRegistryName("block_longdarkoak_top").setUnlocalizedName("block_longdarkoak_top");
		DARKOAK_bot = new BlockLongDarkoak(Material.WOOD, false).setRegistryName("block_longdarkoak_bot").setUnlocalizedName("block_longdarkoak_bot").setCreativeTab(ChinjufuModTabs.tab_cmodwadeco);
		JUNGLE_top = new BlockLongJungle(Material.WOOD, true).setRegistryName("block_longjungle_top").setUnlocalizedName("block_longjungle_top");
		JUNGLE_bot = new BlockLongJungle(Material.WOOD, false).setRegistryName("block_longjungle_bot").setUnlocalizedName("block_longjungle_bot").setCreativeTab(ChinjufuModTabs.tab_cmodwadeco);
		OAK_top = new BlockLongOak(Material.WOOD, true).setRegistryName("block_longoak_top").setUnlocalizedName("block_longoak_top");
		OAK_bot = new BlockLongOak(Material.WOOD, false).setRegistryName("block_longoak_bot").setUnlocalizedName("block_longoak_bot").setCreativeTab(ChinjufuModTabs.tab_cmodwadeco);
		SPRUCE_top = new BlockLongSpruce(Material.WOOD, true).setRegistryName("block_longspruce_top").setUnlocalizedName("block_longspruce_top");
		SPRUCE_bot = new BlockLongSpruce(Material.WOOD, false).setRegistryName("block_longspruce_bot").setUnlocalizedName("block_longspruce_bot").setCreativeTab(ChinjufuModTabs.tab_cmodwadeco);

		ACACIA_low = new BlockLowTree().setRegistryName("block_low_acacia").setUnlocalizedName("block_low_acacia").setCreativeTab(ChinjufuModTabs.tab_cmodwadeco);
		BIRCH_low = new BlockLowTree().setRegistryName("block_low_birch").setUnlocalizedName("block_low_birch").setCreativeTab(ChinjufuModTabs.tab_cmodwadeco);
		DARKOAK_low = new BlockLowTree().setRegistryName("block_low_darkoak").setUnlocalizedName("block_low_darkoak").setCreativeTab(ChinjufuModTabs.tab_cmodwadeco);
		JUNGLE_low = new BlockLowTree().setRegistryName("block_low_jungle").setUnlocalizedName("block_low_jungle").setCreativeTab(ChinjufuModTabs.tab_cmodwadeco);
		OAK_low = new BlockLowTree().setRegistryName("block_low_oak").setUnlocalizedName("block_low_oak").setCreativeTab(ChinjufuModTabs.tab_cmodwadeco);
		SPRUCE_low = new BlockLowTree().setRegistryName("block_low_spruce").setUnlocalizedName("block_low_spruce").setCreativeTab(ChinjufuModTabs.tab_cmodwadeco);


	}


	public static void register() {

		registerBlock(SUDARE_1);
		registerBlock(SUDARE_2);
		registerBlock(SUDARE_3);

		registerBlock(ISHITOUROU_stone);
		registerBlock(ISHITOUROU_and);
		registerBlock(ISHITOUROU_dio);
		registerBlock(ISHITOUROU_gra);
		registerBlock(LIT_ISHITOUROU_stone);
		registerBlock(LIT_ISHITOUROU_and);
		registerBlock(LIT_ISHITOUROU_dio);
		registerBlock(LIT_ISHITOUROU_gra);
		registerBlock(LONGTOUROU_stone);
		registerBlock(LONGTOUROU_and);
		registerBlock(LONGTOUROU_dio);
		registerBlock(LONGTOUROU_gra);
		registerBlock(LIT_LONGTOUROU_stone);
		registerBlock(LIT_LONGTOUROU_and);
		registerBlock(LIT_LONGTOUROU_dio);
		registerBlock(LIT_LONGTOUROU_gra);

		registerBlock(CHOUZUBACHI_1);
		registerBlock(CHOUZUBACHI_2);
		registerBlock(CHOUZUBACHI_3);
		registerBlock(CHOUZUBACHI_4);
		registerBlock(CHOUZUBACHI_kara);
		registerBlock(CHOUZU_AND_1);
		registerBlock(CHOUZU_AND_2);
		registerBlock(CHOUZU_AND_3);
		registerBlock(CHOUZU_AND_4);
		registerBlock(CHOUZU_AND_kara);
		registerBlock(CHOUZU_DIO_1);
		registerBlock(CHOUZU_DIO_2);
		registerBlock(CHOUZU_DIO_3);
		registerBlock(CHOUZU_DIO_4);
		registerBlock(CHOUZU_DIO_kara);
		registerBlock(CHOUZU_GRA_1);
		registerBlock(CHOUZU_GRA_2);
		registerBlock(CHOUZU_GRA_3);
		registerBlock(CHOUZU_GRA_4);
		registerBlock(CHOUZU_GRA_kara);

		registerBlock(ACACIA_top);
		registerBlock(ACACIA_bot);
		registerBlock(BIRCH_top);
		registerBlock(BIRCH_bot);
		registerBlock(DARKOAK_top);
		registerBlock(DARKOAK_bot);
		registerBlock(JUNGLE_top);
		registerBlock(JUNGLE_bot);
		registerBlock(OAK_top);
		registerBlock(OAK_bot);
		registerBlock(SPRUCE_top);
		registerBlock(SPRUCE_bot);

		registerBlock(ACACIA_low);
		registerBlock(BIRCH_low);
		registerBlock(DARKOAK_low);
		registerBlock(JUNGLE_low);
		registerBlock(OAK_low);
		registerBlock(SPRUCE_low);

	}

	public static void registerBlock(Block block) {
		registerBlock(block, new ItemBlock(block));
	}

	public static void registerBlock(Block block, ItemBlock item) {
		RegistrationHandler.BLOCKS.add(block);
		item.setRegistryName(block.getRegistryName());
		ChinjufuModItems.RegistrationHandler.ITEMS.add(item);
	}


	public static void registerRenders() {

		registerRender(SUDARE_1);

		registerRender(ISHITOUROU_stone);
		registerRender(ISHITOUROU_and);
		registerRender(ISHITOUROU_dio);
		registerRender(ISHITOUROU_gra);
		registerRender(LONGTOUROU_stone);
		registerRender(LONGTOUROU_and);
		registerRender(LONGTOUROU_dio);
		registerRender(LONGTOUROU_gra);

		registerRender(CHOUZUBACHI_kara);
		registerRender(CHOUZU_AND_kara);
		registerRender(CHOUZU_DIO_kara);
		registerRender(CHOUZU_GRA_kara);

		registerRender(ACACIA_bot);
		registerRender(BIRCH_bot);
		registerRender(DARKOAK_bot);
		registerRender(JUNGLE_bot);
		registerRender(OAK_bot);
		registerRender(SPRUCE_bot);

		registerRender(ACACIA_low);
		registerRender(BIRCH_low);
		registerRender(DARKOAK_low);
		registerRender(JUNGLE_low);
		registerRender(OAK_low);
		registerRender(SPRUCE_low);

	}

	@SideOnly(Side.CLIENT)
	private static void registerRender(Block block) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation(block.getRegistryName(),"inventory"));
	}

	@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
	public static class RegistrationHandler {

		public static final List<Block> BLOCKS = new LinkedList<>();

		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Block> event) {

			ASDecoModGarden.init();
			ASDecoModGarden.register();
			BLOCKS.stream().forEach(block -> event.getRegistry().register(block));
		}
	}
}
