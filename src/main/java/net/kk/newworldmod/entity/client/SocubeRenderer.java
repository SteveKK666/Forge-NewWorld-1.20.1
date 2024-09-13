package net.kk.newworldmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.kk.newworldmod.NewWorldMod;
import net.kk.newworldmod.entity.client.ModModelLayers;
import net.kk.newworldmod.entity.client.SoCubeModelForge;
import net.kk.newworldmod.entity.custom.SocubeEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SocubeRenderer extends MobRenderer<SocubeEntity, SoCubeModelForge<SocubeEntity>> {
    public SocubeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new SoCubeModelForge<>(pContext.bakeLayer(ModModelLayers.SOCUBE_LAYER)), 2f);
    }

    @Override
    public ResourceLocation getTextureLocation(SocubeEntity pEntity) {
        return new ResourceLocation(NewWorldMod.MOD_ID, "textures/entity/rhino.png");
    }

    @Override
    public void render(SocubeEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}