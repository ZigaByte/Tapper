package com.zigabyte.tapper.menu;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.zigabyte.tapper.input.Input;
import com.zigabyte.tapper.level.ui.Background;
import com.zigabyte.tapper.math.Vector2f;
import com.zigabyte.tapper.math.animation.Animatable;
import com.zigabyte.tapper.math.animation.AnimationFloatEndable;
import com.zigabyte.tapper.menu.button.BackButton;
import com.zigabyte.tapper.menu.button.Button;
import com.zigabyte.tapper.menu.button.PlayButton;

import java.util.ArrayList;

import static com.zigabyte.tapper.Game.game;

/**
 * Created by Žiga on 26.4.2016.
 */
public class Menu implements Animatable{

    protected ArrayList<Button> buttons = new ArrayList<Button>();
    protected Background background;

    protected Menu previous;

    private boolean startingGame;

    public Menu(Menu previous){
        this.previous = previous;
        init();
    }

    protected void init(){
        startingGame = false;

        if(previous != null)
            background = previous.getBackground();
        else background = new Background();
    }

    public void checkInput(){
        Vector2f input = Input.getInput();
        if(input != null){
            for(Button b : buttons){
                if(input.isInside(b.pos.x, b.pos.y, b.pos.x + b.size.x, b.pos.y + b.size.y)){
                    b.clicked();
                    break;
                }
            }
        }
    }

    public void update(){
        checkInput();

        for(Button b : buttons){
            b.update();
        }
        background.update();
    }

    public void render(Canvas g){
        background.render(g);
        for(Button b : buttons){
            b.render(g);
        }
    }

    public void setScaleToAllButtons(float scale){
        if(scale < 0) scale = 0;
        for(Button b : buttons){
            b.setScale(scale);
        }
    }

    public void setAlphaToAllButtons(int alpha){
        if(alpha < 0)alpha = 0;
        else if(alpha > 255)alpha = 255;
        for(Button b : buttons){
            b.setAlpha(alpha);
        }
    }

    /**
     * Sets up all the animations and background and starts the game
     * */
    public void startGame(){

        // Make sure this doesn't trigger twice
        if(startingGame)
            return;
        else
            startingGame = true;

        // Start clearing the background
        this.getBackground().setClearing(true);

        final Menu menu = this;
        // Set scale to all menu items
        animations.add(new AnimationFloatEndable(1, -0.25f, 30) {
            @Override
            public void finish() {
                game.start();
            }

            @Override
            public void setValue() {
                menu.setScaleToAllButtons(animatable);
                menu.setAlphaToAllButtons((int)(255 * animatable));
            }
        });
    }

    public Background getBackground() {
        return background;
    }
}
