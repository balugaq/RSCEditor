package com.balugaq.rsceditor.implementation.items;

import com.balugaq.rsceditor.api.BooleanTypeItem;
import com.balugaq.rsceditor.api.DoubleTypeItem;
import com.balugaq.rsceditor.api.GroupType;
import com.balugaq.rsceditor.api.GroupTypeItem;
import com.balugaq.rsceditor.api.IntegerTypeItem;
import com.balugaq.rsceditor.api.RadioactivityTypeItem;
import com.balugaq.rsceditor.api.RainbowType;
import com.balugaq.rsceditor.api.RainbowTypeItem;
import com.balugaq.rsceditor.api.RecipeTypeItem;
import com.balugaq.rsceditor.api.TextTypeItem;
import com.balugaq.rsceditor.implementation.RSCEditor;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactivity;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashSet;
import java.util.Set;

public class TypeItems {
    public static void register() {
        BooleanTypeItem booleanTypeItem = new BooleanTypeItem(
                new SlimefunItemStack("RSC_EDITOR_BOOLEAN_TYPE_ITEM",
                        new CustomItemStack(
                                Material.PAPER,
                                "&b布尔占位符"
                        )
                )
        );
        booleanTypeItem.register(RSCEditor.getInstance());

        IntegerTypeItem integerTypeItem = new IntegerTypeItem(
                new SlimefunItemStack("RSC_EDITOR_INTEGER_TYPE_ITEM",
                        new CustomItemStack(
                                Material.PAPER,
                                "&b整数占位符"
                        )
                )
        );
        integerTypeItem.register(RSCEditor.getInstance());

        DoubleTypeItem doubleTypeItem = new DoubleTypeItem(
                new SlimefunItemStack("RSC_EDITOR_DOUBLE_TYPE_ITEM",
                        new CustomItemStack(
                                Material.PAPER,
                                "&b浮点数占位符"
                        )
                )
        );
        doubleTypeItem.register(RSCEditor.getInstance());

        TextTypeItem textTypeItem = new TextTypeItem(
                new SlimefunItemStack("RSC_EDITOR_TEXT_TYPE_ITEM",
                        new CustomItemStack(
                                Material.PAPER,
                                "&b文字占位符"
                        )
                )
        );
        textTypeItem.register(RSCEditor.getInstance());

        GroupTypeItem nested = new GroupTypeItem(
                new SlimefunItemStack("RSC_EDITOR_GROUP_TYPE_ITEM_NESTED",
                        new CustomItemStack(
                                Material.PAPER,
                                "&b物品组类型占位符",
                                "&eNested"
                        )
                ),
                GroupType.NESTED
        );
        nested.register(RSCEditor.getInstance());

        GroupTypeItem normal = new GroupTypeItem(
                new SlimefunItemStack("RSC_EDITOR_GROUP_TYPE_ITEM_NORMAL",
                        new CustomItemStack(
                                Material.PAPER,
                                "&b物品组类型占位符",
                                "&eNormal"
                        )
                ),
                GroupType.NORMAL
        );
        normal.register(RSCEditor.getInstance());

        GroupTypeItem sub = new GroupTypeItem(
                new SlimefunItemStack("RSC_EDITOR_GROUP_TYPE_ITEM_SUB",
                        new CustomItemStack(
                                Material.PAPER,
                                "&b物品组类型占位符",
                                "&eSub"
                        )
                ),
                GroupType.SUB
        );
        sub.register(RSCEditor.getInstance());

        GroupTypeItem seasonal = new GroupTypeItem(
                new SlimefunItemStack("RSC_EDITOR_GROUP_TYPE_ITEM_SEASONAL",
                        new CustomItemStack(
                                Material.PAPER,
                                "&b物品组类型占位符",
                                "&eSeasonal"
                        )
                ),
                GroupType.SEASONAL
        );
        seasonal.register(RSCEditor.getInstance());

        GroupTypeItem button = new GroupTypeItem(
                new SlimefunItemStack("RSC_EDITOR_GROUP_TYPE_ITEM_BUTTON",
                        new CustomItemStack(
                                Material.PAPER,
                                "&b物品组类型占位符",
                                "&eButton"
                        )
                ),
                GroupType.BUTTON
        );
        button.register(RSCEditor.getInstance());

        GroupTypeItem locked = new GroupTypeItem(
                new SlimefunItemStack("RSC_EDITOR_GROUP_TYPE_ITEM_LOCKED",
                        new CustomItemStack(
                                Material.PAPER,
                                "&b物品组类型占位符",
                                "&eLocked"
                        )
                ),
                GroupType.LOCKED
        );
        locked.register(RSCEditor.getInstance());

        RadioactivityTypeItem low = new RadioactivityTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RADIOACTIVITY_TYPE_ITEM_LOW",
                        new CustomItemStack(
                                Material.PAPER,
                                "&b辐射占位符",
                                Radioactivity.LOW.getLore()
                        )
                ),
                Radioactivity.LOW
        );
        low.register(RSCEditor.getInstance());

        RadioactivityTypeItem moderate = new RadioactivityTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RADIOACTIVITY_TYPE_ITEM_MODERATE",
                        new CustomItemStack(
                                Material.PAPER,
                                "&b辐射占位符",
                                Radioactivity.MODERATE.getLore()
                        )
                ),
                Radioactivity.MODERATE
        );
        moderate.register(RSCEditor.getInstance());

        RadioactivityTypeItem high = new RadioactivityTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RADIOACTIVITY_TYPE_ITEM_HIGH",
                        new CustomItemStack(
                                Material.PAPER,
                                "&b辐射占位符",
                                Radioactivity.HIGH.getLore()
                        )
                ),
                Radioactivity.HIGH
        );
        high.register(RSCEditor.getInstance());

        RadioactivityTypeItem veryHigh = new RadioactivityTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RADIOACTIVITY_TYPE_ITEM_VERY_HIGH",
                        new CustomItemStack(
                                Material.PAPER,
                                "&b辐射占位符",
                                Radioactivity.VERY_HIGH.getLore()
                        )
                ),
                Radioactivity.VERY_HIGH
        );
        veryHigh.register(RSCEditor.getInstance());

        RadioactivityTypeItem veryDeadly = new RadioactivityTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RADIOACTIVITY_TYPE_ITEM_VERY_DEADLY",
                        new CustomItemStack(
                                Material.PAPER,
                                "&b辐射占位符",
                                Radioactivity.VERY_DEADLY.getLore()
                        )
                ),
                Radioactivity.VERY_DEADLY
        );
        veryDeadly.register(RSCEditor.getInstance());

        RainbowTypeItem wool = new RainbowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RAINBOW_TYPE_ITEM_WOOL",
                        new CustomItemStack(
                                Material.WHITE_WOOL,
                                "&b彩虹类型占位符",
                                "&eWool"
                        )
                ),
                RainbowType.WOOL
        );
        wool.register(RSCEditor.getInstance());

        RainbowTypeItem carpet = new RainbowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RAINBOW_TYPE_ITEM_CARPET",
                        new CustomItemStack(
                                Material.WHITE_CARPET,
                                "&b彩虹类型占位符",
                                "&eCarpet"
                        )
                ),
                RainbowType.CARPET
        );
        carpet.register(RSCEditor.getInstance());

        RainbowTypeItem stained_glass = new RainbowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RAINBOW_TYPE_ITEM_STAINED_GLASS",
                        new CustomItemStack(
                                Material.WHITE_STAINED_GLASS,
                                "&b彩虹类型占位符",
                                "&eStained Glass"
                        )
                ),
                RainbowType.STAINED_GLASS
        );
        stained_glass.register(RSCEditor.getInstance());

        RainbowTypeItem stained_glass_pane = new RainbowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RAINBOW_TYPE_ITEM_STAINED_GLASS_PANE",
                        new CustomItemStack(
                                Material.WHITE_STAINED_GLASS_PANE,
                                "&b彩虹类型占位符",
                                "&eStained Glass Pane"
                        )
                ),
                RainbowType.STAINED_GLASS_PANE
        );
        stained_glass_pane.register(RSCEditor.getInstance());

        RainbowTypeItem terracotta = new RainbowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RAINBOW_TYPE_ITEM_TERRACOTTA",
                        new CustomItemStack(
                                Material.TERRACOTTA,
                                "&b彩虹类型占位符",
                                "&eTerracotta"
                        )
                ),
                RainbowType.TERRACOTTA
        );
        terracotta.register(RSCEditor.getInstance());

        RainbowTypeItem glazed_terracotta = new RainbowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RAINBOW_TYPE_ITEM_GLAZED_TERRACOTTA",
                        new CustomItemStack(
                                Material.WHITE_GLAZED_TERRACOTTA,
                                "&b彩虹类型占位符",
                                "&eGlazed Terracotta"
                        )
                ),
                RainbowType.GLAZED_TERRACOTTA
        );
        glazed_terracotta.register(RSCEditor.getInstance());


        RainbowTypeItem concrete = new RainbowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RAINBOW_TYPE_ITEM_CONCRETE",
                        new CustomItemStack(
                                Material.WHITE_CONCRETE,
                                "&b彩虹类型占位符",
                                "&eConcrete"
                        )
                ),
                RainbowType.CONCRETE
        );
        concrete.register(RSCEditor.getInstance());

        RainbowTypeItem shulker_box = new RainbowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RAINBOW_TYPE_ITEM_SHULKER_BOX",
                        new CustomItemStack(
                                Material.WHITE_SHULKER_BOX,
                                "&b彩虹类型占位符",
                                "&eShulker Box"
                        )
                ),
                RainbowType.SHULKER_BOX
        );
        shulker_box.register(RSCEditor.getInstance());

        RainbowTypeItem custom = new RainbowTypeItem(
                new SlimefunItemStack("RSC_EDITOR_RAINBOW_TYPE_ITEM_CUSTOM",
                        new CustomItemStack(
                                Material.WHITE_BANNER,
                                "&b彩虹类型占位符",
                                "&eCustom"
                        )
                ),
                RainbowType.CUSTOM
        );
        custom.register(RSCEditor.getInstance());


    }
}
