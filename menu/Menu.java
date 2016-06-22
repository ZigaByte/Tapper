package com.zigabyte.tapper.menu;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.zigabyte.tapper.input.Input;
import com.zigabyte.tapper.level.ui.Background;
import com.zigabyte.tapper.math.Vector2f;
import com.zigabyte.tapper.menu.button.BackButton;
import com.zigabyte.tapper.menu.button.Button;
import com.zigabyte.tapper.menu.button.PlayButton;

import java.util.ArrayList;

/**
 * Created by Žiga on 26.4.2016.
 */
public class Menu {

    protected ArrayList<Button> buttons = new ArrayList<Button>();
    protected Background background;

    protected Menu previous;

    public Menu(Menu previous){
        this.previous = previous;
        init();
    }

    protected void init(){
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

    public Background getBackground() {
        return background;
    }
}
