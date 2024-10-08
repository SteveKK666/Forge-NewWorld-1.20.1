package net.kk.newworldmod.entity;

import net.kk.newworldmod.NewWorldMod;
import net.kk.newworldmod.entity.custom.SocubeEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, NewWorldMod.MOD_ID);

    public static final RegistryObject<EntityType<SocubeEntity>> SOCUBE =
            ENTITY_TYPES.register("socube", () -> EntityType.Builder.of(SocubeEntity::new, MobCategory.CREATURE)
                    .sized(2.5f, 2.5f).build("socube"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}