package com.smushytaco.experience_remover.mixins.client;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.smushytaco.experience_remover.ExperienceRemover;
import net.minecraft.client.gui.Gui;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
@Mixin(Gui.class)
public abstract class LowerStatusBars {
    @Shadow
    protected abstract Gui.ContextualInfo nextContextualInfoState();
    @ModifyExpressionValue(method = "renderPlayerHealth", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;guiHeight()I"))
    private int shiftPlayerHealthDown(int original) {
        return ExperienceRemover.INSTANCE.getConfig().getDisableMod() || nextContextualInfoState() != Gui.ContextualInfo.EMPTY ? original : original + 6;
    }
    @ModifyExpressionValue(method = "renderVehicleHealth", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;guiHeight()I"))
    private int shiftVehicleHealthDown(int original) {
        return ExperienceRemover.INSTANCE.getConfig().getDisableMod() || nextContextualInfoState() != Gui.ContextualInfo.EMPTY ? original : original + 6;
    }
}