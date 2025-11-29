package com.smushytaco.experience_remover.mixins.client;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.smushytaco.experience_remover.ExperienceRemover;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
@Mixin(MultiPlayerGameMode.class)
public abstract class HideExperienceBar {
    @ModifyReturnValue(method = "hasExperience", at = @At("RETURN"))
    private boolean hookHasExperienceBar(boolean original) { return ExperienceRemover.INSTANCE.getConfig().getDisableMod() && original; }
}