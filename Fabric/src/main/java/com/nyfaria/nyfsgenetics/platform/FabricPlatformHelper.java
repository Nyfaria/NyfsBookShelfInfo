package com.nyfaria.nyfsgenetics.platform;

import com.nyfaria.nyfsgenetics.api.VillagerGenes;
import com.nyfaria.nyfsgenetics.cap.VillagerGeneticsHolderAttacher;
import com.nyfaria.nyfsgenetics.platform.services.IPlatformHelper;
import com.nyfaria.nyfsgenetics.traits.EyeBrow;
import com.nyfaria.nyfsgenetics.traits.EyeColor;
import com.nyfaria.nyfsgenetics.traits.HairColor;
import com.nyfaria.nyfsgenetics.traits.HairType;
import com.nyfaria.nyfsgenetics.traits.Height;
import com.nyfaria.nyfsgenetics.traits.NoseSize;
import com.nyfaria.nyfsgenetics.traits.SkinTone;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.entity.npc.Villager;

public class FabricPlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    @Override
    public VillagerGenes getVillagerGenes(Villager villagerEntity) {
        return VillagerGeneticsHolderAttacher.GENETICS.get(villagerEntity);
    }

}
