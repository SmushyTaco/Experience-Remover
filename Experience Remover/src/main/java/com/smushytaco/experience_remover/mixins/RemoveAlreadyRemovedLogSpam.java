package com.smushytaco.experience_remover.mixins;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.smushytaco.experience_remover.ExperienceRemover;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
@Mixin(ServerWorld.class)
public abstract class RemoveAlreadyRemovedLogSpam {
    @ModifyReturnValue(method = "addEntity", at = @At("RETURN"))
    @SuppressWarnings("unused")
    private boolean hookOnUse(boolean original, Entity entity) {
        if (ExperienceRemover.INSTANCE.getConfig().getDisableMod() || !(entity instanceof ExperienceOrbEntity)) return original;
        return false;
    }
}