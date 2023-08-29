package com.nyfaria.nyfsgenetics.init;

import com.nyfaria.nyfsgenetics.CommonClass;
import com.nyfaria.nyfsgenetics.Constants;
import com.nyfaria.nyfsgenetics.registration.EntityDataSerializerHelper;
import com.nyfaria.nyfsgenetics.traits.EyeColor;
import com.nyfaria.nyfsgenetics.traits.Height;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.resources.ResourceLocation;

public class DataSerializerInit {
//    public static final RegistrationProvider<EntityDataSerializer<?>> DATA_SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.ENTITY_DATA_SERIALIZERS, Constants.MODID);
    public static final EntityDataSerializer<EyeColor> EYE_COLOR = EntityDataSerializerHelper.INSTANCE.register(new ResourceLocation(Constants.MODID,"eye_color"),CommonClass.EYE_COLOR);
    public static final EntityDataSerializer<Height> HEIGHT = EntityDataSerializerHelper.INSTANCE.register(new ResourceLocation(Constants.MODID,"height"),CommonClass.HEIGHT);

}
