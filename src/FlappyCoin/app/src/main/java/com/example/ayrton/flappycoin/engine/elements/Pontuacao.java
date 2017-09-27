package com.example.ayrton.flappycoin.engine.elements;

import android.graphics.Canvas;

import com.example.ayrton.flappycoin.engine.elements.util.Cores;

/**
 * Created by ayrton on 05/09/17.
 */

public class Pontuacao {
    private int pontos;

    public  Pontuacao (){
        pontos = 0;
    }

    public void acumular(){
        pontos++;
    }

    public void paint(Canvas canvas){
        canvas.drawText("" + pontos, 200, 50, Cores.getWhiteText());
    }

    public int getPontos(){
        return pontos;
    }

    public void reset() {
        pontos = 0;
    }
}
