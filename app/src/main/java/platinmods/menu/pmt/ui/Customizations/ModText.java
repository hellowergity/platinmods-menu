package platinmods.menu.pmt.ui.Customizations;

import platinmods.menu.pmt.CategoriesHolder;
import platinmods.menu.pmt.Reborn;
import platinmods.menu.pmt.ui.Category;

public class ModText extends Category
{
    public ModText(Reborn rebornInstance)
    {
        super(rebornInstance);

        setToggle("Red Text", () ->
                rebornInstance.modTextColor = Reborn.textColors[Reborn.COLOR_RED]
        );

        setToggle("Green Text", () ->
                rebornInstance.modTextColor = Reborn.textColors[Reborn.COLOR_GREEN]
        );

        setToggle("Blue Text", () ->
                rebornInstance.modTextColor = Reborn.textColors[Reborn.COLOR_BLUE]
        );

        setToggle("Yellow Text", () ->
                rebornInstance.modTextColor = Reborn.textColors[Reborn.COLOR_YELLOW]
        );

        setToggle("Orange Text", () ->
                rebornInstance.modTextColor = Reborn.textColors[Reborn.COLOR_ORANGE]
        );

        setToggle("Pink Text", () ->
                rebornInstance.modTextColor = Reborn.textColors[Reborn.COLOR_PINK]
        );

        setToggle("Purple Text", () ->
                rebornInstance.modTextColor = Reborn.textColors[Reborn.COLOR_PURPLE]
        );

        setToggle("Black Text", () ->
                rebornInstance.modTextColor = Reborn.textColors[Reborn.COLOR_BLACK]
        );

        setToggle("back...", () -> Replace(CategoriesHolder.customizationMenu));
    }

    @Override
    public void Show()
    {
        super.Show();

        setTitle("WergityMods<3\nMod Text");
    }
}
