package com.nyfaria.nyfsgenetics.platform;

import com.nyfaria.nyfsgenetics.cap.VillagerGeneticsHolder;
import com.nyfaria.nyfsgenetics.cap.VillagerGeneticsHolderAttacher;
import com.nyfaria.nyfsgenetics.platform.services.IPlatformHelper;
import com.nyfaria.nyfsgenetics.traits.EyeBrow;
import com.nyfaria.nyfsgenetics.traits.EyeColor;
import com.nyfaria.nyfsgenetics.traits.HairColor;
import com.nyfaria.nyfsgenetics.traits.HairType;
import com.nyfaria.nyfsgenetics.traits.Height;
import com.nyfaria.nyfsgenetics.traits.NoseSize;
import com.nyfaria.nyfsgenetics.traits.SkinTone;
import net.minecraft.world.entity.npc.Villager;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;

public class ForgePlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {

        return "Forge";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return !FMLLoader.isProduction();
    }

    @Override
    public EyeColor getVillagerEyeColor(Villager villagerEntity) {
        VillagerGeneticsHolder villagerGeneticsHolder = VillagerGeneticsHolderAttacher.getHolderUnwrap(villagerEntity);
        if(villagerGeneticsHolder != null) {
            return villagerGeneticsHolder.getEyeColor();
        }
        return EyeColor.BLUE;
    }

    @Override
    public Height getVillagerHeight(Villager villagerEntity) {
        VillagerGeneticsHolder villagerGeneticsHolder = VillagerGeneticsHolderAttacher.getHolderUnwrap(villagerEntity);
        if(villagerGeneticsHolder != null) {
            return villagerGeneticsHolder.getHeight();
        }
        return Height.NORMAL;
    }

    @Override
    public void setVillagerEyeColor(Villager villagerEntity, EyeColor eyeColor) {
        VillagerGeneticsHolder villagerGeneticsHolder = VillagerGeneticsHolderAttacher.getHolderUnwrap(villagerEntity);
        if(villagerGeneticsHolder != null) {
            villagerGeneticsHolder.setEyeColor(eyeColor);
        }
    }

    @Override
    public void setVillagerHairColor(Villager villagerEntity, HairColor hairColor) {
        VillagerGeneticsHolder villagerGeneticsHolder = VillagerGeneticsHolderAttacher.getHolderUnwrap(villagerEntity);
        if(villagerGeneticsHolder != null) {
            villagerGeneticsHolder.setHairColor(hairColor);
        }
    }

    @Override
    public HairColor getVillagerHairColor(Villager villagerEntity) {
        VillagerGeneticsHolder villagerGeneticsHolder = VillagerGeneticsHolderAttacher.getHolderUnwrap(villagerEntity);
        if(villagerGeneticsHolder != null) {
            return villagerGeneticsHolder.getHairColor();
        }
        return HairColor.BLACK;
    }

    @Override
    public boolean isVillagerInitialized(Villager villagerEntity) {
        VillagerGeneticsHolder villagerGeneticsHolder = VillagerGeneticsHolderAttacher.getHolderUnwrap(villagerEntity);
        if(villagerGeneticsHolder != null) {
            return villagerGeneticsHolder.isInitialized();
        }
        return false;
    }

    @Override
    public void setVillagerInitialized(Villager villagerEntity, boolean initialized) {
        VillagerGeneticsHolder villagerGeneticsHolder = VillagerGeneticsHolderAttacher.getHolderUnwrap(villagerEntity);
        if(villagerGeneticsHolder != null) {
            villagerGeneticsHolder.setInitialized(initialized);
        }
    }

    @Override
    public void initialize(Villager villagerEntity, EyeColor eyeColor, Height height, NoseSize noseSize, SkinTone skinTone, HairColor hairColor, HairType hairType, EyeBrow eyeBrow) {
        VillagerGeneticsHolder villagerGeneticsHolder = VillagerGeneticsHolderAttacher.getHolderUnwrap(villagerEntity);
        if(villagerGeneticsHolder != null) {
            villagerGeneticsHolder.initialize(height, eyeColor, noseSize, skinTone, hairColor, hairType, eyeBrow);
        }
    }

    @Override
    public NoseSize getVillagerNoseSize(Villager villager) {
        VillagerGeneticsHolder villagerGeneticsHolder = VillagerGeneticsHolderAttacher.getHolderUnwrap(villager);
        if(villagerGeneticsHolder != null) {
            return villagerGeneticsHolder.getNoseSize();
        }
        return NoseSize.NORMAL;
    }

    @Override
    public SkinTone getVillagerSkinTone(Villager villager) {
        VillagerGeneticsHolder villagerGeneticsHolder = VillagerGeneticsHolderAttacher.getHolderUnwrap(villager);
        if(villagerGeneticsHolder != null) {
            return villagerGeneticsHolder.getSkinTone();
        }
        return SkinTone.NORMAL;
    }
    @Override
    public HairType getVillagerHairType(Villager villager) {
        VillagerGeneticsHolder villagerGeneticsHolder = VillagerGeneticsHolderAttacher.getHolderUnwrap(villager);
        if(villagerGeneticsHolder != null) {
            return villagerGeneticsHolder.getHairType();
        }
        return HairType.NONE;
    }

    @Override
    public EyeBrow getVillagerEyeBrow(Villager villager) {
        VillagerGeneticsHolder villagerGeneticsHolder = VillagerGeneticsHolderAttacher.getHolderUnwrap(villager);
        if(villagerGeneticsHolder != null) {
            return villagerGeneticsHolder.getEyeBrow();
        }
        return EyeBrow.NORMAL;
    }

    @Override
    public void setVillagerSkinTone(Villager villager, SkinTone tone) {
        VillagerGeneticsHolder villagerGeneticsHolder = VillagerGeneticsHolderAttacher.getHolderUnwrap(villager);
        if(villagerGeneticsHolder != null) {
            villagerGeneticsHolder.setSkinTone(tone);
        }
    }

    @Override
    public void setVillagerHairType(Villager villager, HairType type) {
        VillagerGeneticsHolder villagerGeneticsHolder = VillagerGeneticsHolderAttacher.getHolderUnwrap(villager);
        if(villagerGeneticsHolder != null) {
            villagerGeneticsHolder.setHairType(type);
        }
    }

    @Override
    public void setVillagerEyebrow(Villager villager, EyeBrow type) {
        VillagerGeneticsHolder villagerGeneticsHolder = VillagerGeneticsHolderAttacher.getHolderUnwrap(villager);
        if(villagerGeneticsHolder != null) {
            villagerGeneticsHolder.setEyeBrow(type);
        }
    }

    @Override
    public void setVillagerHeight(Villager villager, Height height) {
        VillagerGeneticsHolder villagerGeneticsHolder = VillagerGeneticsHolderAttacher.getHolderUnwrap(villager);
        if (villagerGeneticsHolder != null) {
            villagerGeneticsHolder.setHeight(height);
        }
    }

    @Override
    public void setVillagerNoseSize(Villager villager, NoseSize size) {
        VillagerGeneticsHolder villagerGeneticsHolder = VillagerGeneticsHolderAttacher.getHolderUnwrap(villager);
        if (villagerGeneticsHolder != null) {
            villagerGeneticsHolder.setNoseSize(size);
        }
    }

    @Override
    public void update(Villager villagerEntity) {
        VillagerGeneticsHolder villagerGeneticsHolder = VillagerGeneticsHolderAttacher.getHolderUnwrap(villagerEntity);
        if (villagerGeneticsHolder != null) {
            villagerGeneticsHolder.updateTracking();
        }
    }
}