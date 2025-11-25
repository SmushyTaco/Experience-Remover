package com.smushytaco.experience_remover.mixins;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.smushytaco.experience_remover.ExperienceRemover;
import net.minecraft.block.AnvilBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import java.util.OptionalInt;
@Mixin(AnvilBlock.class)
public abstract class RemoveAnvilFunctionality {
    @ModifyReturnValue(method = "onUse", at = @At("RETURN"))
    private ActionResult hookOnUse(ActionResult original, BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) { return ExperienceRemover.INSTANCE.getConfig().getDisableMod() || ExperienceRemover.INSTANCE.getConfig().getAllowAnvilUse() || player.isCreative() ? original : ActionResult.FAIL; }
    @WrapOperation(method = "onUse", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;openHandledScreen(Lnet/minecraft/screen/NamedScreenHandlerFactory;)Ljava/util/OptionalInt;"))
    private OptionalInt hookOnUseOpenHandledScreen(PlayerEntity instance, NamedScreenHandlerFactory factory, Operation<OptionalInt> original) {
        if (ExperienceRemover.INSTANCE.getConfig().getDisableMod() || ExperienceRemover.INSTANCE.getConfig().getAllowAnvilUse() || instance.isCreative()) return original.call(instance, factory);
        return OptionalInt.empty();
    }
    @WrapWithCondition(method = "onUse", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;incrementStat(Lnet/minecraft/util/Identifier;)V"))
    private boolean hookOnUseIncrementStat(PlayerEntity instance, Identifier stat) { return ExperienceRemover.INSTANCE.getConfig().getDisableMod() || ExperienceRemover.INSTANCE.getConfig().getAllowAnvilUse() || instance.isCreative(); }
}