package com.example.ayrton.flappycoin.engine.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.ayrton.flappycoin.engine.elements.util.Cores;
import com.example.ayrton.flappycoin.engine.elements.util.Tela;

/**
 * Created by ayrton on 24/08/17.
 */

public class Obstaculo {
    private static final int ALTURA_OBSTACULO = 400;
    private static final int LARGURA_OBSTACULO = 100;
    private static final Paint COR = Cores.getGold();
    private int posicao;
    private Tela tela;
    private int posicaoInicial;
    private int altura;
    public Obstaculo(Tela tela, int posicaoInicial){
        posicao = posicaoInicial;
        this.posicaoInicial = posicao;
        this.tela = tela;
        altura = tela.getAltura() - ALTURA_OBSTACULO;
    }
    public void paint(Canvas canvas){
        canvas.drawRect(posicao, altura , posicao + LARGURA_OBSTACULO, tela.getAltura(), COR);
    }

    public void move(){
        this.posicao -= 5;
        if (posicao <= - LARGURA_OBSTACULO){
            posicao = posicaoInicial;
        }
    }

    public int getAlturaObstaculo(){
        return altura;
    }

    public int getXInicial(){
        return posicao;
    }
    public int getXFinal(){
        return posicao + LARGURA_OBSTACULO;
    }


}
