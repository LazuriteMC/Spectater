package lazurite.spectater.mixin;

import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ClientPlayerEntity.class)
public abstract class ClientPlayerEntityMixin {
    @Redirect(
        method = "sendMovementPackets",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/network/ClientPlayerEntity;isCamera()Z"
        )
    )
    boolean isCamera(ClientPlayerEntity clientPlayerEntity) {
        return ((IClientPlayerEntityMixin) clientPlayerEntity).invokeIsCamera() || clientPlayerEntity.isSpectator();
    }
}
