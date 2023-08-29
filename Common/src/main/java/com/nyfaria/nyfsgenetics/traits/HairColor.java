package com.nyfaria.nyfsgenetics.traits;

import com.nyfaria.nyfsgenetics.traits.api.Trait;
import net.minecraft.util.RandomSource;

public enum HairColor implements Trait {
    BLONDE(Type.DOMINANT, "blonde"),
    BROWN(Type.CODOMINANT, "brown"),
    BLACK(Type.RECESSIVE, "black"),
    RED(Type.MUTATION, "red"),
    WHITE(Type.MUTATION, "white");

    private final Type type;
    private final String name;
    HairColor(Type type, String name) {
        this.type = type;
        this.name = name;
    }
    @Override
    public Type getType() {
        return type;
    }

    public static HairColor byName(String hairColor) {
        for (HairColor color : values()) {
            if (color.getName().equals(hairColor)) {
                return color;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public static HairColor fromParents(HairColor villagerHairColor, HairColor villagerHairColor1) {
        boolean doMutation = RandomSource.create().nextInt(100) < 1;
        if(doMutation){
            return switch (RandomSource.create().nextInt(2)) {
                case 0 -> RED;
                case 1 -> WHITE;
                default -> RED;
            };
        }
        if(villagerHairColor == BLONDE && villagerHairColor1 == BLACK){
            return BROWN;
        }
        if(villagerHairColor == BLACK && villagerHairColor1 == BLONDE){
            return BROWN;
        }
        if(villagerHairColor == BLONDE && villagerHairColor1 == BROWN){
            return RandomSource.create().nextBoolean() ? BROWN : BLONDE;
        }
        if(villagerHairColor == BROWN && villagerHairColor1 == BLONDE){
            return RandomSource.create().nextBoolean() ? BROWN : BLONDE;
        }
        if(villagerHairColor == BROWN && villagerHairColor1 == BLACK){
            return RandomSource.create().nextBoolean() ? BROWN : BLACK;
        }
        if(villagerHairColor == BLACK && villagerHairColor1 == BROWN){
            return RandomSource.create().nextBoolean() ? BROWN : BLACK;
        }
        if(villagerHairColor == BLACK && villagerHairColor1 == BLACK){
            return BLACK;
        }
        if(villagerHairColor == BLONDE && villagerHairColor1 == BLONDE){
            return BLONDE;
        }
        return RandomSource.create().nextBoolean() ? villagerHairColor : villagerHairColor1;
    }
    public static HairColor getRandomHairColor(){
        return switch (RandomSource.create().nextInt(3)) {
            case 0 -> BLONDE;
            case 1 -> BROWN;
            case 2 -> BLACK;
            default -> BLONDE;
        };
    }
}
