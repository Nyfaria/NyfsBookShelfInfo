package com.nyfaria.nyfsgenetics.cap;

import com.nyfaria.nyfsgenetics.network.NetworkHandler;
import com.nyfaria.nyfsgenetics.traits.EyeBrow;
import com.nyfaria.nyfsgenetics.traits.EyeColor;
import com.nyfaria.nyfsgenetics.traits.HairColor;
import com.nyfaria.nyfsgenetics.traits.HairType;
import com.nyfaria.nyfsgenetics.traits.Height;
import com.nyfaria.nyfsgenetics.traits.NoseSize;
import com.nyfaria.nyfsgenetics.traits.SkinTone;
import dev._100media.capabilitysyncer.core.EntityCapability;
import dev._100media.capabilitysyncer.network.EntityCapabilityStatusPacket;
import dev._100media.capabilitysyncer.network.SimpleEntityCapabilityStatusPacket;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.network.simple.SimpleChannel;

public class VillagerGeneticsHolder extends EntityCapability {
    private EyeColor eyeColor = EyeColor.GREEN;
    private Height height = Height.NORMAL;
    private NoseSize noseSize = NoseSize.NORMAL;
    private SkinTone skinTone = SkinTone.NORMAL;
    private HairColor hairColor = HairColor.BROWN;
    private HairType hairType = HairType.NONE;
    private EyeBrow eyeBrow = EyeBrow.NORMAL;

    private boolean initialized = false;

    protected VillagerGeneticsHolder(Entity entity) {
        super(entity);
    }


    @Override
    public CompoundTag serializeNBT(boolean savingToDisk) {
        CompoundTag tag = new CompoundTag();
        tag.putString("eyeColor", this.getEyeColor().getName());
        tag.putString("height", this.getHeight().getName());
        tag.putString("noseSize", this.getNoseSize().getName());
        tag.putString("skinTone", this.getSkinTone().getName());
        tag.putString("hairColor", this.getHairColor().getName());
        tag.putString("hairType", this.getHairType().getName());
        tag.putString("eyeBrow", this.getEyeBrow().getName());
        tag.putBoolean("initialized", this.initialized);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt, boolean readingFromDisk) {
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

    public void setSkinTone(SkinTone skinTone) {
        this.skinTone = skinTone;
    }

    public HairColor getHairColor() {
        return hairColor;
    }

    public void setHairColor(HairColor hairColor) {
        this.hairColor = hairColor;
    }

    public HairType getHairType() {
        return hairType;
    }

    public void setHairType(HairType hairType) {
        this.hairType = hairType;
    }

    public EyeColor getEyeColor() {
        if (eyeColor == null)
            return EyeColor.GREEN;
        return eyeColor;
    }

    public EyeBrow getEyeBrow() {
        return eyeBrow;
    }

    public void setEyeBrow(EyeBrow eyeBrow) {
        this.eyeBrow = eyeBrow;
    }

    public void setEyeColor(EyeColor eyeColor) {
        this.eyeColor = eyeColor;
    }

    public Height getHeight() {
        if (height == null)
            return Height.NORMAL;
        return height;
    }

    public void setHeight(Height height) {
        this.height = height;
    }

    public NoseSize getNoseSize() {
        return noseSize;
    }

    public void setNoseSize(NoseSize noseSize) {
        this.noseSize = noseSize;
    }

    public boolean isInitialized() {
        return initialized;
    }

    public void setInitialized(boolean initialized) {
        this.initialized = initialized;
        updateTracking();
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

    public void initialize(Height height, EyeColor eyeColor, NoseSize noseSize, SkinTone skinTone, HairColor hairColor, HairType hairType, EyeBrow eyeBrow) {
        setHeight(height);
        setEyeColor(eyeColor);
        setNoseSize(noseSize);
        setSkinTone(skinTone);
        setHairColor(hairColor);
        setHairType(hairType);
        setEyeBrow(eyeBrow);
        setInitialized(true);
    }


    @Override
    public EntityCapabilityStatusPacket createUpdatePacket() {
        return new SimpleEntityCapabilityStatusPacket(this.entity.getId(), VillagerGeneticsHolderAttacher.RESOURCE_LOCATION, this);
    }

    @Override
    public SimpleChannel getNetworkChannel() {
        return NetworkHandler.INSTANCE;
    }
}
