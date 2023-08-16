package com.Hileb.custom_village_hileb.function;

import com.Hileb.custom_village_hileb.CustomVillageModMain;
import com.Hileb.custom_village_hileb.json.load.CustomVillageLoader;
import com.Hileb.custom_village_hileb.json.load.LoadedVillage;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.VillagerRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.registries.IForgeRegistry;

/**
 * @Project CustomVillage
 * @Author Hileb
 * @Date 2023/8/16 10:25
 **/
@Mod.EventBusSubscriber(modid = CustomVillageModMain.MODID)
public class CVFunction {
    @SubscribeEvent
    public static void onRegister(RegistryEvent.Register<VillagerRegistry.VillagerProfession> event){
        IForgeRegistry<VillagerRegistry.VillagerProfession> forgeRegistry=event.getRegistry();
        //if (FMLCommonHandler.instance().getSide()== Side.CLIENT){
            for(LoadedVillage village: CustomVillageLoader.loadClient()){
                village.run(forgeRegistry);
            }
//        }else for(LoadedVillage village: CustomVillageLoader.loadServer()){
//            village.run(forgeRegistry);
//        }
    }
}
