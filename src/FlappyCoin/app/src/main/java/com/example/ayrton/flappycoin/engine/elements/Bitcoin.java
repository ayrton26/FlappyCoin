package com.example.ayrton.flappycoin.engine.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.ayrton.flappycoin.engine.elements.util.Cores;
import com.example.ayrton.flappycoin.engine.elements.util.Tela;

/**
 * Created by ayrton on 22/08/17.
 */

public class Bitcoin {
    private int altura;
    private static final int X = 100;
    private static final int RAIO = 50;
    private static Paint cor = Cores.getBlue();
    private boolean invencivel;
    private int turnosInvencivel;

    public Bitcoin (Tela tela){
        altura = tela.getAltura()/2;
        invencivel = false;
        turnosInvencivel = 0;
    }

    public void paint(Canvas canvas) {
        canvas.drawCircle(X, altura, RAIO, cor);
    }

    public void queda() {
        this.altura += 5;
    }

    public void pular() {
        this.altura -= 150;
    }

    public boolean avaliarColisoes(Obstaculo obstaculo) {
        if (invencivel) {
            turnosInvencivel--;
            if (turnosInvencivel <= 0){
                invencivel = false;
                cor = Cores.getBlue();
            }
            return false;
        }

        if (altura + RAIO >= obstaculo.getAlturaObstaculo()) {
            int fronteiraDireita = X + RAIO;
            int fronteiraEsquerda = X - RAIO;
            if ((fronteiraDireita > obstaculo.getXInicial() && fronteiraDireita < obstaculo.getXFinal()) ||
                    (fronteiraEsquerda > obstaculo.getXInicial() && fronteiraEsquerda < obstaculo.getXFinal())) {
                invencivel = true;
                turnosInvencivel = 40;
                cor = Cores.getGreen();
                return true;
            }
        }
        return false;
    }
}
