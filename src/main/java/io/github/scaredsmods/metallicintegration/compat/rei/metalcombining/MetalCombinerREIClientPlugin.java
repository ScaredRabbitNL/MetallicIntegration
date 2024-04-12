package io.github.scaredsmods.metallicintegration.compat.rei.metalcombining;

import io.github.scaredsmods.metallicmc.api.recipe.metalcombiner.MetalCombiningRecipe;
import io.github.scaredsmods.metallicmc.block.machine.ModMachines;
import io.github.scaredsmods.metallicmc.screen.metalcombiner.MetalCombiningScreen;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;

public class MetalCombinerREIClientPlugin implements REIClientPlugin {

    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new MetalCombiningCategory());
        registry.addWorkstations(MetalCombiningCategory.METAL_COMBINING, EntryStacks.of(ModMachines.METAL_COMBINER));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(MetalCombiningRecipe.class, MetalCombiningRecipe.Type.INSTANCE,
                MetalCombiningDisplay::new);

    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(75,  30, 20 ,30), MetalCombiningScreen.class,
                MetalCombiningCategory.METAL_COMBINING);
    }
}
