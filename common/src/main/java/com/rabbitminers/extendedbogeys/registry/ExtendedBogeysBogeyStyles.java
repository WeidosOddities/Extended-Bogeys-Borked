package com.rabbitminers.extendedbogeys.registry;

import com.rabbitminers.extendedbogeys.ExtendedBogeys;
import com.rabbitminers.extendedbogeys.bogeys.styles.DoubleAxisTrailingRenderer.SmallDoubleAxisTrailingRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.SingleAxisTrailingRenderer.SmallSingleAxisTrailingRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.SingleAxleBogeyRenderer.SmallSingleAxleOffsetRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.TripleAxisTrailingRenderer.SmallTripleAxisTrailingRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.SingleAxleBogeyRenderer.LargeSingleAxleLongBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.SingleAxleBogeyRenderer.LargeSingleAxlePistonlessBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.DoubleAxleBogeyRenderer.LargeDoubleAxleLongBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.DoubleAxleBogeyRenderer.LargeDoubleAxleLongBogeyRearRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.DoubleAxleBogeyRenderer.LargeDoubleAxleShortBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.DoubleAxleBogeyRenderer.LargeDoubleAxlePistonlessBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.TripleAxleBogeyRenderer.SmallTripleAxleBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.TripleAxleBogeyRenderer.LargeTripleAxleLongBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.TripleAxleBogeyRenderer.LargeTripleAxleShortBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.TripleAxleBogeyRenderer.LargeTripleAxlePistonlessBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.TripleAxleBogeyRenderer.LargeTripleExtendedAxleLongBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.TripleAxleBogeyRenderer.LargeTripleExtendedAxleShortBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.TripleAxleBogeyRenderer.LargeTripleExtendedAxlePistonlessBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.QuadrupleAxleBogeyRenderer.SmallQuadrupleAxleBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.QuadrupleAxleBogeyRenderer.LargeQuadrupleAxleLongBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.QuadrupleAxleBogeyRenderer.LargeQuadrupleAxleShortBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.QuadrupleAxleBogeyRenderer.LargeQuadrupleAxlePistonlessBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.QuintupleAxleBogeyRenderer.SmallQuintupleAxleBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.QuintupleAxleBogeyRenderer.LargeQuintupleAxleLongBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.QuintupleAxleBogeyRenderer.LargeQuintupleAxleShortBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.QuintupleAxleBogeyRenderer.LargeQuintupleAxlePistonlessBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.SextupleBogeyRenderer.LargeSextupleAxleLongBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.SextupleBogeyRenderer.LargeSextupleAxleShortBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.SingleAxleBogeyRenderer.ExtraLargeSingleAxleLongBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.SingleAxleBogeyRenderer.ExtraLargeSingleAxlePistonlessBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.DoubleAxleBogeyRenderer.ExtraLargeDoubleAxleBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.DoubleAxleBogeyRenderer.ExtraLargeDoubleAxleLongBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.DoubleAxleBogeyRenderer.ExtraLargeDoubleAxleExtraLongBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.DoubleAxleBogeyRenderer.ExtraLargeDoubleAxleShortBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.DoubleAxleBogeyRenderer.ExtraLargeDoubleAxlePistonlessBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.TripleAxleBogeyRenderer.ExtraLargeTripleAxleBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.TripleAxleBogeyRenderer.ExtraLargeTripleAxleLongBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.TripleAxleBogeyRenderer.ExtraLargeTripleAxleShortBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.TripleAxleBogeyRenderer.ExtraLargeTripleAxlePistonlessBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.TripleAxleBogeyRenderer.ExtraLargeTripleExtendedAxleLongBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.TripleAxleBogeyRenderer.ExtraLargeTripleExtendedAxleShortBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.TripleAxleBogeyRenderer.ExtraLargeTripleExtendedAxlePistonlessBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.QuadrupleAxleBogeyRenderer.ExtraLargeQuadrupleAxleBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.QuadrupleAxleBogeyRenderer.ExtraLargeQuadrupleAxleLongBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.QuadrupleAxleBogeyRenderer.ExtraLargeQuadrupleAxleShortBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.QuadrupleAxleBogeyRenderer.ExtraLargeQuadrupleAxlePistonlessBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.QuintupleAxleBogeyRenderer.ExtraLargeQuintupleAxleLongBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.QuintupleAxleBogeyRenderer.ExtraLargeQuintupleAxleShortBogeyRenderer;
import com.rabbitminers.extendedbogeys.bogeys.styles.QuintupleAxleBogeyRenderer.ExtraLargeQuintupleAxlePistonlessBogeyRenderer;
import com.rabbitminers.extendedbogeys.data.ExtendedBogeysBogeySize;
import com.simibubi.create.AllBogeyStyles;
import com.simibubi.create.Create;
import com.simibubi.create.content.trains.bogey.BogeyStyle;
import com.simibubi.create.foundation.utility.Components;
import com.simibubi.create.content.trains.bogey.BogeySizes;


