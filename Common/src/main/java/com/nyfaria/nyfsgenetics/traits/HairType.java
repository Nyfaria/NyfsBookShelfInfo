package com.nyfaria.nyfsgenetics.traits;

import com.nyfaria.nyfsgenetics.traits.api.Trait;
import net.minecraft.util.RandomSource;

public enum HairType implements Trait {
    CURLY(Type.DOMINANT, "curly"),
    STRAIGHT(Type.CODOMINANT, "straight"),
    NONE(Type.RECESSIVE, "none"),
    WEIRD(Type.MUTATION, "weird");
    
    private final Type type;
    private final String name;
    HairType(Type type, String name) {
        this.type = type;
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public static HairType byName(String hairType) {
        for (HairType color : values()) {
            if (color.getName().equals(hairType)) {
                return color;
            }
        }
        return null;
    }
    
    @Override
    public Type getType() {
        return type;
    }

    public static HairType fromParents(HairType villagerHairType, HairType villagerHairType1) {
        boolean doMutation = RandomSource.create().nextInt(100) < 1;
        if(doMutation){
            return WEIRD;
        }
        if(villagerHairType == CURLY && villagerHairType1 == NONE){
            return STRAIGHT;
        }
        if(villagerHairType == NONE && villagerHairType1 == CURLY){
            return STRAIGHT;
        }
        if(villagerHairType == CURLY && villagerHairType1 == STRAIGHT){
            return RandomSource.create().nextBoolean() ? STRAIGHT : CURLY;
        }
        if(villagerHairType == STRAIGHT && villagerHairType1 == CURLY){
            return RandomSource.create().nextBoolean() ? STRAIGHT : CURLY;
        }
        if(villagerHairType == STRAIGHT && villagerHairType1 == NONE){
            return RandomSource.create().nextBoolean() ? STRAIGHT : NONE;
        }
        if(villagerHairType == NONE && villagerHairType1 == STRAIGHT){
            return RandomSource.create().nextBoolean() ? STRAIGHT : NONE;
        }
        if(villagerHairType == NONE && villagerHairType1 == NONE){
            return NONE;
        }
        if(villagerHairType == CURLY && villagerHairType1 == CURLY){
            return CURLY;
        }
        if(villagerHairType == STRAIGHT && villagerHairType1 == STRAIGHT){
            return RandomSource.create().nextBoolean() ? STRAIGHT : RandomSource.create().nextBoolean() ? NONE : CURLY;
        }
        return RandomSource.create().nextBoolean() ? villagerHairType : villagerHairType1;
    }
    public static HairType getRandomHairType(){
        return values()[RandomSource.create().nextInt(values().length-1)];
    }
}
