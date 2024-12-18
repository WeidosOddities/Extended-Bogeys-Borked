package com.rabbitminers.extendedbogeys.bogeys.styles;

import com.jozufozu.flywheel.api.MaterialManager;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.simibubi.create.content.trains.bogey.BogeySizes;
import com.simibubi.create.content.trains.entity.CarriageBogey;
import com.simibubi.create.foundation.utility.AngleHelper;
import com.simibubi.create.content.trains.bogey.BogeyRenderer;
import com.simibubi.create.foundation.utility.Iterate;
import net.minecraft.nbt.CompoundTag;

import static com.rabbitminers.extendedbogeys.registry.ExtendedBogeysPartials.*;

public class WalschaertsBogeyRenderer {
    public static class LargeTripleAxleShortWalschaertsBogeyRenderer extends BogeyRenderer {
        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, L_A6S_WALSCHAERTS_FRAME);
            createModelInstance(materialManager, L_WALSCHAERTS_WHEEL_CENTER);
            createModelInstance(materialManager, L_WALSCHAERTS_WHEEL_OUTER, 2);
            createModelInstance(materialManager, L_WALSCHAERTS_ECCENTRIC);

            createModelInstance(materialManager, L_R6S_WALSCHAERTS_C_LEVER);
            createModelInstance(materialManager, L_R6S_WALSCHAERTS_C_ROD);
            createModelInstance(materialManager, L_R6S_WALSCHAERTS_E_LINK);
            createModelInstance(materialManager, L_R6S_WALSCHAERTS_E_ROD);
            createModelInstance(materialManager, L_R6S_WALSCHAERTS_M_ROD);
            createModelInstance(materialManager, L_R6S_WALSCHAERTS_P_ROD);
            createModelInstance(materialManager, L_R6S_WALSCHAERTS_R_BAR);
            createModelInstance(materialManager, L_R6S_WALSCHAERTS_U_LINK);
            createModelInstance(materialManager, L_R6S_WALSCHAERTS_V_STEM);

