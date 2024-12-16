package com.rabbitminers.extendedbogeys.registry;

import com.jozufozu.flywheel.core.PartialModel;
import com.rabbitminers.extendedbogeys.ExtendedBogeys;

public class ExtendedBogeysPartials {
    public static final PartialModel
//Standard Wheels
    SMALL_SHARED_WHEELS = block("bogey/small/shared/wheels"),
    SMALL_SHARED_WHEELS_PINS = block("bogey/small/shared/wheels_pins"),
    LARGE_SHARED_WHEELS = block("bogey/large/shared/wheels"),
    LARGE_SHARED_WHEELS_SEMI_BLIND = block("bogey/large/shared/wheels_semi_blind"),
    LARGE_SHARED_WHEELS_BLIND = block("bogey/large/shared/wheels_blind"),
    LARGE_SHARED_WHEELS_SINGLE = block("bogey/large/shared/wheels_single"),
    EXTRA_LARGE_SHARED_WHEELS = block("bogey/extra_large/shared/wheels"),
    EXTRA_LARGE_SHARED_WHEELS_SEMI_BLIND = block("bogey/extra_large/shared/wheels_semi_blind"),
    EXTRA_LARGE_SHARED_WHEELS_BLIND = block("bogey/extra_large/shared/wheels_blind"),
    EXTRA_LARGE_SHARED_WHEELS_SINGLE = block("bogey/extra_large/shared/wheels_single"),

//Scotch Yoke Wheels
    CREATE_EXTRA_LARGE_SHARED_WHEELS = block("bogey/extra_large/shared/wheels_create"),
    CREATE_EXTRA_LARGE_SHARED_WHEELS_SEMI_BLIND = block("bogey/extra_large/shared/wheels_semi_blind_create"),

//Small Stuff...
    SMALL_STANDARD_2_FRAME = block("bogey/small/s2/frame"),
    SMALL_STANDARD_6_FRAME = block("bogey/small/s6/frame"),
    SMALL_STANDARD_8_FRAME = block("bogey/small/s8/frame"),
    SMALL_STANDARD_10_FRAME = block("bogey/small/s10/frame"),

