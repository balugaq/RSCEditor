package com.balugaq.rsceditor.utils;

import com.balugaq.rsceditor.api.objects.types.LinkedMachineRecipe;
import com.balugaq.rsceditor.api.objects.types.MachineRecipe;
import com.balugaq.rsceditor.api.objects.types.Register;
import com.balugaq.rsceditor.api.objects.types.TemplateMachineRecipe;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.net.URL;
import java.util.List;

@SuppressWarnings("deprecation")
@Getter
public class YamlWriter {
    private String root;
    private File file;
    private FileConfiguration configuration;

    public YamlWriter() {
        configuration = new YamlConfiguration();
    }

    @CanIgnoreReturnValue
    public @NotNull YamlWriter setFile(@NotNull File file) {
        this.file = file;
        this.configuration = YamlConfiguration.loadConfiguration(file);
        return this;
    }

    @CanIgnoreReturnValue
    public @NotNull YamlWriter setRoot(@NotNull String root) {
        this.root = root;
        return this;
    }

    @CanIgnoreReturnValue
    public @NotNull YamlWriter set(String key, @NotNull MachineRecipe recipe) {
        String recipeKey = getKey(key + "." + recipe.getName());
        configuration.set(recipeKey + ".seconds", recipe.getProcessingTime());
        String inputKey = recipeKey + ".input";
        for (int i = 0; i < recipe.getInputs().length; i++) {
            set(inputKey + "." + i, recipe.getInputs()[i], false);
        }

        String outputKey = recipeKey + ".output";
        for (int i = 0; i < recipe.getOutputs().length; i++) {
            set(outputKey + "." + i, recipe.getOutputs()[i], false);
        }

        configuration.set(recipeKey + ".chooseOne", recipe.isChooseOne());
        configuration.set(recipeKey + ".forDisplay", recipe.isForDisplay());
        configuration.set(recipeKey + ".hide", recipe.isHide());

        return this;
    }

    @CanIgnoreReturnValue
    public @NotNull YamlWriter set(String key, @NotNull TemplateMachineRecipe recipe) {
        String recipeKey = getKey(key + "." + recipe.getId() + "." + recipe.getName());
        configuration.set(recipeKey + ".seconds", recipe.getProcessingTime());
        String inputKey = recipeKey + ".input";
        for (int i = 0; i < recipe.getInputs().length; i++) {
            set(inputKey + "." + i, recipe.getInputs()[i], false);
        }

        String outputKey = recipeKey + ".output";
        for (int i = 0; i < recipe.getOutputs().length; i++) {
            set(outputKey + "." + i, recipe.getOutputs()[i], false);
        }

        configuration.set(recipeKey + ".chooseOne", recipe.isChooseOne());
        configuration.set(recipeKey + ".forDisplay", recipe.isForDisplay());
        configuration.set(recipeKey + ".hide", recipe.isHide());

        return this;
    }

    @CanIgnoreReturnValue
    public @NotNull YamlWriter set(String key, @NotNull LinkedMachineRecipe recipe) {
        String recipeKey = getKey(key + "." + recipe.getName());
        configuration.set(recipeKey + ".seconds", recipe.getProcessingTime());
        String inputKey = recipeKey + ".input";
        String outputKey = recipeKey + ".output";
        int i = 0;
        for (Integer slot : recipe.getLinkedInputs().keySet()) {
            ItemStack itemStack = recipe.getLinkedInputs().get(slot);
            if (itemStack == null || itemStack.getType() == Material.AIR) {
                continue;
            }
            set(inputKey + "." + i, itemStack.clone(), false);
            configuration.set(inputKey + "." + i + ".slot", slot);
            i++;
        }

        i = 0;
        for (Integer slot : recipe.getLinkedOutputs().keySet()) {
            ItemStack itemStack = recipe.getLinkedOutputs().get(slot);
            if (itemStack == null || itemStack.getType() == Material.AIR) {
                continue;
            }
            set(outputKey + "." + i, itemStack.clone(), false);
            configuration.set(outputKey + "." + i + ".slot", slot);
            i++;
        }

        for (ItemStack itemStack : recipe.getFreeOutputs()) {
            if (itemStack == null || itemStack.getType() == Material.AIR) {
                continue;
            }
            set(outputKey + "." + i, itemStack.clone(), false);
        }

        configuration.set(recipeKey + ".chooseOne", recipe.isChooseOne());
        configuration.set(recipeKey + ".forDisplay", recipe.isForDisplay());
        configuration.set(recipeKey + ".hide", recipe.isHide());

        return this;
    }

