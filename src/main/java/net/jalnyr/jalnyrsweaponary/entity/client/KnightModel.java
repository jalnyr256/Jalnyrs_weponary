package net.jalnyr.jalnyrsweaponary.entity.client;// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.jalnyr.jalnyrsweaponary.entity.animations.ModAnimationDefinitions;
import net.jalnyr.jalnyrsweaponary.entity.custom.KnightEntity;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class KnightModel<T extends Entity> extends HierarchicalModel<T> implements ArmedModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "knight"), "main");
	private final ModelPart knight;
	private final ModelPart body;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart torso;
	private final ModelPart arm1;
	private final ModelPart arm2;
	private final ModelPart head;

	public KnightModel(ModelPart root) {
		this.knight = root.getChild("knight");
		this.body = this.knight.getChild("body");
		this.leg1 = this.body.getChild("leg1");
		this.leg2 = this.body.getChild("leg2");
		this.torso = this.body.getChild("torso");
		this.arm1 = this.body.getChild("arm1");
		this.arm2 = this.body.getChild("arm2");
		this.head = this.body.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition knight = partdefinition.addOrReplaceChild("knight", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = knight.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leg1 = body.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(24, 16).addBox(-4.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 0.0F));

		PartDefinition leg2 = body.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(0, 32).addBox(0.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 0.0F));

		PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition arm1 = body.addOrReplaceChild("arm1", CubeListBuilder.create().texOffs(32, 0).addBox(0.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -24.0F, 0.0F));

		PartDefinition arm2 = body.addOrReplaceChild("arm2", CubeListBuilder.create().texOffs(16, 32).addBox(-4.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -24.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

        this.animateWalk(ModAnimationDefinitions.WALK, limbSwing, limbSwingAmount, 1f, 1.5f);
        this.animate(((KnightEntity) entity).idleAnimationState, ModAnimationDefinitions.IDLE, ageInTicks, 1f);
        this.animate(((KnightEntity) entity).attackAnimationState, ModAnimationDefinitions.ATTACK, ageInTicks, 1f);
    }


    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }
    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        knight.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
    @Override
    public void translateToHand(HumanoidArm arm, PoseStack poseStack) {
        body.translateAndRotate(poseStack);
        torso.translateAndRotate(poseStack);
        if (arm == HumanoidArm.RIGHT) {
            arm1.translateAndRotate(poseStack);
            poseStack.translate(0.0F, 0.0F, 0.0F);
        } else {
           arm2.translateAndRotate(poseStack);
           poseStack.translate(0.0F, 0.0F, 0.0F);
        }
    }

    @Override
    public ModelPart root() {
        return knight;
    }
}