package platinmods.menu.pmt.ui;

import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import platinmods.menu.pmt.Reborn;

public class Category
{
    private final Reborn rebornInstance;

    private final List<TextView> viewList;

    private static Category activeCategory;

    public Category(Reborn reborn)
    {
        rebornInstance = reborn;
        viewList = new ArrayList<>();
    }

    public void setTitle(String text)
    {
        TextView textView = rebornInstance.titleTextView;

        textView.setText(text);
        textView.setShadowLayer(12, 0, 0, rebornInstance.titleTextColor);

        textView.setOnClickListener(v ->
        {
            Hide();
            rebornInstance.toggleMenu();
        });
    }

    public void UpdateColors()
    {
        rebornInstance.titleTextView.setShadowLayer(
                12,
                0,
                0,
                rebornInstance.titleTextColor
        );

        rebornInstance.menu.setBackgroundColor(rebornInstance.menuBgColor);

        for (TextView textView : viewList)
        {
            textView.setShadowLayer(
                    12,
                    0,
                    0,
                    rebornInstance.modTextColor
            );
        }
    }

    public void setToggle(String text, Callback callback)
    {
        TextView textView = new TextView(rebornInstance);
        textView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));

        textView.setText(text);
        textView.setTextSize(19);
        textView.setTextColor(0xFFFFFFFF);
        textView.setVisibility(View.GONE);
        textView.setGravity(Gravity.CENTER_HORIZONTAL);
        textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        textView.setShadowLayer(12, 0, 0, rebornInstance.modTextColor);

        textView.setOnClickListener(v ->
        {
            textView.setBackgroundColor(rebornInstance.modHighlightColor);

            new Handler().postDelayed(() ->
            {
                textView.setBackgroundColor(0x00000000);
                callback.OnClick();
                UpdateColors();
            }, 250L);
        });

        rebornInstance.menuList.addView(textView);

        viewList.add(textView);
    }

    public void Hide()
    {
        for (TextView textView : viewList)
        {
            textView.setVisibility(View.GONE);
        }
    }

    public void Show()
    {
        for (TextView textView : viewList)
        {
            textView.setShadowLayer(12, 0, 0, rebornInstance.modTextColor);
            textView.setVisibility(View.VISIBLE);
        }

        activeCategory = this;
    }

    public void Replace(Category category)
    {
        if (activeCategory != this)
        {
            return;
        }

        Hide();
        category.Show();
    }

    public interface Callback
    {
        void OnClick();
    }
}
