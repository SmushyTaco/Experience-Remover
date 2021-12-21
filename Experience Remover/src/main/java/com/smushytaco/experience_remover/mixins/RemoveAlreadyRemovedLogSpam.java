package com.smushytaco.experience_remover.mixins;

import com.smushytaco.experience_remover.ExperienceRemover;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ServerWorld.class)
public abstract class RemoveAlreadyRemovedLogSpam {
    @Inject(method = "addEntity", at = @At("HEAD"), cancellable = true)
    private void hookOnUse(Entity entity, CallbackInfoReturnable<Boolean> cir) {
        if (ExperienceRemover.INSTANCE.getConfig().getDisableMod() || !(entity instanceof ExperienceOrbEntity)) return;
        cir.setReturnValue(false);
    }
}