public class ExtendedBogeysBogeyStyles {
    
    public static final BogeyStyle SINGLE_AXLE_TRAIlER = create("single_axle_trailer")
            .displayName(Components.translatable("extendedbogeys.bogeys.styles.single_axle_trailer"))
            .size(BogeySizes.SMALL, () -> SmallSingleAxisTrailingRenderer::new, ExtendedBogeysBlocks.STANDARD_BOGEYS.get(ExtendedBogeysBogeySize.SMALL))
            .build();

    public static final BogeyStyle SINGLE_AXLE_STANDARD = create("single_axle_standard")
            .displayName(Components.translatable("extendedbogeys.bogeys.styles.single_axle_standard"))
            .size(BogeySizes.SMALL, () -> SmallSingleAxleOffsetRenderer::new, ExtendedBogeysBlocks.STANDARD_BOGEYS.get(ExtendedBogeysBogeySize.SMALL))
            .build();

    public static final BogeyStyle SINGLE_AXLE_LONG_BOGEY = create("single_axle_long")
            .displayName(Components.translatable("extendedbogeys.bogeys.styles.single_axle_long"))
            .size(BogeySizes.LARGE, () -> LargeSingleAxleLongBogeyRenderer::new, ExtendedBogeysBlocks.STANDARD_BOGEYS.get(ExtendedBogeysBogeySize.LARGE))
            .size(ExtendedBogeysBogeySizes.EXTRA_LARGE, () -> ExtraLargeSingleAxleLongBogeyRenderer::new, ExtendedBogeysBlocks.EXTRA_LARGE_BOGEYS.get(ExtendedBogeysBogeySize.EXTRA_LARGE))
            .build();

    public static final BogeyStyle SINGLE_AXLE_PISTONLESS_BOGEY = create("single_axle_pistonless")
            .displayName(Components.translatable("extendedbogeys.bogeys.styles.single_axle_pistonless"))
            .size(BogeySizes.LARGE, () -> LargeSingleAxlePistonlessBogeyRenderer::new, ExtendedBogeysBlocks.STANDARD_BOGEYS.get(ExtendedBogeysBogeySize.LARGE))
            .size(ExtendedBogeysBogeySizes.EXTRA_LARGE, () -> ExtraLargeSingleAxlePistonlessBogeyRenderer::new, ExtendedBogeysBlocks.EXTRA_LARGE_BOGEYS.get(ExtendedBogeysBogeySize.EXTRA_LARGE))
            .build();

    public static final BogeyStyle CREATE_DOUBLE_AXLE_BOGEY = create("double_axle_scotch_yoke")
            .displayName(Components.translatable("extendedbogeys.bogeys.styles.double_axle_scotch_yoke"))
            .size(ExtendedBogeysBogeySizes.EXTRA_LARGE, () -> ExtraLargeDoubleAxleBogeyRenderer::new, ExtendedBogeysBlocks.EXTRA_LARGE_BOGEYS.get(ExtendedBogeysBogeySize.EXTRA_LARGE))
            .build();

    public static final BogeyStyle DOUBLE_AXLE_LONG_BOGEY = create("double_axle_long")
            .displayName(Components.translatable("extendedbogeys.bogeys.styles.double_axle_long"))
            .size(BogeySizes.LARGE, () -> LargeDoubleAxleLongBogeyRenderer::new, ExtendedBogeysBlocks.STANDARD_BOGEYS.get(ExtendedBogeysBogeySize.LARGE))
            .size(ExtendedBogeysBogeySizes.EXTRA_LARGE, () -> ExtraLargeDoubleAxleLongBogeyRenderer::new, ExtendedBogeysBlocks.EXTRA_LARGE_BOGEYS.get(ExtendedBogeysBogeySize.EXTRA_LARGE))
            .build();

