package com.skyblockevolution.mixin;

import com.skyblockevolution.world.level.levelgen.SBEChunkGenerator;
import net.minecraft.core.Registry;
import net.minecraft.world.level.dimension.LevelStem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(LevelStem.class)
public class MixinLevelStem {
    @Inject(at = @At("RETURN"), method = "stable", cancellable = true)
    private static void stable(Registry<LevelStem> registry, CallbackInfoReturnable<Boolean> cir) {
        if (!cir.getReturnValueZ()) {
            Optional<LevelStem> optional4 = registry.getOptional(LevelStem.OVERWORLD);
            if (optional4.isPresent() && optional4.get().generator() instanceof SBEChunkGenerator) {
                cir.setReturnValue(true);
            }
        }
    }
}
