package com.zigabyte.tapper.level;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import com.zigabyte.tapper.Game;
import com.zigabyte.tapper.math.Vector2f;
import com.zigabyte.tapper.math.animation.Animatable;
import com.zigabyte.tapper.math.animation.Animation;
import com.zigabyte.tapper.math.animation.AnimationFloatEndable;
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
    private int transparency = 0;

    public int stage;

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

        transparency = 255;
        /*if(animation)
            animations.add(new AnimationFloatSqrt(0, 255, 40) {
                @Override
                public void setValue() {
                    transparency = (int) animatable;
                }

                @Override
                public void finish() {
                    game.level.started = true;
                    game.level.paused = false;
                }
            });
        else transparency = 255;*/
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

    public void update() {

    }

    public void render(Canvas g) {
        Paint p = new Paint();

        switch (stage) {
            case 0:
                //p.setColor(Colors.GRAY);
                p.setColor(Colors.CLOUD);
                break;
            case 1:
                p.setColor(Colors.YELLOW);
                break;
            case 2:
                p.setColor(Colors.ORANGE);
                break;
            case 3:
                p.setColor(Colors.RED);
                break;
        }

        g.translate(pos.x + size.x / 2, pos.y + size.y / 2);
        g.scale(0.965f * (transparency / 255.0f), 0.975f * (transparency / 255.0f));

        p.setAlpha(transparency);
        g.drawRect(-size.x / 2, -size.y / 2, size.x / 2, size.y / 2, p);

        g.scale(1 / (0.965f * (transparency / 255.0f)), 1 / (0.975f * (transparency / 255.0f)));
        g.translate(-(pos.x + size.x / 2), -(pos.y + size.y / 2));
    }

}
