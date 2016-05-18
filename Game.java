package com.zigabyte.tapper;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.zigabyte.tapper.level.Level;
import com.zigabyte.tapper.math.animation.Animation;
import com.zigabyte.tapper.menu.MainMenu;
import com.zigabyte.tapper.menu.Menu;
import com.zigabyte.tapper.menu.ResultMenu;

import java.util.Random;

public class Game {

    public enum GameState {
        MENU, GAME;
    }

    public static Game game;

    public GameState state;
    public static Paint textPaint;

    public Menu menu;
    public Level level;

    private final Random random;

    private int time = 0;

    public Game() {
        game = this;

        random = new Random();

        state = GameState.MENU;
        menu = new MainMenu();
    }

    public void start() {
        level = new Level();
        menu = null;

        state = GameState.GAME;
    }

    public void end() {
        //level = null;
        state = GameState.MENU;
        menu = new ResultMenu();
    }

    public void update() {
        // Update Animations
        Animation.updateAnimations();

        switch(state){
            case MENU:
                menu.update();
                break;
            case GAME:
                level.update();
                break;
        }
    }


    public void render(Canvas g) {
        switch(state){
            case MENU:
                menu.render(g);
                break;
            case GAME:
                level.render(g);
                break;
        }
    }

}
