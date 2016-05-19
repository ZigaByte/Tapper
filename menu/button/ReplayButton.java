package com.zigabyte.tapper.menu.button;

import com.zigabyte.tapper.math.Vector2f;
import com.zigabyte.tapper.math.animation.AnimationFloatSin;
import com.zigabyte.tapper.menu.MainMenu;
import com.zigabyte.tapper.resources.Images;

import static com.zigabyte.tapper.Game.game;
import static com.zigabyte.tapper.MyCanvas.SIZE;

/**
 * Created by zvene_000 on 19.5.2016.
 */
public class ReplayButton extends Button{


    public ReplayButton(){
        animations.add(new AnimationFloatSin(scale, 0.1f, 120) {
            @Override
            public void setValue() {
                scale = animatable;
            }
        });

        bitmap = Images.button_replay;
    }

    @Override
    protected void init() {
        size = new Vector2f(440,200);
        pos = SIZE.div(2).sub(size.div(2)).add(new Vector2f(0,300));
    }

    @Override
    public void clicked() {
        game.menu = new MainMenu();
    }
}
