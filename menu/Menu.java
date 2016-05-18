package com.zigabyte.tapper.menu;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.zigabyte.tapper.input.Input;
import com.zigabyte.tapper.math.Vector2f;
import com.zigabyte.tapper.menu.button.Button;
import com.zigabyte.tapper.menu.button.PlayButton;

import java.util.ArrayList;

/**
 * Created by Žiga on 26.4.2016.
 */
public class Menu {

    protected ArrayList<Button> buttons = new ArrayList<Button>();

    public Menu(){
        init();
    }

    protected void init(){

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
    }

    public void render(Canvas g){
        for(Button b : buttons){
            b.render(g);
        }
    }
}