    SMALL_TRAILING_2_FRAME = block("bogey/small/t2/frame"),
    SMALL_TRAILING_4_FRAME = block("bogey/small/t4/frame"),
    SMALL_TRAILING_6_FRAME = block("bogey/small/t6/frame"),

//Large 0-2-0 Long
    LARGE_2_FRAME_LONG = block("bogey/large/l2/l2_long/frame"),
    LARGE_2_LEFT_C_ROD_LONG = block("bogey/large/l2/l2_long/left_c_rod"),
    LARGE_2_RIGHT_C_ROD_LONG = block("bogey/large/l2/l2_long/right_c_rod"),
    LARGE_2_LEFT_M_ROD_LONG = block("bogey/large/l2/l2_long/left_m_rod"),
    LARGE_2_RIGHT_M_ROD_LONG = block("bogey/large/l2/l2_long/right_m_rod"),
    LARGE_2_LEFT_P_ROD_LONG = block("bogey/large/l2/l2_long/left_p_rod"),
    LARGE_2_RIGHT_P_ROD_LONG = block("bogey/large/l2/l2_long/right_p_rod"),

//Large 0-2-0 Pistonless
    LARGE_2_FRAME_PISTONLESS = block("bogey/large/l2/l2_pistonless/frame"),

//Large 0-4-0 Long
    LARGE_4_FRAME_LONG = block("bogey/large/l4/l4_long/frame"),
    LARGE_4_LEFT_C_ROD_LONG = block("bogey/large/l4/l4_long/left_c_rod"),
    LARGE_4_RIGHT_C_ROD_LONG = block("bogey/large/l4/l4_long/right_c_rod"),
    LARGE_4_LEFT_M_ROD_LONG = block("bogey/large/l4/l4_long/left_m_rod"),
    LARGE_4_RIGHT_M_ROD_LONG = block("bogey/large/l4/l4_long/right_m_rod"),
    LARGE_4_LEFT_P_ROD_LONG = block("bogey/large/l4/l4_long/left_p_rod"),
    LARGE_4_RIGHT_P_ROD_LONG = block("bogey/large/l4/l4_long/right_p_rod"),

//Large 0-4-0 Long Rear Linkage
    LARGE_4_FRAME_LONG_REAR = block("bogey/large/l4/l4_long_rear/frame"),
    LARGE_4_LEFT_C_ROD_LONG_REAR = block("bogey/large/l4/l4_long_rear/left_c_rod"),
    LARGE_4_RIGHT_C_ROD_LONG_REAR = block("bogey/large/l4/l4_long_rear/right_c_rod"),
    LARGE_4_LEFT_M_ROD_LONG_REAR = block("bogey/large/l4/l4_long_rear/left_m_rod"),
    LARGE_4_RIGHT_M_ROD_LONG_REAR = block("bogey/large/l4/l4_long_rear/right_m_rod"),
    LARGE_4_LEFT_P_ROD_LONG_REAR = block("bogey/large/l4/l4_long_rear/left_p_rod"),
    LARGE_4_RIGHT_P_ROD_LONG_REAR = block("bogey/large/l4/l4_long_rear/right_p_rod"),

//Large 0-4-0 Short
    LARGE_4_FRAME_SHORT = block("bogey/large/l4/l4_short/frame"),
    LARGE_4_LEFT_C_ROD_SHORT = block("bogey/large/l4/l4_short/left_c_rod"),
    LARGE_4_RIGHT_C_ROD_SHORT = block("bogey/large/l4/l4_short/right_c_rod"),
    LARGE_4_LEFT_M_ROD_SHORT = block("bogey/large/l4/l4_short/left_m_rod"),
    LARGE_4_RIGHT_M_ROD_SHORT = block("bogey/large/l4/l4_short/right_m_rod"),
    LARGE_4_LEFT_P_ROD_SHORT = block("bogey/large/l4/l4_short/left_p_rod"),
    LARGE_4_RIGHT_P_ROD_SHORT = block("bogey/large/l4/l4_short/right_p_rod"),

//Large 0-4-0 Pistonless
    LARGE_4_FRAME_PISTONLESS = block("bogey/large/l4/l4_pistonless/frame"),
    LARGE_4_LEFT_C_ROD_PISTONLESS = block("bogey/large/l4/l4_pistonless/left_c_rod"),
    LARGE_4_RIGHT_C_ROD_PISTONLESS = block("bogey/large/l4/l4_pistonless/right_c_rod"),

//Large 0-6-0 Long
    LARGE_6_FRAME_LONG = block("bogey/large/l6/l6_long/frame"),
    LARGE_6_LEFT_M_ROD_LONG = block("bogey/large/l6/l6_long/left_m_rod"),
    LARGE_6_RIGHT_M_ROD_LONG = block("bogey/large/l6/l6_long/right_m_rod"),
    LARGE_6_LEFT_P_ROD_LONG = block("bogey/large/l6/l6_long/left_p_rod"),
    LARGE_6_RIGHT_P_ROD_LONG = block("bogey/large/l6/l6_long/right_p_rod"),

//Large 0-6-0 Connecting Rods
    LARGE_6_SHARED_LEFT_C_ROD = block("bogey/large/l6/l6_shared/left_c_rod"),
    LARGE_6_SHARED_RIGHT_C_ROD = block("bogey/large/l6/l6_shared/right_c_rod"),

//Large 0-6-0 Short
    LARGE_6_FRAME_SHORT = block("bogey/large/l6/l6_short/frame"),
    LARGE_6_LEFT_M_ROD_SHORT = block("bogey/large/l6/l6_short/left_m_rod"),
    LARGE_6_RIGHT_M_ROD_SHORT = block("bogey/large/l6/l6_short/right_m_rod"),
    LARGE_6_LEFT_P_ROD_SHORT = block("bogey/large/l6/l6_short/left_p_rod"),
    LARGE_6_RIGHT_P_ROD_SHORT = block("bogey/large/l6/l6_short/right_p_rod"),

//Large Extended 0-6-0 Long
    LARGE_6E_FRAME_LONG = block("bogey/large/l6/l6e_long/frame"),

//Large Extended 0-6-0 Connecting Rods
    LARGE_6E_SHARED_LEFT_C_ROD = block("bogey/large/l6/l6e_shared/left_c_rod"),
    LARGE_6E_SHARED_RIGHT_C_ROD = block("bogey/large/l6/l6e_shared/right_c_rod"),

//Large Extended 0-6-0 Short
    LARGE_6E_FRAME_SHORT = block("bogey/large/l6/l6e_short/frame"),

//Large 0-6-0 Pistonless
    LARGE_6_FRAME_PISTONLESS = block("bogey/large/l6/l6_pistonless/frame"),
    LARGE_6_LEFT_C_ROD_PISTONLESS = block("bogey/large/l6/l6_pistonless/left_c_rod"),
    LARGE_6_RIGHT_C_ROD_PISTONLESS = block("bogey/large/l6/l6_pistonless/right_c_rod"),

//Large Extended 0-6-0 Pistonless
    LARGE_6E_FRAME_PISTONLESS = block("bogey/large/l6/l6e_pistonless/frame"),
    LARGE_6E_LEFT_C_ROD_PISTONLESS = block("bogey/large/l6/l6e_pistonless/left_c_rod"),
    LARGE_6E_RIGHT_C_ROD_PISTONLESS = block("bogey/large/l6/l6e_pistonless/right_c_rod"),

//Large 0-8-0 Long
    LARGE_8_FRAME_LONG = block("bogey/large/l8/l8_long/frame"),
    LARGE_8_LEFT_C_ROD_LONG = block("bogey/large/l8/l8_long/left_c_rod"),
    LARGE_8_RIGHT_C_ROD_LONG = block("bogey/large/l8/l8_long/right_c_rod"),
    LARGE_8_LEFT_M_ROD_LONG = block("bogey/large/l8/l8_long/left_m_rod"),
    LARGE_8_RIGHT_M_ROD_LONG = block("bogey/large/l8/l8_long/right_m_rod"),
    LARGE_8_LEFT_P_ROD_LONG = block("bogey/large/l8/l8_long/left_p_rod"),
    LARGE_8_RIGHT_P_ROD_LONG = block("bogey/large/l8/l8_long/right_p_rod"),

//Large 0-8-0 Short
    LARGE_8_FRAME_SHORT = block("bogey/large/l8/l8_short/frame"),
    LARGE_8_LEFT_C_ROD_SHORT = block("bogey/large/l8/l8_short/left_c_rod"),
    LARGE_8_RIGHT_C_ROD_SHORT = block("bogey/large/l8/l8_short/right_c_rod"),
    LARGE_8_LEFT_M_ROD_SHORT = block("bogey/large/l8/l8_short/left_m_rod"),
    LARGE_8_RIGHT_M_ROD_SHORT = block("bogey/large/l8/l8_short/right_m_rod"),
    LARGE_8_LEFT_P_ROD_SHORT = block("bogey/large/l8/l8_short/left_p_rod"),
    LARGE_8_RIGHT_P_ROD_SHORT = block("bogey/large/l8/l8_short/right_p_rod"),

//Large 0-8-0 Pistonless
    LARGE_8_FRAME_PISTONLESS = block("bogey/large/l8/l8_pistonless/frame"),
    LARGE_8_LEFT_C_ROD_PISTONLESS = block("bogey/large/l8/l8_pistonless/left_c_rod"),
    LARGE_8_RIGHT_C_ROD_PISTONLESS = block("bogey/large/l8/l8_pistonless/right_c_rod"),

//Large 0-10-0 Long
    LARGE_10_FRAME_LONG = block("bogey/large/l10/l10_long/frame"),
    LARGE_10_LEFT_C_ROD_LONG = block("bogey/large/l10/l10_long/left_c_rod"),
    LARGE_10_RIGHT_C_ROD_LONG = block("bogey/large/l10/l10_long/right_c_rod"),
    LARGE_10_LEFT_M_ROD_LONG = block("bogey/large/l10/l10_long/left_m_rod"),
    LARGE_10_RIGHT_M_ROD_LONG = block("bogey/large/l10/l10_long/right_m_rod"),
    LARGE_10_LEFT_P_ROD_LONG = block("bogey/large/l10/l10_long/left_p_rod"),
    LARGE_10_RIGHT_P_ROD_LONG = block("bogey/large/l10/l10_long/right_p_rod"),

//Large 0-10-0 Short
    LARGE_10_FRAME_SHORT = block("bogey/large/l10/l10_short/frame"),
    LARGE_10_LEFT_C_ROD_SHORT = block("bogey/large/l10/l10_short/left_c_rod"),
    LARGE_10_RIGHT_C_ROD_SHORT = block("bogey/large/l10/l10_short/right_c_rod"),
    LARGE_10_LEFT_M_ROD_SHORT = block("bogey/large/l10/l10_short/left_m_rod"),
    LARGE_10_RIGHT_M_ROD_SHORT = block("bogey/large/l10/l10_short/right_m_rod"),
    LARGE_10_LEFT_P_ROD_SHORT = block("bogey/large/l10/l10_short/left_p_rod"),
    LARGE_10_RIGHT_P_ROD_SHORT = block("bogey/large/l10/l10_short/right_p_rod"),

//Large 0-10-0 Pistonless
    LARGE_10_FRAME_PISTONLESS = block("bogey/large/l10/l10_pistonless/frame"),
    LARGE_10_LEFT_C_ROD_PISTONLESS = block("bogey/large/l10/l10_pistonless/left_c_rod"),
    LARGE_10_RIGHT_C_ROD_PISTONLESS = block("bogey/large/l10/l10_pistonless/right_c_rod"),

//Large 0-12-0 Long
    LARGE_12_FRAME_LONG = block("bogey/large/l12/l12_long/frame"),
    LARGE_12_CENTER_M_ROD_LONG = block("bogey/large/l12/l12_long/center_m_rod"),
    LARGE_12_CENTER_P_ROD_LONG = block("bogey/large/l12/l12_long/center_p_rod"),
    LARGE_12_LEFT_C_ROD_LONG = block("bogey/large/l12/l12_long/left_c_rod"),
    LARGE_12_RIGHT_C_ROD_LONG = block("bogey/large/l12/l12_long/right_c_rod"),
    LARGE_12_LEFT_M_ROD_LONG = block("bogey/large/l12/l12_long/left_m_rod"),
    LARGE_12_RIGHT_M_ROD_LONG = block("bogey/large/l12/l12_long/right_m_rod"),
    LARGE_12_LEFT_P_ROD_LONG = block("bogey/large/l12/l12_long/left_p_rod"),
    LARGE_12_RIGHT_P_ROD_LONG = block("bogey/large/l12/l12_long/right_p_rod"),

//Large 0-12-0 Shared
    LARGE_12_CENTER_SHAFT = block("bogey/large/l12/l12_shared/axis"),
    LARGE_12_WHEELS = block("bogey/large/l12/l12_shared/wheels"),
    LARGE_12_WHEELS_BLIND = block("bogey/large/l12/l12_shared/wheels_blind"),
    LARGE_12_WHEELS_SEMI_BLIND = block("bogey/large/l12/l12_shared/wheels_semi_blind"),
    LARGE_12_CENTER_WEIGHT = block("bogey/large/l12/l12_shared/center_weight"),

//Large 0-12-0 Short
    LARGE_12_FRAME_SHORT = block("bogey/large/l12/l12_short/frame"),
    LARGE_12_CENTER_M_ROD_SHORT = block("bogey/large/l12/l12_short/center_m_rod"),
    LARGE_12_CENTER_P_ROD_SHORT = block("bogey/large/l12/l12_short/center_p_rod"),
    LARGE_12_LEFT_C_ROD_SHORT = block("bogey/large/l12/l12_short/left_c_rod"),
    LARGE_12_RIGHT_C_ROD_SHORT = block("bogey/large/l12/l12_short/right_c_rod"),
    LARGE_12_LEFT_M_ROD_SHORT = block("bogey/large/l12/l12_short/left_m_rod"),
    LARGE_12_RIGHT_M_ROD_SHORT = block("bogey/large/l12/l12_short/right_m_rod"),
    LARGE_12_LEFT_P_ROD_SHORT = block("bogey/large/l12/l12_short/left_p_rod"),
    LARGE_12_RIGHT_P_ROD_SHORT = block("bogey/large/l12/l12_short/right_p_rod"),

//Extra Large 0-2-0 Long
    EXTRA_LARGE_2_FRAME_LONG = block("bogey/extra_large/xl2/xl2_long/frame"),
    EXTRA_LARGE_2_LEFT_C_ROD_LONG = block("bogey/extra_large/xl2/xl2_long/left_c_rod"),
    EXTRA_LARGE_2_RIGHT_C_ROD_LONG = block("bogey/extra_large/xl2/xl2_long/right_c_rod"),
    EXTRA_LARGE_2_LEFT_M_ROD_LONG = block("bogey/extra_large/xl2/xl2_long/left_m_rod"),
    EXTRA_LARGE_2_RIGHT_M_ROD_LONG = block("bogey/extra_large/xl2/xl2_long/right_m_rod"),
    EXTRA_LARGE_2_LEFT_P_ROD_LONG = block("bogey/extra_large/xl2/xl2_long/left_p_rod"),
    EXTRA_LARGE_2_RIGHT_P_ROD_LONG = block("bogey/extra_large/xl2/xl2_long/right_p_rod"),

//Extra Large 0-2-0 Pistonless
    EXTRA_LARGE_2_FRAME_PISTONLESS = block("bogey/extra_large/xl2/xl2_pistonless/frame"),

//Extra Large 0-4-0 Long
    EXTRA_LARGE_4_FRAME_LONG = block("bogey/extra_large/xl4/xl4_long/frame"),
    EXTRA_LARGE_4_LEFT_M_ROD_LONG = block("bogey/extra_large/xl4/xl4_long/left_m_rod"),
    EXTRA_LARGE_4_RIGHT_M_ROD_LONG = block("bogey/extra_large/xl4/xl4_long/right_m_rod"),
    EXTRA_LARGE_4_LEFT_P_ROD_LONG = block("bogey/extra_large/xl4/xl4_long/left_p_rod"),
    EXTRA_LARGE_4_RIGHT_P_ROD_LONG = block("bogey/extra_large/xl4/xl4_long/right_p_rod"),

//Extra Large 0-4-0 Extra Long
    EXTRA_LARGE_4_FRAME_EXTRA_LONG = block("bogey/extra_large/xl4/xl4_extra_long/frame"),
    EXTRA_LARGE_4_LEFT_M_ROD_EXTRA_LONG = block("bogey/extra_large/xl4/xl4_extra_long/left_m_rod"),
    EXTRA_LARGE_4_RIGHT_M_ROD_EXTRA_LONG = block("bogey/extra_large/xl4/xl4_extra_long/right_m_rod"),
    EXTRA_LARGE_4_LEFT_P_ROD_EXTRA_LONG = block("bogey/extra_large/xl4/xl4_extra_long/left_p_rod"),
    EXTRA_LARGE_4_RIGHT_P_ROD_EXTRA_LONG = block("bogey/extra_large/xl4/xl4_extra_long/right_p_rod"),
    EXTRA_LARGE_4_LEFT_C_ROD_EXTRA_LONG = block("bogey/extra_large/xl4/xl4_extra_long/left_c_rod"),
    EXTRA_LARGE_4_RIGHT_C_ROD_EXTRA_LONG = block("bogey/extra_large/xl4/xl4_extra_long/right_c_rod"),

//Extra Large 0-4-0 Connecting Rods
    EXTRA_LARGE_4_SHARED_LEFT_C_ROD = block("bogey/extra_large/xl4/xl4_shared/left_c_rod"),
    EXTRA_LARGE_4_SHARED_RIGHT_C_ROD = block("bogey/extra_large/xl4/xl4_shared/right_c_rod"),

//Extra Large 0-4-0 Short
    EXTRA_LARGE_4_FRAME_SHORT = block("bogey/extra_large/xl4/xl4_short/frame"),
    EXTRA_LARGE_4_LEFT_M_ROD_SHORT = block("bogey/extra_large/xl4/xl4_short/left_m_rod"),
    EXTRA_LARGE_4_RIGHT_M_ROD_SHORT = block("bogey/extra_large/xl4/xl4_short/right_m_rod"),
    EXTRA_LARGE_4_LEFT_P_ROD_SHORT = block("bogey/extra_large/xl4/xl4_short/left_p_rod"),
    EXTRA_LARGE_4_RIGHT_P_ROD_SHORT = block("bogey/extra_large/xl4/xl4_short/right_p_rod"),

//Extra Large 0-4-0 Pistonless
    EXTRA_LARGE_4_FRAME_PISTONLESS = block("bogey/extra_large/xl4/xl4_pistonless/frame"),
    EXTRA_LARGE_4_LEFT_C_ROD_PISTONLESS = block("bogey/extra_large/xl4/xl4_pistonless/left_c_rod"),
    EXTRA_LARGE_4_RIGHT_C_ROD_PISTONLESS = block("bogey/extra_large/xl4/xl4_pistonless/right_c_rod"),

//Extra Large 0-6-0 Long
    EXTRA_LARGE_6_FRAME_LONG = block("bogey/extra_large/xl6/xl6_long/frame"),
    EXTRA_LARGE_6_LEFT_M_ROD_LONG = block("bogey/extra_large/xl6/xl6_long/left_m_rod"),
    EXTRA_LARGE_6_RIGHT_M_ROD_LONG = block("bogey/extra_large/xl6/xl6_long/right_m_rod"),
    EXTRA_LARGE_6_LEFT_P_ROD_LONG = block("bogey/extra_large/xl6/xl6_long/left_p_rod"),
    EXTRA_LARGE_6_RIGHT_P_ROD_LONG = block("bogey/extra_large/xl6/xl6_long/right_p_rod"),

//Extra Large 0-6-0 Connecting Rods
    EXTRA_LARGE_6_SHARED_LEFT_C_ROD = block("bogey/extra_large/xl6/xl6_shared/left_c_rod"),
    EXTRA_LARGE_6_SHARED_RIGHT_C_ROD = block("bogey/extra_large/xl6/xl6_shared/right_c_rod"),

//Extra Large 0-6-0 Short
    EXTRA_LARGE_6_FRAME_SHORT = block("bogey/extra_large/xl6/xl6_short/frame"),
    EXTRA_LARGE_6_LEFT_M_ROD_SHORT = block("bogey/extra_large/xl6/xl6_short/left_m_rod"),
    EXTRA_LARGE_6_RIGHT_M_ROD_SHORT = block("bogey/extra_large/xl6/xl6_short/right_m_rod"),
    EXTRA_LARGE_6_LEFT_P_ROD_SHORT = block("bogey/extra_large/xl6/xl6_short/left_p_rod"),
    EXTRA_LARGE_6_RIGHT_P_ROD_SHORT = block("bogey/extra_large/xl6/xl6_short/right_p_rod"),

//Extra Large 0-6-0 Pistonless
    EXTRA_LARGE_6_FRAME_PISTONLESS = block("bogey/extra_large/xl6/xl6_pistonless/frame"),
    EXTRA_LARGE_6_LEFT_C_ROD_PISTONLESS = block("bogey/extra_large/xl6/xl6_pistonless/left_c_rod"),
    EXTRA_LARGE_6_RIGHT_C_ROD_PISTONLESS = block("bogey/extra_large/xl6/xl6_pistonless/right_c_rod"),

//Extra Large Extended 0-6-0 Long
    EXTRA_LARGE_6E_FRAME_LONG = block("bogey/extra_large/xl6/xl6e_long/frame"),

//Extra Large Extended 0-6-0 Connecting Rods
    EXTRA_LARGE_6E_SHARED_LEFT_C_ROD = block("bogey/extra_large/xl6/xl6e_shared/left_c_rod"),
    EXTRA_LARGE_6E_SHARED_RIGHT_C_ROD = block("bogey/extra_large/xl6/xl6e_shared/right_c_rod"),

//Extra Large Extended 0-6-0 Short
    EXTRA_LARGE_6E_FRAME_SHORT = block("bogey/extra_large/xl6/xl6e_short/frame"),

//Extra Large Extended 0-6-0 Pistonless
    EXTRA_LARGE_6E_FRAME_PISTONLESS = block("bogey/extra_large/xl6/xl6e_pistonless/frame"),
    EXTRA_LARGE_6E_LEFT_C_ROD_PISTONLESS = block("bogey/extra_large/xl6/xl6e_pistonless/left_c_rod"),
    EXTRA_LARGE_6E_RIGHT_C_ROD_PISTONLESS = block("bogey/extra_large/xl6/xl6e_pistonless/right_c_rod"),

//Extra Large 0-8-0 Long
    EXTRA_LARGE_8_FRAME_LONG = block("bogey/extra_large/xl8/xl8_long/frame"),
    EXTRA_LARGE_8_LEFT_C_ROD_LONG = block("bogey/extra_large/xl8/xl8_long/left_c_rod"),
    EXTRA_LARGE_8_RIGHT_C_ROD_LONG = block("bogey/extra_large/xl8/xl8_long/right_c_rod"),
    EXTRA_LARGE_8_LEFT_M_ROD_LONG = block("bogey/extra_large/xl8/xl8_long/left_m_rod"),
    EXTRA_LARGE_8_RIGHT_M_ROD_LONG = block("bogey/extra_large/xl8/xl8_long/right_m_rod"),
    EXTRA_LARGE_8_LEFT_P_ROD_LONG = block("bogey/extra_large/xl8/xl8_long/left_p_rod"),
    EXTRA_LARGE_8_RIGHT_P_ROD_LONG = block("bogey/extra_large/xl8/xl8_long/right_p_rod"),

//Extra Large 0-8-0 Short
    EXTRA_LARGE_8_FRAME_SHORT = block("bogey/extra_large/xl8/xl8_short/frame"),
    EXTRA_LARGE_8_LEFT_C_ROD_SHORT = block("bogey/extra_large/xl8/xl8_short/left_c_rod"),
    EXTRA_LARGE_8_RIGHT_C_ROD_SHORT = block("bogey/extra_large/xl8/xl8_short/right_c_rod"),
    EXTRA_LARGE_8_LEFT_M_ROD_SHORT = block("bogey/extra_large/xl8/xl8_short/left_m_rod"),
    EXTRA_LARGE_8_RIGHT_M_ROD_SHORT = block("bogey/extra_large/xl8/xl8_short/right_m_rod"),
    EXTRA_LARGE_8_LEFT_P_ROD_SHORT = block("bogey/extra_large/xl8/xl8_short/left_p_rod"),
    EXTRA_LARGE_8_RIGHT_P_ROD_SHORT = block("bogey/extra_large/xl8/xl8_short/right_p_rod"),

//Extra Large 0-8-0 Pistonless
    EXTRA_LARGE_8_FRAME_PISTONLESS = block("bogey/extra_large/xl8/xl8_pistonless/frame"),
    EXTRA_LARGE_8_LEFT_C_ROD_PISTONLESS = block("bogey/extra_large/xl8/xl8_pistonless/left_c_rod"),
    EXTRA_LARGE_8_RIGHT_C_ROD_PISTONLESS = block("bogey/extra_large/xl8/xl8_pistonless/right_c_rod"),

//Extra Large 0-10-0 Long
    EXTRA_LARGE_10_FRAME_LONG = block("bogey/extra_large/xl10/xl10_long/frame"),
    EXTRA_LARGE_10_LEFT_M_ROD_LONG = block("bogey/extra_large/xl10/xl10_long/left_m_rod"),
    EXTRA_LARGE_10_RIGHT_M_ROD_LONG = block("bogey/extra_large/xl10/xl10_long/right_m_rod"),
    EXTRA_LARGE_10_LEFT_P_ROD_LONG = block("bogey/extra_large/xl10/xl10_long/left_p_rod"),
    EXTRA_LARGE_10_RIGHT_P_ROD_LONG = block("bogey/extra_large/xl10/xl10_long/right_p_rod"),

//Extra Large 0-10-0 Shared
    EXTRA_LARGE_10_SHARED_LEFT_C_ROD = block("bogey/extra_large/xl10/xl10_shared/left_c_rod"),
    EXTRA_LARGE_10_SHARED_RIGHT_C_ROD = block("bogey/extra_large/xl10/xl10_shared/right_c_rod"),

//Extra Large 0-10-0 Short
    EXTRA_LARGE_10_FRAME_SHORT = block("bogey/extra_large/xl10/xl10_short/frame"),
    EXTRA_LARGE_10_LEFT_M_ROD_SHORT = block("bogey/extra_large/xl10/xl10_short/left_m_rod"),
    EXTRA_LARGE_10_RIGHT_M_ROD_SHORT = block("bogey/extra_large/xl10/xl10_short/right_m_rod"),
    EXTRA_LARGE_10_LEFT_P_ROD_SHORT = block("bogey/extra_large/xl10/xl10_short/left_p_rod"),
    EXTRA_LARGE_10_RIGHT_P_ROD_SHORT = block("bogey/extra_large/xl10/xl10_short/right_p_rod"),

//Extra Large 0-10-0 Pistonless
    EXTRA_LARGE_10_FRAME_PISTONLESS = block("bogey/extra_large/xl10/xl10_pistonless/frame"),
    EXTRA_LARGE_10_LEFT_C_ROD_PISTONLESS = block("bogey/extra_large/xl10/xl10_pistonless/left_c_rod"),
    EXTRA_LARGE_10_RIGHT_C_ROD_PISTONLESS = block("bogey/extra_large/xl10/xl10_pistonless/right_c_rod"),

//Extra Large Scotch Yoke 0-2-0
    CREATE_EXTRA_LARGE_2_FRAME = block("bogey/extra_large/xl2_create/frame"),
    CREATE_EXTRA_LARGE_2_PINS_RIGHT = block("bogey/extra_large/xl2_create/right_pins"),
    CREATE_EXTRA_LARGE_2_PINS_LEFT = block("bogey/extra_large/xl2_create/left_pins"),
    CREATE_EXTRA_LARGE_2_PISTON_RIGHT = block("bogey/extra_large/xl2_create/right_piston"),
    CREATE_EXTRA_LARGE_2_PISTON_LEFT = block("bogey/extra_large/xl2_create/left_piston"),

//Extra Large Scotch Yoke 0-4-0
    CREATE_EXTRA_LARGE_4_FRAME = block("bogey/extra_large/xl4_create/frame"),
    CREATE_EXTRA_LARGE_4_PINS_RIGHT = block("bogey/extra_large/xl4_create/right_pins"),
    CREATE_EXTRA_LARGE_4_PINS_LEFT = block("bogey/extra_large/xl4_create/left_pins"),
    CREATE_EXTRA_LARGE_4_PISTON_RIGHT = block("bogey/extra_large/xl4_create/right_piston"),
    CREATE_EXTRA_LARGE_4_PISTON_LEFT = block("bogey/extra_large/xl4_create/left_piston"),

//Extra Large Scotch Yoke 0-6-0
    CREATE_EXTRA_LARGE_6_FRAME = block("bogey/extra_large/xl6_create/frame"),
    CREATE_EXTRA_LARGE_6_PINS_RIGHT = block("bogey/extra_large/xl6_create/right_pins"),
    CREATE_EXTRA_LARGE_6_PINS_LEFT = block("bogey/extra_large/xl6_create/left_pins"),
    CREATE_EXTRA_LARGE_6_PISTON_RIGHT = block("bogey/extra_large/xl6_create/right_piston"),
    CREATE_EXTRA_LARGE_6_PISTON_LEFT = block("bogey/extra_large/xl6_create/left_piston"),

//Extra Large Scotch Yoke 0-8-0
    CREATE_EXTRA_LARGE_8_FRAME = block("bogey/extra_large/xl8_create/frame"),
    CREATE_EXTRA_LARGE_8_PINS_RIGHT = block("bogey/extra_large/xl8_create/right_pins"),
    CREATE_EXTRA_LARGE_8_PINS_LEFT = block("bogey/extra_large/xl8_create/left_pins"),
    CREATE_EXTRA_LARGE_8_PISTON_RIGHT = block("bogey/extra_large/xl8_create/right_piston"),
    CREATE_EXTRA_LARGE_8_PISTON_LEFT = block("bogey/extra_large/xl8_create/left_piston"),

//Walschaerts
    WALSCHAERTS_WHEEL_CENTER = block("bogey/extra_large/walschaerts/wheel_center"),
    WALSCHAERTS_WHEEL_OUTER = block("bogey/extra_large/walschaerts/wheel_outer"),
    WALSCHAERTS_ECCENTRIC = block("bogey/extra_large/walschaerts/eccentric"),

