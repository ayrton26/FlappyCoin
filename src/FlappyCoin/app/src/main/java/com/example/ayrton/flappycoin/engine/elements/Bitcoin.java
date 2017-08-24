package com.example.ayrton.flappycoin.engine.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.ayrton.flappycoin.engine.elements.util.Cores;

/**
 * Created by ayrton on 22/08/17.
 */

public class Bitcoin {
    private int altura;
    private static final int X = 100;
    private static final int RAIO = 50;
    private static Paint COR = Cores.getRed();

    public void paint(Canvas canvas) {
        canvas.drawCircle(X, altura, RAIO, COR);
    }

    public void queda() {
        this.altura += 5;
    }

    public void pular() {
        this.altura -= 150;
    }

    public void avaliarColisoes(Obstaculo obstaculo) {
        if (altura + RAIO >= obstaculo.getAlturaObstaculo()) {
            int fronteiraDireita = X + RAIO;
            int fronteiraEsquerda = X - RAIO;
            if ((fronteiraDireita > obstaculo.getXInicial() && fronteiraDireita < obstaculo.getXFinal()) ||
                    (fronteiraEsquerda > obstaculo.getXInicial() && fronteiraEsquerda < obstaculo.getXFinal())) {
                COR = Cores.getBlue();
            }
        }
    }
}
