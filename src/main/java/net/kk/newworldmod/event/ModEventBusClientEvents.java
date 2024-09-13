package net.kk.newworldmod.event;

import net.kk.newworldmod.NewWorldMod;
import net.kk.newworldmod.entity.client.ModModelLayers;
import net.kk.newworldmod.entity.client.SoCubeModelForge;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NewWorldMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.SOCUBE_LAYER, SoCubeModelForge::createBodyLayer);
    }
}