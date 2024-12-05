package com.rabbitminers.extendedbogeys;

import com.rabbitminers.extendedbogeys.bogeys.compat.Mods;
import com.rabbitminers.extendedbogeys.bogeys.compat.steamnrails.MenuImpl;
import com.rabbitminers.extendedbogeys.registry.ExtendedBogeysPartials;
import dev.architectury.injectables.annotations.ExpectPlatform;

public class ExtendedBogeysClient {
    public static void init() {
        registerBuiltinPack("brassless_bogeys", "teacup's Brassless Bogeys");

        ExtendedBogeysPartials.init();
        Mods.RAILWAYS.executeIfInstalled(() -> MenuImpl::load);
    }
    @ExpectPlatform
    public static void registerBuiltinPack(String id, String name) {
        throw new AssertionError();
    }
}
