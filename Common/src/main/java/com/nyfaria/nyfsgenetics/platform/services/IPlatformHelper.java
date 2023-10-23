package com.nyfaria.nyfsgenetics.platform.services;

import com.nyfaria.nyfsgenetics.api.VillagerGenes;
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
    
    VillagerGenes getVillagerGenes(Villager villagerEntity);
}