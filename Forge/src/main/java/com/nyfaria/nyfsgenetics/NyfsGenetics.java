package com.nyfaria.nyfsgenetics;

import com.nyfaria.nyfsgenetics.cap.VillagerGeneticsHolderAttacher;
import com.nyfaria.nyfsgenetics.datagen.ModBlockStateProvider;
import com.nyfaria.nyfsgenetics.datagen.ModItemModelProvider;
import com.nyfaria.nyfsgenetics.datagen.ModLangProvider;
import com.nyfaria.nyfsgenetics.datagen.ModLootTableProvider;
import com.nyfaria.nyfsgenetics.datagen.ModRecipeProvider;
import com.nyfaria.nyfsgenetics.datagen.ModSoundProvider;
import com.nyfaria.nyfsgenetics.datagen.ModTagProvider;
import com.nyfaria.nyfsgenetics.init.DataSerializerInit;
import com.nyfaria.nyfsgenetics.network.NetworkHandler;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.MODID)
public class NyfsGenetics {
    
    public NyfsGenetics() {
    
        // This method is invoked by the Forge mod loader when it is ready
        // to load your mod. You can access Forge and Common code in this
        // project.
    
        // Use Forge to bootstrap the Common mod.
        Constants.LOG.info("Hello Forge world!");
        CommonClass.init();
//        DataSerializerInit.DATA_SERIALIZERS.register(FMLJavaModLoadingContext.get().getModEventBus());
        NetworkHandler.register();
        VillagerGeneticsHolderAttacher.register();
        
    }

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        PackOutput packOutput = event.getGenerator().getPackOutput();
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        boolean includeServer = event.includeServer();
        boolean includeClient = event.includeClient();
        generator.addProvider(includeServer, new ModRecipeProvider(packOutput));
        generator.addProvider(includeServer, new ModLootTableProvider(packOutput));
        generator.addProvider(includeServer, new ModSoundProvider(packOutput, existingFileHelper));
        generator.addProvider(includeServer, new ModTagProvider.Blocks(packOutput,event.getLookupProvider(), existingFileHelper));
        generator.addProvider(includeServer, new ModTagProvider.Items(packOutput,event.getLookupProvider(), existingFileHelper));
        generator.addProvider(includeClient, new ModItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(includeClient, new ModBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(includeClient, new ModLangProvider(packOutput));
    }
}