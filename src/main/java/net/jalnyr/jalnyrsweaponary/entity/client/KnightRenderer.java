package net.jalnyr.jalnyrsweaponary.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.jalnyr.jalnyrsweaponary.JalnyrsWeaponary;
import net.jalnyr.jalnyrsweaponary.entity.custom.KnightEntity;
import net.jalnyr.jalnyrsweaponary.entity.custom.OldManEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class KnightRenderer extends MobRenderer<KnightEntity, KnightModel<KnightEntity>> {

    public KnightRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new KnightModel<>(pContext.bakeLayer(ModModelLayers.KNIGHT_LAYER)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(KnightEntity pEntity) {
        return new ResourceLocation(JalnyrsWeaponary.MOD_ID, "textures/entity/knight.png");
    }

    @Override
    public void render(KnightEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(1f, 1f, 1f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
