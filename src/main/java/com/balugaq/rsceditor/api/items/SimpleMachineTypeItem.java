package com.balugaq.rsceditor.api.items;

import com.balugaq.rsceditor.api.base.PlaceholderItem;
import com.balugaq.rsceditor.api.objects.types.SimpleMachineType;
import com.balugaq.rsceditor.implementation.groups.RSCEItemGroups;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class SimpleMachineTypeItem extends PlaceholderItem {
    private final SimpleMachineType simpleMachineType;

    public SimpleMachineTypeItem(@NotNull SlimefunItemStack item, SimpleMachineType simpleMachineType) {
        super(RSCEItemGroups.TYPE_GROUP, item);
        this.simpleMachineType = simpleMachineType;
    }
}