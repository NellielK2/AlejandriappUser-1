package me.unmsm.alejandriapp.presentacion.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import me.unmsm.alejandriapp.presentacion.util.FontUtil;


/**
 * Created by KERLY on 03/10/2017.
 */

public class LigthText extends TextView {
    public LigthText(Context context) {
        super(context);
        init(context);
    }

    public LigthText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LigthText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setTypeface(FontUtil.getMontserratLight(context));
    }
}
