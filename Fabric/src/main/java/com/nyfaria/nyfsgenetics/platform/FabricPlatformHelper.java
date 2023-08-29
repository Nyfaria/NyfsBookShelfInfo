package com.nyfaria.nyfsgenetics.platform;

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
    public EyeColor getVillagerEyeColor(Villager villagerEntity) {
        return null;
    }

    @Override
    public HairColor getVillagerHairColor(Villager villagerEntity) {
        return null;
    }

    @Override
    public Height getVillagerHeight(Villager villagerEntity) {
        return null;
    }

    @Override
    public void setVillagerEyeColor(Villager villagerEntity, EyeColor eyeColor) {

    }

    @Override
    public void setVillagerHairColor(Villager villagerEntity, HairColor hairColor) {

    }

    @Override
    public boolean isVillagerInitialized(Villager villagerEntity) {
        return false;
    }

    @Override
    public void setVillagerInitialized(Villager villagerEntity, boolean initialized) {

    }

    @Override
    public void initialize(Villager villagerEntity, EyeColor eyeColor, Height height, NoseSize noseSize, SkinTone skinTone, HairColor hairColor, HairType hairType, EyeBrow eyeBrow) {

    }

    @Override
    public NoseSize getVillagerNoseSize(Villager villager) {
        return null;
    }

    @Override
    public SkinTone getVillagerSkinTone(Villager villager) {
        return null;
    }

    @Override
    public HairType getVillagerHairType(Villager villager) {
        return null;
    }

    @Override
    public EyeBrow getVillagerEyeBrow(Villager villager) {
        return null;
    }

    @Override
    public void setVillagerSkinTone(Villager villager, SkinTone tone) {

    }

    @Override
    public void setVillagerHairType(Villager villager, HairType type) {

    }

    @Override
    public void setVillagerEyebrow(Villager villager, EyeBrow type) {

    }

    @Override
    public void setVillagerHeight(Villager villager, Height height) {

    }

    @Override
    public void setVillagerNoseSize(Villager villager, NoseSize size) {

    }

    @Override
    public void update(Villager villagerEntity) {

    }
}
