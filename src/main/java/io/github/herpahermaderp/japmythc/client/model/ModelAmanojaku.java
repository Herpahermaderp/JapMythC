package io.github.herpahermaderp.japmythc.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAmanojaku extends ModelBase {
	
  //fields
    ModelRenderer Rightarm2;
    ModelRenderer LeftArm2;
    ModelRenderer RightLeg2;
    ModelRenderer LeftLeg2;
    ModelRenderer Horn;
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
  
  public ModelAmanojaku() {
	  
    textureWidth = 64;
    textureHeight = 64;
    
      Rightarm2 = new ModelRenderer(this, 37, 46);
      Rightarm2.addBox(0F, 0F, 0F, 3, 3, 8);
      Rightarm2.setRotationPoint(-8F, 10F, -7F);
      Rightarm2.setTextureSize(64, 64);
      Rightarm2.mirror = true;
      setRotation(Rightarm2, 0F, 0F, 0F);
      LeftArm2 = new ModelRenderer(this, 33, 3);
      LeftArm2.addBox(0F, 0F, 0F, 3, 3, 8);
      LeftArm2.setRotationPoint(5F, 10F, -7F);
      LeftArm2.setTextureSize(64, 64);
      LeftArm2.mirror = true;
      setRotation(LeftArm2, 0F, 0F, 0F);
      RightLeg2 = new ModelRenderer(this, 2, 50);
      RightLeg2.addBox(0F, 0F, 0F, 3, 1, 2);
      RightLeg2.setRotationPoint(-4F, 23F, -4F);
      RightLeg2.setTextureSize(64, 64);
      RightLeg2.mirror = true;
      setRotation(RightLeg2, 0F, 0F, 0F);
      LeftLeg2 = new ModelRenderer(this, 2, 55);
      LeftLeg2.addBox(0F, 0F, 0F, 3, 1, 2);
      LeftLeg2.setRotationPoint(1F, 23F, -4F);
      LeftLeg2.setTextureSize(64, 64);
      LeftLeg2.mirror = true;
      setRotation(LeftLeg2, 0F, 0F, 0F);
      Horn = new ModelRenderer(this, 25, 40);
      Horn.addBox(0F, 0F, 0F, 2, 4, 1);
      Horn.setRotationPoint(-1F, -9F, -7F);
      Horn.setTextureSize(64, 64);
      Horn.mirror = true;
      setRotation(Horn, 0.5061455F, 0F, 0F);
      head = new ModelRenderer(this, 1, 1);
      head.addBox(-5F, -8F, -4F, 8, 7, 7);
      head.setRotationPoint(1F, 1F, -2F);
      head.setTextureSize(64, 64);
      head.mirror = true;
      setRotation(head, 0.2094395F, 0F, 0F);
      body = new ModelRenderer(this, 16, 16);
      body.addBox(-4F, 0F, -2F, 8, 12, 4);
      body.setRotationPoint(0F, 0F, -2F);
      body.setTextureSize(64, 64);
      body.mirror = true;
      setRotation(body, 0.1919862F, 0F, 0F);
      rightarm = new ModelRenderer(this, 41, 31);
      rightarm.addBox(-3F, -2F, -2F, 3, 11, 3);
      rightarm.setRotationPoint(-4F, 2F, 0F);
      rightarm.setTextureSize(64, 64);
      rightarm.mirror = true;
      setRotation(rightarm, 0F, 0F, 0.1745329F);
      leftarm = new ModelRenderer(this, 41, 16);
      leftarm.addBox(-1F, -2F, -2F, 3, 11, 3);
      leftarm.setRotationPoint(5F, 2F, 0F);
      leftarm.setTextureSize(64, 64);
      leftarm.mirror = true;
      setRotation(leftarm, 0F, 0F, -0.1745329F);
      rightleg = new ModelRenderer(this, 1, 33);
      rightleg.addBox(-2F, 0F, -2F, 3, 12, 3);
      rightleg.setRotationPoint(-2F, 12F, 0F);
      rightleg.setTextureSize(64, 64);
      rightleg.mirror = true;
      setRotation(rightleg, 0F, 0F, 0F);
      leftleg = new ModelRenderer(this, 1, 17);
      leftleg.addBox(-2F, 0F, -2F, 3, 12, 3);
      leftleg.setRotationPoint(3F, 12F, 0F);
      leftleg.setTextureSize(64, 64);
      leftleg.mirror = true;
      setRotation(leftleg, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
	  
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Rightarm2.render(f5);
    LeftArm2.render(f5);
    RightLeg2.render(f5);
    LeftLeg2.render(f5);
    Horn.render(f5);
    head.render(f5);
    body.render(f5);
    rightarm.render(f5);
    leftarm.render(f5);
    rightleg.render(f5);
    leftleg.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z) {
	  
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
