package com.nyfaria.nyfsgenetics.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.nyfaria.nyfsgenetics.platform.Services;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.npc.Villager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MobRenderer.class)
public class MobRendererMixin {

    @Inject(method = "render(Lnet/minecraft/world/entity/Mob;FFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V", at = @At("HEAD"))
    public void renderStart(Mob mob, float $$1, float $$2, PoseStack poseStack, MultiBufferSource $$4, int $$5, CallbackInfo ci) {
        if(mob instanceof Villager villagerGenes){
            if(mob.isBaby())return;
            float scale = Services.PLATFORM.getVillagerHeight(villagerGenes).scale();
            poseStack.scale(scale, scale, scale);
        }
    }
    @Inject(method = "render(Lnet/minecraft/world/entity/Mob;FFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V", at = @At("RETURN"))
    public void renderEnd(Mob mob, float $$1, float $$2, PoseStack poseStack, MultiBufferSource $$4, int $$5, CallbackInfo ci) {
        if(mob instanceof Villager villagerGenes){
            if(mob.isBaby())return;
            float scale = 1f/Services.PLATFORM.getVillagerHeight(villagerGenes).scale();
            poseStack.scale(scale, scale, scale);
        }
    }
}
