package com.example.ayrton.flappycoin.engine.elements.util;

import android.graphics.Paint;

/**
 * Created by ayrton on 23/08/17.
 */

public class Cores {
    public static Paint getRed(){
        Paint paint = new Paint();
        paint.setColor(0xFFFF0000);

        return paint;
    }
    public static Paint getGold(){
        Paint paint = new Paint();
        paint.setColor(0xFFFFD700);

        return paint;
    }

    public static Paint getBlue(){
        Paint paint = new Paint();
        paint.setColor(0xFF0000FF);

        return paint;
    }
}
