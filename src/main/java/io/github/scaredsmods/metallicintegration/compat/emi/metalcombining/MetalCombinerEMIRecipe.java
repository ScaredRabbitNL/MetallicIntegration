package io.github.scaredsmods.metallicintegration.compat.emi.metalcombining;

import dev.emi.emi.api.recipe.BasicEmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.FillingArrowWidget;
import dev.emi.emi.api.widget.WidgetHolder;
import io.github.scaredsmods.metallicmc.MetallicMC;
import io.github.scaredsmods.metallicmc.api.recipe.metalcombiner.MetalCombiningRecipe;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MetalCombinerEMIRecipe implements EmiRecipe {

    private final Identifier id;
    private final List<EmiIngredient> input;
    private final List<EmiStack> output;

    public MetalCombinerEMIRecipe(MetalCombiningRecipe recipe) {
        this.id = MetalCombiningRecipe.getEMI_id();
        this.input = List.of(EmiIngredient.of(recipe.getIngredients().get(0)), EmiIngredient.of(recipe.getIngredients().get(1)));
        this.output = List.of(EmiStack.of(recipe.getResult(null)));
    }

    @Override
    public EmiRecipeCategory getCategory() {
        return MetalCombinerEMIClientPlugin.METAL_COMBINING;
    }

    @Override
    public @Nullable Identifier getId() {
        return id;
    }

    @Override
    public List<EmiIngredient> getInputs() {
        return input;
    }

    @Override
    public List<EmiStack> getOutputs() {
        return output;
    }

    @Override
    public int getDisplayWidth() {
        return 76;
    }

    @Override
    public int getDisplayHeight() {
        return 54;
    }

    @Override
    public void addWidgets(WidgetHolder widgets) {
        widgets.addTexture(EmiTexture.FULL_ARROW, 26, 18);


        widgets.addSlot(input.get(0), 0, 0);
        widgets.addSlot(input.get(1), 0, 36);


        widgets.addSlot(output.get(0), 58, 18);


    }

}
