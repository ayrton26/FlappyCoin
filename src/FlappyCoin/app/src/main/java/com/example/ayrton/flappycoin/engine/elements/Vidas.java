package com.example.ayrton.flappycoin.engine.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.ayrton.flappycoin.engine.elements.util.Cores;

/**
 * Created by ayrton on 28/08/17.
 */

public class Vidas {
    private int vidas;
    private int largura;
    private static final int Y = 30;
    private static final int RAIO = 25;
    private static final Paint COR = Cores.getRed();

    public Vidas(){
        vidas = 3;
        largura = 20;
    }

    public void paint(Canvas canvas){
        int i = 1;
        largura = 20;
        while (i <= vidas){
            canvas.drawCircle(largura, Y, RAIO, COR);
            largura = largura + 50;
            i = i + 1;
        }
    }

    public void perderVidas(){
        vidas = vidas -1;
    }
}
