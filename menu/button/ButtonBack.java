package com.zigabyte.tapper.menu.button;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.zigabyte.tapper.math.Vector2f;
import com.zigabyte.tapper.math.animation.AnimationFloatSin;
import com.zigabyte.tapper.menu.MainMenu;
import com.zigabyte.tapper.menu.Menu;
import com.zigabyte.tapper.resources.Images;

import java.util.ArrayList;

import static com.zigabyte.tapper.Game.game;
import static com.zigabyte.tapper.MyCanvas.SIZE;

/**
 * Created by zvene_000 on 19.5.2016.
 */
public class ButtonBack extends Button{

    public ButtonBack(Menu menu){
        super(menu);
        animations.add(new AnimationFloatSin(scale, 0.05f, 120) {
            @Override
            public void setValue() {
                scale = animatable-0.1f;
            }
        });

        bitmap = Images.button_back;
    }

    @Override
    protected void init() {
        size = new Vector2f(240, 400);
        pos = SIZE.div(2).sub(size.div(2)).add(new Vector2f(-120, 200));
    }

    @Override
    public void clicked() {
        game.menu = new MainMenu(menu);
    }
}
