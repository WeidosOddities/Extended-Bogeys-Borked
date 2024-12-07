package com.rabbitminers.extendedbogeys.bogeys.styles;

import com.jozufozu.flywheel.api.MaterialManager;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.rabbitminers.extendedbogeys.bogeys.renderers.ExtendedBogeysBogeyRenderer;
import com.simibubi.create.content.trains.bogey.BogeySizes;
import com.simibubi.create.content.trains.entity.CarriageBogey;
import com.simibubi.create.foundation.utility.Iterate;
import com.simibubi.create.foundation.utility.AngleHelper;

import static com.rabbitminers.extendedbogeys.registry.ExtendedBogeysPartials.*;

public class SextupleBogeyRenderer {
    public static class LargeSextupleAxleLongBogeyRenderer extends ExtendedBogeysBogeyRenderer {
        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, LARGE_12_FRAME_LONG);
            createModelInstance(materialManager, LARGE_12_WHEELS, 2);
            createModelInstance(materialManager, LARGE_12_WHEELS_BLIND, 2);
            createModelInstance(materialManager, LARGE_12_WHEELS_SEMI_BLIND, 2);
            createModelInstance(materialManager, LARGE_12_CENTER_WEIGHT);
            createModelInstance(materialManager, LARGE_12_CENTER_P_ROD_LONG);
            createModelInstance(materialManager, LARGE_12_CENTER_M_ROD_LONG);
            createModelInstance(materialManager, LARGE_12_RIGHT_C_ROD_LONG);
            createModelInstance(materialManager, LARGE_12_LEFT_C_ROD_LONG);
            createModelInstance(materialManager, LARGE_12_RIGHT_P_ROD_LONG);
            createModelInstance(materialManager, LARGE_12_LEFT_P_ROD_LONG);
            createModelInstance(materialManager, LARGE_12_RIGHT_M_ROD_LONG);
            createModelInstance(materialManager, LARGE_12_LEFT_M_ROD_LONG);
            createModelInstance(materialManager, LARGE_12_CENTER_SHAFT, 2);
        }
        @Override
        public BogeySizes.BogeySize getSize() {
            return BogeySizes.LARGE;
        }
        @Override
        public void render(boolean forwards, float wheelAngle, PoseStack ms, int light, VertexConsumer vb, boolean inContraption) {
            boolean inInstancedContraption = vb == null;

            double wheel_r = AngleHelper.rad(wheelAngle + 0);
            double wheel_l = AngleHelper.rad(wheelAngle + 225);
            double wheel_c = AngleHelper.rad(wheelAngle + 135);

            double wheel_r180 = AngleHelper.rad(-(wheelAngle + 0));
            double wheel_l180 = AngleHelper.rad(-(wheelAngle - 225));
            double wheel_c180 = AngleHelper.rad(-(wheelAngle - 135));

            double zoffset_r = 0.25*Math.sin(wheel_r+((1.25/16f)*Math.cos(wheel_r)));
            double zoffset_l = 0.25*Math.sin(wheel_l+((1.25/16f)*Math.cos(wheel_l)));
            double zoffset_c = 0.25*Math.sin(wheel_c+((1.25/16f)*Math.cos(wheel_c)));

            double zoffset_r180 = 0.25*Math.sin(wheel_r180+((1.25/16f)*Math.cos(wheel_r180)));
            double zoffset_l180 = 0.25*Math.sin(wheel_l180+((1.25/16f)*Math.cos(wheel_l180)));
            double zoffset_c180 = 0.25*Math.sin(wheel_c180+((1.25/16f)*Math.cos(wheel_c180)));

            double xrotate_r = AngleHelper.deg(Math.asin(0.25*((-Math.cos(wheel_r)/4.9375))));
            double xrotate_l = AngleHelper.deg(Math.asin(0.25*((-Math.cos(wheel_l)/4.9375))));
            double xrotate_c = AngleHelper.deg(Math.asin(0.25*((-Math.cos(wheel_c)/3.1875))));

            double xrotate_r180 = AngleHelper.deg(Math.asin(0.25*((-Math.cos(wheel_r180)/4.9375))));
            double xrotate_l180 = AngleHelper.deg(Math.asin(0.25*((-Math.cos(wheel_l180)/4.9375))));
            double xrotate_c180 = AngleHelper.deg(Math.asin(0.25*((-Math.cos(wheel_c180)/3.1875))));

            getTransform(LARGE_12_FRAME_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .render(ms, light, vb);

            BogeyModelData[] wheels1 = getTransform(LARGE_12_WHEELS, ms, inInstancedContraption, 2);
            for (int side : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel1 = wheels1[(side + 1) / 2];
                wheel1.rotateY(forwards ? 0 : 180)
                        .translate(0, 1, side * 4.375)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            BogeyModelData[] wheels2 = getTransform(LARGE_12_WHEELS_SEMI_BLIND, ms, inInstancedContraption, 2);
            for (int side : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel2 = wheels2[(side + 1) / 2];
                wheel2.rotateY(forwards ? 0 : 180)
                        .translate(0, 1, side * 2.625)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            BogeyModelData[] wheels3 = getTransform(LARGE_12_WHEELS_BLIND, ms, inInstancedContraption, 2);
            for (int side : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel3 = wheels3[(side + 1) / 2];
                wheel3.rotateY(forwards ? 0 : 180)
                        .translate(0, 1, side * 0.875)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            BogeyModelData[] shafts = getTransform(LARGE_12_CENTER_SHAFT, ms, inInstancedContraption, 2);
            for (int side : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData shaft = shafts[(side + 1) / 2];
                shaft.rotateY(forwards ? 0 : 180)
                        .translate(0, 1, -2.625 + side * 1.75)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            getTransform(LARGE_12_CENTER_WEIGHT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1, -2.625)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 0, 0)
                    .render(ms, light, vb);

            getTransform(LARGE_12_RIGHT_C_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translateZ(0.875)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 1 / 4f, 0)
                    .rotateX(forwards ? -wheelAngle : wheelAngle)
                    .translateY(1)
                    .render(ms, light, vb);

            getTransform(LARGE_12_LEFT_C_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translateZ(0.875)
                    .rotateX(forwards ? wheelAngle + 225 : -wheelAngle + 225)
                    .translate(0, 1 / 4f, 0)
                    .rotateX(forwards ? -wheelAngle - 225 : wheelAngle - 225)
                    .translateY(1)
                    .render(ms, light, vb);

            getTransform(LARGE_12_RIGHT_P_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translateZ(forwards ? zoffset_r : zoffset_r180)
                    .render(ms, light, vb);

            getTransform(LARGE_12_LEFT_P_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translateZ(forwards ? zoffset_l : zoffset_l180)
                    .render(ms, light, vb);

            getTransform(LARGE_12_RIGHT_M_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1, -5.8125)
                    .translateZ(forwards ? zoffset_r : zoffset_r180)
                    .rotateX(forwards ? xrotate_r : xrotate_r180)
                    .render(ms, light, vb);

            getTransform(LARGE_12_LEFT_M_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1, -5.8125)
                    .translateZ(forwards ? zoffset_l : zoffset_l180)
                    .rotateX(forwards ? xrotate_l : xrotate_l180)
                    .render(ms, light, vb);

            getTransform(LARGE_12_CENTER_P_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(6.75)
                    .translate(0,-0.6875,0)
                    .translateZ(forwards ? zoffset_c : zoffset_c180)
                    .render(ms, light, vb);

            getTransform(LARGE_12_CENTER_M_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1.375, -5.75)
                    .rotateX(5.75)
                    .translateZ(forwards ? zoffset_c : zoffset_c180)
                    .rotateX(forwards ? xrotate_c : xrotate_c180)
                    .render(ms, light, vb);
        }
    }
    public static class LargeSextupleAxleShortBogeyRenderer extends ExtendedBogeysBogeyRenderer {
        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, LARGE_12_FRAME_SHORT);
            createModelInstance(materialManager, LARGE_12_WHEELS, 2);
            createModelInstance(materialManager, LARGE_12_WHEELS_BLIND, 2);
            createModelInstance(materialManager, LARGE_12_WHEELS_SEMI_BLIND, 2);
            createModelInstance(materialManager, LARGE_12_CENTER_WEIGHT);
            createModelInstance(materialManager, LARGE_12_CENTER_P_ROD_SHORT);
            createModelInstance(materialManager, LARGE_12_CENTER_M_ROD_SHORT);
            createModelInstance(materialManager, LARGE_12_RIGHT_C_ROD_SHORT);
            createModelInstance(materialManager, LARGE_12_LEFT_C_ROD_SHORT);
            createModelInstance(materialManager, LARGE_12_RIGHT_P_ROD_SHORT);
            createModelInstance(materialManager, LARGE_12_LEFT_P_ROD_SHORT);
            createModelInstance(materialManager, LARGE_12_RIGHT_M_ROD_SHORT);
            createModelInstance(materialManager, LARGE_12_LEFT_M_ROD_SHORT);
            createModelInstance(materialManager, LARGE_12_CENTER_SHAFT, 2);
        }
        @Override
        public BogeySizes.BogeySize getSize() {
            return BogeySizes.LARGE;
        }
        @Override
        public void render(boolean forwards, float wheelAngle, PoseStack ms, int light, VertexConsumer vb, boolean inContraption) {
            boolean inInstancedContraption = vb == null;

            double wheel_r = AngleHelper.rad(wheelAngle + 0);
            double wheel_l = AngleHelper.rad(wheelAngle + 225);
            double wheel_c = AngleHelper.rad(wheelAngle + 135);

            double wheel_r180 = AngleHelper.rad(-(wheelAngle + 0));
            double wheel_l180 = AngleHelper.rad(-(wheelAngle - 225));
            double wheel_c180 = AngleHelper.rad(-(wheelAngle - 135));

            double zoffset_r = 0.25*Math.sin(wheel_r+((1.25/16f)*Math.cos(wheel_r)));
            double zoffset_l = 0.25*Math.sin(wheel_l+((1.25/16f)*Math.cos(wheel_l)));
            double zoffset_c = 0.25*Math.sin(wheel_c+((1.25/16f)*Math.cos(wheel_c)));

            double zoffset_r180 = 0.25*Math.sin(wheel_r180+((1.25/16f)*Math.cos(wheel_r180)));
            double zoffset_l180 = 0.25*Math.sin(wheel_l180+((1.25/16f)*Math.cos(wheel_l180)));
            double zoffset_c180 = 0.25*Math.sin(wheel_c180+((1.25/16f)*Math.cos(wheel_c180)));

            double xrotate_r = AngleHelper.deg(Math.asin(0.25*((-Math.cos(wheel_r)/5.6875))));
            double xrotate_l = AngleHelper.deg(Math.asin(0.25*((-Math.cos(wheel_l)/5.6875))));
            double xrotate_c = AngleHelper.deg(Math.asin(0.25*((-Math.cos(wheel_c)/3.9375))));

            double xrotate_r180 = AngleHelper.deg(Math.asin(0.25*((-Math.cos(wheel_r180)/5.6875))));
            double xrotate_l180 = AngleHelper.deg(Math.asin(0.25*((-Math.cos(wheel_l180)/5.6875))));
            double xrotate_c180 = AngleHelper.deg(Math.asin(0.25*((-Math.cos(wheel_c180)/3.9375))));

            getTransform(LARGE_12_FRAME_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .render(ms, light, vb);

            BogeyModelData[] wheels1 = getTransform(LARGE_12_WHEELS, ms, inInstancedContraption, 2);
            for (int side : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel1 = wheels1[(side + 1) / 2];
                wheel1.rotateY(forwards ? 0 : 180)
                        .translate(0, 1, side * 4.375)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            BogeyModelData[] wheels2 = getTransform(LARGE_12_WHEELS_SEMI_BLIND, ms, inInstancedContraption, 2);
            for (int side : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel2 = wheels2[(side + 1) / 2];
                wheel2.rotateY(forwards ? 0 : 180)
                        .translate(0, 1, side * 2.625)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            BogeyModelData[] wheels3 = getTransform(LARGE_12_WHEELS_BLIND, ms, inInstancedContraption, 2);
            for (int side : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel3 = wheels3[(side + 1) / 2];
                wheel3.rotateY(forwards ? 0 : 180)
                        .translate(0, 1, side * 0.875)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            BogeyModelData[] shafts = getTransform(LARGE_12_CENTER_SHAFT, ms, inInstancedContraption, 2);
            for (int side : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData shaft = shafts[(side + 1) / 2];
                shaft.rotateY(forwards ? 0 : 180)
                        .translate(0, 1, -3.5 + side * 0.875)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            getTransform(LARGE_12_CENTER_WEIGHT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1, -0.875)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 0, 0)
                    .render(ms, light, vb);

            getTransform(LARGE_12_RIGHT_C_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 1 / 4f, 0)
                    .rotateX(forwards ? -wheelAngle : wheelAngle)
                    .translateY(1)
                    .render(ms, light, vb);

            getTransform(LARGE_12_LEFT_C_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle + 225 : -wheelAngle + 225)
                    .translate(0, 1 / 4f, 0)
                    .rotateX(forwards ? -wheelAngle - 225 : wheelAngle - 225)
                    .translateY(1)
                    .render(ms, light, vb);

            getTransform(LARGE_12_RIGHT_P_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translateZ(forwards ? zoffset_r : zoffset_r180)
                    .render(ms, light, vb);

            getTransform(LARGE_12_LEFT_P_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translateZ(forwards ? zoffset_l : zoffset_l180)
                    .render(ms, light, vb);

            getTransform(LARGE_12_RIGHT_M_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1, -4.8125)
                    .translateZ(forwards ? zoffset_r : zoffset_r180)
                    .rotateX(forwards ? xrotate_r : xrotate_r180)
                    .render(ms, light, vb);

            getTransform(LARGE_12_LEFT_M_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1, -4.8125)
                    .translateZ(forwards ? zoffset_l : zoffset_l180)
                    .rotateX(forwards ? xrotate_l : xrotate_l180)
                    .render(ms, light, vb);

            getTransform(LARGE_12_CENTER_P_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, -0.0625, -0.1875)
                    .rotateX(5.75)
                    .translateZ(forwards ? zoffset_c : zoffset_c180)
                    .render(ms, light, vb);

            getTransform(LARGE_12_CENTER_M_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1.375, -4.8125)
                    .rotateX(5.75)
                    .translateZ(forwards ? zoffset_c : zoffset_c180)
                    .rotateX(forwards ? xrotate_c : xrotate_c180)
                    .render(ms, light, vb);
        }
    }
}
