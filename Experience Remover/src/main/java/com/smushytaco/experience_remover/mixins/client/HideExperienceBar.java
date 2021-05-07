package com.smushytaco.experience_remover.mixins.client;
import com.smushytaco.experience_remover.ExperienceRemover;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
@Mixin(ClientPlayerInteractionManager.class)
public abstract class HideExperienceBar {
    @Inject(method = "hasExperienceBar", at = @At("HEAD"), cancellable = true)
    private void hookHasExperienceBar(CallbackInfoReturnable<Boolean> cir) {
        if (ExperienceRemover.INSTANCE.getConfig().getDisableMod()) return;
        cir.setReturnValue(false);
    }
}