package platinmods.menu.pmt;

import platinmods.menu.pmt.ui.MainView;
import platinmods.menu.pmt.ui.Customizations.CustomizationMenu;

public class CategoriesHolder
{
    public static MainView mainView;
    public static CustomizationMenu customizationMenu;

    public static void CreateViews(Reborn rebornInstance)
    {
        mainView = new MainView(rebornInstance);
        customizationMenu = new CustomizationMenu(rebornInstance);

        mainView.Show();
    }
}