    public static final BogeyStyle DOUBLE_AXLE_EXTRA_LONG_BOGEY = create("double_axle_extra_long")
            .displayName(Components.translatable("extendedbogeys.bogeys.styles.double_axle_extra_long"))
            .size(BogeySizes.LARGE, () -> LargeDoubleAxleLongBogeyRearRenderer::new, ExtendedBogeysBlocks.STANDARD_BOGEYS.get(ExtendedBogeysBogeySize.LARGE))
            .size(ExtendedBogeysBogeySizes.EXTRA_LARGE, () -> ExtraLargeDoubleAxleExtraLongBogeyRenderer::new, ExtendedBogeysBlocks.EXTRA_LARGE_BOGEYS.get(ExtendedBogeysBogeySize.EXTRA_LARGE))
            .build();

    public static final BogeyStyle DOUBLE_AXLE_SHORT_BOGEY = create("double_axle_short")
            .displayName(Components.translatable("extendedbogeys.bogeys.styles.double_axle_short"))
            .size(BogeySizes.LARGE, () -> LargeDoubleAxleShortBogeyRenderer::new, ExtendedBogeysBlocks.STANDARD_BOGEYS.get(ExtendedBogeysBogeySize.LARGE))
            .size(ExtendedBogeysBogeySizes.EXTRA_LARGE, () -> ExtraLargeDoubleAxleShortBogeyRenderer::new, ExtendedBogeysBlocks.EXTRA_LARGE_BOGEYS.get(ExtendedBogeysBogeySize.EXTRA_LARGE))
            .build();

    public static final BogeyStyle DOUBLE_AXLE_PISTONLESS_BOGEY = create("double_axle_pistonless")
            .displayName(Components.translatable("extendedbogeys.bogeys.styles.double_axle_pistonless"))
            .size(BogeySizes.LARGE, () -> LargeDoubleAxlePistonlessBogeyRenderer::new, ExtendedBogeysBlocks.STANDARD_BOGEYS.get(ExtendedBogeysBogeySize.LARGE))
            .size(ExtendedBogeysBogeySizes.EXTRA_LARGE, () -> ExtraLargeDoubleAxlePistonlessBogeyRenderer::new, ExtendedBogeysBlocks.EXTRA_LARGE_BOGEYS.get(ExtendedBogeysBogeySize.EXTRA_LARGE))
            .build();

    public static final BogeyStyle DOUBLE_AXLE_TRAILER = create("double_axle_trailer")
            .displayName(Components.translatable("extendedbogeys.bogeys.styles.double_axle_trailer"))
            .size(BogeySizes.SMALL, () -> SmallDoubleAxisTrailingRenderer::new, ExtendedBogeysBlocks.STANDARD_BOGEYS.get(ExtendedBogeysBogeySize.SMALL))
            .build();

    public static final BogeyStyle TRIPLE_AXLE_BOGEY = create("triple_axle")
            .displayName(Components.translatable("extendedbogeys.bogeys.styles.triple_axle"))
            .size(BogeySizes.SMALL, () -> SmallTripleAxleBogeyRenderer::new, ExtendedBogeysBlocks.STANDARD_BOGEYS.get(ExtendedBogeysBogeySize.SMALL))
            .build();

    public static final BogeyStyle CREATE_TRIPLE_AXLE_BOGEY = create("triple_axle_scotch_yoke")
            .displayName(Components.translatable("extendedbogeys.bogeys.styles.triple_axle_scotch_yoke"))
            .size(ExtendedBogeysBogeySizes.EXTRA_LARGE, () -> ExtraLargeTripleAxleBogeyRenderer::new, ExtendedBogeysBlocks.EXTRA_LARGE_BOGEYS.get(ExtendedBogeysBogeySize.EXTRA_LARGE))
            .build();

