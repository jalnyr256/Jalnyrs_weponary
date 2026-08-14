package net.jalnyr.jalnyrsweaponary.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.jalnyr.jalnyrsweaponary.JalnyrsWeaponary;
import net.jalnyr.jalnyrsweaponary.entity.custom.EliteKnightEntity;
import net.jalnyr.jalnyrsweaponary.entity.custom.KnightEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class EliteKnightRenderer extends MobRenderer<EliteKnightEntity, EliteKnightModel> {

    public EliteKnightRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new EliteKnightModel(pContext.bakeLayer(ModModelLayers.ELITE_KNIGHT_LAYER)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(EliteKnightEntity pEntity) {
        return new ResourceLocation(JalnyrsWeaponary.MOD_ID, "textures/entity/elite_knight.png");
    }

    @Override
    public void render(EliteKnightEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(1f, 3f, 1f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
