package com.zigabyte.tapper.menu.button;

import com.zigabyte.tapper.math.Vector2f;
import com.zigabyte.tapper.math.animation.AnimationFloat;
import com.zigabyte.tapper.menu.Menu;
import com.zigabyte.tapper.menu.SettingsMenu;

import java.util.Set;

import static com.zigabyte.tapper.Game.game;
import static com.zigabyte.tapper.MyCanvas.SIZE;

/**
 * Created by Žiga on 29.4.2016.
 */
public class SettingsButton extends Button{

    public SettingsButton(Menu menu){
        super(menu);
        animations.add(new AnimationFloat(0, 1) {
            @Override
            public void setValue() {
                rotation = animatable;
            }
        });
    }

    @Override
    protected void init() {
        size = new Vector2f(250,250);
        pos = SIZE.div(2).sub(size.div(2)).add(new Vector2f(0, 500));
    }

    @Override
    public void clicked() {
        game.menu = new SettingsMenu(menu);
    }
}
