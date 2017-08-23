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
import com.example.ayrton.flappycoin.engine.elements.util.Tela;

/**
 * Created by ayrton on 22/08/17.
 */

public class Game extends SurfaceView implements Runnable, View.OnTouchListener{
    private boolean started;
    private SurfaceHolder surfaceHolder;
    private Bitcoin bitcoin;
    private Bitmap background;
    private Tela tela;

    public Game(Context context){
        super(context);
        started = false;
        surfaceHolder = getHolder();
        tela = new Tela(this.getContext());
        bitcoin = new Bitcoin();
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        background = Bitmap.createScaledBitmap(b, b.getWidth(), tela.getAltura(), false);
        setOnTouchListener(this);
    }

    public void start(){
        started = true;
        new Thread(this).start();
    }

    @Override
    public void run(){
        while (started){
            if (!this.surfaceHolder.getSurface().isValid()){
                continue;
            }
            Canvas canvas = this.surfaceHolder.lockCanvas();
            canvas.drawBitmap(background, 0, 0, null);
            bitcoin.paint(canvas);
            bitcoin.queda();

            this.surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    public void end(){

        started = false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent e){
        bitcoin.pular();
        return false;
    }
}
