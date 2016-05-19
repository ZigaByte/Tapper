package com.zigabyte.tapper.menu.button;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;

import com.zigabyte.tapper.math.Vector2f;
import com.zigabyte.tapper.math.animation.AnimationFloat;
import com.zigabyte.tapper.math.animation.AnimationFloatSin;
import com.zigabyte.tapper.resources.Images;

import static com.zigabyte.tapper.Game.game;
import static com.zigabyte.tapper.MyCanvas.SIZE;
/**
 * Created by Žiga on 27.4.2016.
 */
public class PlayButton extends Button{

    public PlayButton(){
        animations.add(new AnimationFloatSin(scale, 0.1f, 120) {
            @Override
            public void setValue() {
                scale = animatable;
            }
        });

        bitmap = Images.button_play;
    }

    @Override
    protected void init() {
        size = new Vector2f(440,440);
        pos = SIZE.div(2).sub(size.div(2));
    }

    @Override
    public void clicked() {
        game.start();
    }
}
