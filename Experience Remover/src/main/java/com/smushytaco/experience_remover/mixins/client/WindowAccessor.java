package com.smushytaco.experience_remover.mixins.client;
import net.minecraft.client.util.Window;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
@Mixin(Window.class)
public interface WindowAccessor {
    @Accessor
    void setScaledHeight(int scaledHeight);
}