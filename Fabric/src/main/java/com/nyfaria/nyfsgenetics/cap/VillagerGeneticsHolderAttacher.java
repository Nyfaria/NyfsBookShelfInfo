package com.nyfaria.nyfsgenetics.cap;

import com.nyfaria.nyfsgenetics.Constants;
import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistryV3;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.Villager;

public class VillagerGeneticsHolderAttacher implements EntityComponentInitializer {
    public static final ComponentKey<VillagerGeneticsHolder> GENETICS = ComponentRegistryV3.INSTANCE.getOrCreate(new ResourceLocation(Constants.MODID, "villager_genetics"), VillagerGeneticsHolder.class);


    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.registerFor(Villager.class, GENETICS, VillagerGeneticsHolder::new);
    }
}
