package com.example.ayrton.flappycoin.engine.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.ayrton.flappycoin.R;
import com.example.ayrton.flappycoin.engine.elements.util.Cores;
import com.example.ayrton.flappycoin.engine.elements.util.Tela;

/**
 * Created by ayrton on 22/08/17.
 */

public class Bitcoin {
    private int altura;
    private static final int X = 100;
    private static final int RAIO = 75;
    private static Paint cor = Cores.getBlue();
    private boolean invencivel;
    private int turnosInvencivel;
    private Vidas vidas;
    private static Bitmap bitcoin;
    private static final int fronteiraDireita = X + RAIO;
    private static final int fronteiraEsquerda = X - RAIO;
    private boolean candidatePontuacao;

    public Bitcoin (Tela tela, Context context){
        altura = tela.getAltura()/2;
        invencivel = false;
        candidatePontuacao = false;
        turnosInvencivel = 0;
        vidas = new Vidas(context);
        bitcoin = BitmapFactory.decodeResource(context.getResources(), R.drawable.bitocin);
        bitcoin = Bitmap.createScaledBitmap(bitcoin, 150, 150, false);
    }

    public void paint(Canvas canvas) {
        if (invencivel){
            if ((turnosInvencivel/10) % 2 == 0){
                canvas.drawBitmap(bitcoin, X-75, altura-75, null);

            }
        } else {
            canvas.drawBitmap(bitcoin, X-75, altura-75, null);

        }

        canvas.drawRect(X - 75, altura - 75, X + 75, altura + 75, Cores.getRed());

        vidas.paint(canvas);
    }

    public void queda() {
        this.altura += 5;
    }

    public void pular() {
        this.altura -= 150;
    }

    public boolean avaliarMovimento(Obstaculo obstaculo) {
        if (invencivel) {
            turnosInvencivel--;
            if (turnosInvencivel <= 0){
                invencivel = false;
                cor = Cores.getBlue();
            }
            return false;
        }

        if (altura + RAIO >= obstaculo.getAlturaObstaculo()) {

            if ((fronteiraDireita > obstaculo.getXInicial() && fronteiraDireita < obstaculo.getXFinal()) ||
                    (fronteiraEsquerda > obstaculo.getXInicial() && fronteiraEsquerda < obstaculo.getXFinal())) {
                vidas.perderVidas();
                invencivel = true;
                turnosInvencivel = 40;
                cor = Cores.getGreen();
                candidatePontuacao = false;
                return false;
            }
        } else {
            if (fronteiraDireita >= obstaculo.getXInicial() && fronteiraEsquerda <= obstaculo.getXFinal() && !invencivel){
                candidatePontuacao = true;
            }
            if (fronteiraEsquerda > obstaculo.getXFinal() && candidatePontuacao){
                candidatePontuacao = false;
                return true;
            }
        }
        return false;
    }

    public boolean hasLife(){
        return this.vidas.hasLife();
    }


}
