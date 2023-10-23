package com.nyfaria.nyfsgenetics;

import com.nyfaria.nyfsgenetics.client.renderlayers.VillagerEyeBrowRenderLayer;
import com.nyfaria.nyfsgenetics.client.renderlayers.VillagerEyesRenderLayer;
import com.nyfaria.nyfsgenetics.client.renderlayers.VillagerHairRenderLayer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.minecraft.client.renderer.entity.VillagerRenderer;
import net.minecraft.world.entity.EntityType;

public class NyfsGeneticsClient implements ClientModInitializer {
    
    @Override
    public void onInitializeClient() {
        LivingEntityFeatureRendererRegistrationCallback.EVENT.register(
                (entityType, entityRenderer, registrationHelper, context) -> {
                    if(entityType== EntityType.VILLAGER){
                        registrationHelper.register(new VillagerEyesRenderLayer<>((VillagerRenderer)entityRenderer));
                        registrationHelper.register(new VillagerEyeBrowRenderLayer<>((VillagerRenderer)entityRenderer));
                        registrationHelper.register(new VillagerHairRenderLayer<>((VillagerRenderer)entityRenderer));
                    }
                }
        );
    }
}
