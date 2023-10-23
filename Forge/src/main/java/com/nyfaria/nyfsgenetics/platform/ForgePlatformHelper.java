package com.nyfaria.nyfsgenetics.platform;

import com.nyfaria.nyfsgenetics.api.VillagerGenes;
import com.nyfaria.nyfsgenetics.cap.VillagerGeneticsHolder;
import com.nyfaria.nyfsgenetics.cap.VillagerGeneticsHolderAttacher;
import com.nyfaria.nyfsgenetics.platform.services.IPlatformHelper;
import com.nyfaria.nyfsgenetics.traits.EyeBrow;
import com.nyfaria.nyfsgenetics.traits.EyeColor;
import com.nyfaria.nyfsgenetics.traits.HairColor;
import com.nyfaria.nyfsgenetics.traits.HairType;
import com.nyfaria.nyfsgenetics.traits.Height;
import com.nyfaria.nyfsgenetics.traits.NoseSize;
import com.nyfaria.nyfsgenetics.traits.SkinTone;
import net.minecraft.world.entity.npc.Villager;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;

public class ForgePlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {

        return "Forge";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return !FMLLoader.isProduction();
    }
    @Override
    public VillagerGenes getVillagerGenes(Villager villagerEntity) {
        return VillagerGeneticsHolderAttacher.getHolderUnwrap(villagerEntity);
    }
}