package net.kk.newworldmod.entity.custom;

import net.kk.newworldmod.entity.ModEntities;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.entity.PartEntity;
import org.jetbrains.annotations.Nullable;

public class SocubeEntity extends Animal {

    private final SocubePart head;
    private final SocubePart tail;

    private final SocubePart[] subEntities;



    public SocubeEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);

        this.head = new SocubePart(this, "head", 5.0F, 5.0F);
        this.tail = new SocubePart(this, "tail", 2.0F, 7.0F);
        this.subEntities = new SocubePart[]{this.head, this.tail};

    }

    public void updateParts() {
      
        float yawRadians = (float) Math.toRadians(this.getYRot());
        double headOffsetX = Math.cos(yawRadians) * 2.0;
        double headOffsetZ = Math.sin(yawRadians) * 2.0;

        
        this.head.setPos(this.getX() + headOffsetX, this.getY(), this.getZ() + headOffsetZ);

        double tailOffsetX = Math.cos(yawRadians + Math.PI) * 3.0;
        double tailOffsetZ = Math.sin(yawRadians + Math.PI) * 3.0;

     
        this.tail.setPos(this.getX() + tailOffsetX, this.getY(), this.getZ() + tailOffsetZ);
    }

    @Override
    public void tick() {
        super.tick();
        updateParts();
    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));

        this.goalSelector.addGoal(1, new BreedGoal(this, 1.15D));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.2D, Ingredient.of(Items.COOKED_BEEF), false));

        this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1D));

        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.1D));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 3f));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));

    }
    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()

                .add(Attributes.MAX_HEALTH, 20D)
                .add(Attributes.FOLLOW_RANGE, 24D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.ARMOR_TOUGHNESS, 0.1f)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5f)
                .add(Attributes.ATTACK_DAMAGE, 2f);
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
     
        if (source.getEntity() instanceof SocubePart) {
          
            amount *= 0.5F; 
        }

      
        return super.hurt(source, amount);
    }
    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return ModEntities.SOCUBE.get().create(serverLevel);
    }

    public boolean isMultipartEntity() {
        return true;
    }

    public PartEntity<?>[] getParts() {
        return this.subEntities;
    }

    public void recreateFromPacket(ClientboundAddEntityPacket pPacket) {
        super.recreateFromPacket(pPacket);
    }
}
