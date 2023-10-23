package com.nyfaria.nyfsgenetics.client.renderlayers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.nyfaria.nyfsgenetics.Constants;
import com.nyfaria.nyfsgenetics.api.VillagerGenes;
import com.nyfaria.nyfsgenetics.platform.Services;
import com.nyfaria.nyfsgenetics.traits.EyeBrow;
import com.nyfaria.nyfsgenetics.traits.HairColor;
import com.nyfaria.nyfsgenetics.traits.SkinTone;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.VillagerHeadModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.Villager;

public class VillagerEyeBrowRenderLayer<T extends Villager, M extends EntityModel<T> & VillagerHeadModel> extends RenderLayer<T, M> {
    public VillagerEyeBrowRenderLayer(RenderLayerParent<T, M> p_174550_) {
        super(p_174550_);
    }

    public void render(PoseStack p_117646_, MultiBufferSource p_117647_, int p_117648_, T villager, float p_117650_, float p_117651_, float p_117652_, float p_117653_, float p_117654_, float p_117655_) {
        if (!villager.isInvisible()) {
            VillagerGenes genes = Services.PLATFORM.getVillagerGenes(villager);
            M m = this.getParentModel();
            HairColor hairColor = genes.getHairColor();
            EyeBrow eyeBrow = genes.getEyeBrow();
            SkinTone skinTone = genes.getSkinTone();
            String eyeBrowString = "";
            if(eyeBrow == EyeBrow.NONE){
                eyeBrowString = eyeBrow.getName() + "_" + skinTone.getName();
            } else {
                eyeBrowString = eyeBrow.getName() + "_" + hairColor.getName();
            }
            ResourceLocation resourcelocation1 = new ResourceLocation(Constants.MODID, "textures/entity/villager/" + eyeBrowString + "_eyebrow.png");
            renderColoredCutoutModel(m, resourcelocation1, p_117646_, p_117647_, p_117648_, villager, 1.0F, 1.0F, 1.0F);
        }
    }
}