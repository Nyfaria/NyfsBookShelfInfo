package com.nyfaria.nyfsgenetics.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.nyfaria.nyfsgenetics.api.VillagerGenes;
import com.nyfaria.nyfsgenetics.platform.Services;
import com.nyfaria.nyfsgenetics.traits.NoseSize;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.VillagerRenderer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.Villager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntityRenderer.class)
public class LivingEntityRenderMixin {

    @Inject(method = "render(Lnet/minecraft/world/entity/LivingEntity;FFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V", at = @At("HEAD"))
    public void renderMixin(LivingEntity livingEntity, float $$1, float $$2, PoseStack $$3, MultiBufferSource $$4, int $$5, CallbackInfo ci) {
        if (livingEntity instanceof Villager villager) {
            if (((Object)this instanceof VillagerRenderer villagerRenderer)) {
                VillagerGenes genes = Services.PLATFORM.getVillagerGenes(villager);
                if (genes.getNoseSize() == NoseSize.SMALL) {
                    villagerRenderer.getModel().getHead().getChild("nose").yScale = 0.5f;
                    villagerRenderer.getModel().getHead().getChild("nose").y = -3.0f;
                    villagerRenderer.getModel().getHead().getChild("nose").zScale = 1.0f;
                    villagerRenderer.getModel().getHead().getChild("nose").z = 0.0f;
                    villagerRenderer.getModel().getHead().getChild("nose").visible = true;
                } else if (genes.getNoseSize() == NoseSize.LONG) {
                    villagerRenderer.getModel().getHead().getChild("nose").yScale = 0.5f;
                    villagerRenderer.getModel().getHead().getChild("nose").zScale = 2.0f;
                    villagerRenderer.getModel().getHead().getChild("nose").y = -3.0f;
                    villagerRenderer.getModel().getHead().getChild("nose").z = 4.0f;
                    villagerRenderer.getModel().getHead().getChild("nose").visible = true;
                } else {
                    villagerRenderer.getModel().getHead().getChild("nose").yScale = 1f;
                    villagerRenderer.getModel().getHead().getChild("nose").zScale = 1.0f;
                    villagerRenderer.getModel().getHead().getChild("nose").y = -2.0f;
                    villagerRenderer.getModel().getHead().getChild("nose").z = 0.0f;
                    villagerRenderer.getModel().getHead().getChild("nose").visible = genes.getNoseSize() != NoseSize.NONE;
                }
            }

        }
    }
}
