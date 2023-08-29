package com.nyfaria.nyfsgenetics.event;

import com.nyfaria.nyfsgenetics.Constants;
import com.nyfaria.nyfsgenetics.client.renderlayers.VillagerEyeBrowRenderLayer;
import com.nyfaria.nyfsgenetics.client.renderlayers.VillagerEyesRenderLayer;
import com.nyfaria.nyfsgenetics.client.renderlayers.VillagerHairRenderLayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.VillagerRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = Constants.MODID, value = Dist.CLIENT)
public class ClientModEvents {

    @SubscribeEvent
    public static void onRendererLayers(EntityRenderersEvent.AddLayers event) {;
        VillagerRenderer renderer = event.getRenderer(EntityType.VILLAGER);
        renderer.addLayer(new VillagerEyesRenderLayer<>(renderer));
        renderer.addLayer(new VillagerEyeBrowRenderLayer<>(renderer));
        renderer.addLayer(new VillagerHairRenderLayer<>(renderer));
    }
}
