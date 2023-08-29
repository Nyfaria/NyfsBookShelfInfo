package com.nyfaria.nyfsgenetics.event;

import com.nyfaria.nyfsgenetics.cap.VillagerGeneticsHolder;
import com.nyfaria.nyfsgenetics.cap.VillagerGeneticsHolderAttacher;
import net.minecraft.world.entity.npc.Villager;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommonForgeEvents {
    @SubscribeEvent
    public static void onEntityJoin(EntityJoinLevelEvent event) {
        if (event.getLevel().isClientSide()) return;
        if (event.getEntity() instanceof Villager villager) {
            VillagerGeneticsHolder villagerGeneticsHolder = VillagerGeneticsHolderAttacher.getHolderUnwrap(villager);
            if(villagerGeneticsHolder == null)return;
            if(villagerGeneticsHolder.isInitialized())return;
            villagerGeneticsHolder.initialize();
        }
    }

}
