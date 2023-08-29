package com.nyfaria.nyfsgenetics.mixin;

import com.nyfaria.nyfsgenetics.platform.Services;
import com.nyfaria.nyfsgenetics.traits.EyeBrow;
import com.nyfaria.nyfsgenetics.traits.EyeColor;
import com.nyfaria.nyfsgenetics.traits.HairColor;
import com.nyfaria.nyfsgenetics.traits.HairType;
import com.nyfaria.nyfsgenetics.traits.Height;
import com.nyfaria.nyfsgenetics.traits.NoseSize;
import com.nyfaria.nyfsgenetics.traits.SkinTone;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ReputationEventHandler;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerDataHolder;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Villager.class)
public abstract class VillagerMixin extends AbstractVillager implements ReputationEventHandler, VillagerDataHolder {

    public VillagerMixin(EntityType<? extends AbstractVillager> $$0, Level $$1) {
        super($$0, $$1);
    }

    @Inject(method = "getBreedOffspring(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/AgeableMob;)Lnet/minecraft/world/entity/npc/Villager;", at = @At("HEAD"), cancellable = true)
    public void onVillagerBreed(ServerLevel level, AgeableMob otherParent, CallbackInfoReturnable<Villager> cir){
        double aDouble = this.random.nextDouble();
        VillagerType villagerType;
        if (aDouble < 0.5) {
            villagerType = VillagerType.byBiome(level.getBiome(this.blockPosition()));
        } else if (aDouble < 0.75) {
            villagerType = this.getVillagerData().getType();
        } else {
            villagerType = ((Villager)otherParent).getVillagerData().getType();
        }

        Villager villager = new Villager(EntityType.VILLAGER, level, villagerType);
        EyeColor eyeColor = EyeColor.fromParents(Services.PLATFORM.getVillagerEyeColor((Villager)(Object)this), Services.PLATFORM.getVillagerEyeColor((Villager)otherParent));
        Height height = Height.fromParents(Services.PLATFORM.getVillagerHeight((Villager)(Object)this), Services.PLATFORM.getVillagerHeight((Villager)otherParent));
        NoseSize noseSize = NoseSize.fromParents(Services.PLATFORM.getVillagerNoseSize((Villager)(Object)this), Services.PLATFORM.getVillagerNoseSize((Villager)otherParent));
        SkinTone skinTone = SkinTone.fromParents(Services.PLATFORM.getVillagerSkinTone((Villager)(Object)this), Services.PLATFORM.getVillagerSkinTone((Villager)otherParent));
        HairColor hairColor = HairColor.fromParents(Services.PLATFORM.getVillagerHairColor((Villager)(Object)this), Services.PLATFORM.getVillagerHairColor((Villager)otherParent));
        HairType hairType = HairType.fromParents(Services.PLATFORM.getVillagerHairType((Villager)(Object)this), Services.PLATFORM.getVillagerHairType((Villager)otherParent));
        EyeBrow eyeBrow = EyeBrow.fromParents(Services.PLATFORM.getVillagerEyeBrow((Villager)(Object)this), Services.PLATFORM.getVillagerEyeBrow((Villager)otherParent));

        Services.PLATFORM.initialize(villager, eyeColor, height, noseSize,skinTone,hairColor,hairType,eyeBrow);
        villager.finalizeSpawn(level, level.getCurrentDifficultyAt(villager.blockPosition()), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
        cir.setReturnValue(villager);
    }
}
