package com.rabbitminers.extendedbogeys.bogeys.styles;

import com.jozufozu.flywheel.api.MaterialManager;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.rabbitminers.extendedbogeys.bogeys.renderers.ExtendedBogeysBogeyRenderer;
import com.simibubi.create.content.trains.bogey.BogeyRenderer;
import com.simibubi.create.content.trains.bogey.BogeySizes;
import com.simibubi.create.content.trains.entity.CarriageBogey;
import com.simibubi.create.foundation.utility.AngleHelper;
import com.simibubi.create.foundation.utility.Iterate;
import net.minecraft.nbt.CompoundTag;

import static com.rabbitminers.extendedbogeys.registry.ExtendedBogeysPartials.*;

public class TripleAxleBogeyRenderer {
    public static class SmallTripleAxleBogeyRenderer extends BogeyRenderer {
        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, SMALL_SHARED_WHEELS_PINS, 3);
            createModelInstance(materialManager, SMALL_STANDARD_6_FRAME);
        }

        @Override
        public BogeySizes.BogeySize getSize() { return BogeySizes.SMALL; }

        @Override
        public void render(CompoundTag bogeyData, float wheelAngle, PoseStack ms, int light, VertexConsumer vb, boolean inContraption) {
            boolean inInstancedContraption = vb == null;

            getTransform(SMALL_STANDARD_6_FRAME, ms, inInstancedContraption)
                    .render(ms, light, vb);

            BogeyModelData[] wheels = getTransform(SMALL_SHARED_WHEELS_PINS, ms, inInstancedContraption, 3);
            for (int side = -1; side < 2; side++) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel = wheels[side + 1];
                wheel.translate(0, 0.75, side)
                        .rotateX(wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }
        }
    }
    public static class LargeTripleAxleLongBogeyRenderer extends ExtendedBogeysBogeyRenderer {
        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, LARGE_6_FRAME_LONG);
            createModelInstance(materialManager, LARGE_SHARED_WHEELS, 2);
            createModelInstance(materialManager, LARGE_SHARED_WHEELS_SEMI_BLIND);
            createModelInstance(materialManager, LARGE_6_SHARED_RIGHT_C_ROD);
            createModelInstance(materialManager, LARGE_6_SHARED_LEFT_C_ROD);
            createModelInstance(materialManager, LARGE_6_RIGHT_P_ROD_LONG);
            createModelInstance(materialManager, LARGE_6_LEFT_P_ROD_LONG);
            createModelInstance(materialManager, LARGE_6_RIGHT_M_ROD_LONG);
            createModelInstance(materialManager, LARGE_6_LEFT_M_ROD_LONG);
        }
        @Override
        public BogeySizes.BogeySize getSize() {
            return BogeySizes.LARGE;
        }
        @Override
        public void render(boolean forwards, float wheelAngle, PoseStack ms, int light, VertexConsumer vb, boolean inContraption) {
            boolean inInstancedContraption = vb == null;

            double wheel_r = AngleHelper.rad(wheelAngle + 0);
            double wheel_l = AngleHelper.rad(wheelAngle + 90);

            double wheel_r180 = AngleHelper.rad(-(wheelAngle + 0));
            double wheel_l180 = AngleHelper.rad(-(wheelAngle - 90));

            double zoffset_r = 0.25*Math.sin(wheel_r+((1.25/16f)*Math.cos(wheel_r)));
            double zoffset_l = 0.25*Math.sin(wheel_l+((1.25/16f)*Math.cos(wheel_l)));

            double zoffset_r180 = 0.25*Math.sin(wheel_r180+((1.25/16f)*Math.cos(wheel_r180)));
            double zoffset_l180 = 0.25*Math.sin(wheel_l180+((1.25/16f)*Math.cos(wheel_l180)));

            double xrotate_r = AngleHelper.deg(Math.asin(0.25*((-Math.cos(wheel_r)/2.609375))));
            double xrotate_l = AngleHelper.deg(Math.asin(0.25*((-Math.cos(wheel_l)/2.609375))));

            double xrotate_r180 = AngleHelper.deg(Math.asin(0.25*((-Math.cos(wheel_r180)/2.609375))));
            double xrotate_l180 = AngleHelper.deg(Math.asin(0.25*((-Math.cos(wheel_l180)/2.609375))));

            getTransform(LARGE_6_FRAME_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .render(ms, light, vb);

            BogeyModelData[] wheels = getTransform(LARGE_SHARED_WHEELS, ms, inInstancedContraption, 2);
            for (int side : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel = wheels[(side + 1) / 2];
                wheel.rotateY(forwards ? 0 : 180)
                        .translate(0, 1, side * 1.6875)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            getTransform(LARGE_SHARED_WHEELS_SEMI_BLIND, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1, 0)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 0, 0)
                    .render(ms, light, vb);

            getTransform(LARGE_6_SHARED_RIGHT_C_ROD, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 1 / 4f, 0)
                    .rotateX(forwards ? -wheelAngle : wheelAngle)
                    .translateY(1)
                    .render(ms, light, vb);

            getTransform(LARGE_6_SHARED_LEFT_C_ROD, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle + 90 : -wheelAngle + 90)
                    .translate(0, 1 / 4f, 0)
                    .rotateX(forwards ? -wheelAngle - 90 : wheelAngle - 90)
                    .translateY(1)
                    .render(ms, light, vb);

            getTransform(LARGE_6_RIGHT_P_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0,1,0)
                    .translateZ(forwards ? zoffset_r : zoffset_r180)
                    .render(ms, light, vb);

            getTransform(LARGE_6_LEFT_P_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0,1,0)
                    .translateZ(forwards ? zoffset_l : zoffset_l180)
                    .render(ms, light, vb);

            getTransform(LARGE_6_RIGHT_M_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1, -2.609375)
                    .translateZ(forwards ? zoffset_r : zoffset_r180)
                    .rotateX(forwards ? xrotate_r : xrotate_r180)
                    .render(ms, light, vb);

            getTransform(LARGE_6_LEFT_M_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1, -2.609375)
                    .translateZ(forwards ? zoffset_l : zoffset_l180)
                    .rotateX(forwards ? xrotate_l : xrotate_l180)
                    .render(ms, light, vb);
        }
    }
    public static class LargeTripleAxleShortBogeyRenderer extends ExtendedBogeysBogeyRenderer {
        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, LARGE_6_FRAME_SHORT);
            createModelInstance(materialManager, LARGE_SHARED_WHEELS, 2);
            createModelInstance(materialManager, LARGE_SHARED_WHEELS_SEMI_BLIND);
            createModelInstance(materialManager, LARGE_6_SHARED_RIGHT_C_ROD);
            createModelInstance(materialManager, LARGE_6_SHARED_LEFT_C_ROD);
            createModelInstance(materialManager, LARGE_6_RIGHT_P_ROD_SHORT);
            createModelInstance(materialManager, LARGE_6_LEFT_P_ROD_SHORT);
            createModelInstance(materialManager, LARGE_6_RIGHT_M_ROD_SHORT);
            createModelInstance(materialManager, LARGE_6_LEFT_M_ROD_SHORT);
        }
        @Override
        public BogeySizes.BogeySize getSize() {
            return BogeySizes.LARGE;
        }
        @Override
        public void render(boolean forwards, float wheelAngle, PoseStack ms, int light, VertexConsumer vb, boolean inContraption) {
            boolean inInstancedContraption = vb == null;

            double wheel_r = AngleHelper.rad(wheelAngle + 0);
            double wheel_l = AngleHelper.rad(wheelAngle + 90);

            double wheel_r180 = AngleHelper.rad(-(wheelAngle + 0));
            double wheel_l180 = AngleHelper.rad(-(wheelAngle - 90));

            double zoffset_r = 0.25*Math.sin(wheel_r+((1.25/16f)*Math.cos(wheel_r)));
            double zoffset_l = 0.25*Math.sin(wheel_l+((1.25/16f)*Math.cos(wheel_l)));

            double zoffset_r180 = 0.25*Math.sin(wheel_r180+((1.25/16f)*Math.cos(wheel_r180)));
            double zoffset_l180 = 0.25*Math.sin(wheel_l180+((1.25/16f)*Math.cos(wheel_l180)));

            double xrotate_r = AngleHelper.deg(Math.asin(0.25*((-Math.cos(wheel_r)/1.796875))));
            double xrotate_l = AngleHelper.deg(Math.asin(0.25*((-Math.cos(wheel_l)/1.796875))));

            double xrotate_r180 = AngleHelper.deg(Math.asin(0.25*((-Math.cos(wheel_r180)/1.796875))));
            double xrotate_l180 = AngleHelper.deg(Math.asin(0.25*((-Math.cos(wheel_l180)/1.796875))));

            getTransform(LARGE_6_FRAME_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .render(ms, light, vb);

            BogeyModelData[] wheels = getTransform(LARGE_SHARED_WHEELS, ms, inInstancedContraption, 2);
            for (int side : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel = wheels[(side + 1) / 2];
                wheel.rotateY(forwards ? 0 : 180)
                        .translate(0, 1, side * 1.6875)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            getTransform(LARGE_SHARED_WHEELS_SEMI_BLIND, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1, 0)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 0, 0)
                    .render(ms, light, vb);

            getTransform(LARGE_6_SHARED_RIGHT_C_ROD, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 1 / 4f, 0)
                    .rotateX(forwards ? -wheelAngle : wheelAngle)
                    .translateY(1)
                    .render(ms, light, vb);

            getTransform(LARGE_6_SHARED_LEFT_C_ROD, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle + 90 : -wheelAngle + 90)
                    .translate(0, 1 / 4f, 0)
                    .rotateX(forwards ? -wheelAngle - 90 : wheelAngle - 90)
                    .translateY(1)
                    .render(ms, light, vb);

            getTransform(LARGE_6_RIGHT_P_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0,1,0)
                    .translateZ(forwards ? zoffset_r : zoffset_r180)
                    .render(ms, light, vb);

            getTransform(LARGE_6_LEFT_P_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0,1,0)
                    .translateZ(forwards ? zoffset_l : zoffset_l180)
                    .render(ms, light, vb);

            getTransform(LARGE_6_RIGHT_M_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1, -1.796875)
                    .translateZ(forwards ? zoffset_r : zoffset_r180)
                    .rotateX(forwards ? xrotate_r : xrotate_r180)
                    .render(ms, light, vb);

            getTransform(LARGE_6_LEFT_M_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1, -1.796875)
                    .translateZ(forwards ? zoffset_l : zoffset_l180)
                    .rotateX(forwards ? xrotate_l : xrotate_l180)
                    .render(ms, light, vb);
        }
    }
    public static class LargeTripleExtendedAxleLongBogeyRenderer extends ExtendedBogeysBogeyRenderer {

        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, LARGE_6E_FRAME_LONG);
            createModelInstance(materialManager, LARGE_SHARED_WHEELS, 2);
            createModelInstance(materialManager, LARGE_SHARED_WHEELS_SEMI_BLIND);
            createModelInstance(materialManager, LARGE_6E_SHARED_RIGHT_C_ROD);
            createModelInstance(materialManager, LARGE_6E_SHARED_LEFT_C_ROD);
            createModelInstance(materialManager, LARGE_6_RIGHT_P_ROD_LONG);
            createModelInstance(materialManager, LARGE_6_LEFT_P_ROD_LONG);
            createModelInstance(materialManager, LARGE_6_RIGHT_M_ROD_LONG);
            createModelInstance(materialManager, LARGE_6_LEFT_M_ROD_LONG);
        }
        @Override
        public BogeySizes.BogeySize getSize() {
            return BogeySizes.LARGE;
        }
        @Override
        public void render(boolean forwards, float wheelAngle, PoseStack ms, int light, VertexConsumer vb, boolean inContraption) {
            boolean inInstancedContraption = vb == null;

            double wheel_r = AngleHelper.rad(wheelAngle + 0);
            double wheel_l = AngleHelper.rad(wheelAngle + 90);

            double wheel_r180 = AngleHelper.rad(-wheelAngle + 0);
            double wheel_l180 = AngleHelper.rad(-wheelAngle + 90);

            double zoffset_r = 0.25*Math.sin(wheel_r+((1.25/16f)*Math.cos(wheel_r)));
            double zoffset_l = 0.25*Math.sin(wheel_l+((1.25/16f)*Math.cos(wheel_l)));

            double zoffset_r180 = 0.25*Math.sin(wheel_r180+((1.25/16f)*Math.cos(wheel_r180)));
            double zoffset_l180 = 0.25*Math.sin(wheel_l180+((1.25/16f)*Math.cos(wheel_l180)));

            double xrotate_r = AngleHelper.deg(Math.asin(0.25*((-Math.cos(wheel_r)/2.609375))));
            double xrotate_l = AngleHelper.deg(Math.asin(0.25*((-Math.cos(wheel_l)/2.609375))));

            double xrotate_r180 = AngleHelper.deg(Math.asin(0.25*((-Math.cos(wheel_r180)/2.609375))));
            double xrotate_l180 = AngleHelper.deg(Math.asin(0.25*((-Math.cos(wheel_l180)/2.609375))));

            getTransform(LARGE_6E_FRAME_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .render(ms, light, vb);

            BogeyModelData[] wheels = getTransform(LARGE_SHARED_WHEELS, ms, inInstancedContraption, 2);
            for (int side : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel = wheels[(side + 1) / 2];
                wheel.rotateY(forwards ? 0 : 180)
                        .translate(0, 1, 0.34375 + side * 2.03125)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            getTransform(LARGE_SHARED_WHEELS_SEMI_BLIND, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1, 0)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 0, 0)
                    .render(ms, light, vb);

            getTransform(LARGE_6E_SHARED_RIGHT_C_ROD, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 1 / 4f, 0)
                    .rotateX(forwards ? -wheelAngle : wheelAngle)
                    .translateY(1)
                    .render(ms, light, vb);

            getTransform(LARGE_6E_SHARED_LEFT_C_ROD, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle + 90 : -wheelAngle + 90)
                    .translate(0, 1 / 4f, 0)
                    .rotateX(forwards ? -wheelAngle - 90 : wheelAngle - 90)
                    .translateY(1)
                    .render(ms, light, vb);

            getTransform(LARGE_6_RIGHT_P_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0,1,0)
                    .translateZ(forwards ? zoffset_r : zoffset_r180)
                    .render(ms, light, vb);

            getTransform(LARGE_6_LEFT_P_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0,1,0)
                    .translateZ(forwards ? zoffset_l : zoffset_l180)
                    .render(ms, light, vb);

            getTransform(LARGE_6_RIGHT_M_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1, -2.609375)
                    .translateZ(forwards ? zoffset_r : zoffset_r180)
                    .rotateX(forwards ? xrotate_r : xrotate_r180)
                    .render(ms, light, vb);

            getTransform(LARGE_6_LEFT_M_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1, -2.609375)
                    .translateZ(forwards ? zoffset_l : zoffset_l180)
                    .rotateX(forwards ? xrotate_l : xrotate_l180)
                    .render(ms, light, vb);
        }
    }
    public static class LargeTripleExtendedAxleShortBogeyRenderer extends ExtendedBogeysBogeyRenderer {
        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, LARGE_6E_FRAME_SHORT);
            createModelInstance(materialManager, LARGE_SHARED_WHEELS, 2);
            createModelInstance(materialManager, LARGE_SHARED_WHEELS_SEMI_BLIND);
            createModelInstance(materialManager, LARGE_6E_SHARED_RIGHT_C_ROD);
            createModelInstance(materialManager, LARGE_6E_SHARED_LEFT_C_ROD);
            createModelInstance(materialManager, LARGE_6_RIGHT_P_ROD_SHORT);
            createModelInstance(materialManager, LARGE_6_LEFT_P_ROD_SHORT);
            createModelInstance(materialManager, LARGE_6_RIGHT_M_ROD_SHORT);
            createModelInstance(materialManager, LARGE_6_LEFT_M_ROD_SHORT);
        }
        @Override
        public BogeySizes.BogeySize getSize() {
            return BogeySizes.LARGE;
        }
        @Override
        public void render(boolean forwards, float wheelAngle, PoseStack ms, int light, VertexConsumer vb, boolean inContraption) {
            boolean inInstancedContraption = vb == null;

            double wheel_r = AngleHelper.rad(wheelAngle + 0);
            double wheel_l = AngleHelper.rad(wheelAngle + 90);

            double wheel_r180 = AngleHelper.rad(-(wheelAngle + 0));
            double wheel_l180 = AngleHelper.rad(-(wheelAngle - 90));

            double zoffset_r = 0.25*Math.sin(wheel_r+((1.25/16f)*Math.cos(wheel_r)));
            double zoffset_l = 0.25*Math.sin(wheel_l+((1.25/16f)*Math.cos(wheel_l)));

            double zoffset_r180 = 0.25*Math.sin(wheel_r180+((1.25/16f)*Math.cos(wheel_r180)));
            double zoffset_l180 = 0.25*Math.sin(wheel_l180+((1.25/16f)*Math.cos(wheel_l180)));

            double xrotate_r = AngleHelper.deg(Math.asin(0.25*((-Math.cos(wheel_r)/1.796875))));
            double xrotate_l = AngleHelper.deg(Math.asin(0.25*((-Math.cos(wheel_l)/1.7968755))));

            double xrotate_r180 = AngleHelper.deg(Math.asin(0.25*((-Math.cos(wheel_r180)/1.796875))));
            double xrotate_l180 = AngleHelper.deg(Math.asin(0.25*((-Math.cos(wheel_l180)/1.796875))));

            getTransform(LARGE_6E_FRAME_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .render(ms, light, vb);

            BogeyModelData[] wheels = getTransform(LARGE_SHARED_WHEELS, ms, inInstancedContraption, 2);
            for (int side : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel = wheels[(side + 1) / 2];
                wheel.rotateY(forwards ? 0 : 180)
                        .translate(0, 1, 0.34375 + side * 2.03125)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            getTransform(LARGE_SHARED_WHEELS_SEMI_BLIND, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1, 0)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 0, 0)
                    .render(ms, light, vb);

            getTransform(LARGE_6E_SHARED_RIGHT_C_ROD, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 1 / 4f, 0)
                    .rotateX(forwards ? -wheelAngle : wheelAngle)
                    .translateY(1)
                    .render(ms, light, vb);

            getTransform(LARGE_6E_SHARED_LEFT_C_ROD, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle + 90 : -wheelAngle + 90)
                    .translate(0, 1 / 4f, 0)
                    .rotateX(forwards ? -wheelAngle - 90 : wheelAngle - 90)
                    .translateY(1)
                    .render(ms, light, vb);

            getTransform(LARGE_6_RIGHT_P_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0,1,0)
                    .translateZ(forwards ? zoffset_r : zoffset_r180)
                    .render(ms, light, vb);

            getTransform(LARGE_6_LEFT_P_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0,1,0)
                    .translateZ(forwards ? zoffset_l : zoffset_l180)
                    .render(ms, light, vb);

            getTransform(LARGE_6_RIGHT_M_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1, -1.796875)
                    .translateZ(forwards ? zoffset_r : zoffset_r180)
                    .rotateX(forwards ? xrotate_r : xrotate_r180)
                    .render(ms, light, vb);

            getTransform(LARGE_6_LEFT_M_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1, -1.796875)
                    .translateZ(forwards ? zoffset_l : zoffset_l180)
                    .rotateX(forwards ? xrotate_l : xrotate_l180)
                    .render(ms, light, vb);
        }
    }
    public static class LargeTripleAxlePistonlessBogeyRenderer extends BogeyRenderer {
        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, LARGE_6_FRAME_PISTONLESS);
            createModelInstance(materialManager, LARGE_SHARED_WHEELS, 2);
            createModelInstance(materialManager, LARGE_SHARED_WHEELS_SEMI_BLIND);
            createModelInstance(materialManager, LARGE_6_RIGHT_C_ROD_PISTONLESS);
            createModelInstance(materialManager, LARGE_6_LEFT_C_ROD_PISTONLESS);
        }
        @Override
        public BogeySizes.BogeySize getSize() {
            return BogeySizes.LARGE;
        }
        @Override
        public void render(CompoundTag bogeyData, float wheelAngle, PoseStack ms, int light, VertexConsumer vb, boolean inContraption) {
            boolean inInstancedContraption = vb == null;

            getTransform(LARGE_6_FRAME_PISTONLESS, ms, inInstancedContraption)
                    .render(ms, light, vb);

            BogeyModelData[] wheels = getTransform(LARGE_SHARED_WHEELS, ms, inInstancedContraption, 2);
            for (int side : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel = wheels[(side + 1) / 2];
                    wheel
                        .translate(0, 1, side * 1.6875)
                        .rotateX(wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            getTransform(LARGE_SHARED_WHEELS_SEMI_BLIND, ms, inInstancedContraption)
                    .translate(0, 1, 0)
                    .rotateX(wheelAngle)
                    .translate(0, 0, 0)
                    .render(ms, light, vb);

            getTransform(LARGE_6_RIGHT_C_ROD_PISTONLESS, ms, inInstancedContraption)
                    .rotateX(wheelAngle)
                    .translate(0, 1 / 4f, 0)
                    .rotateX(-wheelAngle)
                    .translateY(1)
                    .render(ms, light, vb);

            getTransform(LARGE_6_LEFT_C_ROD_PISTONLESS, ms, inInstancedContraption)
                    .rotateX(wheelAngle + 90)
                    .translate(0, 1 / 4f, 0)
                    .rotateX(-wheelAngle - 90)
                    .translateY(1)
                    .render(ms, light, vb);
        }
    }
    public static class LargeTripleExtendedAxlePistonlessBogeyRenderer extends ExtendedBogeysBogeyRenderer {
        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, LARGE_6E_FRAME_PISTONLESS);
            createModelInstance(materialManager, LARGE_SHARED_WHEELS, 2);
            createModelInstance(materialManager, LARGE_SHARED_WHEELS_SEMI_BLIND);
            createModelInstance(materialManager, LARGE_6E_RIGHT_C_ROD_PISTONLESS);
            createModelInstance(materialManager, LARGE_6E_LEFT_C_ROD_PISTONLESS);
        }
        @Override
        public BogeySizes.BogeySize getSize() {
            return BogeySizes.LARGE;
        }
        @Override
        public void render(boolean forwards, float wheelAngle, PoseStack ms, int light, VertexConsumer vb, boolean inContraption) {
            boolean inInstancedContraption = vb == null;

            getTransform(LARGE_6E_FRAME_PISTONLESS, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .render(ms, light, vb);

            BogeyModelData[] wheels = getTransform(LARGE_SHARED_WHEELS, ms, inInstancedContraption, 2);
            for (int side : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel = wheels[(side + 1) / 2];
                wheel.rotateY(forwards ? 0 : 180)
                        .translate(0, 1, 0.34375 + side * 2.03125)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            getTransform(LARGE_SHARED_WHEELS_SEMI_BLIND, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1, 0)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 0, 0)
                    .render(ms, light, vb);

            getTransform(LARGE_6E_RIGHT_C_ROD_PISTONLESS, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 1 / 4f, 0)
                    .rotateX(forwards ? -wheelAngle : wheelAngle)
                    .translateY(1)
                    .render(ms, light, vb);

            getTransform(LARGE_6E_LEFT_C_ROD_PISTONLESS, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle + 90 : -wheelAngle + 90)
                    .translate(0, 1 / 4f, 0)
                    .rotateX(forwards ? -wheelAngle - 90 : wheelAngle - 90)
                    .translateY(1)
                    .render(ms, light, vb);
        }
    }
    public static class ExtraLargeTripleAxleLongBogeyRenderer extends ExtendedBogeysBogeyRenderer {
        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, EXTRA_LARGE_6_FRAME_LONG);
            createModelInstance(materialManager, EXTRA_LARGE_SHARED_WHEELS, 2);
            createModelInstance(materialManager, EXTRA_LARGE_SHARED_WHEELS_SEMI_BLIND);
            createModelInstance(materialManager, EXTRA_LARGE_6_SHARED_RIGHT_C_ROD);
            createModelInstance(materialManager, EXTRA_LARGE_6_SHARED_LEFT_C_ROD);
            createModelInstance(materialManager, EXTRA_LARGE_6_RIGHT_P_ROD_LONG);
            createModelInstance(materialManager, EXTRA_LARGE_6_LEFT_P_ROD_LONG);
            createModelInstance(materialManager, EXTRA_LARGE_6_RIGHT_M_ROD_LONG);
            createModelInstance(materialManager, EXTRA_LARGE_6_LEFT_M_ROD_LONG);
        }
        @Override
        public BogeySizes.BogeySize getSize() {
            return BogeySizes.LARGE;
        }
        @Override
        public void render(boolean forwards, float wheelAngle, PoseStack ms, int light, VertexConsumer vb, boolean inContraption) {
            boolean inInstancedContraption = vb == null;

            double wheel_r = AngleHelper.rad(wheelAngle + 0);
            double wheel_l = AngleHelper.rad(wheelAngle + 90);

            double wheel_r180 = AngleHelper.rad(-(wheelAngle + 0));
            double wheel_l180 = AngleHelper.rad(-(wheelAngle - 90));

            double zoffset_r = 0.375*Math.sin(wheel_r+((1.25/16f)*Math.cos(wheel_r)));
            double zoffset_l = 0.375*Math.sin(wheel_l+((1.25/16f)*Math.cos(wheel_l)));

            double zoffset_r180 = 0.375*Math.sin(wheel_r180+((1.25/16f)*Math.cos(wheel_r180)));
            double zoffset_l180 = 0.375*Math.sin(wheel_l180+((1.25/16f)*Math.cos(wheel_l180)));

            double xrotate_r = AngleHelper.deg(Math.asin(0.375*((-Math.cos(wheel_r)/3.4375))));
            double xrotate_l = AngleHelper.deg(Math.asin(0.375*((-Math.cos(wheel_l)/3.4375))));

            double xrotate_r180 = AngleHelper.deg(Math.asin(0.375*((-Math.cos(wheel_r180)/3.4375))));
            double xrotate_l180 = AngleHelper.deg(Math.asin(0.375*((-Math.cos(wheel_l180)/3.4375))));

            getTransform(EXTRA_LARGE_6_FRAME_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .render(ms, light, vb);

            BogeyModelData[] wheels = getTransform(EXTRA_LARGE_SHARED_WHEELS, ms, inInstancedContraption, 2);
            for (int side : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel = wheels[(side + 1) / 2];
                wheel.rotateY(forwards ? 0 : 180)
                        .translate(0, 1.25, side * 2.25)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            getTransform(EXTRA_LARGE_SHARED_WHEELS_SEMI_BLIND, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1.25, 0)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 0, 0)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_6_SHARED_RIGHT_C_ROD, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 3 / 8f, 0)
                    .rotateX(forwards ? -wheelAngle : wheelAngle)
                    .translateY(1.25)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_6_SHARED_LEFT_C_ROD, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle + 90 : -wheelAngle + 90)
                    .translate(0, 3 / 8f, 0)
                    .rotateX(forwards ? -wheelAngle - 90 : wheelAngle - 90)
                    .translateY(1.25)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_6_RIGHT_P_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0,1.25,0)
                    .translateZ(forwards ? zoffset_r : zoffset_r180)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_6_LEFT_P_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0,1.25,0)
                    .translateZ(forwards ? zoffset_l : zoffset_l180)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_6_RIGHT_M_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1.25, -3.4375)
                    .translateZ(forwards ? zoffset_r : zoffset_r180)
                    .rotateX(forwards ? xrotate_r : xrotate_r180)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_6_LEFT_M_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1.25, -3.4375)
                    .translateZ(forwards ? zoffset_l : zoffset_l180)
                    .rotateX(forwards ? xrotate_l : xrotate_l180)
                    .render(ms, light, vb);
        }
    }
    public static class ExtraLargeTripleAxleShortBogeyRenderer extends ExtendedBogeysBogeyRenderer {
        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, EXTRA_LARGE_6_FRAME_SHORT);
            createModelInstance(materialManager, EXTRA_LARGE_SHARED_WHEELS, 2);
            createModelInstance(materialManager, EXTRA_LARGE_SHARED_WHEELS_SEMI_BLIND);
            createModelInstance(materialManager, EXTRA_LARGE_6_SHARED_RIGHT_C_ROD);
            createModelInstance(materialManager, EXTRA_LARGE_6_SHARED_LEFT_C_ROD);
            createModelInstance(materialManager, EXTRA_LARGE_6_RIGHT_P_ROD_SHORT);
            createModelInstance(materialManager, EXTRA_LARGE_6_LEFT_P_ROD_SHORT);
            createModelInstance(materialManager, EXTRA_LARGE_6_RIGHT_M_ROD_SHORT);
            createModelInstance(materialManager, EXTRA_LARGE_6_LEFT_M_ROD_SHORT);
        }
        @Override
        public BogeySizes.BogeySize getSize() {
            return BogeySizes.LARGE;
        }
        @Override
        public void render(boolean forwards, float wheelAngle, PoseStack ms, int light, VertexConsumer vb, boolean inContraption) {
            boolean inInstancedContraption = vb == null;

            double wheel_r = AngleHelper.rad(wheelAngle + 0);
            double wheel_l = AngleHelper.rad(wheelAngle + 90);

            double wheel_r180 = AngleHelper.rad(-(wheelAngle + 0));
            double wheel_l180 = AngleHelper.rad(-(wheelAngle - 90));

            double zoffset_r = 0.375*Math.sin(wheel_r+((1.25/16f)*Math.cos(wheel_r)));
            double zoffset_l = 0.375*Math.sin(wheel_l+((1.25/16f)*Math.cos(wheel_l)));

            double zoffset_r180 = 0.375*Math.sin(wheel_r180+((1.25/16f)*Math.cos(wheel_r180)));
            double zoffset_l180 = 0.375*Math.sin(wheel_l180+((1.25/16f)*Math.cos(wheel_l180)));

            double xrotate_r = AngleHelper.deg(Math.asin(0.375*((-Math.cos(wheel_r)/2.4375))));
            double xrotate_l = AngleHelper.deg(Math.asin(0.375*((-Math.cos(wheel_l)/2.4375))));

            double xrotate_r180 = AngleHelper.deg(Math.asin(0.375*((-Math.cos(wheel_r180)/2.4375))));
            double xrotate_l180 = AngleHelper.deg(Math.asin(0.375*((-Math.cos(wheel_l180)/2.4375))));

            getTransform(EXTRA_LARGE_6_FRAME_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .render(ms, light, vb);

            BogeyModelData[] wheels = getTransform(EXTRA_LARGE_SHARED_WHEELS, ms, inInstancedContraption, 2);
            for (int side : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel = wheels[(side + 1) / 2];
                wheel.rotateY(forwards ? 0 : 180)
                        .translate(0, 1.25, side * 2.25)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            getTransform(EXTRA_LARGE_SHARED_WHEELS_SEMI_BLIND, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1.25, 0)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 0, 0)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_6_SHARED_RIGHT_C_ROD, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 3 / 8f, 0)
                    .rotateX(forwards ? -wheelAngle : wheelAngle)
                    .translateY(1.25)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_6_SHARED_LEFT_C_ROD, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle + 90 : -wheelAngle + 90)
                    .translate(0, 3 / 8f, 0)
                    .rotateX(forwards ? -wheelAngle - 90 : wheelAngle - 90)
                    .translateY(1.25)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_6_RIGHT_P_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0,1.25,0)
                    .translateZ(forwards ? zoffset_r : zoffset_r180)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_6_LEFT_P_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0,1.25,0)
                    .translateZ(forwards ? zoffset_l : zoffset_l180)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_6_RIGHT_M_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1.25, -2.4375)
                    .translateZ(forwards ? zoffset_r : zoffset_r180)
                    .rotateX(forwards ? xrotate_r : xrotate_r180)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_6_LEFT_M_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1.25, -2.4375)
                    .translateZ(forwards ? zoffset_l : zoffset_l180)
                    .rotateX(forwards ? xrotate_l : xrotate_l180)
                    .render(ms, light, vb);
        }
    }
    public static class ExtraLargeTripleAxlePistonlessBogeyRenderer extends BogeyRenderer {
        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, EXTRA_LARGE_6_FRAME_PISTONLESS);
            createModelInstance(materialManager, EXTRA_LARGE_SHARED_WHEELS, 2);
            createModelInstance(materialManager, EXTRA_LARGE_SHARED_WHEELS_SEMI_BLIND);
            createModelInstance(materialManager, EXTRA_LARGE_6_RIGHT_C_ROD_PISTONLESS);
            createModelInstance(materialManager, EXTRA_LARGE_6_LEFT_C_ROD_PISTONLESS);
        }
        @Override
        public BogeySizes.BogeySize getSize() {
            return BogeySizes.LARGE;
        }
        @Override
        public void render(CompoundTag bogeyData, float wheelAngle, PoseStack ms, int light, VertexConsumer vb, boolean inContraption) {
            boolean inInstancedContraption = vb == null;

            getTransform(EXTRA_LARGE_6_FRAME_PISTONLESS, ms, inInstancedContraption)
                    .render(ms, light, vb);

            BogeyModelData[] wheels = getTransform(EXTRA_LARGE_SHARED_WHEELS, ms, inInstancedContraption, 2);
            for (int side : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel = wheels[(side + 1) / 2];
                    wheel
                        .translate(0, 1.25, side * 2.25)
                        .rotateX(wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            getTransform(EXTRA_LARGE_SHARED_WHEELS_SEMI_BLIND, ms, inInstancedContraption)
                    .translate(0, 1.25, 0)
                    .rotateX(wheelAngle)
                    .translate(0, 0, 0)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_6_RIGHT_C_ROD_PISTONLESS, ms, inInstancedContraption)
                    .rotateX(wheelAngle)
                    .translate(0, 3 / 8f, 0)
                    .rotateX(-wheelAngle)
                    .translateY(1.25)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_6_LEFT_C_ROD_PISTONLESS, ms, inInstancedContraption)
                    .rotateX(wheelAngle + 90)
                    .translate(0, 3 / 8f, 0)
                    .rotateX(-wheelAngle - 90)
                    .translateY(1.25)
                    .render(ms, light, vb);
        }
    }
    public static class ExtraLargeTripleExtendedAxleLongBogeyRenderer extends ExtendedBogeysBogeyRenderer {
        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, EXTRA_LARGE_6E_FRAME_LONG);
            createModelInstance(materialManager, EXTRA_LARGE_SHARED_WHEELS, 2);
            createModelInstance(materialManager, EXTRA_LARGE_SHARED_WHEELS_SEMI_BLIND);
            createModelInstance(materialManager, EXTRA_LARGE_6E_SHARED_RIGHT_C_ROD);
            createModelInstance(materialManager, EXTRA_LARGE_6E_SHARED_LEFT_C_ROD);
            createModelInstance(materialManager, EXTRA_LARGE_6_RIGHT_P_ROD_LONG);
            createModelInstance(materialManager, EXTRA_LARGE_6_LEFT_P_ROD_LONG);
            createModelInstance(materialManager, EXTRA_LARGE_6_RIGHT_M_ROD_LONG);
            createModelInstance(materialManager, EXTRA_LARGE_6_LEFT_M_ROD_LONG);
        }
        @Override
        public BogeySizes.BogeySize getSize() {
            return BogeySizes.LARGE;
        }
        @Override
        public void render(boolean forwards, float wheelAngle, PoseStack ms, int light, VertexConsumer vb, boolean inContraption) {
            boolean inInstancedContraption = vb == null;

            double wheel_r = AngleHelper.rad(wheelAngle + 0);
            double wheel_l = AngleHelper.rad(wheelAngle + 90);

            double wheel_r180 = AngleHelper.rad(-(wheelAngle + 0));
            double wheel_l180 = AngleHelper.rad(-(wheelAngle - 90));

            double zoffset_r = 0.375*Math.sin(wheel_r+((1.25/16f)*Math.cos(wheel_r)));
            double zoffset_l = 0.375*Math.sin(wheel_l+((1.25/16f)*Math.cos(wheel_l)));

            double zoffset_r180 = 0.375*Math.sin(wheel_r180+((1.25/16f)*Math.cos(wheel_r180)));
            double zoffset_l180 = 0.375*Math.sin(wheel_l180+((1.25/16f)*Math.cos(wheel_l180)));

            double xrotate_r = AngleHelper.deg(Math.asin(0.375*((-Math.cos(wheel_r)/3.4375))));
            double xrotate_l = AngleHelper.deg(Math.asin(0.375*((-Math.cos(wheel_l)/3.4375))));

            double xrotate_r180 = AngleHelper.deg(Math.asin(0.375*((-Math.cos(wheel_r180)/3.4375))));
            double xrotate_l180 = AngleHelper.deg(Math.asin(0.375*((-Math.cos(wheel_l180)/3.4375))));

            getTransform(EXTRA_LARGE_6E_FRAME_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .render(ms, light, vb);

            BogeyModelData[] wheels = getTransform(EXTRA_LARGE_SHARED_WHEELS, ms, inInstancedContraption, 2);
            for (int side : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel = wheels[(side + 1) / 2];
                wheel.rotateY(forwards ? 0 : 180)
                        .translate(0, 1.25, 0.5625 + side * 2.8125)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            getTransform(EXTRA_LARGE_SHARED_WHEELS_SEMI_BLIND, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1.25, 0)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 0, 0)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_6E_SHARED_RIGHT_C_ROD, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 3 / 8f, 0)
                    .rotateX(forwards ? -wheelAngle : wheelAngle)
                    .translateY(1.25)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_6E_SHARED_LEFT_C_ROD, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle + 90 : -wheelAngle + 90)
                    .translate(0, 3 / 8f, 0)
                    .rotateX(forwards ? -wheelAngle - 90 : wheelAngle - 90)
                    .translateY(1.25)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_6_RIGHT_P_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0,1.25,0)
                    .translateZ(forwards ? zoffset_r : zoffset_r180)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_6_LEFT_P_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0,1.25,0)
                    .translateZ(forwards ? zoffset_l : zoffset_l180)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_6_RIGHT_M_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1.25, -3.4375)
                    .translateZ(forwards ? zoffset_r : zoffset_r180)
                    .rotateX(forwards ? xrotate_r : xrotate_r180)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_6_LEFT_M_ROD_LONG, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1.25, -3.4375)
                    .translateZ(forwards ? zoffset_l : zoffset_l180)
                    .rotateX(forwards ? xrotate_l : xrotate_l180)
                    .render(ms, light, vb);
        }
    }
    public static class ExtraLargeTripleExtendedAxleShortBogeyRenderer extends ExtendedBogeysBogeyRenderer {
        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, EXTRA_LARGE_6E_FRAME_SHORT);
            createModelInstance(materialManager, EXTRA_LARGE_SHARED_WHEELS, 2);
            createModelInstance(materialManager, EXTRA_LARGE_SHARED_WHEELS_SEMI_BLIND);
            createModelInstance(materialManager, EXTRA_LARGE_6E_SHARED_RIGHT_C_ROD);
            createModelInstance(materialManager, EXTRA_LARGE_6E_SHARED_LEFT_C_ROD);
            createModelInstance(materialManager, EXTRA_LARGE_6_RIGHT_P_ROD_SHORT);
            createModelInstance(materialManager, EXTRA_LARGE_6_LEFT_P_ROD_SHORT);
            createModelInstance(materialManager, EXTRA_LARGE_6_RIGHT_M_ROD_SHORT);
            createModelInstance(materialManager, EXTRA_LARGE_6_LEFT_M_ROD_SHORT);
        }
        @Override
        public BogeySizes.BogeySize getSize() {
            return BogeySizes.LARGE;
        }
        @Override
        public void render(boolean forwards, float wheelAngle, PoseStack ms, int light, VertexConsumer vb, boolean inContraption) {
            boolean inInstancedContraption = vb == null;

            double wheel_r = AngleHelper.rad(wheelAngle + 0);
            double wheel_l = AngleHelper.rad(wheelAngle + 90);

            double wheel_r180 = AngleHelper.rad(-(wheelAngle + 0));
            double wheel_l180 = AngleHelper.rad(-(wheelAngle - 90));

            double zoffset_r = 0.375*Math.sin(wheel_r+((1.25/16f)*Math.cos(wheel_r)));
            double zoffset_l = 0.375*Math.sin(wheel_l+((1.25/16f)*Math.cos(wheel_l)));

            double zoffset_r180 = 0.375*Math.sin(wheel_r180+((1.25/16f)*Math.cos(wheel_r180)));
            double zoffset_l180 = 0.375*Math.sin(wheel_l180+((1.25/16f)*Math.cos(wheel_l180)));

            double xrotate_r = AngleHelper.deg(Math.asin(0.375*((-Math.cos(wheel_r)/2.4375))));
            double xrotate_l = AngleHelper.deg(Math.asin(0.375*((-Math.cos(wheel_l)/2.4375))));

            double xrotate_r180 = AngleHelper.deg(Math.asin(0.375*((-Math.cos(wheel_r180)/2.4375))));
            double xrotate_l180 = AngleHelper.deg(Math.asin(0.375*((-Math.cos(wheel_l180)/2.4375))));

            getTransform(EXTRA_LARGE_6E_FRAME_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .render(ms, light, vb);

            BogeyModelData[] wheels = getTransform(EXTRA_LARGE_SHARED_WHEELS, ms, inInstancedContraption, 2);
            for (int side : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel = wheels[(side + 1) / 2];
                wheel.rotateY(forwards ? 0 : 180)
                        .translate(0, 1.25, 0.5625 + side * 2.8125)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            getTransform(EXTRA_LARGE_SHARED_WHEELS_SEMI_BLIND, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1.25, 0)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 0, 0)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_6E_SHARED_RIGHT_C_ROD, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 3 / 8f, 0)
                    .rotateX(forwards ? -wheelAngle : wheelAngle)
                    .translateY(1.25)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_6E_SHARED_LEFT_C_ROD, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle + 90 : -wheelAngle + 90)
                    .translate(0, 3 / 8f, 0)
                    .rotateX(forwards ? -wheelAngle - 90 : wheelAngle - 90)
                    .translateY(1.25)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_6_RIGHT_P_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0,1.25,0)
                    .translateZ(forwards ? zoffset_r : zoffset_r180)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_6_LEFT_P_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0,1.25,0)
                    .translateZ(forwards ? zoffset_l : zoffset_l180)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_6_RIGHT_M_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1.25, -2.4375)
                    .translateZ(forwards ? zoffset_r : zoffset_r180)
                    .rotateX(forwards ? xrotate_r : xrotate_r180)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_6_LEFT_M_ROD_SHORT, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1.25, -2.4375)
                    .translateZ(forwards ? zoffset_l : zoffset_l180)
                    .rotateX(forwards ? xrotate_l : xrotate_l180)
                    .render(ms, light, vb);
        }
    }
    public static class ExtraLargeTripleExtendedAxlePistonlessBogeyRenderer extends ExtendedBogeysBogeyRenderer {
        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, EXTRA_LARGE_6E_FRAME_PISTONLESS);
            createModelInstance(materialManager, EXTRA_LARGE_SHARED_WHEELS, 2);
            createModelInstance(materialManager, EXTRA_LARGE_SHARED_WHEELS_SEMI_BLIND);
            createModelInstance(materialManager, EXTRA_LARGE_6E_RIGHT_C_ROD_PISTONLESS);
            createModelInstance(materialManager, EXTRA_LARGE_6E_LEFT_C_ROD_PISTONLESS);
        }
        @Override
        public BogeySizes.BogeySize getSize() {
            return BogeySizes.LARGE;
        }
        @Override
        public void render(boolean forwards, float wheelAngle, PoseStack ms, int light, VertexConsumer vb, boolean inContraption) {
            boolean inInstancedContraption = vb == null;

            getTransform(EXTRA_LARGE_6E_FRAME_PISTONLESS, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .render(ms, light, vb);

            BogeyModelData[] wheels = getTransform(EXTRA_LARGE_SHARED_WHEELS, ms, inInstancedContraption, 2);
            for (int side : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel = wheels[(side + 1) / 2];
                wheel.rotateY(forwards ? 0 : 180)
                        .translate(0, 1.25, 0.5625 + side * 2.8125)
                        .rotateX(forwards ? wheelAngle: -wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            getTransform(EXTRA_LARGE_SHARED_WHEELS_SEMI_BLIND, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .translate(0, 1.25, 0)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 0, 0)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_6E_RIGHT_C_ROD_PISTONLESS, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle : -wheelAngle)
                    .translate(0, 3 / 8f, 0)
                    .rotateX(forwards ? -wheelAngle : wheelAngle)
                    .translateY(1.25)
                    .render(ms, light, vb);

            getTransform(EXTRA_LARGE_6E_LEFT_C_ROD_PISTONLESS, ms, inInstancedContraption)
                    .rotateY(forwards ? 0 : 180)
                    .rotateX(forwards ? wheelAngle + 90 : -wheelAngle + 90)
                    .translate(0, 3 / 8f, 0)
                    .rotateX(forwards ? -wheelAngle - 90 : wheelAngle - 90)
                    .translateY(1.25)
                    .render(ms, light, vb);
        }
    }
    public static class ExtraLargeTripleAxleBogeyRenderer extends BogeyRenderer {
        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, CREATE_EXTRA_LARGE_SHARED_WHEELS, 2);
            createModelInstance(materialManager, CREATE_EXTRA_LARGE_SHARED_WHEELS_SEMI_BLIND);
            createModelInstance(materialManager, CREATE_EXTRA_LARGE_6_FRAME);
            createModelInstance(materialManager, CREATE_EXTRA_LARGE_6_PINS_RIGHT);
            createModelInstance(materialManager, CREATE_EXTRA_LARGE_6_PINS_LEFT);
            createModelInstance(materialManager, CREATE_EXTRA_LARGE_6_PISTON_RIGHT);
            createModelInstance(materialManager, CREATE_EXTRA_LARGE_6_PISTON_LEFT);
        }

        @Override
        public BogeySizes.BogeySize getSize() {
            return BogeySizes.LARGE;
        }

        @Override
        public void render(CompoundTag bogeyData, float wheelAngle, PoseStack ms, int light, VertexConsumer vb, boolean inContraption) {
            boolean inInstancedContraption = vb == null;

            getTransform(CREATE_EXTRA_LARGE_6_FRAME, ms, inInstancedContraption)
                    .render(ms, light, vb);

            getTransform(CREATE_EXTRA_LARGE_SHARED_WHEELS_SEMI_BLIND, ms, inInstancedContraption)
                    .translate(0,1.25,0)
                    .rotateX(wheelAngle)
                    .render(ms, light, vb);

            BogeyModelData[] wheels = getTransform(CREATE_EXTRA_LARGE_SHARED_WHEELS, ms, inInstancedContraption, 2);
            for (int side : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel = wheels[(side + 1) / 2];
                wheel.translate(0, 1.25, side * 2.25)
                        .rotateX(wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            getTransform(CREATE_EXTRA_LARGE_6_PISTON_LEFT, ms, inInstancedContraption)
                    .translate(0, 1.25, 3 / 8f * Math.sin(AngleHelper.rad(wheelAngle)))
                    .render(ms, light, vb);

            getTransform(CREATE_EXTRA_LARGE_6_PISTON_RIGHT, ms, inInstancedContraption)
                    .translate(0, 1.25, 3 / 8f * Math.sin(AngleHelper.rad(wheelAngle + 180)))
                    .render(ms, light, vb);

            getTransform(CREATE_EXTRA_LARGE_6_PINS_LEFT, ms, inInstancedContraption)
                    .translate(0, 1.25, 0)
                    .rotateX(wheelAngle)
                    .translate(0, 3 / 8f, 0)
                    .rotateX(-wheelAngle)
                    .render(ms, light, vb);

            getTransform(CREATE_EXTRA_LARGE_6_PINS_RIGHT, ms, inInstancedContraption)
                    .translate(0, 1.25, 0)
                    .rotateX(wheelAngle + 180)
                    .translate(0, 3 / 8f, 0)
                    .rotateX(-wheelAngle - 180)
                    .render(ms, light, vb);
        }
    }
}