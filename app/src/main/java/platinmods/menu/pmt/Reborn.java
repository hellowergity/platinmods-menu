package platinmods.menu.pmt;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.IBinder;
import android.util.Base64;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class Reborn extends Service
{
    public static final int COLOR_RED = 0;
    public static final int COLOR_GREEN = 1;
    public static final int COLOR_BLUE = 2;
    public static final int COLOR_YELLOW = 3;
    public static final int COLOR_ORANGE = 4;
    public static final int COLOR_PINK = 5;
    public static final int COLOR_PURPLE = 6;
    public static final int COLOR_BLACK = 7;

    public static final int[] textColors = {
            0xFFFF0000, // COLOR_RED
            0xFF00FF00, // COLOR_GREEN
            0xFF0000FF, // COLOR_BLUE
            0xFFFFFF00, // COLOR_YELLOW
            0xFFFF7700, // COLOR_ORANGE
            0xFFFFC0CB, // COLOR_PINK
            0xFFFF00FF, // COLOR_PURPLE
            0xFF000000  // COLOR_BLACK
    };

    public static final int[] menuColors = {
            0x99250000, // COLOR_RED
            0x99002500, // COLOR_GREEN
            0x99000025, // COLOR_BLUE
            0x99252500, // COLOR_YELLOW
            0x99251200, // COLOR_ORANGE
            0x99251819, // COLOR_PINK
            0x99250025, // COLOR_PURPLE
            0x99000000  // COLOR_BLACK
    };

    private static final int ICON_SIZE = 175;

    private WindowManager wm;

    private int width;
    private int height;

    public int titleTextColor;
    public int modTextColor;
    public int modHighlightColor;
    public int menuBgColor;

    private WindowManager.LayoutParams iconOverlayParam;
    private RelativeLayout icon;

    public LinearLayout menuList;
    public RelativeLayout menu;

    public TextView titleTextView;

    private void Initialize()
    {
        titleTextColor = textColors[COLOR_RED];
        modTextColor = textColors[COLOR_RED];
        modHighlightColor = textColors[COLOR_RED];
        menuBgColor = menuColors[COLOR_RED];
    }

    private int getWindowType()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            return WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        }
        else
        {
            return WindowManager.LayoutParams.TYPE_PHONE;
        }
    }

    private void initIcon()
    {
        iconOverlayParam = new WindowManager.LayoutParams(
                ICON_SIZE, ICON_SIZE,
                getWindowType(),
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT
        );

        iconOverlayParam.gravity = Gravity.TOP | Gravity.START;

        icon = new RelativeLayout(this);
        icon.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));

        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));

        icon.addView(imageView);

        try
        {
            byte[] decode = Base64.decode(SetupActivity.image, Base64.DEFAULT);
            imageView.setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
        }
        catch (Exception exception)
        {
            Toast.makeText(this, exception.getMessage(), Toast.LENGTH_LONG).show();
        }

        wm.addView(icon, iconOverlayParam);
    }

    private void initMenu()
    {
        ScrollView scrollView = new ScrollView(this);
        scrollView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));

        menuList = new LinearLayout(this);
        menuList.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));

        menuList.setOrientation(LinearLayout.VERTICAL);
        scrollView.addView(menuList);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
        layoutParams.setMargins(0, 180, 0, 180);

        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.addView(scrollView);

        menu = new RelativeLayout(this);
        menu.setLayoutParams(new RelativeLayout.LayoutParams(
                width,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));

        menu.setVisibility(View.GONE);
        menu.setBackgroundColor(menuBgColor);
        menu.addView(relativeLayout);

        int size = width / 3;
        int position = (int) ((float) size / 2.0f * 1.5f);

        WindowManager.LayoutParams wmParams = new WindowManager.LayoutParams(
                size, height,
                getWindowType(),
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT
        );
        wmParams.x = position;

        wm.addView(menu, wmParams);
    }

    private void createWindowParams()
    {
        initIcon();
        initMenu();
    }

    public void toggleMenu()
    {
        menu.setVisibility(View.GONE);
        icon.setVisibility(View.VISIBLE);

        CategoriesHolder.mainView.Show();
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onCreate()
    {
        super.onCreate();

        Initialize();

        wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        width = wm.getDefaultDisplay().getWidth();
        height = wm.getDefaultDisplay().getHeight();

        createWindowParams();

        icon.setOnTouchListener(new View.OnTouchListener()
        {
            private float initialTouchX;
            private float initialTouchY;
            private int initialX;
            private int initialY;

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent)
            {
                switch (motionEvent.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        initialX = iconOverlayParam.x;
                        initialY = iconOverlayParam.y;

                        initialTouchX = motionEvent.getRawX();
                        initialTouchY = motionEvent.getRawY();
                        return true;

                    case MotionEvent.ACTION_UP:
                        int rawX = (int) (motionEvent.getRawX() - initialTouchX);
                        int rawY = (int) (motionEvent.getRawY() - initialTouchY);

                        if (rawX < 10 && rawY < 10)
                        {
                            menu.setVisibility(View.VISIBLE);
                            icon.setVisibility(View.GONE);
                        }

                        return true;

                    case MotionEvent.ACTION_MOVE:
                        iconOverlayParam.x = initialX + ((int) (motionEvent.getRawX() - initialTouchX));
                        iconOverlayParam.y = initialY + ((int) (motionEvent.getRawY() - initialTouchY));
                        wm.updateViewLayout(icon, iconOverlayParam);
                        return true;

                    default:
                        return false;
                }
            }
        });

        titleTextView = new TextView(this);
        titleTextView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));

        titleTextView.setTextSize(23);
        titleTextView.setTextColor(0xFFFFFFFF);
        titleTextView.setGravity(Gravity.CENTER_HORIZONTAL);
        titleTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        menu.addView(titleTextView);

        CategoriesHolder.CreateViews(this);
    }

    @Override
    public void onTaskRemoved(Intent rootIntent)
    {
        stopSelf();

        try {
            Thread.sleep(100);
        } catch (Exception ignored) {}

        super.onTaskRemoved(rootIntent);
    }

    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }

    @Override
    public void onDestroy()
    {
        if (icon != null)
        {
            wm.removeView(icon);
        }

        if (menu != null)
        {
            wm.removeView(menu);
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_NOT_STICKY;
    }
}