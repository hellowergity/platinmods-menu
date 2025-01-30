package platinmods.menu.pmt.ui.Customizations;

import platinmods.menu.pmt.CategoriesHolder;
import platinmods.menu.pmt.Reborn;
import platinmods.menu.pmt.ui.Category;

public class ModHighlight extends Category
{
    public ModHighlight(Reborn rebornInstance)
    {
        super(rebornInstance);

        setToggle("Red Highlight", () ->
                rebornInstance.modHighlightColor = Reborn.textColors[Reborn.COLOR_RED]
        );

        setToggle("Green Highlight", () ->
                rebornInstance.modHighlightColor = Reborn.textColors[Reborn.COLOR_GREEN]
        );

        setToggle("Blue Highlight", () ->
                rebornInstance.modHighlightColor = Reborn.textColors[Reborn.COLOR_BLUE]
        );

        setToggle("Yellow Highlight", () ->
                rebornInstance.modHighlightColor = Reborn.textColors[Reborn.COLOR_YELLOW]
        );

        setToggle("Orange Highlight", () ->
                rebornInstance.modHighlightColor = Reborn.textColors[Reborn.COLOR_ORANGE]
        );

        setToggle("Pink Highlight", () ->
                rebornInstance.modHighlightColor = Reborn.textColors[Reborn.COLOR_PINK]
        );

        setToggle("Purple Highlight", () ->
                rebornInstance.modHighlightColor = Reborn.textColors[Reborn.COLOR_PURPLE]
        );

        setToggle("Black Highlight", () ->
                rebornInstance.modHighlightColor = Reborn.textColors[Reborn.COLOR_BLACK]
        );

        setToggle("back...", () -> Replace(CategoriesHolder.customizationMenu));
    }

    @Override
    public void Show()
    {
        super.Show();

        setTitle("WergityMods<3\nMod Highlight");
    }
}
