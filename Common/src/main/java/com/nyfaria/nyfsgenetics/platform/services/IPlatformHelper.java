package com.nyfaria.nyfsgenetics.platform.services;

import com.nyfaria.nyfsgenetics.traits.EyeBrow;
import com.nyfaria.nyfsgenetics.traits.EyeColor;
import com.nyfaria.nyfsgenetics.traits.HairColor;
import com.nyfaria.nyfsgenetics.traits.HairType;
import com.nyfaria.nyfsgenetics.traits.Height;
import com.nyfaria.nyfsgenetics.traits.NoseSize;
import com.nyfaria.nyfsgenetics.traits.SkinTone;
import net.minecraft.world.entity.npc.Villager;

public interface IPlatformHelper {

    /**
     * Gets the name of the current platform
     *
     * @return The name of the current platform.
     */
    String getPlatformName();

    /**
     * Checks if a mod with the given id is loaded.
     *
     * @param modId The mod to check if it is loaded.
     * @return True if the mod is loaded, false otherwise.
     */
    boolean isModLoaded(String modId);

    /**
     * Check if the game is currently in a development environment.
     *
     * @return True if in a development environment, false otherwise.
     */
    boolean isDevelopmentEnvironment();

    /**
     * Gets the name of the environment type as a string.
     *
     * @return The name of the environment type.
     */
    default String getEnvironmentName() {

        return isDevelopmentEnvironment() ? "development" : "production";
    }

    EyeColor getVillagerEyeColor(Villager villagerEntity);

    HairColor getVillagerHairColor(Villager villagerEntity);

    Height getVillagerHeight(Villager villagerEntity);

    void setVillagerEyeColor(Villager villagerEntity, EyeColor eyeColor);

    void setVillagerHairColor(Villager villagerEntity, HairColor hairColor);

    boolean isVillagerInitialized(Villager villagerEntity);

    void setVillagerInitialized(Villager villagerEntity, boolean initialized);

    void initialize(Villager villagerEntity, EyeColor eyeColor, Height height, NoseSize noseSize, SkinTone skinTone, HairColor hairColor, HairType hairType, EyeBrow eyeBrow);

    default void initialize(Villager villagerEntity) {
        initialize(villagerEntity,
                EyeColor.getRandomEyeColor(),
                Height.getRandomHeight(),
                NoseSize.getRandomNoseSize(),
                SkinTone.getRandomSkinTone(),
                HairColor.getRandomHairColor(),
                HairType.getRandomHairType(),
                EyeBrow.getRandomEyeBrow()
        );
    }

    NoseSize getVillagerNoseSize(Villager villager);

    SkinTone getVillagerSkinTone(Villager villager);

    HairType getVillagerHairType(Villager villager);

    EyeBrow getVillagerEyeBrow(Villager villager);

    void setVillagerSkinTone(Villager villager, SkinTone tone);

    void setVillagerHairType(Villager villager, HairType type);

    void setVillagerEyebrow(Villager villager, EyeBrow type);

    void setVillagerHeight(Villager villager, Height height);

    void setVillagerNoseSize(Villager villager, NoseSize size);
    void update(Villager villagerEntity);
}