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
 * @Date 2023/8/16 11:30
 **/
public class ItemAndEmeraldToItem {
    public static class Loader extends TradeBase.Loader{
        public Loader(ResourceLocation resourceLocation) {
            super(resourceLocation);
        }
        @Override
        public EntityVillager.ITradeList loadTrade(JsonObject trade) {
            JsonObject from= JsonUtils.getJsonObject(trade,"from");
            int minPrice1=JsonUtils.getInt(from,"minPrice");
            int maxPrice1=JsonUtils.getInt(from,"maxPrice");
            Item item1= ForgeRegistries.ITEMS.getValue(new ResourceLocation(JsonUtils.getString(from,"item")));
            JsonObject to=JsonUtils.getJsonObject(trade,"to");
            int minPrice2=JsonUtils.getInt(to,"minPrice");
            int maxPrice2=JsonUtils.getInt(to,"maxPrice");
            Item item2= ForgeRegistries.ITEMS.getValue(new ResourceLocation(JsonUtils.getString(to,"item")));
            return new EntityVillager.ItemAndEmeraldToItem(item1,new EntityVillager.PriceInfo(minPrice1,maxPrice1),item2,new EntityVillager.PriceInfo(minPrice2,maxPrice2));
        }
    }
}
