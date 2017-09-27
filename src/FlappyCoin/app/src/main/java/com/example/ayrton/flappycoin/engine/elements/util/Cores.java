package com.example.ayrton.flappycoin.engine.elements.util;

import android.graphics.Paint;
import android.graphics.Typeface;

/**
 * Created by ayrton on 23/08/17.
 */

public class Cores {
    public static Paint getRed(){
        Paint paint = new Paint();
        paint.setColor(0x22FF0000);

        return paint;
    }
    public static Paint getGold(){
        Paint paint = new Paint();
        paint.setColor(0x44FFD700);

        return paint;
    }

    public static Paint getBlue(){
        Paint paint = new Paint();
        paint.setColor(0xFF0000FF);

        return paint;
    }

    public static Paint getGreen(){
        Paint paint = new Paint();
        paint.setColor(0xFF00FF00);

        return paint;
    }

    public static Paint getWhiteText(){
        Paint paint = new Paint();
        paint.setColor(0XFFFFFFFF);
        paint.setTextSize(50);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setShadowLayer(3, 5, 5, 0XFF000000);

        return paint;
    }

    public static Paint getRedText(){
        Paint paint = new Paint();
        paint.setColor(0XFFFF0000);
        paint.setTextSize(80);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setShadowLayer(3, 5, 5, 0XFFFFFFFF);

        return paint;
    }
}
