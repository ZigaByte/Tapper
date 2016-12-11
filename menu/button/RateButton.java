package com.zigabyte.tapper.menu.button;

import com.zigabyte.tapper.MyCanvas;
import com.zigabyte.tapper.math.Vector2f;
import com.zigabyte.tapper.menu.Menu;
import com.zigabyte.tapper.resources.Images;

/**
 * Created by zvene_000 on 19.5.2016.
 */
public class RateButton extends MainMenuButtonBottom{

    public RateButton(Menu menu){
        super(menu);
        bitmap = Images.button_rate;
    }

    @Override
    protected void init() {
        size = new Vector2f(SIZE, SIZE);
        pos = new Vector2f(X_OFFSET * 1 + (X_OFFSET - SIZE) / 2 , Y_POS);
    }

    @Override
    public void clicked() {
        MyCanvas.context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                MyCanvas.context.signOut();
            }
        });
    }
}
