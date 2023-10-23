package com.nyfaria.nyfsgenetics.api;

import com.nyfaria.nyfsgenetics.traits.EyeBrow;
import com.nyfaria.nyfsgenetics.traits.EyeColor;
import com.nyfaria.nyfsgenetics.traits.HairColor;
import com.nyfaria.nyfsgenetics.traits.HairType;
import com.nyfaria.nyfsgenetics.traits.Height;
import com.nyfaria.nyfsgenetics.traits.NoseSize;
import com.nyfaria.nyfsgenetics.traits.SkinTone;

public interface VillagerGenes {
    SkinTone getSkinTone();
    void setSkinTone(SkinTone skinTone, boolean update);
    HairColor getHairColor();
    void setHairColor(HairColor hairColor, boolean update);
    HairType getHairType();
    void setHairType(HairType hairType, boolean update);
    EyeColor getEyeColor();
    EyeBrow getEyeBrow();
    void setEyeBrow(EyeBrow eyeBrow, boolean update);
    void setEyeColor(EyeColor eyeColor, boolean update);
    Height getHeight();
    void setHeight(Height height, boolean update);
    NoseSize getNoseSize();
    void setNoseSize(NoseSize noseSize, boolean update);
    boolean isInitialized();
    void initialize();
    void setInitialized(boolean initialized);
    default void initialize(Height height, EyeColor eyeColor, NoseSize noseSize, SkinTone skinTone, HairColor hairColor, HairType hairType, EyeBrow eyeBrow){
        setHeight(height, false);
        setEyeColor(eyeColor, false);
        setNoseSize(noseSize, false);
        setSkinTone(skinTone, false);
        setHairColor(hairColor, false);
        setHairType(hairType, false);
        setEyeBrow(eyeBrow, false);
        setInitialized(true);
    };
}
