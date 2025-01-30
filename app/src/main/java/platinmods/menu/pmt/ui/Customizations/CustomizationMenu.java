package platinmods.menu.pmt.ui.Customizations;

import platinmods.menu.pmt.CategoriesHolder;
import platinmods.menu.pmt.Reborn;
import platinmods.menu.pmt.ui.Category;

public class CustomizationMenu extends Category
{
    public static TitleText titleText;
    public static ModText modText;
    public static ModHighlight modHighlight;
    public static MenuBackground menuBackground;

    public CustomizationMenu(Reborn rebornInstance)
    {
        super(rebornInstance);

        titleText = new TitleText(rebornInstance);
        modText = new ModText(rebornInstance);
        modHighlight = new ModHighlight(rebornInstance);
        menuBackground = new MenuBackground(rebornInstance);

        setToggle("Title Text Color", () -> Replace(titleText));
        setToggle("Mod Text Color", () -> Replace(modText));
        setToggle("Mod Highlight Color", () -> Replace(modHighlight));
        setToggle("Menu Background Color", () -> Replace(menuBackground));
        setToggle("back...", () -> Replace(CategoriesHolder.mainView));
    }

    @Override
    public void Show()
    {
        super.Show();

        setTitle("WergityMods<3\nCustomization Menu");
    }
}
