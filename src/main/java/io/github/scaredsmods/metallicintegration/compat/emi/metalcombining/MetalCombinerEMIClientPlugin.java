package io.github.scaredsmods.metallicintegration.compat.emi.metalcombining;

import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiStack;
import io.github.scaredsmods.metallicmc.MetallicMC;
import io.github.scaredsmods.metallicmc.api.recipe.ModRecipes;
import io.github.scaredsmods.metallicmc.api.recipe.metalcombiner.MetalCombiningRecipe;
import io.github.scaredsmods.metallicmc.block.machine.ModMachines;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.util.Identifier;

public class MetalCombinerEMIClientPlugin implements EmiPlugin {
    public static final Identifier TEXTURE = new Identifier(MetallicMC.MOD_ID, "textures/gui/metal_combiner_gui.png");
    public static final EmiStack METAL_COMBINER_WORKSTATION = EmiStack.of(ModMachines.METAL_COMBINER);
    public static final EmiRecipeCategory METAL_COMBINING
            = new EmiRecipeCategory(new Identifier(MetallicMC.MOD_ID, "metal_combining"), METAL_COMBINER_WORKSTATION, new EmiTexture(TEXTURE, -20, 0, 16, 16));

    @Override
    public void register(EmiRegistry registry) {
        // Tell EMI to add a tab for your category
        registry.addCategory(METAL_COMBINING);

        // Add all the workstations your category uses
        registry.addWorkstation(METAL_COMBINING, METAL_COMBINER_WORKSTATION);

        RecipeManager manager = registry.getRecipeManager();

        // Use vanilla's concept of your recipes and pass them to your EmiRecipe representation
        for (RecipeEntry<MetalCombiningRecipe> recipe : manager.listAllOfType(MetalCombiningRecipe.Type.INSTANCE)) {
            registry.addRecipe(new MetalCombinerEMIRecipe(recipe.value()));
        }
    }
}
