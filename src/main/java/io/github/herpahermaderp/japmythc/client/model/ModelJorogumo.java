package io.github.herpahermaderp.japmythc.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelJorogumo extends ModelBase
{
  //fields
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Leg3;
    ModelRenderer Leg4;
    ModelRenderer Leg5;
    ModelRenderer Leg6;
    ModelRenderer Leg7;
    ModelRenderer Leg8;
    ModelRenderer leg9;
    ModelRenderer leg10;
    ModelRenderer leg11;
    ModelRenderer leg12;
    ModelRenderer leg13;
    ModelRenderer leg14;
    ModelRenderer leg15;
    ModelRenderer leg16;
    ModelRenderer HairKnokt;
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer Breast1;
    ModelRenderer Breast2;
  
  public ModelJorogumo()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      Leg1 = new ModelRenderer(this, 82, 0);
      Leg1.addBox(0F, 0F, 0F, 1, 1, 12);
      Leg1.setRotationPoint(2F, 1F, 2F);
      Leg1.setTextureSize(128, 128);
      Leg1.mirror = true;
      setRotation(Leg1, 0.2443461F, 0.9424778F, 0F);
      Leg2 = new ModelRenderer(this, 82, 14);
      Leg2.addBox(0F, 0F, 0F, 1, 1, 12);
      Leg2.setRotationPoint(2F, 4F, 2F);
      Leg2.setTextureSize(128, 128);
      Leg2.mirror = true;
      setRotation(Leg2, 0.2443461F, 0.9424778F, 0F);
      Leg3 = new ModelRenderer(this, 82, 28);
      Leg3.addBox(0F, 0F, 0F, 1, 1, 12);
      Leg3.setRotationPoint(2F, 7F, 2F);
      Leg3.setTextureSize(128, 128);
      Leg3.mirror = true;
      setRotation(Leg3, 0.2443461F, 0.9424778F, 0F);
      Leg4 = new ModelRenderer(this, 82, 42);
      Leg4.addBox(0F, 0F, 0F, 1, 1, 12);
      Leg4.setRotationPoint(2F, 10F, 2F);
      Leg4.setTextureSize(128, 128);
      Leg4.mirror = true;
      setRotation(Leg4, 0.2443461F, 0.9424778F, 0F);
      Leg5 = new ModelRenderer(this, 0, 34);
      Leg5.addBox(0F, 0F, 0F, 1, 1, 12);
      Leg5.setRotationPoint(-2F, 1F, 1F);
      Leg5.setTextureSize(128, 128);
      Leg5.mirror = true;
      setRotation(Leg5, 0.2443461F, -0.9424778F, 0F);
      Leg6 = new ModelRenderer(this, 0, 48);
      Leg6.addBox(0F, 0F, 0F, 1, 1, 12);
      Leg6.setRotationPoint(-2F, 4F, 1F);
      Leg6.setTextureSize(128, 128);
      Leg6.mirror = true;
      setRotation(Leg6, 0.2443461F, -0.9424778F, 0F);
      Leg7 = new ModelRenderer(this, 27, 34);
      Leg7.addBox(0F, 0F, 0F, 1, 1, 12);
      Leg7.setRotationPoint(-2F, 7F, 1F);
      Leg7.setTextureSize(128, 128);
      Leg7.mirror = true;
      setRotation(Leg7, 0.2443461F, -0.9424778F, 0F);
      Leg8 = new ModelRenderer(this, 27, 48);
      Leg8.addBox(0F, 0F, 0F, 1, 1, 12);
      Leg8.setRotationPoint(-2F, 10F, 1F);
      Leg8.setTextureSize(128, 128);
      Leg8.mirror = true;
      setRotation(Leg8, 0.2443461F, -0.9424778F, 0F);
      leg9 = new ModelRenderer(this, 1, 65);
      leg9.addBox(0F, 0F, 0F, 1, 3, 1);
      leg9.setRotationPoint(-11F, -2F, 8F);
      leg9.setTextureSize(128, 128);
      leg9.mirror = true;
      setRotation(leg9, 0F, 0.6457718F, 0.6806784F);
      leg10 = new ModelRenderer(this, 1, 72);
      leg10.addBox(0F, 0F, 0F, 1, 3, 1);
      leg10.setRotationPoint(-11F, 1F, 8F);
      leg10.setTextureSize(128, 128);
      leg10.mirror = true;
      setRotation(leg10, 0F, 0.6457718F, 0.6806784F);
      leg11 = new ModelRenderer(this, 1, 79);
      leg11.addBox(0F, 0F, 0F, 1, 3, 1);
      leg11.setRotationPoint(-11F, 4F, 8F);
      leg11.setTextureSize(128, 128);
      leg11.mirror = true;
      setRotation(leg11, 0F, 0.6457718F, 0.6806784F);
      leg12 = new ModelRenderer(this, 1, 86);
      leg12.addBox(0F, 0F, 0F, 1, 3, 1);
      leg12.setRotationPoint(-11F, 7F, 8F);
      leg12.setTextureSize(128, 128);
      leg12.mirror = true;
      setRotation(leg12, 0F, 0.6457718F, 0.6806784F);
      leg13 = new ModelRenderer(this, 71, 0);
      leg13.addBox(0F, 0F, 0F, 1, 3, 1);
      leg13.setRotationPoint(11F, -1F, 8F);
      leg13.setTextureSize(128, 128);
      setRotation(leg13, 0F, -0.5061455F, -0.8203047F);
      leg13.mirror = true;
      leg14 = new ModelRenderer(this, 71, 5);
      leg14.addBox(0F, 0F, 0F, 1, 3, 1);
      leg14.setRotationPoint(11F, 2F, 8F);
      leg14.setTextureSize(128, 128);
      leg14.mirror = true;
      setRotation(leg14, 0F, -0.5061455F, -0.6806784F);
      leg15 = new ModelRenderer(this, 71, 10);
      leg15.addBox(0F, 0F, 0F, 1, 3, 1);
      leg15.setRotationPoint(11F, 5F, 8F);
      leg15.setTextureSize(128, 128);
      leg15.mirror = true;
      setRotation(leg15, 0F, -0.5061455F, -0.6806784F);
      leg16 = new ModelRenderer(this, 71, 15);
      leg16.addBox(0F, 0F, 0F, 1, 3, 1);
      leg16.setRotationPoint(11F, 8F, 8F);
      leg16.setTextureSize(128, 128);
      leg16.mirror = true;
      setRotation(leg16, 0F, -0.5061455F, -0.6806784F);
      HairKnokt = new ModelRenderer(this, 1, 94);
      HairKnokt.addBox(0F, 0F, 0F, 6, 3, 5);
      HairKnokt.setRotationPoint(-3F, -11F, 3F);
      HairKnokt.setTextureSize(128, 128);
      HairKnokt.mirror = true;
      setRotation(HairKnokt, -0.5934119F, 0F, 0F);
      head = new ModelRenderer(this, 2, 7);
      head.addBox(-4F, -8F, -4F, 8, 8, 8);
      head.setRotationPoint(0F, 0F, 0F);
      head.setTextureSize(128, 128);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 36, 16);
      body.addBox(-4F, 0F, -2F, 8, 12, 4);
      body.setRotationPoint(0F, 0F, 0F);
      body.setTextureSize(128, 128);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      rightarm = new ModelRenderer(this, 39, 76);
      rightarm.addBox(-2F, -2F, -2F, 3, 12, 4);
      rightarm.setRotationPoint(-5F, 2F, 0F);
      rightarm.setTextureSize(128, 128);
      rightarm.mirror = true;
      setRotation(rightarm, 0F, 0F, 0.122173F);
      leftarm = new ModelRenderer(this, 54, 76);
      leftarm.addBox(-1F, -2F, -2F, 3, 12, 4);
      leftarm.setRotationPoint(5F, 2F, 0F);
      leftarm.setTextureSize(128, 128);
      leftarm.mirror = true;
      setRotation(leftarm, 0F, 0F, -0.122173F);
      rightleg = new ModelRenderer(this, 39, 96);
      rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
      rightleg.setRotationPoint(-2F, 12F, 0F);
      rightleg.setTextureSize(128, 128);
      rightleg.mirror = true;
      setRotation(rightleg, 0F, 0F, 0F);
      leftleg = new ModelRenderer(this, 57, 96);
      leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
      leftleg.setRotationPoint(2F, 12F, 0F);
      leftleg.setTextureSize(128, 128);
      leftleg.mirror = true;
      setRotation(leftleg, 0F, 0F, 0F);
      Breast1 = new ModelRenderer(this, 11, 70);
      Breast1.addBox(0F, 0F, 0F, 2, 2, 1);
      Breast1.setRotationPoint(1F, 2F, -3F);
      Breast1.setTextureSize(128, 128);
      Breast1.mirror = true;
      setRotation(Breast1, 0F, 0F, 0F);
      Breast2 = new ModelRenderer(this, 11, 65);
      Breast2.addBox(0F, 0F, 0F, 2, 2, 1);
      Breast2.setRotationPoint(-3F, 2F, -3F);
      Breast2.setTextureSize(128, 128);
      Breast2.mirror = true;
      setRotation(Breast2, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Leg1.render(f5);
    Leg2.render(f5);
    Leg3.render(f5);
    Leg4.render(f5);
    Leg5.render(f5);
    Leg6.render(f5);
    Leg7.render(f5);
    Leg8.render(f5);
    leg9.render(f5);
    leg10.render(f5);
    leg11.render(f5);
    leg12.render(f5);
    leg13.render(f5);
    leg14.render(f5);
    leg15.render(f5);
    leg16.render(f5);
    HairKnokt.render(f5);
    head.render(f5);
    body.render(f5);
    rightarm.render(f5);
    leftarm.render(f5);
    rightleg.render(f5);
    leftleg.render(f5);
    Breast1.render(f5);
    Breast2.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
