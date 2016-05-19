package com.zigabyte.tapper.menu.button;

import com.zigabyte.tapper.math.Vector2f;
import com.zigabyte.tapper.resources.Images;

/**
 * Created by zvene_000 on 19.5.2016.
 */
public class ModeButton extends MainMenuButtonBottom{

    public ModeButton(){
        bitmap = Images.button_mode;
    }

    @Override
    protected void init() {
        size = new Vector2f(SIZE, SIZE);
        pos = new Vector2f(X_OFFSET * 1 + (X_OFFSET - SIZE) / 2 , Y_POS);
    }
}
