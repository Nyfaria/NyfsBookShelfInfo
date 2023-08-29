package com.nyfaria.nyfsgenetics.traits;

import com.nyfaria.nyfsgenetics.traits.api.Trait;
import net.minecraft.util.RandomSource;

public enum EyeBrow implements Trait {
    DOUBLE(Type.DOMINANT, "double"),
    NORMAL(Type.CODOMINANT, "normal"),
    NONE(Type.RECESSIVE, "none"),
    BUSHY(Type.MUTATION, "bushy");

    private final Type type;
    private final String name;

    EyeBrow(Type type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static EyeBrow byName(String eyeBrow) {
        for (EyeBrow color : values()) {
            if (color.getName().equals(eyeBrow)) {
                return color;
            }
        }
        return null;
    }

    @Override
    public Type getType() {
        return type;
    }

    public static EyeBrow fromParents(EyeBrow villagerEyeBrow, EyeBrow villagerEyeBrow1) {
        boolean doMutation = RandomSource.create().nextInt(100)<1;
        if(doMutation){
            return BUSHY;
        }
        if(villagerEyeBrow == DOUBLE && villagerEyeBrow1 == NONE){
            return NORMAL;
        }
        if(villagerEyeBrow == NONE && villagerEyeBrow1 == DOUBLE){
            return NORMAL;
        }
        if(villagerEyeBrow == DOUBLE && villagerEyeBrow1 == NORMAL){
            return RandomSource.create().nextBoolean() ? NORMAL : DOUBLE;
        }
        if(villagerEyeBrow == NORMAL && villagerEyeBrow1 == DOUBLE){
            return RandomSource.create().nextBoolean() ? NORMAL : DOUBLE;
        }
        if(villagerEyeBrow == NORMAL && villagerEyeBrow1 == NONE){
            return RandomSource.create().nextBoolean() ? NORMAL : NONE;
        }
        if(villagerEyeBrow == NONE && villagerEyeBrow1 == NORMAL){
            return RandomSource.create().nextBoolean() ? NORMAL : NONE;
        }
        if(villagerEyeBrow == NONE && villagerEyeBrow1 == NONE){
            return NONE;
        }
        if(villagerEyeBrow == DOUBLE && villagerEyeBrow1 == DOUBLE){
            return DOUBLE;
        }
        if(villagerEyeBrow == NORMAL && villagerEyeBrow1 == NORMAL){
            return RandomSource.create().nextBoolean() ? NORMAL : RandomSource.create().nextBoolean() ? NONE : DOUBLE;
        }
        return RandomSource.create().nextBoolean() ? villagerEyeBrow : villagerEyeBrow1;
    }
    public static EyeBrow getRandomEyeBrow(){
        return values()[RandomSource.create().nextInt(values().length-1)];
    }
}
