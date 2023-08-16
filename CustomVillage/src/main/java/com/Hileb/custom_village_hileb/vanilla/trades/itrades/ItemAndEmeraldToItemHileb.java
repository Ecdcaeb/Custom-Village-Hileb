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
 * @Date 2023/8/16 14:20
 **/
public class ItemAndEmeraldToItemHileb implements EntityVillager.ITradeList{
    /**
     * The itemstack to buy with an emerald. The Item and damage value is used only, any tag data is not
     * retained.
     */
    public ItemStack buyingItemStack;
    /** The price info defining the amount of the buying item required with 1 emerald to match the selling item. */
    public EntityVillager.PriceInfo buyingPriceInfo;
    public EntityVillager.PriceInfo buyingPriceInfo2;
    /** The itemstack to sell. The item and damage value are used only, any tag data is not retained. */
    public ItemStack sellingItemstack;
    public EntityVillager.PriceInfo sellingPriceInfo;


    public ItemAndEmeraldToItemHileb(){}
    public void addMerchantRecipe(IMerchant merchant, MerchantRecipeList recipeList, Random random)
    {
        int i = this.buyingPriceInfo.getPrice(random);
        int j = this.sellingPriceInfo.getPrice(random);
        int k = this.buyingPriceInfo.getPrice(random);
        ItemStack stack1=this.buyingItemStack.copy();
        stack1.setCount(i);
        ItemStack stack2=this.sellingItemstack.copy();
        ItemStack stack=new ItemStack(Items.EMERALD);
        stack.setCount(k);
        recipeList.add(new MerchantRecipe(stack1, stack, stack2));
    }

}