    A6L_WALSCHAERTS_FRAME = block("bogey/extra_large/walschaerts/xl_long/frame"),

    R6L_WALSCHAERTS_C_LEVER = block("bogey/extra_large/walschaerts/xl_long/right_c_lever"),
    R6L_WALSCHAERTS_C_ROD = block("bogey/extra_large/walschaerts/xl_long/right_c_rod"),
    R6L_WALSCHAERTS_E_LINK = block("bogey/extra_large/walschaerts/xl_long/right_e_link"),
    R6L_WALSCHAERTS_E_ROD = block("bogey/extra_large/walschaerts/xl_long/right_e_rod"),
    R6L_WALSCHAERTS_M_ROD = block("bogey/extra_large/walschaerts/xl_long/right_m_rod"),
    R6L_WALSCHAERTS_P_ROD = block("bogey/extra_large/walschaerts/xl_long/right_p_rod"),
    R6L_WALSCHAERTS_R_BAR = block("bogey/extra_large/walschaerts/xl_long/right_r_bar"),
    R6L_WALSCHAERTS_U_LINK = block("bogey/extra_large/walschaerts/xl_long/right_u_link"),
    R6L_WALSCHAERTS_V_STEM = block("bogey/extra_large/walschaerts/xl_long/right_v_stem"),

