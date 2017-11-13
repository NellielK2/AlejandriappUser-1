package me.unmsm.alejandriapp.presentacion.widget;

import android.content.Context;
import android.util.AttributeSet;

import me.unmsm.alejandriapp.presentacion.util.FontUtil;


/**
 * Created by KERLY on 03/10/2017.
 */

public class MediumButton extends android.support.v7.widget.AppCompatButton {
    public MediumButton(Context context) {
        super(context);
        init(context);
    }

    public MediumButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MediumButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setTypeface(FontUtil.getMontserratMedium(context));
    }
}
