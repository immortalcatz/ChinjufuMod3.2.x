package com.ayutaki.chinjufumod.entity.render;

import org.lwjgl.opengl.GL11;

import com.ayutaki.chinjufumod.entity.EntityFallIchoh;
import com.ayutaki.chinjufumod.entity.model.ModelFallIchoh;
import com.ayutaki.chinjufumod.main.Reference;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SuppressWarnings("rawtypes")
@SideOnly(Side.CLIENT)
public class RenderFallIchoh extends Render {

	private ModelFallIchoh model;

	public RenderFallIchoh(RenderManager manager) {
		super(manager);
		this.model = new ModelFallIchoh();
	}

	public static final ResourceLocation RESOURCE =
			new ResourceLocation(Reference.MOD_ID, "textures/entity/effect/par_fallichoh.png");

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
			return RESOURCE;
	}

	@SuppressWarnings("unchecked")
	public void renderLeaf(EntityFallIchoh entity, double d, double d1, double d2, float f, float f1) {

		GL11.glPushMatrix();
		GL11.glTranslatef((float)d, (float)d1, (float)d2);
		bindEntityTexture(entity);

		GL11.glScalef(0.8F, 0.8F, 0.8F);
		GL11.glRotatef(180.0F, entity.getRx(), entity.getRy(), entity.getRz());

		this.model.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glColor3f(1.0F, 1.0F, 1.0F);
		GL11.glPopMatrix();
	}

	public void doRender(Entity entity, double d, double d1, double d2, float f, float f1) {
		renderLeaf((EntityFallIchoh)entity, d, d1, d2, f, f1);
	}

}