    L6L_WALSCHAERTS_C_LEVER = block("bogey/extra_large/walschaerts/xl_long/left_c_lever"),
    L6L_WALSCHAERTS_C_ROD = block("bogey/extra_large/walschaerts/xl_long/left_c_rod"),
    L6L_WALSCHAERTS_E_LINK = block("bogey/extra_large/walschaerts/xl_long/left_e_link"),
    L6L_WALSCHAERTS_E_ROD = block("bogey/extra_large/walschaerts/xl_long/left_e_rod"),
    L6L_WALSCHAERTS_M_ROD = block("bogey/extra_large/walschaerts/xl_long/left_m_rod"),
    L6L_WALSCHAERTS_P_ROD = block("bogey/extra_large/walschaerts/xl_long/left_p_rod"),
    L6L_WALSCHAERTS_R_BAR = block("bogey/extra_large/walschaerts/xl_long/left_r_bar"),
    L6L_WALSCHAERTS_U_LINK = block("bogey/extra_large/walschaerts/xl_long/left_u_link"),
    L6L_WALSCHAERTS_V_STEM = block("bogey/extra_large/walschaerts/xl_long/left_v_stem"),
//Short
    A6S_WALSCHAERTS_FRAME = block("bogey/extra_large/walschaerts/xl_short/frame"),

