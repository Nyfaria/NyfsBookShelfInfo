package com.nyfaria.nyfsgenetics.cap;

import com.nyfaria.nyfsgenetics.api.VillagerGenes;
import com.nyfaria.nyfsgenetics.traits.EyeBrow;
import com.nyfaria.nyfsgenetics.traits.EyeColor;
import com.nyfaria.nyfsgenetics.traits.HairColor;
import com.nyfaria.nyfsgenetics.traits.HairType;
import com.nyfaria.nyfsgenetics.traits.Height;
import com.nyfaria.nyfsgenetics.traits.NoseSize;
import com.nyfaria.nyfsgenetics.traits.SkinTone;
import dev.onyxstudios.cca.api.v3.component.Component;
import dev.onyxstudios.cca.api.v3.component.ComponentV3;
import dev.onyxstudios.cca.api.v3.component.CopyableComponent;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;

public class VillagerGeneticsHolder implements ComponentV3, Component, CopyableComponent<VillagerGeneticsHolder>, AutoSyncedComponent, VillagerGenes {
    private EyeColor eyeColor = EyeColor.GREEN;
    private Height height = Height.NORMAL;
    private NoseSize noseSize = NoseSize.NORMAL;
    private SkinTone skinTone = SkinTone.NORMAL;
    private HairColor hairColor = HairColor.BROWN;
    private HairType hairType = HairType.NONE;
    private EyeBrow eyeBrow = EyeBrow.NORMAL;

    private boolean initialized = false;
    private final Entity entity;

    protected VillagerGeneticsHolder(Entity entity) {
        this.entity = entity;
    }


    @Override
    public void writeToNbt(CompoundTag tag) {
        tag.putString("eyeColor", this.getEyeColor().getName());
        tag.putString("height", this.getHeight().getName());
        tag.putString("noseSize", this.getNoseSize().getName());
        tag.putString("skinTone", this.getSkinTone().getName());
        tag.putString("hairColor", this.getHairColor().getName());
        tag.putString("hairType", this.getHairType().getName());
        tag.putString("eyeBrow", this.getEyeBrow().getName());
        tag.putBoolean("initialized", this.initialized);
    }

    @Override
    public void readFromNbt(CompoundTag nbt) {
        this.eyeColor = EyeColor.byName(nbt.getString("eyeColor"));
        this.height = Height.byName(nbt.getString("height"));
        this.noseSize = NoseSize.byName(nbt.getString("noseSize"));
        this.skinTone = SkinTone.byName(nbt.getString("skinTone"));
        this.hairColor = HairColor.byName(nbt.getString("hairColor"));
        this.hairType = HairType.byName(nbt.getString("hairType"));
        this.eyeBrow = EyeBrow.byName(nbt.getString("eyeBrow"));
        this.initialized = nbt.getBoolean("initialized");
    }

    public SkinTone getSkinTone() {
        return skinTone;
    }

    public void setSkinTone(SkinTone skinTone, boolean update) {
        this.skinTone = skinTone;
    }

    public HairColor getHairColor() {
        return hairColor;
    }

    public void setHairColor(HairColor hairColor, boolean update) {
        this.hairColor = hairColor;
        if(update)
            updateTracking();
    }

    public HairType getHairType() {
        return hairType;
    }

    public void setHairType(HairType hairType, boolean update) {
        this.hairType = hairType;
        if(update)
            updateTracking();
    }

    public EyeColor getEyeColor() {
        if (eyeColor == null)
            return EyeColor.GREEN;
        return eyeColor;
    }

    public EyeBrow getEyeBrow() {
        return eyeBrow;
    }

    public void setEyeBrow(EyeBrow eyeBrow, boolean update) {
        this.eyeBrow = eyeBrow;
        if(update)
            updateTracking();
    }

    public void setEyeColor(EyeColor eyeColor, boolean update) {
        this.eyeColor = eyeColor;
        if(update)
            updateTracking();
    }

    public Height getHeight() {
        if (height == null)
            return Height.NORMAL;
        return height;
    }

    public void setHeight(Height height, boolean update) {
        this.height = height;
        if(update)
            updateTracking();
    }

    public NoseSize getNoseSize() {
        return noseSize;
    }

    public void setNoseSize(NoseSize noseSize, boolean update) {
        this.noseSize = noseSize;
        if(update)
            updateTracking();
    }

    public boolean isInitialized() {
        return initialized;
    }


    private void updateTracking() {
        VillagerGeneticsHolderAttacher.GENETICS.sync(entity);
    }

    public void initialize() {
        initialize(
                Height.getRandomHeight(),
                EyeColor.getRandomEyeColor(),
                NoseSize.getRandomNoseSize(),
                SkinTone.getRandomSkinTone(),
                HairColor.getRandomHairColor(),
                HairType.getRandomHairType(),
                EyeBrow.getRandomEyeBrow()
        );
    }
    public void setInitialized(boolean initialized) {
        this.initialized = initialized;
        updateTracking();
    }

    @Override
    public void copyFrom(VillagerGeneticsHolder other) {
        this.eyeColor = other.eyeColor;
        this.height = other.height;
        this.noseSize = other.noseSize;
        this.skinTone = other.skinTone;
        this.hairColor = other.hairColor;
        this.hairType = other.hairType;
        this.eyeBrow = other.eyeBrow;
        this.initialized = other.initialized;
    }
}
