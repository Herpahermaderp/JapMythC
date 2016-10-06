package io.github.herpahermaderp.japmythc.client.gui;

import org.lwjgl.opengl.GL11;

import io.github.herpahermaderp.japmythc.inventory.ContainerTatara;
import io.github.herpahermaderp.japmythc.lib.Reference;
import io.github.herpahermaderp.japmythc.tileentity.TileEntityTatara;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiTatara extends GuiContainer {
	
	private TileEntityTatara tileTatara;
	
	public GuiTatara(InventoryPlayer playerInv, TileEntityTatara te) {
		
		super(new ContainerTatara(playerInv, te));
		this.tileTatara = te;
		this.xSize = 176;
		this.ySize = 166;
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.ID + ":textures/gui/container/tatara.png"));
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
		
		if(this.tileTatara.isBurning()) {
			
			int i1 = this.tileTatara.getBurnTimeRemainingScaled(13);
			this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 1);
			i1 = this.tileTatara.getCookProgressScaled(24);
			this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
		}
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		
		String s = "Tatara";
		this.fontRendererObj.drawString(s, 88 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
		this.fontRendererObj.drawString("Inventory", 8, 72, 4210752);
	}
}
