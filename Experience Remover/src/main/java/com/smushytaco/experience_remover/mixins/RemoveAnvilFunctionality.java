package com.smushytaco.experience_remover.mixins;
import com.smushytaco.experience_remover.ExperienceRemover;
import net.minecraft.block.AnvilBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
@Mixin(AnvilBlock.class)
public abstract class RemoveAnvilFunctionality {
    @Inject(method = "onUse", at = @At("HEAD"), cancellable = true)
    private void hookOnUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit, CallbackInfoReturnable<ActionResult> cir) {
        if (ExperienceRemover.INSTANCE.getConfig().getDisableMod()) return;
        cir.setReturnValue(ActionResult.FAIL);
    }
}