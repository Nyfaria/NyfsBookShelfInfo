package com.nyfaria.nyfsgenetics.traits;

import com.nyfaria.nyfsgenetics.traits.api.Trait;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.RandomSource;

public enum NoseSize implements Trait {
    SMALL(Type.DOMINANT, "small"),
    NORMAL(Type.CODOMINANT, "normal"),
    NONE(Type.RECESSIVE, "none"),
    LONG(Type.MUTATION, "long");

    private final Type type;
    private final String name;
    NoseSize(Type type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static NoseSize byName(String noseSize) {
        for (NoseSize color : values()) {
            if (color.getName().equals(noseSize)) {
                return color;
            }
        }
        return null;
    }

    @Override
    public Type getType() {
        return type;
    }
    public static NoseSize fromParents(NoseSize villagerNoseSize, NoseSize villagerNoseSize1) {
        boolean doMutation = RandomSource.create().nextInt(100)<1;
        if(doMutation){
            return LONG;
        }
        if(villagerNoseSize == SMALL && villagerNoseSize1 == NONE){
            return NORMAL;
        }
        if(villagerNoseSize == NONE && villagerNoseSize1 == SMALL){
            return NORMAL;
        }
        if(villagerNoseSize == SMALL && villagerNoseSize1 == NORMAL){
            return RandomSource.create().nextBoolean() ? NORMAL : SMALL;
        }
        if(villagerNoseSize == NORMAL && villagerNoseSize1 == SMALL){
            return RandomSource.create().nextBoolean() ? NORMAL : SMALL;
        }
        if(villagerNoseSize == NORMAL && villagerNoseSize1 == NONE){
            return RandomSource.create().nextBoolean() ? NORMAL : NONE;
        }
        if(villagerNoseSize == NONE && villagerNoseSize1 == NORMAL){
            return RandomSource.create().nextBoolean() ? NORMAL : NONE;
        }
        if(villagerNoseSize == NONE && villagerNoseSize1 == NONE){
            return NONE;
        }
        if(villagerNoseSize == SMALL && villagerNoseSize1 == SMALL){
            return SMALL;
        }
        if(villagerNoseSize == NORMAL && villagerNoseSize1 == NORMAL){
            return RandomSource.create().nextBoolean() ? NORMAL : RandomSource.create().nextBoolean() ? NONE : SMALL;
        }
        return RandomSource.create().nextBoolean() ? villagerNoseSize : villagerNoseSize1;
    }
    public static NoseSize getRandomNoseSize(){
        return values()[RandomSource.create().nextInt(3)];
    }
}
