package dev.lazurite.spectater.mixin;

import dev.lazurite.spectater.mixin.access.ILocalPlayerMixin;
import net.minecraft.client.player.LocalPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LocalPlayer.class)
public abstract class ClientPlayerEntityMixin {
    @Redirect(
        method = "sendPosition",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/player/LocalPlayer;isControlledCamera()Z"
        )
    )
    protected boolean isCamera(LocalPlayer localPlayer) {
        return ((ILocalPlayerMixin) localPlayer).invokeIsControlledCamera() || localPlayer.isSpectator();
    }
}