    public static final BogeyStyle TRIPLE_AXLE_LONG_BOGEY = create("triple_axle_long")
            .displayName(Components.translatable("extendedbogeys.bogeys.styles.triple_axle_long"))
            .size(BogeySizes.LARGE, () -> LargeTripleAxleLongBogeyRenderer::new, ExtendedBogeysBlocks.STANDARD_BOGEYS.get(ExtendedBogeysBogeySize.LARGE))
            .size(ExtendedBogeysBogeySizes.EXTRA_LARGE, () -> ExtraLargeTripleAxleLongBogeyRenderer::new, ExtendedBogeysBlocks.EXTRA_LARGE_BOGEYS.get(ExtendedBogeysBogeySize.EXTRA_LARGE))
            .build();

    public static final BogeyStyle TRIPLE_EXTENDED_AXLE_LONG_BOGEY = create("triple_extended_axle_long")
            .displayName(Components.translatable("extendedbogeys.bogeys.styles.triple_extended_axle_long"))
            .size(BogeySizes.LARGE, () -> LargeTripleExtendedAxleLongBogeyRenderer::new, ExtendedBogeysBlocks.STANDARD_BOGEYS.get(ExtendedBogeysBogeySize.LARGE))
            .size(ExtendedBogeysBogeySizes.EXTRA_LARGE, () -> ExtraLargeTripleExtendedAxleLongBogeyRenderer::new, ExtendedBogeysBlocks.EXTRA_LARGE_BOGEYS.get(ExtendedBogeysBogeySize.EXTRA_LARGE))
            .build();

    public static final BogeyStyle TRIPLE_AXLE_SHORT_BOGEY = create("triple_axle_short")
            .displayName(Components.translatable("extendedbogeys.bogeys.styles.triple_axle_short"))
            .size(BogeySizes.LARGE, () -> LargeTripleAxleShortBogeyRenderer::new, ExtendedBogeysBlocks.STANDARD_BOGEYS.get(ExtendedBogeysBogeySize.LARGE))
            .size(ExtendedBogeysBogeySizes.EXTRA_LARGE, () -> ExtraLargeTripleAxleShortBogeyRenderer::new, ExtendedBogeysBlocks.EXTRA_LARGE_BOGEYS.get(ExtendedBogeysBogeySize.EXTRA_LARGE))
            .build();

    public static final BogeyStyle TRIPLE_AXLE_PISTONLESS_BOGEY = create("triple_axle_pistonless")
            .displayName(Components.translatable("extendedbogeys.bogeys.styles.triple_axle_pistonless"))
            .size(BogeySizes.LARGE, () -> LargeTripleAxlePistonlessBogeyRenderer::new, ExtendedBogeysBlocks.STANDARD_BOGEYS.get(ExtendedBogeysBogeySize.LARGE))
            .size(ExtendedBogeysBogeySizes.EXTRA_LARGE, () -> ExtraLargeTripleAxlePistonlessBogeyRenderer::new, ExtendedBogeysBlocks.EXTRA_LARGE_BOGEYS.get(ExtendedBogeysBogeySize.EXTRA_LARGE))
            .build();

    public static final BogeyStyle TRIPLE_EXTENDED_AXLE_SHORT_BOGEY = create("triple_extended_axle_short")
            .displayName(Components.translatable("extendedbogeys.bogeys.styles.triple_extended_axle_short"))
            .size(BogeySizes.LARGE, () -> LargeTripleExtendedAxleShortBogeyRenderer::new, ExtendedBogeysBlocks.STANDARD_BOGEYS.get(ExtendedBogeysBogeySize.LARGE))
            .size(ExtendedBogeysBogeySizes.EXTRA_LARGE, () -> ExtraLargeTripleExtendedAxleShortBogeyRenderer::new, ExtendedBogeysBlocks.EXTRA_LARGE_BOGEYS.get(ExtendedBogeysBogeySize.EXTRA_LARGE))
            .build();

    public static final BogeyStyle TRIPLE_EXTENDED_AXLE_PISTONLESS_BOGEY = create("triple_extended_axle_pistonless")
            .displayName(Components.translatable("extendedbogeys.bogeys.styles.triple_extended_axle_pistonless"))
            .size(BogeySizes.LARGE, () -> LargeTripleExtendedAxlePistonlessBogeyRenderer::new, ExtendedBogeysBlocks.STANDARD_BOGEYS.get(ExtendedBogeysBogeySize.LARGE))
            .size(ExtendedBogeysBogeySizes.EXTRA_LARGE, () -> ExtraLargeTripleExtendedAxlePistonlessBogeyRenderer::new, ExtendedBogeysBlocks.EXTRA_LARGE_BOGEYS.get(ExtendedBogeysBogeySize.EXTRA_LARGE))
            .build();