    R6S_WALSCHAERTS_C_LEVER = block("bogey/extra_large/walschaerts/xl_short/right_c_lever"),
    R6S_WALSCHAERTS_C_ROD = block("bogey/extra_large/walschaerts/xl_short/right_c_rod"),
    R6S_WALSCHAERTS_E_LINK = block("bogey/extra_large/walschaerts/xl_short/right_e_link"),
    R6S_WALSCHAERTS_E_ROD = block("bogey/extra_large/walschaerts/xl_short/right_e_rod"),
    R6S_WALSCHAERTS_M_ROD = block("bogey/extra_large/walschaerts/xl_short/right_m_rod"),
    R6S_WALSCHAERTS_P_ROD = block("bogey/extra_large/walschaerts/xl_short/right_p_rod"),
    R6S_WALSCHAERTS_R_BAR = block("bogey/extra_large/walschaerts/xl_short/right_r_bar"),
    R6S_WALSCHAERTS_U_LINK = block("bogey/extra_large/walschaerts/xl_short/right_u_link"),
    R6S_WALSCHAERTS_V_STEM = block("bogey/extra_large/walschaerts/xl_short/right_v_stem"),

    L6S_WALSCHAERTS_C_LEVER = block("bogey/extra_large/walschaerts/xl_short/left_c_lever"),
    L6S_WALSCHAERTS_C_ROD = block("bogey/extra_large/walschaerts/xl_short/left_c_rod"),
    L6S_WALSCHAERTS_E_LINK = block("bogey/extra_large/walschaerts/xl_short/left_e_link"),
    L6S_WALSCHAERTS_E_ROD = block("bogey/extra_large/walschaerts/xl_short/left_e_rod"),
    L6S_WALSCHAERTS_M_ROD = block("bogey/extra_large/walschaerts/xl_short/left_m_rod"),
    L6S_WALSCHAERTS_P_ROD = block("bogey/extra_large/walschaerts/xl_short/left_p_rod"),
    L6S_WALSCHAERTS_R_BAR = block("bogey/extra_large/walschaerts/xl_short/left_r_bar"),
    L6S_WALSCHAERTS_U_LINK = block("bogey/extra_large/walschaerts/xl_short/left_u_link"),
    L6S_WALSCHAERTS_V_STEM = block("bogey/extra_large/walschaerts/xl_short/left_v_stem"),

