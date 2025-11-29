package com.smushytaco.experience_remover.mixins;
import com.smushytaco.experience_remover.ExperienceRemover;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
@Mixin(ExperienceOrb.class)
public abstract class RemoveExperienceOrbs {
    @Inject(method = "<init>(Lnet/minecraft/world/level/Level;DDDI)V", at = @At("RETURN"))
    private void hookFirstInit(Level world, double x, double y, double z, int amount, CallbackInfo ci) {
        if (ExperienceRemover.INSTANCE.getConfig().getDisableMod()) return;
        ExperienceOrb experienceOrbEntity = (ExperienceOrb) (Object) this;
        experienceOrbEntity.remove(Entity.RemovalReason.DISCARDED);
    }
    @Inject(method = "<init>(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", at = @At("RETURN"))
    private void hookSecondInit(EntityType<? extends ExperienceOrb> entityType, Level world, CallbackInfo ci) {
        if (ExperienceRemover.INSTANCE.getConfig().getDisableMod()) return;
        ExperienceOrb experienceOrbEntity = (ExperienceOrb) (Object) this;
        experienceOrbEntity.remove(Entity.RemovalReason.DISCARDED);
    }
}