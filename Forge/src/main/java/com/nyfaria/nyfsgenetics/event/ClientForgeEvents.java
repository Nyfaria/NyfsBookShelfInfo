package com.nyfaria.nyfsgenetics.event;

import com.nyfaria.nyfsgenetics.cap.VillagerGeneticsHolderAttacher;
import com.nyfaria.nyfsgenetics.traits.NoseSize;
import net.minecraft.client.model.VillagerModel;
import net.minecraft.client.renderer.entity.VillagerRenderer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.npc.Villager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientForgeEvents {

    @SubscribeEvent
    public static void onVillageRender(RenderLivingEvent.Pre<Villager, VillagerModel<Villager>> event) {

//        if (event.getEntity() instanceof Villager villager) {
//            if (event.getRenderer() instanceof VillagerRenderer villagerRenderer) {
//                VillagerGeneticsHolderAttacher.getHolder(villager).ifPresent(
//                        holder -> {
//                            if (holder.getNoseSize() == NoseSize.SMALL) {
//                                villagerRenderer.getModel().getHead().getChild("nose").yScale = 0.5f;
//                                villagerRenderer.getModel().getHead().getChild("nose").y = -3.0f;
//                                villagerRenderer.getModel().getHead().getChild("nose").zScale = 1.0f;
//                                villagerRenderer.getModel().getHead().getChild("nose").z = 0.0f;
//                                villagerRenderer.getModel().getHead().getChild("nose").visible = true;
//                            } else if (holder.getNoseSize() == NoseSize.LONG) {
//                                villagerRenderer.getModel().getHead().getChild("nose").yScale = 0.5f;
//                                villagerRenderer.getModel().getHead().getChild("nose").zScale = 2.0f;
//                                villagerRenderer.getModel().getHead().getChild("nose").y = -3.0f;
//                                villagerRenderer.getModel().getHead().getChild("nose").z = 4.0f;
//                                villagerRenderer.getModel().getHead().getChild("nose").visible = true;
//                            } else {
//                                villagerRenderer.getModel().getHead().getChild("nose").yScale = 1f;
//                                villagerRenderer.getModel().getHead().getChild("nose").zScale = 1.0f;
//                                villagerRenderer.getModel().getHead().getChild("nose").y = -2.0f;
//                                villagerRenderer.getModel().getHead().getChild("nose").z = 0.0f;
//                                villagerRenderer.getModel().getHead().getChild("nose").visible = holder.getNoseSize() != NoseSize.NONE;
//                            }
//                        }
//                );
//            }
//        }
    }
}
