package com.smushytaco.experience_remover.mixins;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.smushytaco.experience_remover.ExperienceRemover;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AnvilBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import java.util.OptionalInt;
@Mixin(AnvilBlock.class)
public abstract class RemoveAnvilFunctionality {
    @ModifyReturnValue(method = "useWithoutItem", at = @At("RETURN"))
    private InteractionResult hookOnUse(InteractionResult original, BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) { return ExperienceRemover.INSTANCE.getConfig().getDisableMod() || ExperienceRemover.INSTANCE.getConfig().getAllowAnvilUse() || player.isCreative() ? original : InteractionResult.FAIL; }
    @WrapOperation(method = "useWithoutItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Player;openMenu(Lnet/minecraft/world/MenuProvider;)Ljava/util/OptionalInt;"))
    private OptionalInt hookOnUseOpenHandledScreen(Player instance, MenuProvider factory, Operation<OptionalInt> original) {
        if (ExperienceRemover.INSTANCE.getConfig().getDisableMod() || ExperienceRemover.INSTANCE.getConfig().getAllowAnvilUse() || instance.isCreative()) return original.call(instance, factory);
        return OptionalInt.empty();
    }
    @WrapWithCondition(method = "useWithoutItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Player;awardStat(Lnet/minecraft/resources/ResourceLocation;)V"))
    private boolean hookOnUseIncrementStat(Player instance, ResourceLocation stat) { return ExperienceRemover.INSTANCE.getConfig().getDisableMod() || ExperienceRemover.INSTANCE.getConfig().getAllowAnvilUse() || instance.isCreative(); }
}