package com.Hileb.custom_village_hileb.vanilla.trades;

import com.google.gson.JsonObject;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

/**
 * @Project CustomVillage
 * @Author Hileb
 * @Date 2023/8/16 11:26
 **/
public class ListItemForEmeralds {
    public static class Loader extends TradeBase.Loader{
        public Loader(ResourceLocation resourceLocation) {
            super(resourceLocation);
        }
        @Override
        public EntityVillager.ITradeList loadTrade(JsonObject trade) {
            JsonObject from= JsonUtils.getJsonObject(trade,"from");
            int minPrice=JsonUtils.getInt(from,"minPrice");
            int maxPrice=JsonUtils.getInt(from,"maxPrice");
            JsonObject to=JsonUtils.getJsonObject(trade,"to");
            JsonObject item=JsonUtils.getJsonObject(to,"item");
            ItemStack stack=TradeBase.getItemStack(item);
            if (to.has("enchantment")){
                for(EnchantmentData data:TradeBase.loadEnch(to)){
                    stack.addEnchantment(data.enchantment,data.enchantmentLevel);
                }
            }
            return new EntityVillager.ListItemForEmeralds(stack.copy(),new EntityVillager.PriceInfo(minPrice,maxPrice));
        }
    }
}
