package com.nyfaria.nyfsgenetics.mixin;

import com.nyfaria.nyfsgenetics.api.VillagerGenes;
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
import net.minecraft.world.DifficultyInstance;
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
import net.minecraft.world.level.ServerLevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(Villager.class)
public abstract class VillagerMixin extends AbstractVillager implements ReputationEventHandler, VillagerDataHolder {

    public VillagerMixin(EntityType<? extends AbstractVillager> $$0, Level $$1) {
        super($$0, $$1);
    }

    @Inject(method = "getBreedOffspring(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/AgeableMob;)Lnet/minecraft/world/entity/npc/Villager;", at = @At("HEAD"), cancellable = true)
    public void onVillagerBreed(ServerLevel level, AgeableMob otherParent, CallbackInfoReturnable<Villager> cir) {
        double aDouble = this.random.nextDouble();
        VillagerType villagerType;
        if (aDouble < 0.5) {
            villagerType = VillagerType.byBiome(level.getBiome(this.blockPosition()));
        } else if (aDouble < 0.75) {
            villagerType = this.getVillagerData().getType();
        } else {
            villagerType = ((Villager) otherParent).getVillagerData().getType();
        }

        Villager villager = new Villager(EntityType.VILLAGER, level, villagerType);
        EyeColor eyeColor = EyeColor.fromParents(Services.PLATFORM.getVillagerGenes((Villager) (Object) this).getEyeColor(), Services.PLATFORM.getVillagerGenes((Villager) otherParent).getEyeColor());
        Height height = Height.fromParents(Services.PLATFORM.getVillagerGenes((Villager) (Object) this).getHeight(), Services.PLATFORM.getVillagerGenes((Villager) otherParent).getHeight());
        NoseSize noseSize = NoseSize.fromParents(Services.PLATFORM.getVillagerGenes((Villager) (Object) this).getNoseSize(), Services.PLATFORM.getVillagerGenes((Villager) otherParent).getNoseSize());
        SkinTone skinTone = SkinTone.fromParents(Services.PLATFORM.getVillagerGenes((Villager) (Object) this).getSkinTone(), Services.PLATFORM.getVillagerGenes((Villager) otherParent).getSkinTone());
        HairColor hairColor = HairColor.fromParents(Services.PLATFORM.getVillagerGenes((Villager) (Object) this).getHairColor(), Services.PLATFORM.getVillagerGenes((Villager) otherParent).getHairColor());
        HairType hairType = HairType.fromParents(Services.PLATFORM.getVillagerGenes((Villager) (Object) this).getHairType(), Services.PLATFORM.getVillagerGenes((Villager) otherParent).getHairType());
        EyeBrow eyeBrow = EyeBrow.fromParents(Services.PLATFORM.getVillagerGenes((Villager) (Object) this).getEyeBrow(), Services.PLATFORM.getVillagerGenes((Villager) otherParent).getEyeBrow());

        Services.PLATFORM.getVillagerGenes(villager).initialize(height, eyeColor, noseSize, skinTone, hairColor, hairType, eyeBrow);
        villager.finalizeSpawn(level, level.getCurrentDifficultyAt(villager.blockPosition()), MobSpawnType.BREEDING, (SpawnGroupData) null, (CompoundTag) null);
        cir.setReturnValue(villager);
    }

    @Inject(method = "finalizeSpawn", at = @At("RETURN"))
    public void setupVillager(ServerLevelAccessor $$0, DifficultyInstance $$1, MobSpawnType $$2, SpawnGroupData $$3, CompoundTag $$4, CallbackInfoReturnable<SpawnGroupData> cir) {
        if (List.of(MobSpawnType.STRUCTURE, MobSpawnType.CHUNK_GENERATION, MobSpawnType.SPAWNER, MobSpawnType.EVENT, MobSpawnType.SPAWN_EGG).contains($$2)) {
            if (level().isClientSide()) return;
            VillagerGenes villagerGeneticsHolder = Services.PLATFORM.getVillagerGenes((Villager)(Object)this);
            if (villagerGeneticsHolder == null) return;
            if (villagerGeneticsHolder.isInitialized()) return;
            villagerGeneticsHolder.initialize();

        }
    }
}