    A8S_WALSCHAERTS_FRAME = block("bogey/extra_large/walschaerts/xl8_short/frame"),

    R8S_WALSCHAERTS_C_LEVER = block("bogey/extra_large/walschaerts/xl8_short/right_c_lever"),
    R8S_WALSCHAERTS_C_ROD = block("bogey/extra_large/walschaerts/xl8_short/right_c_rod"),
    R8S_WALSCHAERTS_E_LINK = block("bogey/extra_large/walschaerts/xl8_short/right_e_link"),
    R8S_WALSCHAERTS_E_ROD = block("bogey/extra_large/walschaerts/xl8_short/right_e_rod"),
    R8S_WALSCHAERTS_M_ROD = block("bogey/extra_large/walschaerts/xl8_short/right_m_rod"),
    R8S_WALSCHAERTS_P_ROD = block("bogey/extra_large/walschaerts/xl8_short/right_p_rod"),
    R8S_WALSCHAERTS_R_BAR = block("bogey/extra_large/walschaerts/xl8_short/right_r_bar"),
    R8S_WALSCHAERTS_U_LINK = block("bogey/extra_large/walschaerts/xl8_short/right_u_link"),
    R8S_WALSCHAERTS_V_STEM = block("bogey/extra_large/walschaerts/xl8_short/right_v_stem"),

