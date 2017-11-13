package me.unmsm.alejandriapp.presentacion.util;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by KERLY on 03/10/2017.
 */

public class FontUtil {
    public static Typeface getMontserratLight(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "font/Montserrat-Light.otf");
    }

    public static Typeface getMontserratMedium(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "font/Montserrat-Medium.otf");
    }
    public static Typeface getMontserratSemiBold(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "font/Montserrat-SemiBold.otf");
    }
}