    @CanIgnoreReturnValue
    public @NotNull YamlWriter set(@NotNull String key, @Nullable Register register) {
        if (register == null) {
            return this;
        }

        String registerKey = getKey(key);
        String id_alias = register.getIdAlias();
        if (id_alias != null) {
            configuration.set(registerKey + ".id_alias", id_alias);
        }

        boolean late_init = register.isLateInit();
        configuration.set(registerKey + ".late_init", late_init);

        boolean warn = register.isWarn();
        configuration.set(registerKey + ".warn", warn);

        boolean unfinished = register.isUnfinished();
        configuration.set(registerKey + ".unfinished", unfinished);

        List<String> conditions = register.getConditions();
        if (conditions != null && !conditions.isEmpty()) {
            configuration.set(registerKey + ".conditions", conditions.toArray(new String[0]));
        }

        return this;
    }

    @CanIgnoreReturnValue
    public @NotNull YamlWriter set(String key, @Nullable ItemStack itemStack) {
        return set(key, itemStack, true);
    }

    @CanIgnoreReturnValue
    public @NotNull YamlWriter set(String key, @Nullable ItemStack itemStack, boolean model) {
        if (itemStack == null) {
            return this;
        }

        if (itemStack.getType() == Material.AIR) {
            configuration.set(getKey(key + ".material_type"), "none");
            return this;
        }

        ItemMeta itemMeta = itemStack.getItemMeta();
        SlimefunItem slimefunItem = SlimefunItem.getByItem(itemStack);
        if (model) {
            if (itemMeta.hasCustomModelData()) {
                int modelData = itemMeta.getCustomModelData();
                configuration.set(getKey(key + ".modelId"), modelData);
            }

            if (itemMeta.hasLore()) {
                List<String> lore = itemMeta.getLore();
                if (lore != null && !lore.isEmpty()) {
                    configuration.set(getKey(key + ".lore"), lore.toArray(new String[0]));
                }
            }

            if (itemMeta.hasDisplayName()) {
                configuration.set(getKey(key + ".name"), itemMeta.getDisplayName());
            }
        }

        configuration.set(getKey(key + ".amount"), itemStack.getAmount());

        if (slimefunItem != null) {
            if (!slimefunItem.getId().equals("LOGITECH_SAMPLE_HEAD")) {
                configuration.set(getKey(key + ".material_type"), "slimefun");
                configuration.set(getKey(key + ".material"), slimefunItem.getId());
                configuration.set(getKey(key + ".amount"), itemStack.getAmount());
                return this;
            }
        }

        if (itemStack.getType() == Material.PLAYER_HEAD || itemStack.getType() == Material.PLAYER_WALL_HEAD) {
            if (itemMeta instanceof SkullMeta skullMeta) {
                try {
                    URL url = skullMeta.getOwnerProfile().getTextures().getSkin();
                    String path = url.getPath();
                    String[] parts = path.split("/");
                    String hash = parts[parts.length - 1];

                    configuration.set(getKey(key + ".material_type"), "skull_hash");
                    configuration.set(getKey(key + ".material"), hash);
                } catch (Throwable ignored) {

                }
            } else {
                configuration.set(getKey(key + ".material_type"), "mc");
                configuration.set(getKey(key + ".material"), itemStack.getType().name());
            }
        } else {
            configuration.set(getKey(key + ".material_type"), "mc");
            configuration.set(getKey(key + ".material"), itemStack.getType().name());
        }

        return this;
    }

    @CanIgnoreReturnValue
    public @NotNull YamlWriter set(@NotNull String key, Object value) {
        configuration.set(getKey(key), value);
        return this;
    }

    public @NotNull String getKey(@NotNull String key) {
        if (root == null) {
            return key;
        }

        return root + "." + key;
    }

    public @NotNull String toString() {
        return configuration.saveToString();
    }

    public void save() {
        try {
            configuration.save(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
