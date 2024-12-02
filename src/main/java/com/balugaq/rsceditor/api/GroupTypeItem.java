package com.balugaq.rsceditor.api;

import com.balugaq.rsceditor.implementation.groups.MyItemGroups;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class GroupTypeItem extends PlaceholderItem {
    private final GroupType type;

    public GroupTypeItem(@NotNull SlimefunItemStack item, GroupType type) {
        super(MyItemGroups.TYPE_GROUP, item);
        this.type = type;
    }
}