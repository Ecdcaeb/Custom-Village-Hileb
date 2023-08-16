package com.Hileb.custom_village_hileb.vanilla.trades;

import com.Hileb.custom_village_hileb.vanilla.trades.itrades.EmeraldForItemsHileb;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

/**
 * @Project CustomVillage
 * @Author Hileb
 * @Date 2023/8/16 11:03
 **/
public class EmeraldForItems {
    public static class Loader extends TradeBase.Loader{
        public Loader(ResourceLocation resourceLocation) {
            super(resourceLocation);
        }
        @Override
        public EntityVillager.ITradeList loadTrade(JsonObject trade) {
            JsonObject from= JsonUtils.getJsonObject(trade,"from");
            JsonObject to=JsonUtils.getJsonObject(trade,"to");
            return new EmeraldForItemsHileb(TradeBase.getFullItemStack(JsonUtils.getJsonObject(to,"item")),
                    TradeBase.loadPrice(JsonUtils.getJsonObject(from,"price")
                    ));
        }
    }

}
