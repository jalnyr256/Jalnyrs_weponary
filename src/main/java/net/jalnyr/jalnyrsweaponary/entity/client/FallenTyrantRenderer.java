package net.jalnyr.jalnyrsweaponary.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.jalnyr.jalnyrsweaponary.JalnyrsWeaponary;
import net.jalnyr.jalnyrsweaponary.entity.custom.EliteKnightEntity;
import net.jalnyr.jalnyrsweaponary.entity.custom.FallenTyrantEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class FallenTyrantRenderer extends MobRenderer<FallenTyrantEntity, FallenTyrantModel> {

    public FallenTyrantRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new FallenTyrantModel(pContext.bakeLayer(ModModelLayers.FALLEN_TYRANT_LAYER)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(FallenTyrantEntity pEntity) {
        return new ResourceLocation(JalnyrsWeaponary.MOD_ID, "textures/entity/fallen_tyrant.png");
    }

    @Override
    public void render(FallenTyrantEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(1f, 3f, 1f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
