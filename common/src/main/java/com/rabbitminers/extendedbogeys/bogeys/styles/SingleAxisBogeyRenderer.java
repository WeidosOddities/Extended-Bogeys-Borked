package com.rabbitminers.extendedbogeys.bogeys.styles;

import com.jozufozu.flywheel.api.MaterialManager;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.rabbitminers.extendedbogeys.bogeys.renderers.ExtendedBogeysBogeyRenderer;
import com.rabbitminers.extendedbogeys.registry.ExtendedBogeysBogeySizes;
import com.rabbitminers.extendedbogeys.registry.ExtendedBogeysPartials;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.kinetics.simpleRelays.ShaftBlock;
import com.simibubi.create.content.trains.bogey.BogeyRenderer;
import com.simibubi.create.content.trains.bogey.BogeySizes;
import com.simibubi.create.content.trains.entity.CarriageBogey;
import com.simibubi.create.foundation.utility.Iterate;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;

import static com.rabbitminers.extendedbogeys.registry.ExtendedBogeysPartials.MEDIUM_SHARED_WHEELS;
import static com.rabbitminers.extendedbogeys.registry.ExtendedBogeysPartials.MEDIUM_SINGLE_WHEEL_FRAME;

public class SingleAxisBogeyRenderer {
    public static class MediumSingleAxisBogeyRenderer extends BogeyRenderer {
        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, MEDIUM_SHARED_WHEELS, MEDIUM_SINGLE_WHEEL_FRAME);
            createModelInstance(materialManager, AllBlocks.SHAFT.getDefaultState()
                    .setValue(ShaftBlock.AXIS, Direction.Axis.Z), 2);
        }

        @Override
        public BogeySizes.BogeySize getSize() {
            return ExtendedBogeysBogeySizes.MEDIUM;
        }

        @Override
        public void render(CompoundTag bogeyData, float wheelAngle, PoseStack ms, int light, VertexConsumer vb, boolean inContraption) {
            BogeyModelData[] secondaryShafts = getTransform(AllBlocks.SHAFT.getDefaultState()
                    .setValue(ShaftBlock.AXIS, Direction.Axis.Z), ms, inContraption, 2);

            for (int i : Iterate.zeroAndOne) {
                secondaryShafts[i]
                        .translate(-.5f, .25f, i * -1)
                        .centre()
                        .rotateZ(wheelAngle)
                        .unCentre()
                        .render(ms, light, vb);
            }

            getTransform(MEDIUM_SINGLE_WHEEL_FRAME, ms, inContraption)
                    .render(ms, light, vb);

            getTransform(MEDIUM_SHARED_WHEELS, ms, inContraption)
                    .translate(0, 12 / 16f, 0)
                    .rotateX(wheelAngle)
                    .translate(0, -13 / 16f, 0)
                    .render(ms, light, vb);
        }
    }
}
