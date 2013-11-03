package com.blackmoon.nails.util;

import java.lang.reflect.Field;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;

public class UIHelper {

    private static Toast sToast = null;

    public static void showToast(Context context, CharSequence text, int duration) {
        if (sToast == null) {
            sToast = Toast.makeText(context, text, duration);
        } else {
            sToast.setText(text);
        }

        sToast.show();
    }

    public static int getResourceIdForName(String res) {
        int resId = -1;

        Pattern pattern = Pattern.compile("^([\\w.]+R)\\.(\\w+)\\.(\\w+)$");
        Matcher matcher = pattern.matcher(res);
        if (matcher.find()) {
            String className = String.format(Locale.US, "%s$%s", matcher.group(1), matcher.group(2));
            String fieldName = matcher.group(3);
            try {
                Class<?> klass = Class.forName(className);
                Field field = klass.getField(fieldName);
                resId = field.getInt(klass);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return resId;
    }

    public static void showToast(Context context, int resId, int duration) {
        showToast(context, context.getString(resId), duration);
    }

    public static int getStatusbarHeight(Activity context) {
        int height = 0;
        Rect outRect = new Rect();
        context.getWindow().getDecorView().getWindowVisibleDisplayFrame(outRect);
        height = outRect.top;
        return height;
    }

    public static int getScreenWidth(Context context) {
        int width = 0;
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        width = dm.widthPixels;
        return width;
    }

    public static int getScreenHeight(Context context) {
        int height = 0;
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        height = dm.heightPixels;
        return height;
    }

    public static final int getRealScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();

        DisplayMetrics metrics = new DisplayMetrics();
        display.getRealMetrics(metrics);
        int realWidth = metrics.widthPixels;

        return realWidth;
    }
}
