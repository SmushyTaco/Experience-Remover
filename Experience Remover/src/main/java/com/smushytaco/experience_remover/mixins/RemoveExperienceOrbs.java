package com.smushytaco.experience_remover.mixins;
import com.smushytaco.experience_remover.ExperienceRemover;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
@Mixin(ExperienceOrbEntity.class)
public abstract class RemoveExperienceOrbs {
    @Inject(method = "<init>(Lnet/minecraft/world/World;DDDI)V", at = @At("RETURN"))
    private void hookFirstInit(World world, double x, double y, double z, int amount, CallbackInfo ci) {
        if (ExperienceRemover.INSTANCE.getConfig().getDisableMod()) return;
        ExperienceOrbEntity experienceOrbEntity = (ExperienceOrbEntity) (Object) this;
        experienceOrbEntity.remove(Entity.RemovalReason.DISCARDED);
    }
    @Inject(method = "<init>(Lnet/minecraft/entity/EntityType;Lnet/minecraft/world/World;)V", at = @At("RETURN"))
    private void hookSecondInit(EntityType<? extends ExperienceOrbEntity> entityType, World world, CallbackInfo ci) {
        if (ExperienceRemover.INSTANCE.getConfig().getDisableMod()) return;
        ExperienceOrbEntity experienceOrbEntity = (ExperienceOrbEntity) (Object) this;
        experienceOrbEntity.remove(Entity.RemovalReason.DISCARDED);
    }
}