    public static final BogeyStyle TRIPLE_AXLE_TRAILER = create("triple_axle_trailer")
            .displayName(Components.translatable("extendedbogeys.bogeys.styles.triple_axle_trailer"))
            .size(BogeySizes.SMALL, () -> SmallTripleAxisTrailingRenderer::new, ExtendedBogeysBlocks.STANDARD_BOGEYS.get(ExtendedBogeysBogeySize.SMALL))
            .build();

    public static final BogeyStyle QUADRUPLE_AXLE_BOGEY = create("quadruple_axle")
            .displayName(Components.translatable("extendedbogeys.bogeys.styles.quadruple_axle"))
            .size(BogeySizes.SMALL, () -> SmallQuadrupleAxleBogeyRenderer::new, ExtendedBogeysBlocks.STANDARD_BOGEYS.get(ExtendedBogeysBogeySize.SMALL))
            .build();

    public static final BogeyStyle CREATE_QUADRUPLE_AXLE_BOGEY = create("quadruple_axle_scotch_yoke")
            .displayName(Components.translatable("extendedbogeys.bogeys.styles.quadruple_axle_scotch_yoke"))
            .size(ExtendedBogeysBogeySizes.EXTRA_LARGE, () -> ExtraLargeQuadrupleAxleBogeyRenderer::new, ExtendedBogeysBlocks.EXTRA_LARGE_BOGEYS.get(ExtendedBogeysBogeySize.EXTRA_LARGE))
            .build();

    public static final BogeyStyle QUADRUPLE_AXLE_LONG_BOGEY = create("quadruple_axle_long")
            .displayName(Components.translatable("extendedbogeys.bogeys.styles.quadruple_axle_long"))
            .size(BogeySizes.LARGE, () -> LargeQuadrupleAxleLongBogeyRenderer::new, ExtendedBogeysBlocks.STANDARD_BOGEYS.get(ExtendedBogeysBogeySize.LARGE))
            .size(ExtendedBogeysBogeySizes.EXTRA_LARGE, () -> ExtraLargeQuadrupleAxleLongBogeyRenderer::new, ExtendedBogeysBlocks.EXTRA_LARGE_BOGEYS.get(ExtendedBogeysBogeySize.EXTRA_LARGE))
            .build();

    public static final BogeyStyle QUADRUPLE_AXLE_SHORT_BOGEY = create("quadruple_axle_short")
            .displayName(Components.translatable("extendedbogeys.bogeys.styles.quadruple_axle_short"))
            .size(BogeySizes.LARGE, () -> LargeQuadrupleAxleShortBogeyRenderer::new, ExtendedBogeysBlocks.STANDARD_BOGEYS.get(ExtendedBogeysBogeySize.LARGE))
            .size(ExtendedBogeysBogeySizes.EXTRA_LARGE, () -> ExtraLargeQuadrupleAxleShortBogeyRenderer::new, ExtendedBogeysBlocks.EXTRA_LARGE_BOGEYS.get(ExtendedBogeysBogeySize.EXTRA_LARGE))
            .build();

    public static final BogeyStyle QUADRUPLE_AXLE_PISTONLESS_BOGEY = create("quadruple_axle_pistonless")
            .displayName(Components.translatable("extendedbogeys.bogeys.styles.quadruple_axle_pistonless"))
            .size(BogeySizes.LARGE, () -> LargeQuadrupleAxlePistonlessBogeyRenderer::new, ExtendedBogeysBlocks.STANDARD_BOGEYS.get(ExtendedBogeysBogeySize.LARGE))
            .size(ExtendedBogeysBogeySizes.EXTRA_LARGE, () -> ExtraLargeQuadrupleAxlePistonlessBogeyRenderer::new, ExtendedBogeysBlocks.EXTRA_LARGE_BOGEYS.get(ExtendedBogeysBogeySize.EXTRA_LARGE))
            .build();

