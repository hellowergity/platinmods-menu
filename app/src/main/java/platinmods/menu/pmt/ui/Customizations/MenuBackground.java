package platinmods.menu.pmt.ui.Customizations;

import platinmods.menu.pmt.CategoriesHolder;
import platinmods.menu.pmt.Reborn;
import platinmods.menu.pmt.ui.Category;

public class MenuBackground extends Category
{
    public MenuBackground(Reborn rebornInstance)
    {
        super(rebornInstance);

        setToggle("Red BG", () ->
                rebornInstance.menuBgColor = Reborn.menuColors[Reborn.COLOR_RED]
        );

        setToggle("Green BG", () ->
                rebornInstance.menuBgColor = Reborn.menuColors[Reborn.COLOR_GREEN]
        );

        setToggle("Blue BG", () ->
                rebornInstance.menuBgColor = Reborn.menuColors[Reborn.COLOR_BLUE]
        );

        setToggle("Yellow BG", () ->
                rebornInstance.menuBgColor = Reborn.menuColors[Reborn.COLOR_YELLOW]
        );

        setToggle("Orange BG", () ->
                rebornInstance.menuBgColor = Reborn.menuColors[Reborn.COLOR_ORANGE]
        );

        setToggle("Pink BG", () ->
                rebornInstance.menuBgColor = Reborn.menuColors[Reborn.COLOR_PINK]
        );

        setToggle("Purple BG", () ->
                rebornInstance.menuBgColor = Reborn.menuColors[Reborn.COLOR_PURPLE]
        );

        setToggle("Black BG", () ->
                rebornInstance.menuBgColor = Reborn.menuColors[Reborn.COLOR_BLACK]
        );

        setToggle("back...", () -> Replace(CategoriesHolder.customizationMenu));
    }

    @Override
    public void Show()
    {
        super.Show();

        setTitle("WergityMods<3\nBackground");
    }
}
