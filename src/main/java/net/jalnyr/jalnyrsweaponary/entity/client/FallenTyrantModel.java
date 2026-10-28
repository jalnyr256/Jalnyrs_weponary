package net.jalnyr.jalnyrsweaponary.entity.client;// Made with Blockbench 5.2.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.jalnyr.jalnyrsweaponary.entity.animations.EliteKnightAnimation;
import net.jalnyr.jalnyrsweaponary.entity.animations.TyrantAnimations;
import net.jalnyr.jalnyrsweaponary.entity.custom.EliteKnightEntity;
import net.jalnyr.jalnyrsweaponary.entity.custom.FallenTyrantEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class FallenTyrantModel extends HierarchicalModel<FallenTyrantEntity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "fallen_tyrant"), "main");
	private final ModelPart tyrant;
	private final ModelPart body;
	private final ModelPart leg1;
	private final ModelPart nivel1;
	private final ModelPart nivel2;
	private final ModelPart nivel5;
	private final ModelPart leg2;
	private final ModelPart nivel3;
	private final ModelPart nivel4;
	private final ModelPart nivel6;
	private final ModelPart torso;
	private final ModelPart arm1;
	private final ModelPart arm2;
	private final ModelPart mace;
	private final ModelPart heart;
	private final ModelPart head;

	public FallenTyrantModel(ModelPart root) {
		this.tyrant = root.getChild("tyrant");
		this.body = this.tyrant.getChild("body");
		this.leg1 = this.body.getChild("leg1");
		this.nivel1 = this.leg1.getChild("nivel1");
		this.nivel2 = this.leg1.getChild("nivel2");
		this.nivel5 = this.leg1.getChild("nivel5");
		this.leg2 = this.body.getChild("leg2");
		this.nivel3 = this.leg2.getChild("nivel3");
		this.nivel4 = this.leg2.getChild("nivel4");
		this.nivel6 = this.leg2.getChild("nivel6");
		this.torso = this.body.getChild("torso");
		this.arm1 = this.torso.getChild("arm1");
		this.arm2 = this.torso.getChild("arm2");
		this.mace = this.arm2.getChild("mace");
		this.heart = this.torso.getChild("heart");
		this.head = this.torso.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition tyrant = partdefinition.addOrReplaceChild("tyrant", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = tyrant.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leg1 = body.addOrReplaceChild("leg1", CubeListBuilder.create(), PartPose.offset(-14.0F, -37.0F, 0.0F));

		PartDefinition nivel1 = leg1.addOrReplaceChild("nivel1", CubeListBuilder.create().texOffs(174, 142).addBox(-1.0F, 12.0F, -9.0F, 2.0F, 1.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(26, 178).addBox(-3.0F, 0.0F, -2.0F, 6.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(86, 180).addBox(1.0F, 12.0F, -7.0F, 3.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(146, 195).addBox(-4.0F, 12.0F, -5.0F, 3.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(206, 138).addBox(-2.0F, 10.0F, -4.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(102, 205).addBox(-2.0F, 0.0F, -3.0F, 4.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(202, 32).addBox(-2.0F, 0.0F, 2.0F, 4.0F, 11.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(216, 149).addBox(-1.0F, 10.0F, -6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(218, 211).addBox(-3.0F, 11.0F, -5.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(218, 215).addBox(2.0F, 11.0F, -5.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(58, 220).addBox(-2.0F, 11.0F, -6.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(220, 78).addBox(1.0F, 11.0F, -6.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(50, 220).addBox(-3.0F, 12.0F, -7.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(194, 207).addBox(3.0F, 0.0F, -1.0F, 1.0F, 11.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(206, 207).addBox(-4.0F, 0.0F, -1.0F, 1.0F, 11.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(174, 215).addBox(-1.0F, 1.0F, -4.0F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(122, 210).addBox(-1.0F, 1.0F, 3.0F, 2.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition nivel2 = leg1.addOrReplaceChild("nivel2", CubeListBuilder.create().texOffs(40, 147).addBox(-2.0F, 1.0F, -3.0F, 4.0F, 11.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(64, 211).addBox(-1.0F, 2.0F, -4.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(92, 200).addBox(-2.0F, 1.0F, 2.0F, 4.0F, 11.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(212, 207).addBox(-1.0F, 2.0F, 3.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(46, 178).addBox(-3.0F, 0.0F, -2.0F, 6.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(138, 205).addBox(3.0F, 1.0F, -1.0F, 1.0F, 11.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(200, 207).addBox(-4.0F, 1.0F, -1.0F, 1.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));

		PartDefinition nivel5 = leg1.addOrReplaceChild("nivel5", CubeListBuilder.create().texOffs(26, 204).addBox(-2.0F, 1.0F, -3.0F, 4.0F, 11.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(214, 170).addBox(-1.0F, 2.0F, -4.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(36, 204).addBox(-2.0F, 1.0F, 2.0F, 4.0F, 11.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(214, 180).addBox(-1.0F, 2.0F, 3.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(134, 179).addBox(-3.0F, 0.0F, -2.0F, 6.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(186, 208).addBox(3.0F, 1.0F, -1.0F, 1.0F, 11.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(208, 194).addBox(-4.0F, 1.0F, -1.0F, 1.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leg2 = body.addOrReplaceChild("leg2", CubeListBuilder.create(), PartPose.offset(14.0F, -37.0F, 0.0F));

		PartDefinition nivel3 = leg2.addOrReplaceChild("nivel3", CubeListBuilder.create().texOffs(176, 34).addBox(-1.0F, 12.0F, -9.0F, 2.0F, 1.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(178, 170).addBox(-3.0F, 0.0F, -2.0F, 6.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(174, 186).addBox(1.0F, 12.0F, -7.0F, 3.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(196, 63).addBox(-4.0F, 12.0F, -5.0F, 3.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(212, 10).addBox(-2.0F, 10.0F, -4.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(112, 205).addBox(-2.0F, 0.0F, -3.0F, 4.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(146, 203).addBox(-2.0F, 0.0F, 2.0F, 4.0F, 11.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(218, 27).addBox(-1.0F, 10.0F, -6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(72, 208).addBox(3.0F, 0.0F, -1.0F, 1.0F, 11.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(78, 208).addBox(-4.0F, 0.0F, -1.0F, 1.0F, 11.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(20, 216).addBox(-1.0F, 1.0F, -4.0F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(128, 210).addBox(-1.0F, 1.0F, 3.0F, 2.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(86, 164).addBox(-3.0F, 12.0F, -7.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(218, 103).addBox(-3.0F, 11.0F, -5.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(218, 138).addBox(2.0F, 11.0F, -5.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(218, 207).addBox(1.0F, 11.0F, -7.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(212, 117).addBox(-2.0F, 11.0F, -6.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition nivel4 = leg2.addOrReplaceChild("nivel4", CubeListBuilder.create().texOffs(156, 203).addBox(-2.0F, 1.0F, -3.0F, 4.0F, 11.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(214, 79).addBox(-1.0F, 2.0F, -4.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 204).addBox(-2.0F, 1.0F, 2.0F, 4.0F, 11.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(214, 107).addBox(-1.0F, 2.0F, 3.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(114, 179).addBox(-3.0F, 0.0F, -2.0F, 6.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(84, 208).addBox(3.0F, 1.0F, -1.0F, 1.0F, 11.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(180, 208).addBox(-4.0F, 1.0F, -1.0F, 1.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));

		PartDefinition nivel6 = leg2.addOrReplaceChild("nivel6", CubeListBuilder.create().texOffs(46, 204).addBox(-2.0F, 1.0F, -3.0F, 4.0F, 11.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(214, 190).addBox(-1.0F, 2.0F, -4.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(204, 79).addBox(-2.0F, 1.0F, 2.0F, 4.0F, 11.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(144, 215).addBox(-1.0F, 2.0F, 3.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(154, 179).addBox(-3.0F, 0.0F, -2.0F, 6.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 210).addBox(3.0F, 1.0F, -1.0F, 1.0F, 11.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(6, 210).addBox(-4.0F, 1.0F, -1.0F, 1.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 0).addBox(-18.0F, -40.0F, -7.0F, 36.0F, 40.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(0, 86).addBox(-14.0F, -27.0F, -9.0F, 28.0F, 20.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(100, 0).addBox(-13.0F, -27.0F, -11.0F, 26.0F, 20.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(64, 54).addBox(-13.0F, -37.0F, 7.0F, 26.0F, 35.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(120, 75).addBox(-13.0F, -7.0F, -9.0F, 26.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(70, 164).addBox(-16.0F, -40.0F, -9.0F, 2.0F, 32.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(78, 164).addBox(14.0F, -40.0F, -9.0F, 2.0F, 32.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(124, 93).addBox(-12.0F, -4.0F, -9.0F, 24.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(210, 96).addBox(-9.0F, -36.0F, -9.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(36, 133).addBox(-14.0F, -39.0F, -9.0F, 5.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(166, 196).addBox(9.0F, -39.0F, -9.0F, 5.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(210, 120).addBox(7.0F, -36.0F, -9.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(210, 14).addBox(-7.0F, -34.0F, -9.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(56, 211).addBox(5.0F, -34.0F, -9.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(98, 126).addBox(-5.0F, -32.0F, -9.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(214, 200).addBox(3.0F, -32.0F, -9.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(106, 190).addBox(-3.0F, -30.0F, -9.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(166, 210).addBox(-1.0F, -30.0F, -9.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(98, 154).addBox(9.0F, -42.0F, -5.0F, 7.0F, 2.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(150, 215).addBox(10.0F, -48.0F, -3.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(218, 219).addBox(8.0F, -48.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(158, 215).addBox(10.0F, -48.0F, 2.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(26, 220).addBox(8.0F, -48.0F, 2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(40, 159).addBox(10.0F, -48.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(166, 215).addBox(-12.0F, -48.0F, -3.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(34, 220).addBox(-10.0F, -48.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(12, 216).addBox(-12.0F, -48.0F, 2.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(42, 220).addBox(-10.0F, -48.0F, 2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(212, 158).addBox(-12.0F, -48.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(154, 120).addBox(-16.0F, -42.0F, -5.0F, 7.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -37.0F, 0.0F));

		PartDefinition arm1 = torso.addOrReplaceChild("arm1", CubeListBuilder.create().texOffs(50, 126).addBox(0.0F, 0.0F, -3.0F, 6.0F, 32.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(100, 40).addBox(6.0F, -1.0F, -4.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(106, 195).addBox(-2.0F, -1.0F, -4.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(190, 14).addBox(6.0F, 7.0F, -4.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(216, 71).addBox(6.0F, 1.0F, -4.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(216, 89).addBox(6.0F, 1.0F, 3.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(86, 190).addBox(6.0F, 15.0F, -4.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(102, 216).addBox(6.0F, 9.0F, -4.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(108, 216).addBox(6.0F, 9.0F, 3.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(114, 216).addBox(6.0F, 17.0F, 3.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(216, 142).addBox(6.0F, 17.0F, -4.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(190, 120).addBox(6.0F, 23.0F, -4.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 192).addBox(6.0F, 31.0F, -4.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(216, 163).addBox(6.0F, 25.0F, -4.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(90, 217).addBox(6.0F, 25.0F, 3.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(18.0F, -40.0F, 0.0F));

		PartDefinition cube_r1 = arm1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(198, 170).addBox(-1.0F, -2.0F, -4.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(76, 200).addBox(-1.0F, 30.0F, -4.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 1.0F, 3.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r2 = arm1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(200, 71).addBox(-1.0F, -2.0F, -4.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(60, 198).addBox(-1.0F, -34.0F, -4.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 33.0F, -3.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition arm2 = torso.addOrReplaceChild("arm2", CubeListBuilder.create().texOffs(74, 126).addBox(0.0F, 0.0F, -3.0F, 6.0F, 32.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(192, 53).addBox(-2.0F, -1.0F, -4.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(192, 154).addBox(-2.0F, 7.0F, -4.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(96, 217).addBox(-2.0F, 1.0F, -4.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(212, 217).addBox(-2.0F, 1.0F, 3.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 194).addBox(-2.0F, 15.0F, -4.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(218, 14).addBox(-2.0F, 9.0F, -4.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(218, 46).addBox(-2.0F, 9.0F, 3.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(218, 96).addBox(-2.0F, 17.0F, 3.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(218, 117).addBox(-2.0F, 17.0F, -4.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 194).addBox(-2.0F, 23.0F, -4.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(194, 107).addBox(-2.0F, 31.0F, -4.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(218, 124).addBox(-2.0F, 25.0F, -4.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(134, 218).addBox(-2.0F, 25.0F, 3.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(126, 195).addBox(6.0F, -1.0F, -4.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-24.0F, -40.0F, 0.0F));

		PartDefinition cube_r3 = arm2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 202).addBox(-1.0F, -2.0F, -4.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(198, 178).addBox(-1.0F, -34.0F, -4.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 33.0F, 3.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r4 = arm2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(200, 142).addBox(-1.0F, -2.0F, -4.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(198, 186).addBox(-1.0F, -34.0F, -4.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 33.0F, -3.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition mace = arm2.addOrReplaceChild("mace", CubeListBuilder.create().texOffs(0, 108).addBox(-2.0F, -3.0F, -21.0F, 4.0F, 4.0F, 21.0F, new CubeDeformation(0.0F))
		.texOffs(106, 109).addBox(-6.0F, -7.0F, -33.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(124, 98).addBox(-5.0F, -8.0F, -32.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(164, 98).addBox(-4.0F, -9.0F, -31.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(176, 46).addBox(-3.0F, -10.0F, -30.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(160, 34).addBox(-2.0F, -11.0F, -29.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(200, 91).addBox(-2.0F, 8.0F, -29.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(176, 72).addBox(-3.0F, 7.0F, -30.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(114, 170).addBox(-4.0F, 6.0F, -31.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(134, 133).addBox(-5.0F, 5.0F, -32.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 180).addBox(-5.0F, -6.0F, -21.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(60, 194).addBox(-1.0F, -4.0F, -4.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(212, 42).addBox(-1.0F, -4.0F, -8.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(212, 0).addBox(-1.0F, -4.0F, -18.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(212, 5).addBox(-1.0F, -4.0F, -13.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(212, 32).addBox(-1.0F, 1.0F, -13.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(212, 37).addBox(-1.0F, 1.0F, -18.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(216, 23).addBox(-1.0F, 1.0F, -8.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(26, 216).addBox(-1.0F, 1.0F, -4.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 29.0F, -3.0F));

		PartDefinition cube_r5 = mace.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(212, 153).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(216, 67).addBox(-1.0F, -1.0F, 7.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(216, 63).addBox(-1.0F, -1.0F, 3.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(90, 212).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -1.0F, -11.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition cube_r6 = mace.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(212, 58).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(212, 53).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(46, 216).addBox(-1.0F, -1.0F, 3.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(36, 216).addBox(-1.0F, -1.0F, 7.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -1.0F, -11.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition cube_r7 = mace.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(206, 133).addBox(-2.0F, -1.0F, -3.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, -2.0F, -27.0F, 1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r8 = mace.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(188, 7).addBox(-3.0F, -1.0F, -4.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, -2.0F, -27.0F, 1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r9 = mace.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(174, 133).addBox(-4.0F, -1.0F, -5.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -2.0F, -27.0F, 1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r10 = mace.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(154, 109).addBox(-5.0F, -1.0F, -6.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -2.0F, -27.0F, 1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r11 = mace.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 154).addBox(-5.0F, -1.0F, -6.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -2.0F, -27.0F, 1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r12 = mace.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(172, 80).addBox(-4.0F, -1.0F, -5.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -2.0F, -27.0F, 1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r13 = mace.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(188, 0).addBox(-3.0F, -1.0F, -4.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -2.0F, -27.0F, 1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r14 = mace.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(56, 206).addBox(-2.0F, -1.0F, -3.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -2.0F, -27.0F, 1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r15 = mace.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(134, 144).addBox(-5.0F, -1.0F, -6.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -33.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r16 = mace.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(146, 170).addBox(-4.0F, -1.0F, -5.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -34.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r17 = mace.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(176, 89).addBox(-3.0F, -1.0F, -4.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -35.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r18 = mace.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(122, 205).addBox(-2.0F, -1.0F, -3.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -36.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition heart = torso.addOrReplaceChild("heart", CubeListBuilder.create().texOffs(120, 84).addBox(0.0F, 1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(120, 86).addBox(-1.0F, 1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(120, 88).addBox(-2.0F, 0.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(36, 147).addBox(-3.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(36, 149).addBox(-4.0F, -2.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(156, 15).addBox(3.0F, -2.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(156, 17).addBox(2.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(156, 19).addBox(1.0F, 0.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(36, 151).addBox(-4.0F, -6.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(94, 164).addBox(3.0F, -6.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(176, 53).addBox(-3.0F, -7.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(164, 107).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(164, 72).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(184, 107).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(182, 96).addBox(-3.0F, -6.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(176, 96).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(178, 107).addBox(1.0F, -7.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(182, 53).addBox(1.0F, -6.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(60, 86).addBox(-5.0F, -5.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(120, 80).addBox(4.0F, -5.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(200, 46).addBox(-4.0F, -5.0F, -1.0F, 8.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -33.0F, -7.0F));

		PartDefinition head = torso.addOrReplaceChild("head", CubeListBuilder.create().texOffs(124, 80).addBox(-6.0F, -2.0F, -6.0F, 12.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(120, 40).addBox(-7.0F, -3.0F, -7.0F, 14.0F, 1.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(0, 54).addBox(-8.0F, -19.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 133).addBox(8.0F, -21.0F, -8.0F, 2.0F, 5.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(134, 155).addBox(8.0F, -16.0F, -8.0F, 2.0F, 1.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(160, 15).addBox(8.0F, -15.0F, -8.0F, 2.0F, 1.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(164, 55).addBox(8.0F, -14.0F, -8.0F, 2.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 165).addBox(8.0F, -13.0F, -8.0F, 2.0F, 4.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(166, 155).addBox(-10.0F, -13.0F, -8.0F, 2.0F, 4.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(196, 96).addBox(-10.0F, -9.0F, -8.0F, 2.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(194, 196).addBox(8.0F, -9.0F, -8.0F, 2.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(86, 167).addBox(-10.0F, -14.0F, -8.0F, 2.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(40, 164).addBox(-10.0F, -15.0F, -8.0F, 2.0F, 1.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(156, 0).addBox(-10.0F, -16.0F, -8.0F, 2.0F, 1.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(98, 133).addBox(-10.0F, -21.0F, -8.0F, 2.0F, 5.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(60, 91).addBox(-8.0F, -21.0F, -8.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(100, 22).addBox(-7.0F, -23.0F, -8.0F, 14.0F, 2.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(50, 109).addBox(-6.0F, -24.0F, -8.0F, 12.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(160, 29).addBox(-8.0F, -21.0F, -10.0F, 16.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(164, 68).addBox(-7.0F, -23.0F, -10.0F, 14.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(196, 28).addBox(-10.0F, -18.0F, -10.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(190, 24).addBox(-1.0F, -18.0F, -10.0F, 11.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(100, 50).addBox(2.0F, -16.0F, -10.0F, 8.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(190, 130).addBox(3.0F, -15.0F, -10.0F, 7.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(200, 50).addBox(4.0F, -14.0F, -10.0F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(200, 150).addBox(-10.0F, -14.0F, -10.0F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(26, 165).addBox(5.0F, -13.0F, -10.0F, 5.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(180, 196).addBox(-10.0F, -13.0F, -10.0F, 5.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(192, 164).addBox(-5.0F, -7.0F, -10.0F, 10.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(194, 117).addBox(-10.0F, -15.0F, -10.0F, 7.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(114, 167).addBox(-10.0F, -16.0F, -10.0F, 8.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(120, 55).addBox(-10.0F, -21.0F, 8.0F, 20.0F, 18.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -39.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}
    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		tyrant.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

    @Override
    public ModelPart root() {
        return tyrant;
    }

    @Override
    public void setupAnim(FallenTyrantEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

        this.animateWalk(TyrantAnimations.IDLE, limbSwing, limbSwingAmount, 2f, 1.5f);
        this.animate(entity.getAnimationState("idle"), TyrantAnimations.IDLE, ageInTicks, 1f);
        this.animate(entity.getAnimationState("attack"), TyrantAnimations.SMASH, ageInTicks, 1f);
    }
}