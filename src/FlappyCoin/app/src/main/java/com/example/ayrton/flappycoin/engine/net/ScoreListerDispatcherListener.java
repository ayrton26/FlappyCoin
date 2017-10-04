package com.example.ayrton.flappycoin.engine.net;

import com.example.ayrton.flappycoin.engine.elements.Score;

import java.util.ArrayList;

/**
 * Created by ayrton on 04/10/17.
 */

public interface ScoreListerDispatcherListener {
    public void notifyListerSuccess(ArrayList<Score> result);

    public void notifyListerError();
}
