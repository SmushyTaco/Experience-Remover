package com.smushytaco.experience_remover.mixins.client;
import com.smushytaco.experience_remover.ExperienceRemover;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
@Mixin(InGameHud.class)
public abstract class LowerStatusBars {
    @Shadow
    private int scaledHeight;
    @Final
    @Shadow
    private MinecraftClient client;
    @Inject(method = "renderStatusBars", at = @At("HEAD"))
    private void hookHeadRenderStatusBars(MatrixStack matrices, CallbackInfo ci) {
        if (ExperienceRemover.INSTANCE.getConfig().getDisableMod()) return;
        scaledHeight = scaledHeight + 6;
    }
    @Inject(method = "renderStatusBars", at = @At("RETURN"))
    private void hookReturnRenderStatusBars(MatrixStack matrices, CallbackInfo ci) {
        if (ExperienceRemover.INSTANCE.getConfig().getDisableMod()) return;
        scaledHeight = client.getWindow().getScaledHeight();
    }
    @Inject(method = "renderMountHealth", at = @At("HEAD"))
    private void hookHeadRenderMountHealth(MatrixStack matrices, CallbackInfo ci) {
        if (ExperienceRemover.INSTANCE.getConfig().getDisableMod()) return;
        scaledHeight = scaledHeight + 6;
    }
    @Inject(method = "renderMountHealth", at = @At("RETURN"))
    private void hookReturnRenderMountHealth(MatrixStack matrices, CallbackInfo ci) {
        if (ExperienceRemover.INSTANCE.getConfig().getDisableMod()) return;
        scaledHeight = client.getWindow().getScaledHeight();
    }
}