            createModelInstance(materialManager, L_L6S_WALSCHAERTS_C_LEVER);
            createModelInstance(materialManager, L_L6S_WALSCHAERTS_C_ROD);
            createModelInstance(materialManager, L_L6S_WALSCHAERTS_E_LINK);
            createModelInstance(materialManager, L_L6S_WALSCHAERTS_E_ROD);
            createModelInstance(materialManager, L_L6S_WALSCHAERTS_M_ROD);
            createModelInstance(materialManager, L_L6S_WALSCHAERTS_P_ROD);
            createModelInstance(materialManager, L_L6S_WALSCHAERTS_R_BAR);
            createModelInstance(materialManager, L_L6S_WALSCHAERTS_U_LINK);
            createModelInstance(materialManager, L_L6S_WALSCHAERTS_V_STEM);

        }
        @Override
        public BogeySizes.BogeySize getSize() {
            return BogeySizes.LARGE;
        }
        @Override
        public void render(CompoundTag bogeyData, float wheelAngle, PoseStack ms, int light, VertexConsumer vb, boolean inContraption) {
            boolean inInstancedContraption = vb == null;

            double r_a_wheel = AngleHelper.rad(wheelAngle-180);
            double r_a_ecentric = AngleHelper.rad(wheelAngle-90);

            double y_height = 1;
            double offset_piston = 1.6734375;
            double wheel_spacing = 1.6875;

            double radius_crank = 0.25;
            double radius_eccentric = 0.1875;
            double length_combination_lever = 1;
            double length_main_rod = 1.6875;
            double length_eccentric_rod = 1;
            double length_union_link = 0.375;
            double length_expansion_link = 0.5625;
            double length_radius_bar = 1.125;
            double rotation_radius_bar = 12.5;
            double offset_valve_stem = 0.25;

            double radius_bar_x = length_radius_bar * Math.cos(AngleHelper.rad(rotation_radius_bar));
            double radius_bar_y = length_radius_bar * Math.sin(AngleHelper.rad(rotation_radius_bar));

            double r_eccentric_val_flip = Math.asin((radius_eccentric*Math.sin(r_a_ecentric+Math.PI))/length_expansion_link);
            double r_x1 = ((length_combination_lever+radius_bar_x)+radius_eccentric*Math.sin(r_eccentric_val_flip))-(radius_crank*Math.sin(r_a_wheel+Math.PI)+Math.sqrt(Math.pow(length_main_rod, 2) - Math.pow(radius_crank, 2) * Math.pow(Math.cos(r_a_wheel + Math.PI), 2)));
            double r_y1 = ((length_expansion_link+radius_bar_y)+radius_eccentric*(-Math.cos(r_eccentric_val_flip)))-(-length_union_link);
            double r_distance = Math.sqrt(Math.pow(r_x1,2)+Math.pow(r_y1,2));
            double r_comb = Math.acos((Math.pow(r_distance,2)+Math.pow(length_combination_lever,2)-Math.pow(length_union_link,2))/(2 *r_distance*length_combination_lever));
            double r_union = Math.acos((Math.pow(r_distance,2)+Math.pow(length_union_link,2)-Math.pow(length_combination_lever,2))/(2*r_distance*length_union_link));
            double r_atan2_union = Math.atan2(r_y1,r_x1);
            double r_atan2_comb = Math.atan2(r_x1,r_y1);
            double r_unionAngle = AngleHelper.deg(r_atan2_union-r_union);
            double r_combAngle = -AngleHelper.deg(r_atan2_comb-r_comb);
            double r_piston_stroke = radius_crank*Math.sin(r_a_wheel)+Math.sqrt(Math.pow(length_main_rod,2)-Math.pow(radius_crank,2)*Math.pow(Math.cos(r_a_wheel),2));
            double r_eccentric_val = Math.asin(radius_eccentric*Math.sin(r_a_ecentric)/length_expansion_link);
            double r_eccentric_cos = Math.cos(r_eccentric_val);
            double r_eccentric_sin = Math.sin(r_eccentric_val);
            double r_m_rod_rotate = AngleHelper.deg(Math.asin(radius_crank*((-Math.cos(r_a_wheel)/length_main_rod))));
            double r_m_rod_z = radius_crank*Math.sin(r_a_wheel+((1.25/16f)*Math.cos(r_a_wheel)));
            double r_e_rod_z = radius_eccentric*Math.sin(r_a_ecentric);
            double r_e_rod_y = length_expansion_link+length_expansion_link*(-r_eccentric_cos);
            double r_e_rod_rotate = 0.845+AngleHelper.deg(Math.asin(radius_eccentric*((-Math.cos(r_a_ecentric))/length_eccentric_rod)));
            double r_e_link_rotate = AngleHelper.deg(Math.asin(radius_eccentric*((-Math.sin(r_a_ecentric)/length_expansion_link))));
            double r_r_bar_z = radius_eccentric*r_eccentric_sin;
            double r_r_bar_y = length_expansion_link+radius_eccentric*(-r_eccentric_cos);
            double r_c_lever_z = radius_eccentric*r_eccentric_sin;
            double r_c_lever_y = (length_expansion_link+radius_bar_y)+radius_eccentric*(-r_eccentric_cos);
            double r_v_stem_z = (radius_eccentric*r_eccentric_sin)+(radius_eccentric*Math.sin(r_atan2_union+radius_bar_x))+0.03125;

            double l_a_wheel = AngleHelper.rad((wheelAngle-180)-90);
            double l_a_ecentric = AngleHelper.rad((wheelAngle-90)-90);

            double l_eccentric_val_flip = Math.asin((radius_eccentric*Math.sin(l_a_ecentric+Math.PI))/length_expansion_link);
            double l_x1 = ((length_combination_lever+radius_bar_x)+radius_eccentric*Math.sin(l_eccentric_val_flip))-(radius_crank*Math.sin(l_a_wheel+Math.PI)+Math.sqrt(Math.pow(length_main_rod, 2)-Math.pow(radius_crank, 2) * Math.pow(Math.cos(l_a_wheel + Math.PI), 2)));
            double l_y1 = ((length_expansion_link+radius_bar_y)+radius_eccentric*(-Math.cos(l_eccentric_val_flip)))-(-length_union_link);
            double l_distance = Math.sqrt(Math.pow(l_x1,2)+Math.pow(l_y1,2));
            double l_comb = Math.acos((Math.pow(l_distance,2)+Math.pow(length_combination_lever,2)-Math.pow(length_union_link,2))/(2*l_distance*length_combination_lever));
            double l_union = Math.acos((Math.pow(l_distance,2)+Math.pow(length_union_link,2)-Math.pow(length_combination_lever,2))/(2*l_distance*length_union_link));
            double l_atan2_union = Math.atan2(l_y1,l_x1);
            double l_atan2_comb = Math.atan2(l_x1,l_y1);
            double l_unionAngle = AngleHelper.deg(l_atan2_union-l_union);
            double l_combAngle = -AngleHelper.deg(l_atan2_comb-l_comb);
            double l_piston_stroke = radius_crank*Math.sin(l_a_wheel)+Math.sqrt(Math.pow(length_main_rod,2)-Math.pow(radius_crank,2)*Math.pow(Math.cos(l_a_wheel),2));
            double l_eccentric_val = Math.asin(radius_eccentric*Math.sin(l_a_ecentric)/length_expansion_link);
            double l_eccentric_cos = Math.cos(l_eccentric_val);
            double l_eccentric_sin = Math.sin(l_eccentric_val);
            double l_m_rod_rotate = AngleHelper.deg(Math.asin(radius_crank*((-Math.cos(l_a_wheel)/length_main_rod))));
            double l_m_rod_z = radius_crank*Math.sin(l_a_wheel+((1.25/16f)*Math.cos(l_a_wheel)));
            double l_e_rod_z = radius_eccentric*Math.sin(l_a_ecentric);
            double l_e_rod_y = length_expansion_link+length_expansion_link*(-l_eccentric_cos);
            double l_e_rod_rotate = 0.845+AngleHelper.deg(Math.asin(radius_eccentric*((-Math.cos(l_a_ecentric))/length_eccentric_rod)));
            double l_e_link_rotate = AngleHelper.deg(Math.asin(radius_eccentric*((-Math.sin(l_a_ecentric)/length_expansion_link))));
            double l_r_bar_z = radius_eccentric*l_eccentric_sin;
            double l_r_bar_y = length_expansion_link+radius_eccentric*(-l_eccentric_cos);
            double l_c_lever_z = radius_eccentric*l_eccentric_sin;
            double l_c_lever_y = (length_expansion_link+radius_bar_y)+radius_eccentric*(-l_eccentric_cos);
            double l_v_stem_z = (radius_eccentric*l_eccentric_sin)+(radius_eccentric*Math.sin(l_atan2_union+radius_bar_x))+0.03125;

            getTransform(L_A6S_WALSCHAERTS_FRAME, ms, inInstancedContraption)
                    .render(ms, light, vb);

            BogeyModelData[] wheels = getTransform(L_WALSCHAERTS_WHEEL_OUTER, ms, inInstancedContraption, 2);
            for (int side : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel = wheels[(side + 1) / 2];
                wheel
                        .translate(0, y_height, side * wheel_spacing)
                        .rotateX(wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            getTransform(L_WALSCHAERTS_WHEEL_CENTER, ms, inInstancedContraption)
                    .translateY(y_height)
                    .rotateX(wheelAngle)
                    .render(ms, light, vb);

            getTransform(L_WALSCHAERTS_ECCENTRIC, ms, inInstancedContraption)
                    .translateY(y_height)
                    .rotateX(wheelAngle)
                    .render(ms, light, vb);

            getTransform(L_R6S_WALSCHAERTS_C_ROD, ms, inInstancedContraption)
                    .rotateX(wheelAngle - 180)
                    .translateY(radius_crank)
                    .rotateX(-(wheelAngle - 180))
                    .translateY(y_height)
                    .render(ms, light, vb);

            getTransform(L_R6S_WALSCHAERTS_P_ROD, ms, inInstancedContraption)
                    .translateZ(r_piston_stroke - offset_piston)
                    .render(ms, light, vb);

            getTransform(L_R6S_WALSCHAERTS_M_ROD, ms, inInstancedContraption)
                    .translateY(y_height)
                    .translateZ(r_m_rod_z - offset_piston)
                    .rotateX(r_m_rod_rotate)
                    .render(ms, light, vb);

            getTransform(L_R6S_WALSCHAERTS_E_ROD, ms, inInstancedContraption)
                    .translateZ(r_e_rod_z - length_eccentric_rod)
                    .translateY(y_height + r_e_rod_y)
                    .rotateX(r_e_rod_rotate)
                    .render(ms, light, vb);

            getTransform(L_R6S_WALSCHAERTS_E_LINK, ms, inInstancedContraption)
                    .translateY(y_height + length_expansion_link)
                    .translateZ(-length_eccentric_rod)
                    .rotateX(r_e_link_rotate)
                    .render(ms, light, vb);

            getTransform(L_R6S_WALSCHAERTS_U_LINK, ms, inInstancedContraption)
                    .translateY(y_height - length_union_link)
                    .translateZ(-offset_piston + r_piston_stroke - offset_piston)
                    .rotateX(r_unionAngle)
                    .render(ms, light, vb);

            getTransform(L_R6S_WALSCHAERTS_R_BAR, ms, inInstancedContraption)
                    .translateY(y_height + r_r_bar_y)
                    .translateZ(-length_eccentric_rod + r_r_bar_z)
                    .rotateX(rotation_radius_bar)
                    .render(ms, light, vb);

            getTransform(L_R6S_WALSCHAERTS_V_STEM, ms, inInstancedContraption)
                    .translateZ(r_v_stem_z - offset_valve_stem)
                    .render(ms, light, vb);

            getTransform(L_R6S_WALSCHAERTS_C_LEVER, ms, inInstancedContraption)
                    .translateZ(-length_eccentric_rod - radius_bar_x + r_c_lever_z)
                    .translateY(y_height + r_c_lever_y)
                    .rotateX(r_combAngle)
                    .render(ms, light, vb);

            getTransform(L_L6S_WALSCHAERTS_C_ROD, ms, inInstancedContraption)
                    .rotateX(wheelAngle - 180)
                    .translateY(radius_crank)
                    .rotateX(-(wheelAngle - 180))
                    .translateY(y_height)
                    .render(ms, light, vb);

            getTransform(L_L6S_WALSCHAERTS_P_ROD, ms, inInstancedContraption)
                    .translateZ(l_piston_stroke - offset_piston)
                    .render(ms, light, vb);

            getTransform(L_L6S_WALSCHAERTS_M_ROD, ms, inInstancedContraption)
                    .translateY(y_height)
                    .translateZ(l_m_rod_z - offset_piston)
                    .rotateX(l_m_rod_rotate)
                    .render(ms, light, vb);

            getTransform(L_L6S_WALSCHAERTS_E_ROD, ms, inInstancedContraption)
                    .translateZ(l_e_rod_z - length_eccentric_rod)
                    .translateY(y_height + l_e_rod_y)
                    .rotateX(l_e_rod_rotate)
                    .render(ms, light, vb);

            getTransform(L_L6S_WALSCHAERTS_E_LINK, ms, inInstancedContraption)
                    .translateY(y_height + length_expansion_link)
                    .translateZ(-length_eccentric_rod)
                    .rotateX(l_e_link_rotate)
                    .render(ms, light, vb);

            getTransform(L_L6S_WALSCHAERTS_U_LINK, ms, inInstancedContraption)
                    .translateY(y_height - length_union_link)
                    .translateZ(-offset_piston + l_piston_stroke - offset_piston)
                    .rotateX(l_unionAngle)
                    .render(ms, light, vb);

            getTransform(L_L6S_WALSCHAERTS_R_BAR, ms, inInstancedContraption)
                    .translateY(y_height + l_r_bar_y)
                    .translateZ(-length_eccentric_rod + l_r_bar_z)
                    .rotateX(rotation_radius_bar)
                    .render(ms, light, vb);

            getTransform(L_L6S_WALSCHAERTS_V_STEM, ms, inInstancedContraption)
                    .translateZ(l_v_stem_z - offset_valve_stem)
                    .render(ms, light, vb);

            getTransform(L_L6S_WALSCHAERTS_C_LEVER, ms, inInstancedContraption)
                    .translateZ(-length_eccentric_rod - radius_bar_x + l_c_lever_z)
                    .translateY(y_height + l_c_lever_y)
                    .rotateX(l_combAngle)
                    .render(ms, light, vb);
        }
    }

    public static class ExtraLargeTripleAxleLongWalschaertsBogeyRenderer extends BogeyRenderer {
        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, XL_A6L_WALSCHAERTS_FRAME);
            createModelInstance(materialManager, XL_WALSCHAERTS_WHEEL_CENTER);
            createModelInstance(materialManager, XL_WALSCHAERTS_WHEEL_OUTER, 2);
            createModelInstance(materialManager, XL_WALSCHAERTS_ECCENTRIC);

            createModelInstance(materialManager, XL_R6L_WALSCHAERTS_C_LEVER);
            createModelInstance(materialManager, XL_R6L_WALSCHAERTS_C_ROD);
            createModelInstance(materialManager, XL_R6L_WALSCHAERTS_E_LINK);
            createModelInstance(materialManager, XL_R6L_WALSCHAERTS_E_ROD);
            createModelInstance(materialManager, XL_R6L_WALSCHAERTS_M_ROD);
            createModelInstance(materialManager, XL_R6L_WALSCHAERTS_P_ROD);
            createModelInstance(materialManager, XL_R6L_WALSCHAERTS_R_BAR);
            createModelInstance(materialManager, XL_R6L_WALSCHAERTS_U_LINK);
            createModelInstance(materialManager, XL_R6L_WALSCHAERTS_V_STEM);

            createModelInstance(materialManager, XL_L6L_WALSCHAERTS_C_LEVER);
            createModelInstance(materialManager, XL_L6L_WALSCHAERTS_C_ROD);
            createModelInstance(materialManager, XL_L6L_WALSCHAERTS_E_LINK);
            createModelInstance(materialManager, XL_L6L_WALSCHAERTS_E_ROD);
            createModelInstance(materialManager, XL_L6L_WALSCHAERTS_M_ROD);
            createModelInstance(materialManager, XL_L6L_WALSCHAERTS_P_ROD);
            createModelInstance(materialManager, XL_L6L_WALSCHAERTS_R_BAR);
            createModelInstance(materialManager, XL_L6L_WALSCHAERTS_U_LINK);
            createModelInstance(materialManager, XL_L6L_WALSCHAERTS_V_STEM);

        }
        @Override
        public BogeySizes.BogeySize getSize() {
            return BogeySizes.LARGE;
        }
        @Override
        public void render(CompoundTag bogeyData, float wheelAngle, PoseStack ms, int light, VertexConsumer vb, boolean inContraption) {
            boolean inInstancedContraption = vb == null;

            double r_a_wheel = AngleHelper.rad(wheelAngle-180);
            double r_a_ecentric = AngleHelper.rad(wheelAngle-90);

            double r_eccentric_val_flip = Math.asin((0.25*Math.sin(r_a_ecentric+3.14159))/0.6875);
            double r_x1 = ((2+1.78746)+0.25*Math.sin(r_eccentric_val_flip))-(0.375*Math.sin(r_a_wheel+3.14159)+Math.sqrt(Math.pow(3.4375,2)-Math.pow(0.375,2)*Math.pow(Math.cos(r_a_wheel+3.14159),2)));
            double r_y1 = ((0.6875+0.29915)+0.25*(-Math.cos(r_eccentric_val_flip)))-(-0.3125);
            double r_distance = Math.sqrt(Math.pow(r_x1,2)+Math.pow(r_y1,2));
            double r_comb = Math.acos((Math.pow(r_distance,2)+Math.pow(1.0625,2)-Math.pow(0.4375,2))/(2*r_distance*1.0625));
            double r_union = Math.acos((Math.pow(r_distance,2)+Math.pow(0.4375,2)-Math.pow(1.0625,2))/(2*r_distance*0.4375));
            double r_atan2_union = Math.atan2(r_y1,r_x1);
            double r_atan2_comb = Math.atan2(r_x1,r_y1);
            double r_unionAngle = AngleHelper.deg(r_atan2_union-r_union);
            double r_combAngle = -AngleHelper.deg(r_atan2_comb-r_comb);
            double r_piston_stroke = 0.375*Math.sin(r_a_wheel)+Math.sqrt(Math.pow(3.4375,2)-Math.pow(0.375,2)*Math.pow(Math.cos(r_a_wheel),2));
            double r_eccentric_val = Math.asin(0.25*Math.sin(r_a_ecentric)/0.6875);
            double r_eccentric_cos = Math.cos(r_eccentric_val);
            double r_eccentric_sin = Math.sin(r_eccentric_val);
            double r_m_rod_rotate = AngleHelper.deg(Math.asin(0.375*((-Math.cos(r_a_wheel)/3.4375))));
            double r_m_rod_z = 0.375*Math.sin(r_a_wheel+((1.25/16f)*Math.cos(r_a_wheel)));
            double r_e_rod_z = 0.25*Math.sin(r_a_ecentric);
            double r_e_rod_y = 0.6875+0.6875*(-r_eccentric_cos);
            double r_e_rod_rotate = 0.845+AngleHelper.deg(Math.asin(0.25*((-Math.cos(r_a_ecentric)/2))));
            double r_e_link_rotate = AngleHelper.deg(Math.asin(0.25*((-Math.sin(r_a_ecentric)/0.6875))));
            double r_r_bar_z = 0.25*r_eccentric_sin;
            double r_r_bar_y = 0.6875+0.25*(-r_eccentric_cos);
            double r_c_lever_z = 0.25*r_eccentric_sin;
            double r_c_lever_y = (0.6875+0.29915)+0.25*(-r_eccentric_cos);
            double r_v_stem_z = (0.25*r_eccentric_sin)+(0.25*Math.sin(r_atan2_union+1.7625))+0.03125;

            double l_a_wheel = AngleHelper.rad((wheelAngle-180)-90);
            double l_a_ecentric = AngleHelper.rad((wheelAngle-90)-90);

            double l_eccentric_val_flip = Math.asin((0.25*Math.sin(l_a_ecentric+3.14159))/0.6875);
            double l_x1 = ((2+1.78746)+0.25*Math.sin(l_eccentric_val_flip))-(0.375*Math.sin(l_a_wheel+3.14159)+Math.sqrt(Math.pow(3.4375,2)-Math.pow(0.375,2)*Math.pow(Math.cos(l_a_wheel+3.14159),2)));
            double l_y1 = ((0.6875+0.29915)+0.25*(-Math.cos(l_eccentric_val_flip)))-(-0.3125);
            double l_distance = Math.sqrt(Math.pow(l_x1,2)+Math.pow(l_y1,2));
            double l_comb = Math.acos((Math.pow(l_distance,2)+Math.pow(1.0625,2)-Math.pow(0.4375,2))/(2*l_distance*1.0625));
            double l_union = Math.acos((Math.pow(l_distance,2)+Math.pow(0.4375,2)-Math.pow(1.0625,2))/(2*l_distance*0.4375));
            double l_atan2_union = Math.atan2(l_y1,l_x1);
            double l_atan2_comb = Math.atan2(l_x1,l_y1);
            double l_unionAngle = AngleHelper.deg(l_atan2_union-l_union);
            double l_combAngle = -AngleHelper.deg(l_atan2_comb-l_comb);
            double l_piston_stroke = 0.375*Math.sin(l_a_wheel)+Math.sqrt(Math.pow(3.4375,2)-Math.pow(0.375,2)*Math.pow(Math.cos(l_a_wheel),2));
            double l_eccentric_val = Math.asin(0.25*Math.sin(l_a_ecentric)/0.6875);
            double l_eccentric_cos = Math.cos(l_eccentric_val);
            double l_eccentric_sin = Math.sin(l_eccentric_val);
            double l_m_rod_rotate = AngleHelper.deg(Math.asin(0.375*((-Math.cos(l_a_wheel)/3.4375))));
            double l_m_rod_z = 0.375*Math.sin(l_a_wheel+((1.25/16f)*Math.cos(l_a_wheel)));
            double l_e_rod_z = 0.25*Math.sin(l_a_ecentric);
            double l_e_rod_y = 0.6875+0.6875*(-l_eccentric_cos);
            double l_e_rod_rotate = 0.845+AngleHelper.deg(Math.asin(0.25*((-Math.cos(l_a_ecentric)/2))));
            double l_e_link_rotate = AngleHelper.deg(Math.asin(0.25*((-Math.sin(l_a_ecentric)/0.6875))));
            double l_r_bar_z = 0.25*l_eccentric_sin;
            double l_r_bar_y = 0.6875+0.25*(-l_eccentric_cos);
            double l_c_lever_z = 0.25*l_eccentric_sin;
            double l_c_lever_y = (0.6875+0.29915)+0.25*(-l_eccentric_cos);
            double l_v_stem_z = (0.25*l_eccentric_sin)+(0.25*Math.sin(l_atan2_union+1.7625))+0.03125;

            getTransform(XL_A6L_WALSCHAERTS_FRAME, ms, inInstancedContraption)
                    .render(ms, light, vb);

            BogeyModelData[] wheels = getTransform(XL_WALSCHAERTS_WHEEL_OUTER, ms, inInstancedContraption, 2);
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

            getTransform(XL_WALSCHAERTS_WHEEL_CENTER, ms, inInstancedContraption)
                    .translate(0, 1.25, 0)
                    .rotateX(wheelAngle)
                    .translate(0, 0, 0)
                    .render(ms, light, vb);

            getTransform(XL_WALSCHAERTS_ECCENTRIC, ms, inInstancedContraption)
                    .translateY(1.25)
                    .rotateX(wheelAngle)
                    .render(ms, light, vb);

            getTransform(XL_R6L_WALSCHAERTS_C_ROD, ms, inInstancedContraption)
                    .rotateX(wheelAngle-180)
                    .translate(0, 0.375, 0)
                    .rotateX(-wheelAngle)
                    .translateY(-1.25)
                    .render(ms, light, vb);

            getTransform(XL_R6L_WALSCHAERTS_P_ROD, ms, inInstancedContraption)
                    .translateZ(r_piston_stroke-3.4375)
                    .render(ms, light, vb);

            getTransform(XL_R6L_WALSCHAERTS_M_ROD, ms, inInstancedContraption)
                    .translate(0, 1.25, -3.4375)
                    .translateZ(r_m_rod_z)
                    .rotateX(r_m_rod_rotate)
                    .render(ms, light, vb);

            getTransform(XL_R6L_WALSCHAERTS_E_ROD, ms, inInstancedContraption)
                    .translate(0, 1.25, -2.0)
                    .translateZ(r_e_rod_z)
                    .translateY(r_e_rod_y)
                    .rotateX(r_e_rod_rotate)
                    .render(ms, light, vb);

            getTransform(XL_R6L_WALSCHAERTS_E_LINK, ms, inInstancedContraption)
                    .translate(0, 1.9375, -2)
                    .rotateX(r_e_link_rotate)
                    .render(ms, light, vb);

            getTransform(XL_R6L_WALSCHAERTS_U_LINK, ms, inInstancedContraption)
                    .translateY(0.9375)
                    .translateZ(-3.4375+r_piston_stroke-3.415625)
                    .rotateX(r_unionAngle)
                    .render(ms, light, vb);

            getTransform(XL_R6L_WALSCHAERTS_R_BAR, ms, inInstancedContraption)
                    .translateY(1.25+r_r_bar_y)
                    .translateZ(-2+r_r_bar_z)
                    .rotateX(10)
                    .render(ms, light, vb);

            getTransform(XL_R6L_WALSCHAERTS_V_STEM, ms, inInstancedContraption)
                    .translateZ(r_v_stem_z)
                    .render(ms, light, vb);

            getTransform(XL_R6L_WALSCHAERTS_C_LEVER, ms, inInstancedContraption)
                    .translateZ(-3.8439+r_c_lever_z+0.0625)
                    .translateY(1.25+r_c_lever_y)
                    .rotateX(r_combAngle)
                    .render(ms, light, vb);


            getTransform(XL_L6L_WALSCHAERTS_C_ROD, ms, inInstancedContraption)
                    .rotateX((wheelAngle-180)-90)
                    .translate(0, 0.375, 0)
                    .rotateX((-wheelAngle)-90)
                    .translateY(1.25)
                    .render(ms, light, vb);

            getTransform(XL_L6L_WALSCHAERTS_P_ROD, ms, inInstancedContraption)
                    .translateZ(l_piston_stroke-3.4375)
                    .render(ms, light, vb);

            getTransform(XL_L6L_WALSCHAERTS_M_ROD, ms, inInstancedContraption)
                    .translate(0, 1.25, -3.4375)
                    .translateZ(l_m_rod_z)
                    .rotateX(l_m_rod_rotate)
                    .render(ms, light, vb);

            getTransform(XL_L6L_WALSCHAERTS_E_ROD, ms, inInstancedContraption)
                    .translate(0, 1.25, -2.0)
                    .translateZ(l_e_rod_z)
                    .translateY(l_e_rod_y)
                    .rotateX(l_e_rod_rotate)
                    .render(ms, light, vb);

            getTransform(XL_L6L_WALSCHAERTS_E_LINK, ms, inInstancedContraption)
                    .translate(0, 1.9375, -2)
                    .rotateX(l_e_link_rotate)
                    .render(ms, light, vb);

            getTransform(XL_L6L_WALSCHAERTS_U_LINK, ms, inInstancedContraption)
                    .translateY(0.9375)
                    .translateZ(-3.4375+l_piston_stroke-3.415625)
                    .rotateX(l_unionAngle)
                    .render(ms, light, vb);

            getTransform(XL_L6L_WALSCHAERTS_R_BAR, ms, inInstancedContraption)
                    .translateY(1.25+l_r_bar_y)
                    .translateZ(-2+l_r_bar_z)
                    .rotateX(10)
                    .render(ms, light, vb);

            getTransform(XL_L6L_WALSCHAERTS_V_STEM, ms, inInstancedContraption)
                    .translateZ(l_v_stem_z)
                    .render(ms, light, vb);

            getTransform(XL_L6L_WALSCHAERTS_C_LEVER, ms, inInstancedContraption)
                    .translateZ(-3.8439+l_c_lever_z+0.0625)
                    .translateY(1.25+l_c_lever_y)
                    .rotateX(l_combAngle)
                    .render(ms, light, vb);
        }
    }

    public static class ExtraLargeTripleAxleShortWalschaertsBogeyRenderer extends BogeyRenderer {
        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, XL_A6S_WALSCHAERTS_FRAME);
            createModelInstance(materialManager, XL_WALSCHAERTS_WHEEL_CENTER);
            createModelInstance(materialManager, XL_WALSCHAERTS_WHEEL_OUTER, 2);
            createModelInstance(materialManager, XL_WALSCHAERTS_ECCENTRIC);

            createModelInstance(materialManager, XL_R6S_WALSCHAERTS_C_LEVER);
            createModelInstance(materialManager, XL_R6S_WALSCHAERTS_C_ROD);
            createModelInstance(materialManager, XL_R6S_WALSCHAERTS_E_LINK);
            createModelInstance(materialManager, XL_R6S_WALSCHAERTS_E_ROD);
            createModelInstance(materialManager, XL_R6S_WALSCHAERTS_M_ROD);
            createModelInstance(materialManager, XL_R6S_WALSCHAERTS_P_ROD);
            createModelInstance(materialManager, XL_R6S_WALSCHAERTS_R_BAR);
            createModelInstance(materialManager, XL_R6S_WALSCHAERTS_U_LINK);
            createModelInstance(materialManager, XL_R6S_WALSCHAERTS_V_STEM);

            createModelInstance(materialManager, XL_L6S_WALSCHAERTS_C_LEVER);
            createModelInstance(materialManager, XL_L6S_WALSCHAERTS_C_ROD);
            createModelInstance(materialManager, XL_L6S_WALSCHAERTS_E_LINK);
            createModelInstance(materialManager, XL_L6S_WALSCHAERTS_E_ROD);
            createModelInstance(materialManager, XL_L6S_WALSCHAERTS_M_ROD);
            createModelInstance(materialManager, XL_L6S_WALSCHAERTS_P_ROD);
            createModelInstance(materialManager, XL_L6S_WALSCHAERTS_R_BAR);
            createModelInstance(materialManager, XL_L6S_WALSCHAERTS_U_LINK);
            createModelInstance(materialManager, XL_L6S_WALSCHAERTS_V_STEM);

        }
        @Override
        public BogeySizes.BogeySize getSize() {
            return BogeySizes.LARGE;
        }
        @Override
        public void render(CompoundTag bogeyData, float wheelAngle, PoseStack ms, int light, VertexConsumer vb, boolean inContraption) {
            boolean inInstancedContraption = vb == null;

            double r_a_wheel = AngleHelper.rad(wheelAngle-180);
            double r_a_ecentric = AngleHelper.rad(wheelAngle-90);

            double r_eccentric_val_flip = Math.asin((0.25*Math.sin(r_a_ecentric+3.14159))/0.6875);
            double r_x1 = ((1.5+1.27886)+0.25*Math.sin(r_eccentric_val_flip))-(0.375*Math.sin(r_a_wheel+3.14159)+Math.sqrt(Math.pow(2.4375,2)-Math.pow(0.375,2)*Math.pow(Math.cos(r_a_wheel+3.14159),2)));
            double r_y1 = ((0.6875+0.29525)+0.25*(-Math.cos(r_eccentric_val_flip)))-(-0.3125);
            double r_distance = Math.sqrt(Math.pow(r_x1,2)+Math.pow(r_y1,2));
            double r_comb = Math.acos((Math.pow(r_distance,2)+Math.pow(1.0625,2)-Math.pow(0.4375,2))/(2*r_distance*1.0625));
            double r_union = Math.acos((Math.pow(r_distance,2)+Math.pow(0.4375,2)-Math.pow(1.0625,2))/(2*r_distance*0.4375));
            double r_atan2_union = Math.atan2(r_y1,r_x1);
            double r_atan2_comb = Math.atan2(r_x1,r_y1);
            double r_unionAngle = AngleHelper.deg(r_atan2_union-r_union);
            double r_combAngle = -AngleHelper.deg(r_atan2_comb-r_comb);
            double r_piston_stroke = 0.375*Math.sin(r_a_wheel)+Math.sqrt(Math.pow(2.4375,2)-Math.pow(0.375,2)*Math.pow(Math.cos(r_a_wheel),2));
            double r_eccentric_val = Math.asin(0.25*Math.sin(r_a_ecentric)/0.6875);
            double r_eccentric_cos = Math.cos(r_eccentric_val);
            double r_eccentric_sin = Math.sin(r_eccentric_val);
            double r_m_rod_rotate = AngleHelper.deg(Math.asin(0.375*((-Math.cos(r_a_wheel)/2.4375))));
            double r_m_rod_z = 0.375*Math.sin(r_a_wheel+((1.25/16f)*Math.cos(r_a_wheel)));
            double r_e_rod_z = 0.25*Math.sin(r_a_ecentric);
            double r_e_rod_y = 0.6875+0.6875*(-r_eccentric_cos);
            double r_e_rod_rotate = 0.845+AngleHelper.deg(Math.asin(0.25*((-Math.cos(r_a_ecentric)/1.5))));
            double r_e_link_rotate = AngleHelper.deg(Math.asin(0.25*((-Math.sin(r_a_ecentric)/0.6875))));
            double r_r_bar_z = 0.25*r_eccentric_sin;
            double r_r_bar_y = 0.6875+0.25*(-r_eccentric_cos);
            double r_c_lever_z = 0.25*r_eccentric_sin;
            double r_c_lever_y = (0.6875+0.29525)+0.25*(-r_eccentric_cos);
            double r_v_stem_z = (0.25*r_eccentric_sin)+(0.25*Math.sin(r_atan2_union+1.27886))+0.03125;

            double l_a_wheel = AngleHelper.rad((wheelAngle-180)-90);
            double l_a_ecentric = AngleHelper.rad((wheelAngle-90)-90);

            double l_eccentric_val_flip = Math.asin((0.25*Math.sin(l_a_ecentric+3.14159))/0.6875);
            double l_x1 = ((1.5+1.27886)+0.25*Math.sin(l_eccentric_val_flip))-(0.375*Math.sin(l_a_wheel+3.14159)+Math.sqrt(Math.pow(2.4375,2)-Math.pow(0.375,2)*Math.pow(Math.cos(l_a_wheel+3.14159),2)));
            double l_y1 = ((0.6875+0.29525)+0.25*(-Math.cos(l_eccentric_val_flip)))-(-0.3125);
            double l_distance = Math.sqrt(Math.pow(l_x1,2)+Math.pow(l_y1,2));
            double l_comb = Math.acos((Math.pow(l_distance,2)+Math.pow(1.0625,2)-Math.pow(0.4375,2))/(2*l_distance*1.0625));
            double l_union = Math.acos((Math.pow(l_distance,2)+Math.pow(0.4375,2)-Math.pow(1.0625,2))/(2*l_distance*0.4375));
            double l_atan2_union = Math.atan2(l_y1,l_x1);
            double l_atan2_comb = Math.atan2(l_x1,l_y1);
            double l_unionAngle = AngleHelper.deg(l_atan2_union-l_union);
            double l_combAngle = -AngleHelper.deg(l_atan2_comb-l_comb);
            double l_piston_stroke = 0.375*Math.sin(l_a_wheel)+Math.sqrt(Math.pow(2.4375,2)-Math.pow(0.375,2)*Math.pow(Math.cos(l_a_wheel),2));
            double l_eccentric_val = Math.asin(0.25*Math.sin(l_a_ecentric)/0.6875);
            double l_eccentric_cos = Math.cos(l_eccentric_val);
            double l_eccentric_sin = Math.sin(l_eccentric_val);
            double l_m_rod_rotate = AngleHelper.deg(Math.asin(0.375*((-Math.cos(l_a_wheel)/2.4375))));
            double l_m_rod_z = 0.375*Math.sin(l_a_wheel+((1.25/16f)*Math.cos(l_a_wheel)));
            double l_e_rod_z = 0.25*Math.sin(l_a_ecentric);
            double l_e_rod_y = 0.6875+0.6875*(-l_eccentric_cos);
            double l_e_rod_rotate = 0.845+AngleHelper.deg(Math.asin(0.25*((-Math.cos(l_a_ecentric)/1.5))));
            double l_e_link_rotate = AngleHelper.deg(Math.asin(0.25*((-Math.sin(l_a_ecentric)/0.6875))));
            double l_r_bar_z = 0.25*l_eccentric_sin;
            double l_r_bar_y = 0.6875+0.25*(-l_eccentric_cos);
            double l_c_lever_z = 0.25*l_eccentric_sin;
            double l_c_lever_y = (0.6875+0.29525)+0.25*(-l_eccentric_cos);
            double l_v_stem_z = (0.25*l_eccentric_sin)+(0.25*Math.sin(l_atan2_union+1.27886))+0.03125;

            getTransform(XL_A6S_WALSCHAERTS_FRAME, ms, inInstancedContraption)
                    .render(ms, light, vb);

            BogeyModelData[] wheels = getTransform(XL_WALSCHAERTS_WHEEL_OUTER, ms, inInstancedContraption, 2);
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

            getTransform(XL_WALSCHAERTS_WHEEL_CENTER, ms, inInstancedContraption)
                    .translate(0, 1.25, 0)
                    .rotateX(wheelAngle)
                    .translate(0, 0, 0)
                    .render(ms, light, vb);

            getTransform(XL_WALSCHAERTS_ECCENTRIC, ms, inInstancedContraption)
                    .translateY(1.25)
                    .rotateX(wheelAngle)
                    .render(ms, light, vb);

            getTransform(XL_R6S_WALSCHAERTS_C_ROD, ms, inInstancedContraption)
                    .rotateX(wheelAngle-180)
                    .translate(0, 0.375, 0)
                    .rotateX(-wheelAngle)
                    .translateY(-1.25)
                    .render(ms, light, vb);

            getTransform(XL_R6S_WALSCHAERTS_P_ROD, ms, inInstancedContraption)
                    .translateZ(r_piston_stroke-2.4375)
                    .render(ms, light, vb);

            getTransform(XL_R6S_WALSCHAERTS_M_ROD, ms, inInstancedContraption)
                    .translate(0, 1.25, -2.4375)
                    .translateZ(r_m_rod_z)
                    .rotateX(r_m_rod_rotate)
                    .render(ms, light, vb);

            getTransform(XL_R6S_WALSCHAERTS_E_ROD, ms, inInstancedContraption)
                    .translate(0, 1.25, -1.5)
                    .translateZ(r_e_rod_z)
                    .translateY(r_e_rod_y)
                    .rotateX(r_e_rod_rotate)
                    .render(ms, light, vb);

            getTransform(XL_R6S_WALSCHAERTS_E_LINK, ms, inInstancedContraption)
                    .translate(0, 1.9375, -1.5)
                    .rotateX(r_e_link_rotate)
                    .render(ms, light, vb);

            getTransform(XL_R6S_WALSCHAERTS_U_LINK, ms, inInstancedContraption)
                    .translateY(0.9375)
                    .translateZ(-2.4375+r_piston_stroke-2.415625)
                    .rotateX(r_unionAngle)
                    .render(ms, light, vb);

            getTransform(XL_R6S_WALSCHAERTS_R_BAR, ms, inInstancedContraption)
                    .translateY(1.25+r_r_bar_y)
                    .translateZ(-1.5+r_r_bar_z)
                    .rotateX(13)
                    .render(ms, light, vb);

            getTransform(XL_R6S_WALSCHAERTS_V_STEM, ms, inInstancedContraption)
                    .translateZ(r_v_stem_z-0.125)
                    .render(ms, light, vb);

            getTransform(XL_R6S_WALSCHAERTS_C_LEVER, ms, inInstancedContraption)
                    .translateZ(-2.8439+r_c_lever_z+0.0625)
                    .translateY(1.25+r_c_lever_y)
                    .rotateX(r_combAngle)
                    .render(ms, light, vb);


            getTransform(XL_L6S_WALSCHAERTS_C_ROD, ms, inInstancedContraption)
                    .rotateX((wheelAngle-180)-90)
                    .translate(0, 0.375, 0)
                    .rotateX((-wheelAngle)-90)
                    .translateY(1.25)
                    .render(ms, light, vb);

            getTransform(XL_L6S_WALSCHAERTS_P_ROD, ms, inInstancedContraption)
                    .translateZ(l_piston_stroke-2.4375)
                    .render(ms, light, vb);

            getTransform(XL_L6S_WALSCHAERTS_M_ROD, ms, inInstancedContraption)
                    .translate(0, 1.25, -2.4375)
                    .translateZ(l_m_rod_z)
                    .rotateX(l_m_rod_rotate)
                    .render(ms, light, vb);

            getTransform(XL_L6S_WALSCHAERTS_E_ROD, ms, inInstancedContraption)
                    .translate(0, 1.25, -1.5)
                    .translateZ(l_e_rod_z)
                    .translateY(l_e_rod_y)
                    .rotateX(l_e_rod_rotate)
                    .render(ms, light, vb);

            getTransform(XL_L6S_WALSCHAERTS_E_LINK, ms, inInstancedContraption)
                    .translate(0, 1.9375, -1.5)
                    .rotateX(l_e_link_rotate)
                    .render(ms, light, vb);

            getTransform(XL_L6S_WALSCHAERTS_U_LINK, ms, inInstancedContraption)
                    .translateY(0.9375)
                    .translateZ(-2.4375+l_piston_stroke-2.415625)
                    .rotateX(l_unionAngle)
                    .render(ms, light, vb);

            getTransform(XL_L6S_WALSCHAERTS_R_BAR, ms, inInstancedContraption)
                    .translateY(1.25+l_r_bar_y)
                    .translateZ(-1.5+l_r_bar_z)
                    .rotateX(13)
                    .render(ms, light, vb);

            getTransform(XL_L6S_WALSCHAERTS_V_STEM, ms, inInstancedContraption)
                    .translateZ(l_v_stem_z-0.125)
                    .render(ms, light, vb);

            getTransform(XL_L6S_WALSCHAERTS_C_LEVER, ms, inInstancedContraption)
                    .translateZ(-2.8439+l_c_lever_z+0.0625)
                    .translateY(1.25+l_c_lever_y)
                    .rotateX(l_combAngle)
                    .render(ms, light, vb);
        }
    }

    public static class ExtraLargeQuadrupleAxleShortWalschaertsBogeyRenderer extends BogeyRenderer {
        @Override
        public void initialiseContraptionModelData(MaterialManager materialManager, CarriageBogey carriageBogey) {
            createModelInstance(materialManager, XL_A8S_WALSCHAERTS_FRAME);
            createModelInstance(materialManager, XL_WALSCHAERTS_WHEEL_CENTER,2);
            createModelInstance(materialManager, XL_WALSCHAERTS_WHEEL_OUTER,2);
            createModelInstance(materialManager, XL_WALSCHAERTS_ECCENTRIC);

            createModelInstance(materialManager, XL_R8S_WALSCHAERTS_C_LEVER);
            createModelInstance(materialManager, XL_R8S_WALSCHAERTS_C_ROD);
            createModelInstance(materialManager, XL_R8S_WALSCHAERTS_E_LINK);
            createModelInstance(materialManager, XL_R8S_WALSCHAERTS_E_ROD);
            createModelInstance(materialManager, XL_R8S_WALSCHAERTS_M_ROD);
            createModelInstance(materialManager, XL_R8S_WALSCHAERTS_P_ROD);
            createModelInstance(materialManager, XL_R8S_WALSCHAERTS_R_BAR);
            createModelInstance(materialManager, XL_R8S_WALSCHAERTS_U_LINK);
            createModelInstance(materialManager, XL_R8S_WALSCHAERTS_V_STEM);

            createModelInstance(materialManager, XL_L8S_WALSCHAERTS_C_LEVER);
            createModelInstance(materialManager, XL_L8S_WALSCHAERTS_C_ROD);
            createModelInstance(materialManager, XL_L8S_WALSCHAERTS_E_LINK);
            createModelInstance(materialManager, XL_L8S_WALSCHAERTS_E_ROD);
            createModelInstance(materialManager, XL_L8S_WALSCHAERTS_M_ROD);
            createModelInstance(materialManager, XL_L8S_WALSCHAERTS_P_ROD);
            createModelInstance(materialManager, XL_L8S_WALSCHAERTS_R_BAR);
            createModelInstance(materialManager, XL_L8S_WALSCHAERTS_U_LINK);
            createModelInstance(materialManager, XL_L8S_WALSCHAERTS_V_STEM);

        }
        @Override
        public BogeySizes.BogeySize getSize() {
            return BogeySizes.LARGE;
        }
        @Override
        public void render(CompoundTag bogeyData, float wheelAngle, PoseStack ms, int light, VertexConsumer vb, boolean inContraption) {
            boolean inInstancedContraption = vb == null;

            double r_a_wheel = AngleHelper.rad(wheelAngle - 180);
            double r_a_ecentric = AngleHelper.rad(wheelAngle - 90);

            double r_eccentric_val_flip = Math.asin((0.25 * Math.sin(r_a_ecentric + Math.PI)) / 0.6875);
            double r_x1 = ((3.125 + 1.9780317) + 0.25 * Math.sin(r_eccentric_val_flip)) - (0.375 * Math.sin(r_a_wheel + Math.PI) + Math.sqrt(Math.pow(4.5625, 2) - Math.pow(0.375, 2) * Math.pow(Math.cos(r_a_wheel + Math.PI), 2)));
            double r_y1 = ((0.6875 + 0.295619) + 0.25 * (-Math.cos(r_eccentric_val_flip))) - (-0.3125);
            double r_distance = Math.sqrt(Math.pow(r_x1, 2) + Math.pow(r_y1, 2));
            double r_comb = Math.acos((Math.pow(r_distance, 2) + Math.pow(1.0625, 2) - Math.pow(0.4375, 2)) / (2 * r_distance * 1.0625));
            double r_union = Math.acos((Math.pow(r_distance, 2) + Math.pow(0.4375, 2) - Math.pow(1.0625, 2)) / (2 * r_distance * 0.4375));
            double r_atan2_union = Math.atan2(r_y1, r_x1);
            double r_atan2_comb = Math.atan2(r_x1, r_y1);
            double r_unionAngle = AngleHelper.deg(r_atan2_union - r_union);
            double r_combAngle = -AngleHelper.deg(r_atan2_comb - r_comb);
            double r_piston_stroke = 0.375 * Math.sin(r_a_wheel) + Math.sqrt(Math.pow(4.5625, 2) - Math.pow(0.375, 2) * Math.pow(Math.cos(r_a_wheel), 2));
            double r_eccentric_val = Math.asin(0.25 * Math.sin(r_a_ecentric) / 0.6875);
            double r_eccentric_cos = Math.cos(r_eccentric_val);
            double r_eccentric_sin = Math.sin(r_eccentric_val);
            double r_m_rod_rotate = AngleHelper.deg(Math.asin(0.375 * ((-Math.cos(r_a_wheel) / 4.5625))));
            double r_m_rod_z = 0.375 * Math.sin(r_a_wheel + ((1.25 / 16f) * Math.cos(r_a_wheel)));
            double r_e_rod_z = 0.25 * Math.sin(r_a_ecentric);
            double r_e_rod_y = 0.6875 + 0.6875 * (-r_eccentric_cos);
            double r_e_rod_rotate = 0.845 + AngleHelper.deg(Math.asin(0.25 * ((-Math.cos(r_a_ecentric) / 3.125))));
            double r_e_link_rotate = AngleHelper.deg(Math.asin(0.25 * ((-Math.sin(r_a_ecentric) / 0.6875))));
            double r_r_bar_z = 0.25 * r_eccentric_sin;
            double r_r_bar_y = 0.6875 + 0.25 * (-r_eccentric_cos);
            double r_c_lever_z = 0.25 * r_eccentric_sin;
            double r_c_lever_y = (0.6875 + 0.295619) + 0.25 * (-r_eccentric_cos);
            double r_v_stem_z = (0.25 * r_eccentric_sin) + (0.25 * Math.sin(r_atan2_union + 1.9780317)) + 0.03125;

            double l_a_wheel = AngleHelper.rad((wheelAngle - 180) - 90);
            double l_a_ecentric = AngleHelper.rad((wheelAngle - 90) - 90);

            double l_eccentric_val_flip = Math.asin((0.25 * Math.sin(l_a_ecentric + Math.PI)) / 0.6875);
            double l_x1 = ((3.125 + 1.9780317) + 0.25 * Math.sin(l_eccentric_val_flip)) - (0.375 * Math.sin(l_a_wheel + Math.PI) + Math.sqrt(Math.pow(4.5625, 2) - Math.pow(0.375, 2) * Math.pow(Math.cos(r_a_wheel + Math.PI), 2)));
            double l_y1 = ((0.6875 + 0.295619) + 0.25 * (-Math.cos(l_eccentric_val_flip))) - (-0.3125);
            double l_distance = Math.sqrt(Math.pow(l_x1, 2) + Math.pow(l_y1, 2));
            double l_comb = Math.acos((Math.pow(l_distance, 2) + Math.pow(1.0625, 2) - Math.pow(0.4375, 2)) / (2 * l_distance * 1.0625));
            double l_union = Math.acos((Math.pow(l_distance, 2) + Math.pow(0.4375, 2) - Math.pow(1.0625, 2)) / (2 * l_distance * 0.4375));
            double l_atan2_union = Math.atan2(l_y1, l_x1);
            double l_atan2_comb = Math.atan2(l_x1, l_y1);
            double l_unionAngle = AngleHelper.deg(l_atan2_union - l_union);
            double l_combAngle = -AngleHelper.deg(l_atan2_comb - l_comb);
            double l_piston_stroke = 0.375 * Math.sin(l_a_wheel) + Math.sqrt(Math.pow(4.5625, 2) - Math.pow(0.375, 2) * Math.pow(Math.cos(l_a_wheel), 2));
            double l_eccentric_val = Math.asin(0.25 * Math.sin(l_a_ecentric) / 0.6875);
            double l_eccentric_cos = Math.cos(l_eccentric_val);
            double l_eccentric_sin = Math.sin(l_eccentric_val);
            double l_m_rod_rotate = AngleHelper.deg(Math.asin(0.375 * ((-Math.cos(l_a_wheel) / 4.5625))));
            double l_m_rod_z = 0.375 * Math.sin(l_a_wheel + ((1.25 / 16f) * Math.cos(l_a_wheel)));
            double l_e_rod_z = 0.25 * Math.sin(l_a_ecentric);
            double l_e_rod_y = 0.6875 + 0.6875 * (-l_eccentric_cos);
            double l_e_rod_rotate = 0.845 + AngleHelper.deg(Math.asin(0.25 * ((-Math.cos(l_a_ecentric) / 3.125))));
            double l_e_link_rotate = AngleHelper.deg(Math.asin(0.25 * ((-Math.sin(l_a_ecentric) / 0.6875))));
            double l_r_bar_z = 0.25 * l_eccentric_sin;
            double l_r_bar_y = 0.6875 + 0.25 * (-l_eccentric_cos);
            double l_c_lever_z = 0.25 * l_eccentric_sin;
            double l_c_lever_y = (0.6875 + 0.295619) + 0.25 * (-l_eccentric_cos);
            double l_v_stem_z = (0.25 * l_eccentric_sin) + (0.25 * Math.sin(l_atan2_union + 1.9780317)) + 0.03125;

            getTransform(XL_A8S_WALSCHAERTS_FRAME, ms, inInstancedContraption)
                    .render(ms, light, vb);

            BogeyModelData[] wheels = getTransform(XL_WALSCHAERTS_WHEEL_OUTER, ms, inInstancedContraption, 2);
            for (int side : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel = wheels[(side + 1) / 2];
                wheel
                        .translate(0, 1.25, side * 3.375)
                        .rotateX(wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            BogeyModelData[] wheels1 = getTransform(XL_WALSCHAERTS_WHEEL_CENTER, ms, inInstancedContraption, 2);
            for (int side1 : Iterate.positiveAndNegative) {
                if (!inInstancedContraption)
                    ms.pushPose();
                BogeyModelData wheel1 = wheels1[(side1 + 1) / 2];
                wheel1
                        .translate(0, 1.25, side1 * 1.125)
                        .rotateX(wheelAngle)
                        .render(ms, light, vb);
                if (!inInstancedContraption)
                    ms.popPose();
            }

            getTransform(XL_WALSCHAERTS_ECCENTRIC, ms, inInstancedContraption)
                    .translateY(1.25)
                    .translateZ(1.125)
                    .rotateX(wheelAngle)
                    .render(ms, light, vb);

            getTransform(XL_R8S_WALSCHAERTS_C_ROD, ms, inInstancedContraption)
                    .rotateX(wheelAngle - 180)
                    .translate(0, 0.375, 0)
                    .rotateX(-wheelAngle + 180)
                    .translateY(1.25)
                    .render(ms, light, vb);

            getTransform(XL_R8S_WALSCHAERTS_P_ROD, ms, inInstancedContraption)
                    .translateZ(r_piston_stroke - 4.5625)
                    .render(ms, light, vb);

            getTransform(XL_R8S_WALSCHAERTS_M_ROD, ms, inInstancedContraption)
                    .translate(0, 1.25, -4.5625 + 1.125)
                    .translateZ(r_m_rod_z)
                    .rotateX(r_m_rod_rotate)
                    .render(ms, light, vb);

            getTransform(XL_R8S_WALSCHAERTS_E_ROD, ms, inInstancedContraption)
                    .translate(0, 1.25, -3.125 + 1.125)
                    .translateZ(r_e_rod_z)
                    .translateY(r_e_rod_y)
                    .rotateX(r_e_rod_rotate)
                    .render(ms, light, vb);

            getTransform(XL_R8S_WALSCHAERTS_E_LINK, ms, inInstancedContraption)
                    .translate(0, 1.9375, -3.125 + 1.125)
                    .rotateX(r_e_link_rotate)
                    .render(ms, light, vb);

            getTransform(XL_R8S_WALSCHAERTS_U_LINK, ms, inInstancedContraption)
                    .translateY(0.9375)
                    .translateZ(-4.5625 + r_piston_stroke - 4.5625 + 1.125)
                    .rotateX(r_unionAngle)
                    .render(ms, light, vb);

            getTransform(XL_R8S_WALSCHAERTS_R_BAR, ms, inInstancedContraption)
                    .translateY(1.25 + r_r_bar_y)
                    .translateZ(r_r_bar_z - 3.125 + 1.125)
                    .rotateX(8.5)
                    .render(ms, light, vb);

            getTransform(XL_R8S_WALSCHAERTS_V_STEM, ms, inInstancedContraption)
                    .translateZ(r_v_stem_z - 0.1875)
                    .render(ms, light, vb);

            getTransform(XL_R8S_WALSCHAERTS_C_LEVER, ms, inInstancedContraption)
                    .translateZ(-5.1030317 + r_c_lever_z + 1.125)
                    .translateY(1.25 + r_c_lever_y)
                    .rotateX(r_combAngle)
                    .render(ms, light, vb);

            getTransform(XL_L8S_WALSCHAERTS_C_ROD, ms, inInstancedContraption)
                    .rotateX((wheelAngle) + 90)
                    .translate(0, 0.375, 0)
                    .rotateX((-wheelAngle) - 90)
                    .translateY(1.25)
                    .render(ms, light, vb);

            getTransform(XL_L8S_WALSCHAERTS_P_ROD, ms, inInstancedContraption)
                    .translateZ(l_piston_stroke - 4.5625)
                    .render(ms, light, vb);

            getTransform(XL_L8S_WALSCHAERTS_M_ROD, ms, inInstancedContraption)
                    .translate(0, 1.25, -4.5625 + 1.125)
                    .translateZ(l_m_rod_z)
                    .rotateX(l_m_rod_rotate)
                    .render(ms, light, vb);

            getTransform(XL_L8S_WALSCHAERTS_E_ROD, ms, inInstancedContraption)
                    .translate(0, 1.25, -3.125 + 1.125)
                    .translateZ(l_e_rod_z)
                    .translateY(l_e_rod_y)
                    .rotateX(l_e_rod_rotate)
                    .render(ms, light, vb);

            getTransform(XL_L8S_WALSCHAERTS_E_LINK, ms, inInstancedContraption)
                    .translate(0, 1.9375, -3.125 + 1.125)
                    .rotateX(l_e_link_rotate)
                    .render(ms, light, vb);

            getTransform(XL_L8S_WALSCHAERTS_U_LINK, ms, inInstancedContraption)
                    .translateY(0.9375)
                    .translateZ(-4.5625 + l_piston_stroke - 4.5625 + 1.125)
                    .rotateX(l_unionAngle)
                    .render(ms, light, vb);

            getTransform(XL_L8S_WALSCHAERTS_R_BAR, ms, inInstancedContraption)
                    .translateY(1.25 + l_r_bar_y)
                    .translateZ(l_r_bar_z - 3.125 + 1.125)
                    .rotateX(8.5)
                    .render(ms, light, vb);

            getTransform(XL_L8S_WALSCHAERTS_V_STEM, ms, inInstancedContraption)
                    .translateZ(l_v_stem_z - 0.1875)
                    .render(ms, light, vb);

            getTransform(XL_L8S_WALSCHAERTS_C_LEVER, ms, inInstancedContraption)
                    .translateZ(-5.1030317 + l_c_lever_z + 1.125)
                    .translateY(1.25 + l_c_lever_y)
                    .rotateX(l_combAngle)
                    .render(ms, light, vb);
        }
    }
}
