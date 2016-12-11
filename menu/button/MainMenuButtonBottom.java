package com.zigabyte.tapper.menu.button;

import com.zigabyte.tapper.math.Vector2f;
import com.zigabyte.tapper.math.animation.AnimationFloatSin;
import com.zigabyte.tapper.menu.Menu;

/**
 * Created by zvene_000 on 19.5.2016.
 */
public class MainMenuButtonBottom extends Button{
    public final int Y_POS = 1320;
    public final int X_OFFSET = 240;

    public final int SIZE = 170;

    public MainMenuButtonBottom(Menu menu){
        super(menu);
        animations.add(new AnimationFloatSin(15, 15, 120) {
            @Override
            public void setValue() {
                offset.y = animatable;
            }
        });
    }
}