    public static final BogeyStyle QUINTUPLE_AXLE_BOGEY = create("quintuple_axle")
            .displayName(Components.translatable("extendedbogeys.bogeys.styles.quintuple_axle"))
            .size(BogeySizes.SMALL, () -> SmallQuintupleAxleBogeyRenderer::new, ExtendedBogeysBlocks.STANDARD_BOGEYS.get(ExtendedBogeysBogeySize.SMALL))
            .build();

    public static final BogeyStyle QUINTUPLE_AXLE_LONG_BOGEY = create("quintuple_axle_long")
            .displayName(Components.translatable("extendedbogeys.bogeys.styles.quintuple_axle_long"))
            .size(BogeySizes.LARGE, () -> LargeQuintupleAxleLongBogeyRenderer::new, ExtendedBogeysBlocks.STANDARD_BOGEYS.get(ExtendedBogeysBogeySize.LARGE))
            .size(ExtendedBogeysBogeySizes.EXTRA_LARGE, () -> ExtraLargeQuintupleAxleLongBogeyRenderer::new, ExtendedBogeysBlocks.EXTRA_LARGE_BOGEYS.get(ExtendedBogeysBogeySize.EXTRA_LARGE))
            .build();

    public static final BogeyStyle QUINTUPLE_AXLE_SHORT_BOGEY = create("quintuple_axle_short")
            .displayName(Components.translatable("extendedbogeys.bogeys.styles.quintuple_axle_short"))
            .size(BogeySizes.LARGE, () -> LargeQuintupleAxleShortBogeyRenderer::new, ExtendedBogeysBlocks.STANDARD_BOGEYS.get(ExtendedBogeysBogeySize.LARGE))
            .size(ExtendedBogeysBogeySizes.EXTRA_LARGE, () -> ExtraLargeQuintupleAxleShortBogeyRenderer::new, ExtendedBogeysBlocks.EXTRA_LARGE_BOGEYS.get(ExtendedBogeysBogeySize.EXTRA_LARGE))
            .build();

    public static final BogeyStyle QUINTUPLE_AXLE_PISTONLESS_BOGEY = create("quintuple_axle_pistonless")
            .displayName(Components.translatable("extendedbogeys.bogeys.styles.quintuple_axle_pistonless"))
            .size(BogeySizes.LARGE, () -> LargeQuintupleAxlePistonlessBogeyRenderer::new, ExtendedBogeysBlocks.STANDARD_BOGEYS.get(ExtendedBogeysBogeySize.LARGE))
            .size(ExtendedBogeysBogeySizes.EXTRA_LARGE, () -> ExtraLargeQuintupleAxlePistonlessBogeyRenderer::new, ExtendedBogeysBlocks.EXTRA_LARGE_BOGEYS.get(ExtendedBogeysBogeySize.EXTRA_LARGE))
            .build();

    public static final BogeyStyle SEXTUPLE_AXLE_LONG_BOGEY = create("sextuple_axle_long")
            .displayName(Components.translatable("extendedbogeys.bogeys.styles.sextuple_axle_long"))
            .size(BogeySizes.LARGE, () -> LargeSextupleAxleLongBogeyRenderer::new, ExtendedBogeysBlocks.STANDARD_BOGEYS.get(ExtendedBogeysBogeySize.LARGE))
            .build();

    public static final BogeyStyle SEXTUPLE_AXLE_SHORT_BOGEY = create("sextuple_axle_short")
            .displayName(Components.translatable("extendedbogeys.bogeys.styles.sextuple_axle_short"))
            .size(BogeySizes.LARGE, () -> LargeSextupleAxleShortBogeyRenderer::new, ExtendedBogeysBlocks.STANDARD_BOGEYS.get(ExtendedBogeysBogeySize.LARGE))
            .build();

    public static AllBogeyStyles.BogeyStyleBuilder create(String name, String cycleGroup) {
        return AllBogeyStyles.create(ExtendedBogeys.asResource(name), ExtendedBogeys.asResource(cycleGroup));
    }

    public static AllBogeyStyles.BogeyStyleBuilder create(String name) {
        return AllBogeyStyles.create(ExtendedBogeys.asResource(name), Create.asResource(AllBogeyStyles.STANDARD_CYCLE_GROUP));
    }

    public static void register() {
        ExtendedBogeys.LOGGER.info("Registered bogey styles for " + ExtendedBogeys.MOD_NAME);
    }
}
