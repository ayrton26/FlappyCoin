package com.example.ayrton.flappycoin.engine.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.ayrton.flappycoin.R;
import com.example.ayrton.flappycoin.engine.elements.util.Cores;

/**
 * Created by ayrton on 28/08/17.
 */

public class Vidas {
    private int vidas;
    private int largura;
    private static Bitmap coracao;

    public Vidas(Context context){
        vidas = 3;
        largura = 20;
        coracao = BitmapFactory.decodeResource(context.getResources(), R.drawable.coracao);
        coracao = Bitmap.createScaledBitmap(coracao, 50, 46, false);
    }

    public void paint(Canvas canvas){
        int i = 1;
        largura = 5;
        while (i <= vidas){
            canvas.drawBitmap(coracao, largura, 5, null);
            largura = largura + 50;
            i = i + 1;
        }
    }

    public void perderVidas(){
        vidas = vidas -1;
    }
}
