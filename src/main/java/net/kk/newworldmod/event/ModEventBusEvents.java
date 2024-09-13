package net.kk.newworldmod.event;

import net.kk.newworldmod.NewWorldMod;
import net.kk.newworldmod.entity.ModEntities;
import net.kk.newworldmod.entity.custom.SocubeEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NewWorldMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.SOCUBE.get(), SocubeEntity.createAttributes().build());
    }
}