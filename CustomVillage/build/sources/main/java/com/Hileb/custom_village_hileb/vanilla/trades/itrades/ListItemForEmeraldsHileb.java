package com.Hileb.custom_village_hileb.vanilla.trades.itrades;

import net.minecraft.entity.IMerchant;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;

import java.util.Random;

/**
 * @Project CustomVillage
 * @Author Hileb
 * @Date 2023/8/16 14:15
 **/
public class ListItemForEmeraldsHileb implements EntityVillager.ITradeList {
    /**
     * The item that is being bought for emeralds
     */
    public ItemStack itemToBuy;
    /**
     * The price info for the amount of emeralds to sell for, or if negative, the amount of the item to buy for
     * an emerald.
     */
    public EntityVillager.PriceInfo priceInfo;
    public ListItemForEmeraldsHileb(ItemStack stack, EntityVillager.PriceInfo priceInfo) {
        this.itemToBuy = stack;
        this.priceInfo = priceInfo;
    }

    public void addMerchantRecipe(IMerchant merchant, MerchantRecipeList recipeList, Random random) {
        int i = 1;

        if (this.priceInfo != null) {
            i = this.priceInfo.getPrice(random);
        }

        ItemStack stackEmerald;
        ItemStack stack;

        if (i < 0) {
            stackEmerald = new ItemStack(Items.EMERALD);
            stack = ItemStack.EMPTY;
        } else {
            stackEmerald = new ItemStack(Items.EMERALD, i, 0);
            stack = itemToBuy.copy();
        }
        recipeList.add(new MerchantRecipe(stackEmerald, stack));
    }
}
