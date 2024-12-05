package com.rabbitminers.extendedbogeys.data;

import com.rabbitminers.extendedbogeys.bogeys.blocks.ExtraLargeBogeyBlock;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllTags;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.jetbrains.annotations.ApiStatus;

import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;

public class BuilderTransformers {
    @ApiStatus.Internal
    public static <B extends ExtraLargeBogeyBlock, P> NonNullUnaryOperator<BlockBuilder<B, P>> bogey() {
        return b -> b.initialProperties(SharedProperties::softMetal)
            .properties(p -> p.sound(SoundType.NETHERITE_BLOCK))
            .properties(BlockBehaviour.Properties::noOcclusion)
            .transform(pickaxeOnly())
            .tag(AllTags.AllBlockTags.SAFE_NBT.tag)
            .loot((p, l) -> p.dropOther(l, AllBlocks.RAILWAY_CASING.get()));
    }
}
