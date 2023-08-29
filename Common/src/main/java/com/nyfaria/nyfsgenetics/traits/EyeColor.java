package com.nyfaria.nyfsgenetics.traits;

import com.nyfaria.nyfsgenetics.traits.api.Trait;
import net.minecraft.util.RandomSource;

public enum EyeColor implements Trait {
    BLUE(Type.DOMINANT, "blue"),
    GREEN(Type.CODOMINANT, "green"),
    BROWN(Type.RECESSIVE, "brown"),
    RED(Type.MUTATION, "red");

    private final Type type;
    private final String name;
    EyeColor(Type type, String name) {
        this.type = type;
        this.name = name;
    }

    public static EyeColor byName(String eyeColor) {
        for (EyeColor color : values()) {
            if (color.name.equals(eyeColor)) {
                return color;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    @Override
    public Type getType() {
        return type;
    }

    public static EyeColor fromParents(EyeColor eyeColor,EyeColor eyeColor2){
        boolean doMutation = RandomSource.create().nextInt(100) < 1;
        if(doMutation){
            return RED;
        }
        if(eyeColor == EyeColor.BLUE && eyeColor2 == EyeColor.BROWN){
            return EyeColor.GREEN;
        }
        if(eyeColor == EyeColor.BROWN && eyeColor2 == EyeColor.BLUE){
            return EyeColor.GREEN;
        }
        if(eyeColor == EyeColor.BLUE && eyeColor2 == EyeColor.GREEN){
            return RandomSource.create().nextBoolean() ? GREEN : BLUE;
        }
        if(eyeColor == EyeColor.GREEN && eyeColor2 == EyeColor.BLUE){
            return RandomSource.create().nextBoolean() ? GREEN : BLUE;
        }
        if(eyeColor == EyeColor.GREEN && eyeColor2 == EyeColor.BROWN){
            return RandomSource.create().nextBoolean() ? GREEN : BROWN;
        }
        if(eyeColor == EyeColor.BROWN && eyeColor2 == EyeColor.GREEN){
            return RandomSource.create().nextBoolean() ? GREEN : BROWN;
        }
        if(eyeColor == EyeColor.BROWN && eyeColor2 == EyeColor.BROWN){
            return BROWN;
        }
        if(eyeColor == EyeColor.BLUE && eyeColor2 == EyeColor.BLUE){
            return BLUE;
        }
        if(eyeColor == EyeColor.GREEN && eyeColor2 == EyeColor.GREEN){
            return RandomSource.create().nextBoolean() ? GREEN : RandomSource.create().nextBoolean() ? BROWN : BLUE;
        }
        return RandomSource.create().nextBoolean() ? eyeColor : eyeColor2;
    }
    public static EyeColor getRandomEyeColor(){
        return switch (RandomSource.create().nextInt(3)) {
            case 0 -> BLUE;
            case 1 -> GREEN;
            case 2 -> BROWN;
            default -> BLUE;
        };
    }
}
