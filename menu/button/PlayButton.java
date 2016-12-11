package com.zigabyte.tapper.menu.button;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;

import com.zigabyte.tapper.math.Vector2f;
import com.zigabyte.tapper.math.animation.AnimationFloat;
import com.zigabyte.tapper.math.animation.AnimationFloatEndable;
import com.zigabyte.tapper.math.animation.AnimationFloatSin;
import com.zigabyte.tapper.menu.MainMenu;
import com.zigabyte.tapper.menu.Menu;
import com.zigabyte.tapper.resources.Images;

import static com.zigabyte.tapper.Game.game;
import static com.zigabyte.tapper.MyCanvas.SIZE;
/**
 * Created by Žiga on 27.4.2016.
 */
public class PlayButton extends Button{

    private boolean starting = false;

    public PlayButton(Menu menu){
        super(menu);
        animations.add(new AnimationFloatSin(scale, 0.1f, 110) {
            @Override
            public void setValue() {
                scale = animatable;
            }
        });

        bitmap = Images.button_play;

        starting = false;
    }

    @Override
    protected void init() {
        size = new Vector2f(440,440);
        pos = SIZE.div(2).sub(size.div(2));
    }

    @Override
    public void clicked() {
        if(starting)
            return;
        else
            starting = true;

        menu.startGame();
    }
}
