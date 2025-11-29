package com.smushytaco.experience_remover.mixins.client;
import com.mojang.blaze3d.platform.Window;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
@Mixin(Window.class)
public interface WindowAccessor {
    @Accessor
    void setGuiScaledHeight(int scaledHeight);
}