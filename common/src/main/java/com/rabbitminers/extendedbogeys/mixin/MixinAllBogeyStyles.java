package com.rabbitminers.extendedbogeys.mixin;

import com.rabbitminers.extendedbogeys.bogeys.styles.StandardBogeyRenderer.ExtraLargeStandardBogeyRenderer;
import com.rabbitminers.extendedbogeys.data.ExtendedBogeysBogeySize;
import com.rabbitminers.extendedbogeys.registry.ExtendedBogeysBlocks;
import com.rabbitminers.extendedbogeys.registry.ExtendedBogeysBogeySizes;
import com.simibubi.create.AllBogeyStyles;
import com.simibubi.create.AllBogeyStyles.BogeyStyleBuilder;
import com.simibubi.create.content.trains.bogey.BogeyStyle;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AllBogeyStyles.class)
public class MixinAllBogeyStyles {
    @Redirect(
            method = "<clinit>",
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/simibubi/create/AllBogeyStyles$BogeyStyleBuilder;build()Lcom/simibubi/create/content/trains/bogey/BogeyStyle;",
                    ordinal = 0
            )
    )
    private static BogeyStyle test(BogeyStyleBuilder builder) {
        return builder
                .size(ExtendedBogeysBogeySizes.EXTRA_LARGE, () -> ExtraLargeStandardBogeyRenderer::new, ExtendedBogeysBlocks.EXTRA_LARGE_BOGEYS.get(ExtendedBogeysBogeySize.EXTRA_LARGE))
                .build();
    }
}
