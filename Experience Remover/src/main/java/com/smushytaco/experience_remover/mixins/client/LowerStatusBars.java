package com.smushytaco.experience_remover.mixins.client;
import com.smushytaco.experience_remover.ExperienceRemover;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
@Mixin(Gui.class)
public abstract class LowerStatusBars {
    @Final
    @Shadow
    private Minecraft minecraft;
    @Inject(method = "renderPlayerHealth", at = @At("HEAD"))
    private void hookHeadRenderStatusBars(GuiGraphics context, CallbackInfo ci) {
        if (ExperienceRemover.INSTANCE.getConfig().getDisableMod()) return;
        ((WindowAccessor) (Object) minecraft.getWindow()).setGuiScaledHeight(context.guiHeight() + 6);
    }
    @Inject(method = "renderPlayerHealth", at = @At("RETURN"))
    private void hookReturnRenderStatusBars(GuiGraphics context, CallbackInfo ci) {
        if (ExperienceRemover.INSTANCE.getConfig().getDisableMod()) return;
        ((WindowAccessor) (Object) minecraft.getWindow()).setGuiScaledHeight(context.guiHeight() - 6);
    }
    @Inject(method = "renderVehicleHealth", at = @At("HEAD"))
    private void hookHeadRenderMountHealth(GuiGraphics context, CallbackInfo ci) {
        if (ExperienceRemover.INSTANCE.getConfig().getDisableMod()) return;
        ((WindowAccessor) (Object) minecraft.getWindow()).setGuiScaledHeight(context.guiHeight() + 6);
    }
    @Inject(method = "renderVehicleHealth", at = @At("RETURN"))
    private void hookReturnRenderMountHealth(GuiGraphics context, CallbackInfo ci) {
        if (ExperienceRemover.INSTANCE.getConfig().getDisableMod()) return;
        ((WindowAccessor) (Object) minecraft.getWindow()).setGuiScaledHeight(context.guiHeight() - 6);
    }
}