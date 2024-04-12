package io.github.scaredsmods.metallicintegration.compat.rei.metalcombining;

import io.github.scaredsmods.metallicmc.MetallicMC;
import io.github.scaredsmods.metallicmc.block.machine.ModMachines;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.BlockLocating;


import java.util.LinkedList;
import java.util.List;


public class MetalCombiningCategory implements DisplayCategory<BasicDisplay> {

    public static final Identifier TEXTURE = new Identifier(MetallicMC.MOD_ID, "textures/gui/metal_combiner_gui.png");
    public static final CategoryIdentifier<MetalCombiningDisplay> METAL_COMBINING =
            CategoryIdentifier.of(MetallicMC.MOD_ID, "metal_combining");


    @Override
    public CategoryIdentifier<? extends BasicDisplay> getCategoryIdentifier() {
        return METAL_COMBINING;
    }

    @Override
    public Text getTitle() {
        return Text.translatable("catagory.rei.metallicmc.metal_combining");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ModMachines.METAL_COMBINER.asItem().getDefaultStack());
    }

    @Override
    public List<Widget> setupDisplay(BasicDisplay display, Rectangle bounds) {
        final Point startPoint = new Point(bounds.getCenterX() - 87, bounds.getCenterY() - 35);
        List<Widget> widgets = new LinkedList<>();
        widgets.add(Widgets.createTexturedWidget(TEXTURE, new Rectangle(startPoint.x, startPoint.y, 175, 82)));

        widgets.add(Widgets.createSlot(new Point(startPoint.x + 62, startPoint.y + 11))
                .entries(display.getInputEntries().get(0)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 98, startPoint.y + 11))
                .entries(display.getInputEntries().get(1)));

        widgets.add(Widgets.createSlot(new Point(startPoint.x + 80, startPoint.y + 59))
                .markOutput().entries(display.getOutputEntries().get(0)));

        return widgets;
    }

    @Override
    public int getDisplayHeight() {
        return 90;
    }
}
