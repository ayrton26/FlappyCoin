package com.example.ayrton.flappycoin.engine.elements;

import android.graphics.Canvas;

import com.example.ayrton.flappycoin.engine.elements.util.Cores;

/**
 * Created by ayrton on 05/09/17.
 */

public class Pontuacao {
    private int fib1;
    private int fib2;

    public  Pontuacao (){
        fib1 = 0;
        fib2 = 1;
    }

    public void acumular(){
        int temp = fib2;
        fib2 = fib1 + fib2;
        fib1 = temp;
    }

    public void paint(Canvas canvas){
        canvas.drawText("" + fib2, 200, 50, Cores.getWhiteText());
    }

    public int getPontos(){
        return fib2;
    }
}
