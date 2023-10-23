package com.nyfaria.nyfsgenetics.init;

import com.mojang.brigadier.CommandDispatcher;
import com.nyfaria.nyfsgenetics.platform.Services;
import com.nyfaria.nyfsgenetics.traits.EyeBrow;
import com.nyfaria.nyfsgenetics.traits.EyeColor;
import com.nyfaria.nyfsgenetics.traits.HairColor;
import com.nyfaria.nyfsgenetics.traits.HairType;
import com.nyfaria.nyfsgenetics.traits.Height;
import com.nyfaria.nyfsgenetics.traits.NoseSize;
import com.nyfaria.nyfsgenetics.traits.SkinTone;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.world.entity.npc.Villager;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.EnumArgument;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommandInit {

//    @SubscribeEvent
//    public static void registerCommands(RegisterCommandsEvent event) {
//        event.getDispatcher().register(Commands.literal("genes")
//                .then(Commands.argument("villager", EntityArgument.entity())
//                        .then(Commands.literal("skintone")
//                                .then(Commands.argument("tone", EnumArgument.enumArgument(SkinTone.class))
//                                        .executes(
//                                                ctx -> {
//                                                    if (EntityArgument.getEntity(ctx, "villager") instanceof Villager villager) {
//                                                        Services.PLATFORM.getVillagerGenes(villager).setSkinTone(ctx.getArgument("tone", SkinTone.class),true);
//                                                    }
//                                                    return 1;
//                                                }
//                                        )
//                                )
//                        )
//                        .then(Commands.literal("hair_color")
//                                .then(Commands.argument("color", EnumArgument.enumArgument(HairColor.class))
//                                        .executes(
//                                                ctx -> {
//                                                    if (EntityArgument.getEntity(ctx, "villager") instanceof Villager villager) {
//                                                        Services.PLATFORM.getVillagerGenes(villager).setHairColor(ctx.getArgument("color", HairColor.class),true);
//                                                    }
//                                                    return 1;
//                                                }
//                                        )
//                                )
//
//                        )
//                        .then(Commands.literal("eye_color")
//                                .then(Commands.argument("color", EnumArgument.enumArgument(EyeColor.class))
//                                        .executes(
//                                                ctx -> {
//                                                    if (EntityArgument.getEntity(ctx, "villager") instanceof Villager villager) {
//                                                        Services.PLATFORM.getVillagerGenes(villager).setEyeColor(ctx.getArgument("color", EyeColor.class),true);
//                                                    }
//                                                    return 1;
//                                                }
//                                        )
//                                )
//
//                        )
//                        .then(Commands.literal("hair_type")
//                                .then(Commands.argument("type", EnumArgument.enumArgument(HairType.class))
//                                        .executes(
//                                                ctx -> {
//                                                    if (EntityArgument.getEntity(ctx, "villager") instanceof Villager villager) {
//                                                        Services.PLATFORM.getVillagerGenes(villager).setHairType(ctx.getArgument("type", HairType.class),true);
//                                                    }
//                                                    return 1;
//                                                }
//                                        )
//                                )
//                        )
//                        .then(Commands.literal("eyebrow")
//                                .then(Commands.argument("type", EnumArgument.enumArgument(EyeBrow.class))
//                                        .executes(
//                                                ctx -> {
//                                                    if (EntityArgument.getEntity(ctx, "villager") instanceof Villager villager) {
//                                                        Services.PLATFORM.getVillagerGenes(villager).setEyeBrow( ctx.getArgument("type", EyeBrow.class),true);
//                                                    }
//                                                    return 1;
//                                                }
//                                        )
//                                )
//                        )
//                        .then(Commands.literal("height")
//                                .then(Commands.argument("height", EnumArgument.enumArgument(Height.class))
//                                        .executes(
//                                                ctx -> {
//                                                    if (EntityArgument.getEntity(ctx, "villager") instanceof Villager villager) {
//                                                        Services.PLATFORM.getVillagerGenes(villager).setHeight(ctx.getArgument("height", Height.class),true);
//                                                    }
//                                                    return 1;
//                                                }
//                                        )
//                                )
//                        )
//                        .then(Commands.literal("nose_size")
//                                .then(Commands.argument("size", EnumArgument.enumArgument(NoseSize.class))
//                                        .executes(
//                                                ctx -> {
//                                                    if (EntityArgument.getEntity(ctx, "villager") instanceof Villager villager) {
//                                                        Services.PLATFORM.getVillagerGenes(villager).setNoseSize( ctx.getArgument("size", NoseSize.class),true);
//                                                    }
//                                                    return 1;
//                                                }
//                                        )
//                                )
//                        )
//                )
//        );
//    }
}
