package com.nyfaria.nyfsgenetics.cap;

import com.nyfaria.nyfsgenetics.Constants;
import dev._100media.capabilitysyncer.core.CapabilityAttacher;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Constants.MODID)
public class VillagerGeneticsHolderAttacher extends CapabilityAttacher {
    public static final Capability<VillagerGeneticsHolder> CAPABILITY = getCapability(new CapabilityToken<>() {});
    public static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation(Constants.MODID, "villager_genetics");
    private static final Class<VillagerGeneticsHolder> CAPABILITY_CLASS = VillagerGeneticsHolder.class;

    @SuppressWarnings("ConstantConditions")
    public static VillagerGeneticsHolder getHolderUnwrap(Entity player) {
        return getHolder(player).orElse(null);
    }

    public static LazyOptional<VillagerGeneticsHolder> getHolder(Entity player) {
        return player.getCapability(CAPABILITY);
    }

    private static void attach(AttachCapabilitiesEvent<Entity> event, Entity entity) {
        genericAttachCapability(event, new VillagerGeneticsHolder(entity), CAPABILITY, RESOURCE_LOCATION);
    }

    public static void register() {
        CapabilityAttacher.registerCapability(CAPABILITY_CLASS);
        CapabilityAttacher.registerEntityAttacher(LivingEntity.class, VillagerGeneticsHolderAttacher::attach, VillagerGeneticsHolderAttacher::getHolder);
    }
}
