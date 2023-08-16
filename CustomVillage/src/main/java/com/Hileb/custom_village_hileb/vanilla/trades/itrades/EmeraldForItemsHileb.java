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
 * @Date 2023/8/16 14:40
 **/
public class EmeraldForItemsHileb implements EntityVillager.ITradeList
{
    public ItemStack buyingItem;
    public EntityVillager.PriceInfo price;

    public EmeraldForItemsHileb(ItemStack itemIn, EntityVillager.PriceInfo priceIn)
    {
        this.buyingItem = itemIn;
        this.price = priceIn;
    }
    public void addMerchantRecipe(IMerchant merchant, MerchantRecipeList recipeList, Random random)
    {
        int i = 1;

        if (this.price != null)
        {
            i = this.price.getPrice(random);
        }
        ItemStack stack=buyingItem.copy();
        stack.setCount(i);

        recipeList.add(new MerchantRecipe(stack, Items.EMERALD));
    }
}
