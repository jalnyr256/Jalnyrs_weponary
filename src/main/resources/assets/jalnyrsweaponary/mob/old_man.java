// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class old_man<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "old_man"), "main");
	private final ModelPart old_man;
	private final ModelPart body;
	private final ModelPart torso;
	private final ModelPart beard;

	public old_man(ModelPart root) {
		this.old_man = root.getChild("old_man");
		this.body = this.old_man.getChild("body");
		this.torso = this.body.getChild("torso");
		this.beard = this.body.getChild("beard");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition old_man = partdefinition.addOrReplaceChild("old_man", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = old_man.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(24, 16).addBox(-4.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 32).addBox(0.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 16).addBox(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-4.0F, -32.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(32, 0).addBox(4.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(16, 32).addBox(-8.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition beard = body.addOrReplaceChild("beard", CubeListBuilder.create().texOffs(32, 32).addBox(-1.0F, -25.0F, -5.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(38, 32).addBox(-2.0F, -25.0F, -5.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 16).addBox(1.0F, -25.0F, -5.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 25).addBox(2.0F, -25.0F, -5.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(42, 31).addBox(-4.0F, -25.0F, -5.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 42).addBox(3.0F, -25.0F, -5.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(38, 41).addBox(-3.0F, -25.0F, -5.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 1.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		old_man.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}