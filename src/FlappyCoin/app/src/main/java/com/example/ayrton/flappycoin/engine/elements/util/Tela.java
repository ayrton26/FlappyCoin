package com.example.ayrton.flappycoin.engine.elements.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by ayrton on 23/08/17.
 */

public class Tela {
    private DisplayMetrics displayMetrics;


    public Tela(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display d = wm.getDefaultDisplay();
        this.displayMetrics = new DisplayMetrics();
        d.getMetrics(this.displayMetrics);
    }

    public int getAltura(){
        return this.displayMetrics.heightPixels;
    }
    public int getLargura(){
        return this.displayMetrics.widthPixels;
    }
}
