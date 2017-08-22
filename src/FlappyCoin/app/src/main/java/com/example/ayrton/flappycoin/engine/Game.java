package com.example.ayrton.flappycoin.engine;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.ayrton.flappycoin.engine.elements.Bitcoin;

/**
 * Created by ayrton on 22/08/17.
 */

public class Game extends SurfaceView implements Runnable{
    private boolean started;
    private SurfaceHolder surfaceHolder;
    private Bitcoin bitcoin;
    public Game(Context context){
        super(context);
        started = false;
        surfaceHolder = getHolder();
        bitcoin = new Bitcoin();
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
            bitcoin.paint(canvas);


            this.surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    public void end(){

        started = false;
    }
}