    L8S_WALSCHAERTS_C_LEVER = block("bogey/extra_large/walschaerts/xl8_short/left_c_lever"),
    L8S_WALSCHAERTS_C_ROD = block("bogey/extra_large/walschaerts/xl8_short/left_c_rod"),
    L8S_WALSCHAERTS_E_LINK = block("bogey/extra_large/walschaerts/xl8_short/left_e_link"),
    L8S_WALSCHAERTS_E_ROD = block("bogey/extra_large/walschaerts/xl8_short/left_e_rod"),
    L8S_WALSCHAERTS_M_ROD = block("bogey/extra_large/walschaerts/xl8_short/left_m_rod"),
    L8S_WALSCHAERTS_P_ROD = block("bogey/extra_large/walschaerts/xl8_short/left_p_rod"),
    L8S_WALSCHAERTS_R_BAR = block("bogey/extra_large/walschaerts/xl8_short/left_r_bar"),
    L8S_WALSCHAERTS_U_LINK = block("bogey/extra_large/walschaerts/xl8_short/left_u_link"),
    L8S_WALSCHAERTS_V_STEM = block("bogey/extra_large/walschaerts/xl8_short/left_v_stem")
    ;

    private static PartialModel block(String path) {
        return new PartialModel(ExtendedBogeys.asResource("block/" + path));
    }
    public static void init() {

    }
}
