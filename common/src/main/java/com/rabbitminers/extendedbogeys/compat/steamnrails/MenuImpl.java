package com.rabbitminers.extendedbogeys.compat.steamnrails;

import com.rabbitminers.extendedbogeys.ExtendedBogeys;
import net.minecraft.resources.ResourceLocation;

import com.railwayteam.railways.api.bogeymenu.v0.BogeyMenuManager;
import com.railwayteam.railways.api.bogeymenu.v0.entry.BogeyEntry;
import com.railwayteam.railways.api.bogeymenu.v0.entry.CategoryEntry;
import com.railwayteam.railways.impl.bogeymenu.v0.BogeyMenuManagerImpl;

import static com.rabbitminers.extendedbogeys.registry.ExtendedBogeysBogeyStyles.*;

public interface MenuImpl {
//Grabs the categories by ID
    BogeyMenuManager INSTANCE = new BogeyMenuManagerImpl();
        CategoryEntry SINGLE_AXLE = INSTANCE.getCategoryById(new ResourceLocation("railways", "bogey_menu/category/singleaxles"));
        CategoryEntry DOUBLE_AXLE = INSTANCE.getCategoryById(new ResourceLocation("railways", "bogey_menu/category/doubleaxles"));
        CategoryEntry TRIPLE_AXLE = INSTANCE.getCategoryById(new ResourceLocation("railways", "bogey_menu/category/tripleaxles"));
        CategoryEntry QUADRUPLE_AXLE = INSTANCE.getCategoryById(new ResourceLocation("railways", "bogey_menu/category/quadrupleaxles"));
        CategoryEntry QUINTUPLE_AXLE = INSTANCE.getCategoryById(new ResourceLocation("railways", "bogey_menu/category/quintupleaxles"));
        CategoryEntry SEXTUPLE_AXLE = INSTANCE.getCategoryById(new ResourceLocation("railways", "bogey_menu/category/sextupleaxles"));

//For registering the bogeys to the specified categories
    BogeyEntry
    //Single Axles
        WALSCHAERTS_TRIPLE_AXLE_LONG = INSTANCE.addToCategory(SINGLE_AXLE, WALSCHAERTS_TRIPLE_AXLE_LONG_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/doubleaxle_driver.png")),
        WALSCHAERTS_TRIPLE_AXLE_SHORT = INSTANCE.addToCategory(SINGLE_AXLE, WALSCHAERTS_TRIPLE_AXLE_SHORT_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/doubleaxle_driver.png")),
        WALSCHAERTS_QUADRUPLE_AXLE_SHORT = INSTANCE.addToCategory(SINGLE_AXLE, WALSCHAERTS_QUADRUPLE_AXLE_SHORT_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/doubleaxle_driver.png")),
        SINGLE_AXLE_TRAILING = INSTANCE.addToCategory(SINGLE_AXLE, SINGLE_AXLE_TRAIlER,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/small_0-2-0_trailing.png")),
        SINGLE_AXLE_OFFSET = INSTANCE.addToCategory(SINGLE_AXLE, SINGLE_AXLE_STANDARD,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/small_0-2-0_trailing.png")),
        SINGLE_AXLE_LONG = INSTANCE.addToCategory(SINGLE_AXLE, SINGLE_AXLE_LONG_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/small_0-2-0_trailing.png")),
        SINGLE_AXLE_PISTONLESS = INSTANCE.addToCategory(SINGLE_AXLE, SINGLE_AXLE_PISTONLESS_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/small_0-2-0_trailing.png")),
    //Double Axles
        TRAILING_DOUBLE_AXLE = INSTANCE.addToCategory(DOUBLE_AXLE, DOUBLE_AXLE_TRAILER,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/small_0-4-0_trailing.png")),
        DOUBLE_AXLE_LONG = INSTANCE.addToCategory(DOUBLE_AXLE, DOUBLE_AXLE_LONG_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/doubleaxle_driver.png"), 17),
        DOUBLE_AXLE_EXTRA_LONG = INSTANCE.addToCategory(DOUBLE_AXLE, DOUBLE_AXLE_EXTRA_LONG_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/doubleaxle_driver.png"), 17),
        DOUBLE_AXLE_SHORT = INSTANCE.addToCategory(DOUBLE_AXLE, DOUBLE_AXLE_SHORT_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/doubleaxle_driver.png"), 17),
        DOUBLE_AXLE_PISTONLESS = INSTANCE.addToCategory(DOUBLE_AXLE, DOUBLE_AXLE_PISTONLESS_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/doubleaxle_driver.png"), 17),
        CREATE_DOUBLE_AXLE = INSTANCE.addToCategory(DOUBLE_AXLE, CREATE_DOUBLE_AXLE_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/create_style_0-4-0.png"), 17),
    //Triple Axles
        TRIPLE_AXLE_STANDARD = INSTANCE.addToCategory(TRIPLE_AXLE, TRIPLE_AXLE_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/small_triple_wheel.png")),
        TRIPLE_AXLE_TRAILING = INSTANCE.addToCategory(TRIPLE_AXLE, TRIPLE_AXLE_TRAILER,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/small_0-6-0_trailing.png")),
        TRIPLE_AXLE_LONG = INSTANCE.addToCategory(TRIPLE_AXLE, TRIPLE_AXLE_LONG_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/tripleaxle_driver.png"), 16),
        TRIPLE_AXLE_SHORT = INSTANCE.addToCategory(TRIPLE_AXLE, TRIPLE_AXLE_SHORT_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/tripleaxle_driver.png"), 16),
        TRIPLE_AXLE_PISTONLESS = INSTANCE.addToCategory(TRIPLE_AXLE, TRIPLE_AXLE_PISTONLESS_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/tripleaxle_driver.png"), 16),
        EXTENDED_AXLE_LONG = INSTANCE.addToCategory(TRIPLE_AXLE, TRIPLE_EXTENDED_AXLE_LONG_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/tripleaxle_driver.png"), 16),
        EXTENDED_AXLE_SHORT = INSTANCE.addToCategory(TRIPLE_AXLE, TRIPLE_EXTENDED_AXLE_SHORT_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/tripleaxle_driver.png"), 16),
        EXTENDED_AXLE_PISTONLESS = INSTANCE.addToCategory(TRIPLE_AXLE, TRIPLE_EXTENDED_AXLE_PISTONLESS_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/tripleaxle_driver.png"), 16),
        CREATE_TRIPLE_AXLE = INSTANCE.addToCategory(TRIPLE_AXLE, CREATE_TRIPLE_AXLE_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/create_style_0-6-0.png"), 16),
    //Quadruple Axles
        QUADRUPLE_AXLE_STANDARD = INSTANCE.addToCategory(QUADRUPLE_AXLE, QUADRUPLE_AXLE_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/small_quadruple_wheel.png")),
        QUADRUPLE_AXLE_LONG = INSTANCE.addToCategory(QUADRUPLE_AXLE, QUADRUPLE_AXLE_LONG_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/tripleaxle_driver.png"), 15),
        QUADRUPLE_AXLE_SHORT = INSTANCE.addToCategory(QUADRUPLE_AXLE, QUADRUPLE_AXLE_SHORT_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/tripleaxle_driver.png"), 15),
        QUADRUPLE_AXLE_PISTONLESS = INSTANCE.addToCategory(QUADRUPLE_AXLE, QUADRUPLE_AXLE_PISTONLESS_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/tripleaxle_driver.png"), 15),
        CREATE_QUADRUPLE_AXLE = INSTANCE.addToCategory(QUADRUPLE_AXLE, CREATE_QUADRUPLE_AXLE_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/create_style_0-6-0.png"), 15),
    //Quintuple Axles
        QUINTUPLE_AXLE_STANDARD = INSTANCE.addToCategory(QUINTUPLE_AXLE, QUINTUPLE_AXLE_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/small_quintuple_wheel.png")),
        QUINTUPLE_AXLE_LONG = INSTANCE.addToCategory(QUINTUPLE_AXLE, QUINTUPLE_AXLE_LONG_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/tripleaxle_driver.png"), 14),
        QUINTUPLE_AXLE_SHORT = INSTANCE.addToCategory(QUINTUPLE_AXLE, QUINTUPLE_AXLE_SHORT_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/tripleaxle_driver.png"), 14),
        QUINTUPLE_AXLE_PISTONLESS = INSTANCE.addToCategory(QUINTUPLE_AXLE, QUINTUPLE_AXLE_PISTONLESS_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/tripleaxle_driver.png"), 14),
    //Sextuple Axles
        SEXTUPLE_AXLE_LONG = INSTANCE.addToCategory(SEXTUPLE_AXLE, SEXTUPLE_AXLE_LONG_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/tripleaxle_driver.png"), 13),
        SEXTUPLE_AXLE_SHORT = INSTANCE.addToCategory(SEXTUPLE_AXLE, SEXTUPLE_AXLE_SHORT_BOGEY,new ResourceLocation("extendedbogeys", "textures/gui/bogey_icons/tripleaxle_driver.png"), 13);

    static void load() {
        ExtendedBogeys.LOGGER.info("Registered Steam N' Rails menu categories for " + ExtendedBogeys.MOD_NAME);
    }
}

