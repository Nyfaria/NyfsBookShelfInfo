package com.nyfaria.nyfsgenetics.mixin;

import com.nyfaria.nyfsgenetics.Constants;
import com.nyfaria.nyfsgenetics.platform.Services;
import com.nyfaria.nyfsgenetics.traits.SkinTone;
import net.minecraft.client.renderer.entity.VillagerRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.Villager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(VillagerRenderer.class)
public class VillagerRendererMixin {
    @Inject(method="getTextureLocation(Lnet/minecraft/world/entity/npc/Villager;)Lnet/minecraft/resources/ResourceLocation;", at=@At("HEAD"), cancellable = true)
    public void getTexture(Villager villager, CallbackInfoReturnable<ResourceLocation> cir){
        SkinTone skinTone = Services.PLATFORM.getVillagerGenes(villager).getSkinTone();
        if(skinTone != null){
            cir.setReturnValue(new ResourceLocation(Constants.MODID, "textures/entity/villager/" + skinTone.getName() + "_villager.png"));
        }
    }
}
