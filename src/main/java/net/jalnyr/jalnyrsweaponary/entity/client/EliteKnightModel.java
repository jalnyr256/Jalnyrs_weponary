package net.jalnyr.jalnyrsweaponary.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.jalnyr.jalnyrsweaponary.entity.animations.EliteKnightAnimation;
import net.jalnyr.jalnyrsweaponary.entity.animations.ModAnimationDefinitions;
import net.jalnyr.jalnyrsweaponary.entity.custom.EliteKnightEntity;
import net.jalnyr.jalnyrsweaponary.entity.custom.KnightEntity;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.HumanoidArm;

public class EliteKnightModel extends HierarchicalModel<EliteKnightEntity>{
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "eliteknight"), "main");
    private final ModelPart eliteknight;
    private final ModelPart body;
    private final ModelPart arm2;
    private final ModelPart hand2;
    private final ModelPart arm1;
    private final ModelPart hand1;
    private final ModelPart sword;
    private final ModelPart leg1;
    private final ModelPart leg2;
    private final ModelPart torso;
    private final ModelPart chain;
    private final ModelPart chain2;
    private final ModelPart head;

    public EliteKnightModel(ModelPart root) {
        this.eliteknight = root.getChild("eliteknight");
        this.body = this.eliteknight.getChild("body");
        this.arm2 = this.body.getChild("arm2");
        this.hand2 = this.arm2.getChild("hand2");
        this.arm1 = this.body.getChild("arm1");
        this.hand1 = this.arm1.getChild("hand1");
        this.sword = this.hand1.getChild("sword");
        this.leg1 = this.body.getChild("leg1");
        this.leg2 = this.body.getChild("leg2");
        this.torso = this.body.getChild("torso");
        this.chain = this.torso.getChild("chain");
        this.chain2 = this.torso.getChild("chain2");
        this.head = this.body.getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition elite_knight = partdefinition.addOrReplaceChild("eliteknight", CubeListBuilder.create(), PartPose.offset(-7.0F, 24.0F, 0.0F));

        PartDefinition body = elite_knight.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition arm2 = body.addOrReplaceChild("arm2", CubeListBuilder.create().texOffs(72, 87).addBox(-4.0F, 0.0F, -2.0F, 4.0F, 21.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 90).addBox(-5.0F, 1.0F, -1.0F, 1.0F, 19.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(18, 90).addBox(-3.0F, 1.0F, -3.0F, 2.0F, 19.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(94, 87).addBox(-3.0F, 1.0F, 2.0F, 2.0F, 19.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -40.0F, 0.0F));

        PartDefinition hand2 = arm2.addOrReplaceChild("hand2", CubeListBuilder.create().texOffs(98, 59).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(110, 84).addBox(1.0F, 1.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(110, 87).addBox(0.0F, 1.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(110, 90).addBox(-1.0F, 1.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(110, 93).addBox(-2.0F, 1.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 21.0F, 0.0F));

        PartDefinition arm1 = body.addOrReplaceChild("arm1", CubeListBuilder.create().texOffs(56, 87).addBox(0.0F, 0.0F, -2.0F, 4.0F, 21.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(88, 87).addBox(4.0F, 1.0F, -1.0F, 1.0F, 19.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(6, 90).addBox(1.0F, 1.0F, -3.0F, 2.0F, 19.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 90).addBox(1.0F, 1.0F, 2.0F, 2.0F, 19.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(16.0F, -40.0F, 0.0F));

        PartDefinition hand1 = arm1.addOrReplaceChild("hand1", CubeListBuilder.create().texOffs(98, 9).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(40, 60).addBox(1.0F, 1.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(110, 75).addBox(0.0F, 1.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(110, 78).addBox(-1.0F, 1.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(110, 81).addBox(-2.0F, 1.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 21.0F, 0.0F));

        PartDefinition sword = hand1.addOrReplaceChild("sword", CubeListBuilder.create().texOffs(34, 99).addBox(-1.0F, -2.0F, -5.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(36, 108).addBox(-1.0F, -5.0F, -5.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(108, 41).addBox(-1.0F, 0.0F, -5.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(46, 14).addBox(-1.0F, -2.0F, -23.0F, 2.0F, 2.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(68, 73).addBox(-1.0F, -4.0F, -17.0F, 2.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(28, 85).addBox(-1.0F, 0.0F, -17.0F, 2.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(96, 73).addBox(-1.0F, -3.0F, -22.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(96, 79).addBox(-1.0F, 0.0F, -22.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));

        PartDefinition leg1 = body.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(86, 27).addBox(-1.0F, 14.0F, -4.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(28, 68).addBox(-1.0F, 0.0F, -1.0F, 4.0F, 14.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(104, 27).addBox(-1.0F, 9.0F, -2.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(92, 41).addBox(-2.0F, 9.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(108, 52).addBox(3.0F, 9.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(104, 30).addBox(-1.0F, 9.0F, 1.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(34, 105).addBox(-1.0F, 3.0F, 1.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(44, 109).addBox(3.0F, 3.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(50, 109).addBox(-2.0F, 3.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(44, 106).addBox(-1.0F, 3.0F, -2.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(6, 110).addBox(3.0F, 14.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(110, 9).addBox(-2.0F, 14.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(106, 62).addBox(-1.0F, 14.0F, 1.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(40, 51).addBox(3.0F, 3.0F, -2.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 90).addBox(-2.0F, 3.0F, -2.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(100, 106).addBox(-2.0F, 3.0F, 1.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(104, 106).addBox(3.0F, 3.0F, 1.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -16.0F, 0.0F));

        PartDefinition leg2 = body.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(92, 34).addBox(-1.0F, 14.0F, -4.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(86, 46).addBox(-1.0F, 0.0F, -1.0F, 4.0F, 14.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(106, 65).addBox(-1.0F, 9.0F, -2.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 110).addBox(-2.0F, 9.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(18, 110).addBox(3.0F, 9.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(106, 68).addBox(-1.0F, 9.0F, 1.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(108, 0).addBox(-1.0F, 3.0F, 1.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(110, 33).addBox(3.0F, 3.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(110, 37).addBox(-2.0F, 3.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(108, 3).addBox(-1.0F, 3.0F, -2.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(110, 56).addBox(3.0F, 14.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(110, 71).addBox(-2.0F, 14.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(108, 6).addBox(-1.0F, 14.0F, 1.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(94, 107).addBox(3.0F, 3.0F, -2.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 108).addBox(-2.0F, 3.0F, -2.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 108).addBox(-2.0F, 3.0F, 1.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(32, 108).addBox(3.0F, 3.0F, 1.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(12.0F, -16.0F, 0.0F));

        PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -24.0F, -2.0F, 18.0F, 24.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(98, 0).addBox(1.0F, -8.0F, -4.0F, 3.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(98, 41).addBox(-4.0F, -8.0F, -4.0F, 3.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(98, 50).addBox(-8.0F, -8.0F, -4.0F, 3.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(24, 99).addBox(5.0F, -8.0F, -4.0F, 3.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(46, 46).addBox(-8.0F, -22.0F, -6.0F, 16.0F, 13.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(46, 99).addBox(5.0F, -9.0F, 2.0F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(100, 85).addBox(-8.0F, -9.0F, 2.0F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(100, 92).addBox(-4.0F, -9.0F, 2.0F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(100, 99).addBox(1.0F, -9.0F, 2.0F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 51).addBox(-8.0F, -22.0F, 2.0F, 16.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, -16.0F, 0.0F));

        PartDefinition chain = torso.addOrReplaceChild("chain", CubeListBuilder.create().texOffs(56, 85).addBox(0.0F, -8.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(110, 102).addBox(-1.0F, -9.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(98, 12).addBox(-1.0F, -7.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(60, 85).addBox(-2.0F, -8.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 85).addBox(-2.0F, -6.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(96, 85).addBox(0.0F, -6.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(102, 12).addBox(-1.0F, -5.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(106, 12).addBox(0.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(106, 71).addBox(-2.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(110, 60).addBox(-2.0F, -4.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(110, 96).addBox(-1.0F, -3.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(110, 98).addBox(0.0F, -4.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(110, 100).addBox(-1.0F, -1.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(110, 104).addBox(1.0F, -1.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(112, 15).addBox(3.0F, -1.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(112, 17).addBox(3.0F, -3.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(112, 19).addBox(4.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 111).addBox(1.0F, -3.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(112, 13).addBox(2.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(112, 21).addBox(5.0F, -1.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(112, 23).addBox(7.0F, -3.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(112, 25).addBox(6.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(56, 112).addBox(5.0F, -3.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(60, 112).addBox(6.0F, -4.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 112).addBox(5.0F, -5.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(68, 112).addBox(7.0F, -5.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(72, 112).addBox(6.0F, -6.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(76, 112).addBox(5.0F, -7.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(80, 112).addBox(7.0F, -7.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(84, 112).addBox(6.0F, -8.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(112, 106).addBox(5.0F, -9.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(112, 108).addBox(7.0F, -9.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(112, 110).addBox(-5.0F, -1.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(114, 27).addBox(-4.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(114, 29).addBox(-3.0F, -1.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(114, 31).addBox(-3.0F, -3.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(112, 112).addBox(-5.0F, -3.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 113).addBox(-8.0F, -8.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(114, 46).addBox(-7.0F, -9.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 113).addBox(-7.0F, -7.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(40, 113).addBox(-6.0F, -6.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(44, 113).addBox(-8.0F, -6.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(48, 113).addBox(-7.0F, -5.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(52, 113).addBox(-6.0F, -4.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 114).addBox(-8.0F, -4.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 114).addBox(-7.0F, -3.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 114).addBox(-8.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 114).addBox(-6.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(114, 48).addBox(-7.0F, -1.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(20, 114).addBox(-6.0F, -8.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition chain2 = torso.addOrReplaceChild("chain2", CubeListBuilder.create().texOffs(114, 50).addBox(0.0F, -8.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(114, 52).addBox(-1.0F, -9.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(114, 54).addBox(-1.0F, -7.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(56, 114).addBox(-2.0F, -8.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(60, 114).addBox(-2.0F, -6.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(114, 60).addBox(0.0F, -6.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 114).addBox(-1.0F, -5.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(68, 114).addBox(0.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(72, 114).addBox(-2.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(114, 75).addBox(-2.0F, -4.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(76, 114).addBox(-1.0F, -3.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(114, 77).addBox(0.0F, -4.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(114, 79).addBox(-1.0F, -1.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(80, 114).addBox(1.0F, -1.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(114, 81).addBox(3.0F, -1.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(114, 83).addBox(3.0F, -3.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(84, 114).addBox(4.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(114, 85).addBox(1.0F, -3.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(114, 87).addBox(2.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(114, 89).addBox(5.0F, -1.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(114, 91).addBox(7.0F, -3.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(114, 93).addBox(6.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(114, 95).addBox(5.0F, -3.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(114, 97).addBox(6.0F, -4.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(114, 99).addBox(5.0F, -5.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(114, 101).addBox(7.0F, -5.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(114, 103).addBox(6.0F, -6.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(108, 114).addBox(5.0F, -7.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(112, 114).addBox(7.0F, -7.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 115).addBox(6.0F, -8.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 115).addBox(5.0F, -9.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(40, 115).addBox(7.0F, -9.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(44, 115).addBox(-5.0F, -1.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(48, 115).addBox(-4.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(52, 115).addBox(-3.0F, -1.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(98, 115).addBox(-3.0F, -3.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(102, 115).addBox(-5.0F, -3.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 116).addBox(-8.0F, -8.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 116).addBox(-7.0F, -9.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(116, 9).addBox(-7.0F, -7.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(116, 11).addBox(-6.0F, -6.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 116).addBox(-8.0F, -6.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(116, 13).addBox(-7.0F, -5.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(116, 15).addBox(-6.0F, -4.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 116).addBox(-8.0F, -4.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(116, 17).addBox(-7.0F, -3.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(116, 19).addBox(-8.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(20, 116).addBox(-6.0F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(116, 21).addBox(-7.0F, -1.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(116, 23).addBox(-6.0F, -8.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 28).addBox(-6.0F, -12.0F, -6.0F, 12.0F, 12.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(44, 0).addBox(-7.0F, -13.0F, -7.0F, 14.0F, 1.0F, 13.0F, new CubeDeformation(0.0F))
                .texOffs(40, 63).addBox(-7.0F, -12.0F, -7.0F, 1.0F, 9.0F, 13.0F, new CubeDeformation(0.0F))
                .texOffs(0, 68).addBox(6.0F, -12.0F, -7.0F, 1.0F, 9.0F, 13.0F, new CubeDeformation(0.0F))
                .texOffs(86, 24).addBox(-6.0F, -12.0F, -7.0F, 12.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(108, 46).addBox(-1.0F, -10.0F, -7.0F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(88, 108).addBox(-6.0F, -10.0F, -7.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(108, 106).addBox(5.0F, -10.0F, -7.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(46, 34).addBox(-6.0F, -14.0F, -6.0F, 12.0F, 1.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(68, 63).addBox(-5.0F, -15.0F, -5.0F, 10.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(86, 14).addBox(-6.0F, -12.0F, 5.0F, 12.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, -40.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }
    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        eliteknight.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return eliteknight;
    }

    @Override
    public void setupAnim(EliteKnightEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

        this.animateWalk(EliteKnightAnimation.WALK, limbSwing, limbSwingAmount, 2f, 1.5f);
        this.animate(entity.getAnimationState("idle"), EliteKnightAnimation.IDLE, ageInTicks, 1f);
        this.animate(entity.getAnimationState("attack"), EliteKnightAnimation.ATTACK, ageInTicks, 1f);
        this.animate(entity.getAnimationState("attack2"), EliteKnightAnimation.ATTACK2, ageInTicks, 1f);
        this.animate(entity.getAnimationState("attack3"), EliteKnightAnimation.ATTACK3, ageInTicks, 1f);
    }
}