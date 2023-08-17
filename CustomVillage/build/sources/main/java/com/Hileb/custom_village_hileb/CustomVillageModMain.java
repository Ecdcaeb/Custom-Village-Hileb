package com.Hileb.custom_village_hileb;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.Hileb.custom_village_hileb.CustomVillageModMain.MODID;
import static com.Hileb.custom_village_hileb.CustomVillageModMain.NAME;

/**
 * @Project CoreModChest
 * @Author Hileb
 * @Date 2023/8/14 10:51
 **/
@Mod(modid = MODID,name =NAME,version = "1.0.2")
public class CustomVillageModMain {
    public static final String MODID="custom_village_hileb";
    public static final String NAME="Custom Village";
    public static final Logger LOGGER= LogManager.getLogger(MODID);
}
