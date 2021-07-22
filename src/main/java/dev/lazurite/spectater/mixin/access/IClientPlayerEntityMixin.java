package dev.lazurite.spectater.mixin.access;

import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(ClientPlayerEntity.class)
public interface IClientPlayerEntityMixin {
    @Invoker
    boolean invokeIsCamera();
}
