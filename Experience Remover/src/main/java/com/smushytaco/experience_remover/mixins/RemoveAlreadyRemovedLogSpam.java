package com.smushytaco.experience_remover.mixins;
import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.smushytaco.experience_remover.ExperienceRemover;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.server.world.ServerWorld;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
@Mixin(ServerWorld.class)
public abstract class RemoveAlreadyRemovedLogSpam {
    @WrapWithCondition(method = "addEntity", at = @At(value = "INVOKE", target = "Lorg/slf4j/Logger;warn(Ljava/lang/String;Ljava/lang/Object;)V", remap = false))
    private boolean hookOnUse(Logger instance, String var1, Object var2, Entity entity) { return ExperienceRemover.INSTANCE.getConfig().getDisableMod() || !(entity instanceof ExperienceOrbEntity); }
}