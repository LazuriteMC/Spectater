package dev.lazurite.spectater.mixin.access;

import net.minecraft.client.player.LocalPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(LocalPlayer.class)
public interface ILocalPlayerMixin {
    @Invoker boolean invokeIsControlledCamera();
}
