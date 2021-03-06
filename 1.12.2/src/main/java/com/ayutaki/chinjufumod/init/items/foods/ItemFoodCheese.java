package com.ayutaki.chinjufumod.init.items.foods;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemFoodCheese extends ItemFood {

	public ItemFoodCheese(int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);

	}

	/* 食べ終わった時の処理 */
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {

		/** ポーションエフェクト の追加 **/
		if (!worldIn.isRemote) {
			/* 1秒＝20 */
			player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 600, 0));
		}
	}

}
