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
 * Created by ayrton on 24/08/17.
 */

public class Obstaculo {
    private static final int ALTURA_OBSTACULO = 363;
    private static final int LARGURA_OBSTACULO = 65;
    private static final Paint COR = Cores.getGold();
    private int posicao;
    private Tela tela;
    private int posicaoInicial;
    private int altura;
    private static Bitmap sprite;

    public Obstaculo(Tela tela, int posicaoInicial, Context context){
        posicao = posicaoInicial + 50;
        this.posicaoInicial = posicao;
        this.tela = tela;
        altura = tela.getAltura() - ALTURA_OBSTACULO;
        sprite = BitmapFactory.decodeResource(context.getResources(), R.drawable.banqueiro);
        sprite = Bitmap.createScaledBitmap(sprite, 168, 363, false);

    }
    public void paint(Canvas canvas){
        canvas.drawBitmap(sprite, posicao - 50, altura, null);
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


    public void reset() {
        posicao = posicaoInicial;
    }
}
