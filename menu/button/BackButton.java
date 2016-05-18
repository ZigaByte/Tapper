package com.zigabyte.tapper.menu.button;

import com.zigabyte.tapper.math.Vector2f;
import com.zigabyte.tapper.menu.MainMenu;
import com.zigabyte.tapper.menu.Menu;

import static com.zigabyte.tapper.Game.game;
import static com.zigabyte.tapper.MyCanvas.SIZE;

/**
 * Created by Žiga on 29.4.2016.
 */
public class BackButton extends Button{

    @Override
    protected void init() {
        size = new Vector2f(200, 200);
        pos = new Vector2f(100, 100);
    }

    @Override
    public void clicked() {
        game.menu = new MainMenu();
    }
}
