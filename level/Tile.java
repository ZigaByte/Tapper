package com.zigabyte.tapper.level;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import com.zigabyte.tapper.Game;
import com.zigabyte.tapper.math.Vector2f;
import com.zigabyte.tapper.math.animation.Animatable;
import com.zigabyte.tapper.math.animation.Animation;
import com.zigabyte.tapper.math.animation.AnimationFloatEndable;
import com.zigabyte.tapper.math.animation.AnimationFloatSin;
import com.zigabyte.tapper.math.animation.AnimationFloatSqrt;
import com.zigabyte.tapper.resources.Colors;

import java.util.ArrayList;
import static com.zigabyte.tapper.Game.game;
/**
 * Created by Žiga on 19.4.2016.
 */
public class Tile implements Animatable{
    //public ArrayList<Animation> animations = new ArrayList<Animation>();

    public Vector2f pos;
    public Vector2f size;

    public int stage;

    // Blue - it was clicked by mistake
    private boolean blue = false;
    private int blueSaturation = 0;
    private Animation flashing;

    public Tile() {
        this(new Vector2f(), new Vector2f());
    }

    public Tile(Vector2f pos, Vector2f size) {
        this(pos, size, false);
    }

    public Tile(Vector2f pos, Vector2f size, boolean animation) {
        this.pos = pos;
        this.size = size;

        stage = 0;
    }

    public boolean clicked() {
        if (stage == 0) return false;
        stage--;
        return true;
    }

    public void activate() {
        if (stage == 3) return;
        stage++;
    }

    public void flashBlue(){
        blue = true;
        stage = 4;

        // Saturation for the blue
        flashing = new AnimationFloatSin(0.5f, 0.5f, 60) {
            @Override
            public void setValue() {
                blueSaturation = (int)(255 * animatable);
            }
        };
        animations.add(flashing);
/*
        animations.add(new AnimationFloatEndable(0,1,120) {
            @Override
            public void finish() {
                Game.game.level.endLevel();
                stopFlashing();
            }
            @Override
            public void setValue() {}
        });*/
    }

    public void stopFlashing(){
        stage = 4;
        animations.remove(flashing);
        flashing = null;
        blueSaturation = 255;
    }

    public void update() {

    }

    public void render(Canvas g) {
        Paint p = new Paint();

        switch (stage) {
            case 1:
                p.setColor(Colors.YELLOW);
                break;
            case 2:
                p.setColor(Colors.ORANGE);
                break;
            case 3:
                p.setColor(Colors.RED);
                break;

            // Set to CLOUD if it-s
            default:
                p.setColor(Colors.CLOUD);
        }
        if(blue)
            p.setColor(Colors.CLOUD);

        g.translate(pos.x + size.x / 2, pos.y + size.y / 2);
        g.scale(0.965f, 0.975f );

        g.drawRect(-size.x / 2, -size.y / 2, size.x / 2, size.y / 2, p);

        // Draw the blue on top
        if(blue) {
            p.setColor(Colors.BLUE);
            p.setAlpha(blueSaturation);
            g.drawRect(-size.x / 2, -size.y / 2, size.x / 2, size.y / 2, p);
        }

        g.scale(1 / 0.965f, 1 / 0.975f);
        g.translate(-(pos.x + size.x / 2), -(pos.y + size.y / 2));
    }

    public void stopBlue(){
        this.blue = false;
        stage = 3;
    }

    public boolean getBlue() {
        return blue;
    }
}
