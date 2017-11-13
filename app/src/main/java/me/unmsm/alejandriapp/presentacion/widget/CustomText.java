package me.unmsm.alejandriapp.presentacion.widget;
import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by KERLY on 03/10/2017.
 */

public class CustomText extends TextView {
    public CustomText(Context context) {
        super(context);
        init();
    }

    public CustomText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setTextColor(getResources().getColor(R.color.black));
        setTextSize(16);
    }
}