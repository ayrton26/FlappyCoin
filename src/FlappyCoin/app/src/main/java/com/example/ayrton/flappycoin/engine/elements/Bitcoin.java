package com.example.ayrton.flappycoin.engine.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by ayrton on 22/08/17.
 */

public class Bitcoin {
    public void paint(Canvas canvas){
        Paint paint = new Paint();
        paint.setColor(0xFFFF0000);
        canvas.drawCircle(100, 100, 50, paint);
    }
}
