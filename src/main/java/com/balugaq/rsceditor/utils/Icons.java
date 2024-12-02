package com.balugaq.rsceditor.utils;

import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Icons {
    public static final ItemStack amount = new CustomItemStack(
            Material.LADDER,
            "&e数量",
            "< 在此处放置 整数占位符"
    );
    public static final ItemStack overworld = new CustomItemStack(
            Material.GRASS_BLOCK,
            "&e世界类型: 主世界",
            "< 在此处放置 群系占位符"
    );

    public static final ItemStack nether = new CustomItemStack(
            Material.NETHERRACK,
            "&e世界类型: 下界",
            "< 在此处放置 群系占位符"
    );

    public static final ItemStack end = new CustomItemStack(
            Material.END_STONE,
            "&e世界类型: 末地",
            "< 在此处放置 群系占位符"
    );

    public static final ItemStack custom_rainbow_block = new CustomItemStack(
            Material.PINK_WOOL,
            "< 在此处放置 方块"
    );

    public static final ItemStack id = new CustomItemStack(
            Material.NAME_TAG,
            "&bID",
            "&b^ 在此处放置 文本占位符 ^"
    );

    public static final ItemStack item = new CustomItemStack(
            Material.ENCHANTED_BOOK,
            "&b物品模型",
            "&b^ 在此处放置物品 ^"
    );

    public static final ItemStack build_recipe_type = new CustomItemStack(
            Material.STRUCTURE_BLOCK,
            "&b构造",
            "&b点击构造配方类型"
    );

    public static final ItemStack mob = new CustomItemStack(
            Material.SPAWNER,
            "&b生物",
            "&b^ 在此处放置 生物蛋 ^"
    );

    public static final ItemStack chance = new CustomItemStack(
            Material.BONE_MEAL,
            "&b几率",
            "&b^ 在此处放置 整数占位符 ^"
    );

    public static final ItemStack build_mob_drop = new CustomItemStack(
            Material.STRUCTURE_BLOCK,
            "&b构造",
            "&b点击构造 生物掉落物"
    );

    public static final ItemStack item_group = new CustomItemStack(
            Material.CHEST,
            "&b物品组",
            "&b^ 在此处放置 物品组占位符 ^"
    );

    public static final ItemStack group_type = new CustomItemStack(
            Material.BEACON,
            "&b物品组类型",
            "&b^ 在此处放置 物品组类型占位符 ^"
    );

    public static final ItemStack tier = new CustomItemStack(
            Material.LADDER,
            "&b等级",
            "&b^ 在此处放置 整数占位符 ^"
    );

    public static final ItemStack parent_group = new CustomItemStack(
            Material.GLASS,
            "&b父物品组",
            "&b^ 在此处放置 物品组占位符 ^",
            "&c当此物品组是子物品组时"
    );

    public static final ItemStack month = new CustomItemStack(
            Material.MOSS_BLOCK,
            "&月份",
            "&b^ 在此处放置 整数占位符 ^",
            "&c当此物品组是季节性物品组时"
    );

    public static final ItemStack parents_group = new CustomItemStack(
            Material.OBSIDIAN,
            "&b爷物品组",
            "&b^ 在此处放置 物品组占位符 ^",
            "&c当此物品组是锁定物品组时"
    );

    public static final ItemStack action = new CustomItemStack(
            Material.ORANGE_GLAZED_TERRACOTTA,
            "&b操作",
            "&b^ 在此处放置 文本占位符 ^",
            "&c当此物品组是链接物品组时"
    );

    public static final ItemStack build_item_group = new CustomItemStack(
            Material.STRUCTURE_BLOCK,
            "&b构造",
            "&b点击以构造物品组"
    );
    public static final ItemStack recipe_type = new CustomItemStack(
            Material.BOOK,
            "&b配方类型",
            "&b^ 在此处放置 配方类型占位符 ^"
    );

    public static final ItemStack placeable = new CustomItemStack(
            Material.REDSTONE_BLOCK,
            "&b放置性",
            "&b^ 在此处放置 布尔占位符 ^"
    );

    public static final ItemStack script = new CustomItemStack(
            Material.SCULK_SENSOR,
            "&b脚本",
            "&b^ 在此处放置 文本占位符 ^"
    );

    public static final ItemStack energy_capacity = new CustomItemStack(
            Material.REDSTONE_TORCH,
            "&b电容量",
            "&b^ 在此处放置 整数占位符 ^"
    );

    public static final ItemStack radiation = new CustomItemStack(
            Material.LIME_DYE,
            "&b辐射",
            "&b^ 在此处放置 辐射类型占位符 ^"
    );

    public static final ItemStack rainbow = new CustomItemStack(
            Material.PINK_WOOL,
            "&b彩虹类型",
            "&b^ 在此处放置 彩虹类型占位符 ^",
            "&c使用自定义彩虹材料时",
            "&c在此机器下方放置 &b自定义彩虹物品容器"
    );

    public static final ItemStack anti_wither = new CustomItemStack(
            Material.WITHER_ROSE,
            "&b防凋灵",
            "&b^ 在此处放置 布尔占位符 ^"
    );

    public static final ItemStack soul_bound = new CustomItemStack(
            Material.PLAYER_HEAD,
            "&b灵魂绑定",
            "&b^ 在此处放置 布尔占位符 ^"
    );

    public static final ItemStack piglin_chance = new CustomItemStack(
            Material.GOLD_INGOT,
            "&b猪灵交易几率",
            "&b^ 在此处放置 整数占位符 ^"
    );

    public static final ItemStack man_made = new CustomItemStack(
            Material.CONDUIT,
            "&b人造",
            "&b^ 在此处放置 布尔占位符 ^"
    );

    public static final ItemStack hidden = new CustomItemStack(
            Material.GRAY_DYE,
            "&b隐藏",
            "&b^ 在此处放置 布尔占位符 ^"
    );

    public static final ItemStack drop_from = new CustomItemStack(
            Material.DIRT,
            "&b挖掘掉落",
            "&b^ 在此处放置 方块 ^"
    );

    public static final ItemStack drop_chance = new CustomItemStack(
            Material.BONE_MEAL,
            "&b掉落几率",
            "&b^ 在此处放置 整数占位符 ^"
    );

    public static final ItemStack drop_amount = new CustomItemStack(
            Material.LADDER,
            "&b掉落数量",
            "&b^ 在此处放置 整数占位符 ^"
    );

    public static final ItemStack build_item = new CustomItemStack(
            Material.STRUCTURE_BLOCK,
            "&b构造",
            "&b点击构造物品"
    );

    public static final ItemStack max_deviation = new CustomItemStack(
            Material.CHAIN,
            "&b资源最大偏差",
            "&b^ 在此处放置 整数占位符 ^"
    );

    public static final ItemStack obtain_from_geo_miner = new CustomItemStack(
            Material.IRON_PICKAXE,
            "&bGEO矿机采集",
            "&b^ 在此处放置 布尔占位符 ^"
    );

    public static final ItemStack geo_name = new CustomItemStack(
            Material.COAL,
            "&bGEO名字",
            "&b^ 在此处放置 文本占位符 ^"
    );

    public static final ItemStack build_geo = new CustomItemStack(
            Material.STRUCTURE_BLOCK,
            "&b构造",
            "&b点击以构造 GEO"
    );

    public static final ItemStack potion = new CustomItemStack(
            Material.POTION,
            "&b药水",
            "&b^ 在此处放置 文本占位符 ^"
    );

    public static final ItemStack fullset = new CustomItemStack(
            Material.END_CRYSTAL,
            "&b全套",
            "&b^ 在此处放置 布尔占位符 ^"
    );

    public static final ItemStack protection_type = new CustomItemStack(
            Material.SHIELD,
            "&b保护类型",
            "&b^ 在此处放置 保护类型占位符 ^"
    );

    public static final ItemStack helmet = new CustomItemStack(
            Material.DIAMOND_HELMET,
            "&b头盔",
            "&b在此机器上方第 4 格放置",
            "&b装备部分容器"
    );

    public static final ItemStack chestplate = new CustomItemStack(
            Material.DIAMOND_CHESTPLATE,
            "&b胸甲",
            "&b在此机器上方第 3 格放置",
            "&b装备部分容器"
    );

    public static final ItemStack leggings = new CustomItemStack(
            Material.DIAMOND_LEGGINGS,
            "&b护腿",
            "&b在此机器上方第 2 格放置",
            "&b装备部分容器"
    );

    public static final ItemStack boots = new CustomItemStack(
            Material.DIAMOND_BOOTS,
            "&b靴子",
            "&b在此机器上方第 1 格放置",
            "&b装备部分容器"
    );

    public static final ItemStack build_armor = new CustomItemStack(
            Material.STRUCTURE_BLOCK,
            "&b构造",
            "&b点击以构造装备"
    );

    public static final ItemStack build_capacitor = new CustomItemStack(
            Material.STRUCTURE_BLOCK,
            "&b构造",
            "&b点击以构造电容"
    );

    public static final ItemStack nutrition = new CustomItemStack(
            Material.BREAD,
            "&b营养",
            "&b^ 在此处放置 整数占位符 ^"
    );

    public static final ItemStack saturation = new CustomItemStack(
            Material.GOLDEN_CARROT,
            "&b饱和度",
            "&b^ 在此处放置 浮点数占位符 ^"
    );

    public static final ItemStack eatseconds = new CustomItemStack(
            Material.CLOCK,
            "&b食入时间",
            "&b^ 在此处放置 浮点数占位符 ^"
    );

    public static final ItemStack always_eatable = new CustomItemStack(
            Material.COOKIE,
            "&b保持可食用性",
            "&b^ 在此处放置 布尔占位符 ^"
    );

    public static final ItemStack build_food = new CustomItemStack(
            Material.STRUCTURE_BLOCK,
            "&b构造",
            "&b点击以构造食物"
    );

    public static final ItemStack recipe_name = new CustomItemStack(
            Material.NAME_TAG,
            "&b配方名称",
            "&b^ 在此处放置 文本占位符 ^"
    );

    public static final ItemStack energy_cost = new CustomItemStack(
            Material.REDSTONE,
            "&b能量消耗",
            "&b^ 在此处放置 整数占位符 ^"
    );

    public static final ItemStack processing_time = new CustomItemStack(
            Material.CLOCK,
            "&b处理时间",
            "&b^ 在此处放置 整数占位符 ^"
    );

    public static final ItemStack choose_one = new CustomItemStack(
            Material.BARRIER,
            "&b仅输出一个物品",
            "&b^ 在此处放置 布尔占位符 ^"
    );

    public static final ItemStack for_display = new CustomItemStack(
            Material.BARRIER,
            "&b仅用于显示",
            "&b^ 在此处放置 布尔占位符 ^"
    );

    public static final ItemStack hide = new CustomItemStack(
            Material.BARRIER,
            "&b隐藏",
            "&b^ 在此处放置 布尔占位符 ^"
    );

    public static final ItemStack build_machine_recipe = new CustomItemStack(
            Material.STRUCTURE_BLOCK,
            "&b构造",
            "&b点击以构造机器配方"
    );

    public static final ItemStack build_linked_machine_recipe = new CustomItemStack(
            Material.STRUCTURE_BLOCK,
            "&b构造",
            "&b点击以构造链接机器配方"
    );

    public static final ItemStack energy_net_component_type = new CustomItemStack(
            Material.BLAZE_ROD,
            "&b能源网络组件类型",
            "&b^ 在此处放置 能源网络组件类型占位符 ^"
    );

    public static final ItemStack title = new CustomItemStack(
            Material.MAP,
            "&b标题",
            "&b^ 在此处放置 文本占位符 ^"
    );

    public static final ItemStack work = new CustomItemStack(
            Material.STONE_BUTTON,
            "&b工作槽位",
            "&b^ 在此处放置 整数占位符 ^"
    );

    public static final ItemStack progress_bar_slot = new CustomItemStack(
            Material.COMPARATOR,
            "&b进度条槽位",
            "&b^ 在此处放置 整数占位符 ^"
    );

    public static final ItemStack build_machine = new CustomItemStack(
            Material.STRUCTURE_BLOCK,
            "&b构造",
            "&b点击以构造机器"
    );

    public static final ItemStack machine_recipes = new CustomItemStack(
            Material.JIGSAW,
            "&b机器配方",
            "&b< 在此处放置 机器配方占位符"
    );

    public static final ItemStack production = new CustomItemStack(
            Material.GLOWSTONE,
            "&b产电量",
            "&b^ 在此处放置 整数占位符 ^"
    );

    public static final ItemStack build_generator = new CustomItemStack(
            Material.STRUCTURE_BLOCK,
            "&b构造",
            "&b点击以构造发电机"
    );
}
