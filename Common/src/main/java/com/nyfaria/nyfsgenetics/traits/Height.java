package com.nyfaria.nyfsgenetics.traits;

import com.nyfaria.nyfsgenetics.traits.api.Trait;
import net.minecraft.util.RandomSource;

public enum Height implements Trait {
    TALL(Type.DOMINANT, 1.1f, "tall"),
    NORMAL(Type.CODOMINANT, 1.0f, "normal"),
    SHORT(Type.RECESSIVE, 0.9f, "short"),
    MIDGET(Type.MUTATION, 0.8f, "midget");

    private final Type type;
    private final float scale;
    private final String name;
    Height(Type type, float scale, String name) {
        this.type = type;
        this.scale = scale;
        this.name = name;
    }

    public static Height fromParents(Height villagerHeight, Height villagerHeight1) {
        boolean doMutation = RandomSource.create().nextInt(100)<1;
        if(doMutation){
            return MIDGET;
        }
        if(villagerHeight == TALL && villagerHeight1 == SHORT){
            return NORMAL;
        }
        if(villagerHeight == SHORT && villagerHeight1 == TALL){
            return NORMAL;
        }
        if(villagerHeight == TALL && villagerHeight1 == NORMAL){
            return RandomSource.create().nextBoolean() ? NORMAL : TALL;
        }
        if(villagerHeight == NORMAL && villagerHeight1 == TALL){
            return RandomSource.create().nextBoolean() ? NORMAL : TALL;
        }
        if(villagerHeight == NORMAL && villagerHeight1 == SHORT){
            return RandomSource.create().nextBoolean() ? NORMAL : SHORT;
        }
        if(villagerHeight == SHORT && villagerHeight1 == NORMAL){
            return RandomSource.create().nextBoolean() ? NORMAL : SHORT;
        }
        if(villagerHeight == SHORT && villagerHeight1 == SHORT){
            return SHORT;
        }
        if(villagerHeight == TALL && villagerHeight1 == TALL){
            return TALL;
        }
        if(villagerHeight == NORMAL && villagerHeight1 == NORMAL){
            return RandomSource.create().nextBoolean() ? NORMAL : RandomSource.create().nextBoolean() ? SHORT : TALL;
        }
        return RandomSource.create().nextBoolean() ? villagerHeight : villagerHeight1;
    }

    public String getName() {
        return name;
    }

    public static Height byName(String height) {
        for (Height color : values()) {
            if (color.getName().equals(height)) {
                return color;
            }
        }
        return null;
    }

    @Override
    public Type getType() {
        return type;
    }

    public float scale() {
        return scale;
    }
    public static Height getRandomHeight(){
        return values()[RandomSource.create().nextInt(3)];
    }
}
