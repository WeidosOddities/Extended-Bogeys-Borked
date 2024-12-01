package com.rabbitminers.extendedbogeys.registry;

import com.rabbitminers.extendedbogeys.ExtendedBogeys;
import com.simibubi.create.content.trains.bogey.BogeySizes;

public class ExtendedBogeysBogeySizes {
    public static final BogeySizes.BogeySize MEDIUM = create(ExtendedBogeys.MOD_ID,"medium", 9f / 16f);
    public static final BogeySizes.BogeySize EXTRA_LARGE = create(ExtendedBogeys.MOD_ID,"extra_large", 14f / 16f);

    public static BogeySizes.BogeySize create(String modId, String name, float size) {
        return BogeySizes.addSize(modId, name, size);
    }

    public static void register() {

    }
}
