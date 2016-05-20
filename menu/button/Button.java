package com.zigabyte.tapper.menu.button;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

import com.zigabyte.tapper.math.animation.Animatable;
import com.zigabyte.tapper.math.animation.Animation;
import com.zigabyte.tapper.math.animation.AnimationFloat;
import com.zigabyte.tapper.math.animation.AnimationFloatEndable;
import com.zigabyte.tapper.math.animation.AnimationVector;
import com.zigabyte.tapper.math.Vector2f;
import static com.zigabyte.tapper.Game.game;
/**
 * Created by Žiga on 26.4.2016.
 */
public class Button implements Animatable{

    protected Bitmap bitmap;

    public Vector2f pos;
    public Vector2f size;

    protected int alpha = 255;
    protected Vector2f display_pos;
    protected float rotation;
    protected float scale = 1;

    public Button(){
        init();
        display_pos = pos;
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

    public void deactivate(){
        animations.add(new AnimationFloatEndable(255, 40, 60) {
            @Override
            public void finish() {
                alpha = 40;
            }

            @Override
            public void setValue() {
                alpha = (int)animatable;
             }
        });
    }

    public void clicked(){

    }

    public void update(){
    }

    public void translate(Canvas g){
        g.translate(display_pos.x + size.x / 2, display_pos.y + size.y / 2);
        g.rotate(rotation);
        g.scale(scale, scale);
    }

    public void untranslate(Canvas g){
        g.scale(1/scale, 1/scale);
        g.rotate(-rotation);
        g.translate(-(display_pos.x + size.x / 2), -(display_pos.y + size.y / 2));
    }

    public void render(Canvas g){
        translate(g);
        Paint p = new Paint();
        p.setAlpha(alpha);
        if(bitmap == null) {
            g.drawRect(-size.x / 2, -size.y / 2, +size.x / 2, +size.y / 2, p);
        }else {
            Rect rect = new Rect(-(int)size.x / 2, -(int)size.y / 2, (int)size.x / 2, (int)size.y / 2 );
            g.drawBitmap(bitmap, null, rect,  p);
        }
        untranslate(g);
    }
}
