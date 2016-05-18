package com.zigabyte.tapper.menu.button;

import android.util.Log;

import com.zigabyte.tapper.math.Vector2f;
import com.zigabyte.tapper.math.animation.AnimationFloat;

import static com.zigabyte.tapper.Game.game;
import static com.zigabyte.tapper.MyCanvas.SIZE;
/**
 * Created by Žiga on 27.4.2016.
 */
public class PlayButton extends Button{

    public PlayButton(){
        animations.add(new AnimationFloat(0, 1) {
            @Override
            public void setValue() {
                rotation = animatable;
            }
        });
    }

    @Override
    protected void init() {
        size = new Vector2f(400,400);
        pos = SIZE.div(2).sub(size.div(2));
    }

    @Override
    public void clicked() {
        game.start();
    }
}
