package platinmods.menu.pmt.ui.Customizations;

import platinmods.menu.pmt.CategoriesHolder;
import platinmods.menu.pmt.Reborn;
import platinmods.menu.pmt.ui.Category;

public class TitleText extends Category
{
    public TitleText(Reborn rebornInstance)
    {
        super(rebornInstance);

        setToggle("Red Title", () ->
                rebornInstance.titleTextColor = Reborn.textColors[Reborn.COLOR_RED]
        );

        setToggle("Green Title", () ->
                rebornInstance.titleTextColor = Reborn.textColors[Reborn.COLOR_GREEN]
        );

        setToggle("Blue Title", () ->
                rebornInstance.titleTextColor = Reborn.textColors[Reborn.COLOR_BLUE]
        );

        setToggle("Yellow Title", () ->
                rebornInstance.titleTextColor = Reborn.textColors[Reborn.COLOR_YELLOW]
        );

        setToggle("Orange Title", () ->
                rebornInstance.titleTextColor = Reborn.textColors[Reborn.COLOR_ORANGE]
        );

        setToggle("Pink Title", () ->
                rebornInstance.titleTextColor = Reborn.textColors[Reborn.COLOR_PINK]
        );

        setToggle("Purple Title", () ->
                rebornInstance.titleTextColor = Reborn.textColors[Reborn.COLOR_PURPLE]
        );

        setToggle("Black Title", () ->
                rebornInstance.titleTextColor = Reborn.textColors[Reborn.COLOR_BLACK]
        );

        setToggle("back...", () -> Replace(CategoriesHolder.customizationMenu));
    }

    @Override
    public void Show()
    {
        super.Show();

        setTitle("WergityMods<3\nTitle Text");
    }
}
