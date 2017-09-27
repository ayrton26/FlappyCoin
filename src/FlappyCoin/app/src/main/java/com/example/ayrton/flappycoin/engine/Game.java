package com.example.ayrton.flappycoin.engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.example.ayrton.flappycoin.R;
import com.example.ayrton.flappycoin.engine.elements.Bitcoin;
import com.example.ayrton.flappycoin.engine.elements.Obstaculo;
import com.example.ayrton.flappycoin.engine.elements.Pontuacao;
import com.example.ayrton.flappycoin.engine.elements.Score;
import com.example.ayrton.flappycoin.engine.elements.User;
import com.example.ayrton.flappycoin.engine.elements.util.Cores;
import com.example.ayrton.flappycoin.engine.elements.util.Tela;
import com.example.ayrton.flappycoin.engine.net.ScoreDispatcher;
import com.example.ayrton.flappycoin.engine.net.ScoreDispatcherListener;

/**
 * Created by ayrton on 22/08/17.
 */

public class Game extends SurfaceView implements Runnable, View.OnTouchListener, ScoreDispatcherListener{
    private boolean started;
    private SurfaceHolder surfaceHolder;
    private Bitcoin bitcoin;
    private Obstaculo obstaculo;
    private Bitmap background;
    private Tela tela;
    private Pontuacao pontuacao;
    private String sendResult;

    public Game(Context context){
        super(context);
        started = false;
        surfaceHolder = getHolder();
        tela = new Tela(this.getContext());
        bitcoin = new Bitcoin(tela, context);
        obstaculo = new Obstaculo(tela, tela.getLargura(), context);
        pontuacao = new Pontuacao();
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        background = Bitmap.createScaledBitmap(b, b.getWidth(), tela.getAltura(), false);
        setOnTouchListener(this);
        sendResult = "";
    }

    public synchronized String getSendResult() {
        return sendResult;
    }

    public synchronized void setSendResult(String sendResult) {
        this.sendResult = sendResult;
    }

    public void start(){
        started = true;
        reset();
        new Thread(this).start();
    }

    public void reset(){
        pontuacao.reset();
        bitcoin.reset();
        obstaculo.reset();

    }

    @Override
    public void run(){
        while (true){
            if (!this.surfaceHolder.getSurface().isValid()){
                continue;
            }
            Canvas canvas = this.surfaceHolder.lockCanvas();

            canvas.drawBitmap(background, 0, 0, null);
            obstaculo.paint(canvas);
            bitcoin.paint(canvas);
            pontuacao.paint(canvas);

            if (started){
                if (bitcoin.hasLife()){
                    obstaculo.move();
                    bitcoin.queda();
                    if (bitcoin.avaliarMovimento(obstaculo)){
                        pontuacao.acumular();
                    }
                } else {
                    this.enviarPontuacao();
                    this.end();//TODO Exibir ranking
                }
            } else {
                canvas.drawText("Game Over", 200, 300, Cores.getRedText());
                canvas.drawText(this.getSendResult(), 200, 500, Cores.getRedText());
            }

            this.surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    public void end(){
        started = false;
        bitcoin.end();
    }

    @Override
    public boolean onTouch(View v, MotionEvent e){
        if (!started){
            start();
        } else {
            bitcoin.pular();
        }
        return false;
    }

    private void enviarPontuacao(){
        User u = new User(4, "Ayrton", "ayrton@gmail"); //TODO tirar hardcoded
        Score s = new Score(u.getId(), u, pontuacao.getPontos());
        ScoreDispatcher sd = new ScoreDispatcher(this);
        sd.send(s); //TODO feedback de trabalho em segundo plano para usuario
    }

    @Override
    public void notifySuccess() {
        setSendResult("Enviado com Sucesso");
    }

    @Override
    public void notifyError() {
        setSendResult("Score não Enviado");
    }
}
