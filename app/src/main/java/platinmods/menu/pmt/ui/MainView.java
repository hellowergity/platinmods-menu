package platinmods.menu.pmt.ui;

import platinmods.menu.pmt.CategoriesHolder;
import platinmods.menu.pmt.Reborn;

public class MainView extends Category
{
    public MainView(Reborn rebornInstance)
    {
        super(rebornInstance);

        setToggle("Customization Menu", () -> Replace(CategoriesHolder.customizationMenu));
    }

    @Override
    public void Show()
    {
        super.Show();

        setTitle("WergityMods<3\nMain Menu");
    }
}