package net.jalnyr.jalnyrsweaponary.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.jalnyr.jalnyrsweaponary.JalnyrsWeaponary;
import net.jalnyr.jalnyrsweaponary.entity.custom.OldManEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class OldManRenderer extends MobRenderer<OldManEntity, OldManModel<OldManEntity>> {

    public OldManRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new OldManModel<>(pContext.bakeLayer(ModModelLayers.OLD_MAN_LAYER)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(OldManEntity pEntity) {
        return new ResourceLocation(JalnyrsWeaponary.MOD_ID, "textures/entity/oldman.png");
    }

    @Override
    public void render(OldManEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
