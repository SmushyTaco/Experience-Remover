package com.smushytaco.experience_remover.mixins.client;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.smushytaco.experience_remover.ExperienceRemover;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
@Mixin(ClientPlayerInteractionManager.class)
public abstract class HideExperienceBar {
    @ModifyReturnValue(method = "hasExperienceBar", at = @At("RETURN"))
    @SuppressWarnings("unused")
    private boolean hookHasExperienceBar(boolean original) {
        if (ExperienceRemover.INSTANCE.getConfig().getDisableMod()) return original;
        return false;
    }
}