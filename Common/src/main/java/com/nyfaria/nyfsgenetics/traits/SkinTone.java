package com.nyfaria.nyfsgenetics.traits;

import com.nyfaria.nyfsgenetics.traits.api.Trait;
import net.minecraft.util.RandomSource;

public enum SkinTone implements Trait {
    BLACK(Type.DOMINANT, "black"),
    YELLOW(Type.CODOMINANT, "yellow"),
    NORMAL(Type.RECESSIVE, "normal"),
    ALBINISM(Type.MUTATION, "albinism");

    private final Type type;
    private final String name;
    SkinTone(Type type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static SkinTone byName(String skinTone) {
        for (SkinTone color : values()) {
            if (color.getName().equals(skinTone)) {
                return color;
            }
        }
        return null;
    }

    @Override
    public Type getType() {
        return type;
    }
    public static SkinTone fromParents(SkinTone villagerSkinTone, SkinTone villagerSkinTone1) {
        boolean doMutation = RandomSource.create().nextInt(100)<1;
        if(doMutation){
            return ALBINISM;
        }
        if(villagerSkinTone == BLACK && villagerSkinTone1 == NORMAL){
            return YELLOW;
        }
        if(villagerSkinTone == NORMAL && villagerSkinTone1 == BLACK){
            return YELLOW;
        }
        if(villagerSkinTone == BLACK && villagerSkinTone1 == YELLOW){
            return RandomSource.create().nextBoolean() ? YELLOW : BLACK;
        }
        if(villagerSkinTone == YELLOW && villagerSkinTone1 == BLACK){
            return RandomSource.create().nextBoolean() ? YELLOW : BLACK;
        }
        if(villagerSkinTone == YELLOW && villagerSkinTone1 == NORMAL){
            return RandomSource.create().nextBoolean() ? YELLOW : NORMAL;
        }
        if(villagerSkinTone == NORMAL && villagerSkinTone1 == YELLOW){
            return RandomSource.create().nextBoolean() ? YELLOW : NORMAL;
        }
        if(villagerSkinTone == NORMAL && villagerSkinTone1 == NORMAL){
            return NORMAL;
        }
        if(villagerSkinTone == BLACK && villagerSkinTone1 == BLACK){
            return BLACK;
        }
        if(villagerSkinTone == YELLOW && villagerSkinTone1 == YELLOW){
            return RandomSource.create().nextBoolean() ? YELLOW : RandomSource.create().nextBoolean() ? NORMAL : BLACK;
        }
        return RandomSource.create().nextBoolean() ? villagerSkinTone : villagerSkinTone1;
    }
    public static SkinTone getRandomSkinTone(){
        return values()[RandomSource.create().nextInt(values().length-1)];
    }
}

