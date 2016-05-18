package com.zigabyte.tapper.menu.button;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import com.zigabyte.tapper.math.animation.Animatable;
import com.zigabyte.tapper.math.animation.Animation;
import com.zigabyte.tapper.math.animation.AnimationFloat;
import com.zigabyte.tapper.math.animation.AnimationVector;
import com.zigabyte.tapper.math.Vector2f;
import static com.zigabyte.tapper.Game.game;
/**
 * Created by Žiga on 26.4.2016.
 */
public class Button implements Animatable{

    public Vector2f pos;
    public Vector2f size;

    protected Vector2f display_pos;
    protected float rotation;

    public Button(){
        init();
        display_pos = pos;

        /*animations.add(new AnimationVector(pos, new Vector2f(0.1f, 0.1f)) {
            public void update() {
                animatable = animatable.add(step);
                display_pos = animatable;
            }
        });*/
    }

    protected void init(){
        pos = new Vector2f(400, 300);
        size = new Vector2f(100, 100);

        animations.add(new AnimationFloat(rotation, 1) {
            public void setValue() {
                rotation = animatable;
            }
        });
    }

    public void clicked(){

    }

    public void update(){
    }

    public void render(Canvas g){
        g.translate(display_pos.x + size.x / 2, display_pos.y + size.y / 2);
        g.rotate(rotation);
        g.drawRect(- size.x / 2, - size.y / 2,+ size.x / 2,+ size.y / 2 ,  new Paint());
        g.rotate(-rotation);
        g.translate(-(display_pos.x + size.x / 2), -(display_pos.y + size.y / 2));
    }
}
