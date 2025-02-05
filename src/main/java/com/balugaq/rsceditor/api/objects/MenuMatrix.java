package com.balugaq.rsceditor.api.objects;

import lombok.Getter;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("deprecation")
@Getter
public class MenuMatrix {
    private final List<String> labels = new ArrayList<>();
    private final Map<Character, ItemStack> itemStackMap = new HashMap<>();
    private final Map<Character, ChestMenu.MenuClickHandler> handlerMap = new HashMap<>();

    public MenuMatrix() {

    }

    public @NotNull MenuMatrix addLine(String label) {
        labels.add(label);
        return this;
    }

    public @NotNull MenuMatrix addItem(Character label, ItemStack item, ChestMenu.MenuClickHandler handler) {
        this.itemStackMap.put(label, item);
        this.handlerMap.put(label, handler);
        return this;
    }

    public @NotNull MenuMatrix addItem(Character label, ItemStack item) {
        return addItem(label, item, (p, s, i, a) -> false);
    }

    public @NotNull MenuMatrix addHandler(Character label, ChestMenu.MenuClickHandler handler) {
        this.handlerMap.put(label, handler);
        return this;
    }

    public @NotNull MenuMatrix addItem(@NotNull String label, ItemStack item, ChestMenu.MenuClickHandler handler) {
        return addItem(label.charAt(0), item, handler);
    }

    public @NotNull MenuMatrix addItem(@NotNull String label, ItemStack item) {
        return addItem(label.charAt(0), item, (p, s, i, a) -> false);
    }

    public @NotNull MenuMatrix addHandler(@NotNull String label, ChestMenu.MenuClickHandler handler) {
        return addHandler(label.charAt(0), handler);
    }

    public void build(@NotNull BlockMenuPreset preset) {
        int index = 0;
        for (String label : labels) {
            for (int j = 0; j < label.length(); j++) {
                if (index >= 54) {
                    break;
                }
                char c = label.charAt(j);
                if (itemStackMap.containsKey(c)) {
                    preset.addItem(index, itemStackMap.get(c), handlerMap.get(c));
                }
                index++;
            }
        }
    }

    public int getChar(Character label) {
        for (int i = 0; i < labels.size(); i++) {
            String line = labels.get(i);
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == label) {
                    return i * 9 + j;
                }
            }
        }

        return -1;
    }

    public int getChar(@NotNull String label) {
        return getChar(label.charAt(0));
    }

    public int[] getChars(Character label) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < labels.size(); i++) {
            String line = labels.get(i);
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == label) {
                    result.add(i * 9 + j);
                }
            }
        }

        int[] array = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            array[i] = result.get(i);
        }

        return array;
    }

    public int[] getChars(@NotNull String label) {
        return getChars(label.charAt(0));
    }
}
