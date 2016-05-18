package com.zigabyte.tapper.level.ui;

import android.graphics.Canvas;

import com.zigabyte.tapper.math.animation.AnimationFloatSqrt;

import static com.zigabyte.tapper.Game.game;
import static com.zigabyte.tapper.Game.textPaint;

/**
 * Created by Žiga on 8.5.2016.
 */
public class GameOverText extends Text{

    private float scale = 0;

    public GameOverText(){
        enabled = false;
    }

    @Override
    public void render(Canvas g) {
        if(enabled) {
            textPaint.setTextSize(350);
            textPaint.setAlpha(191);

            g.translate(480, 750);
            g.scale(scale, scale);

            g.drawText("Game", 0, 0, textPaint);
            g.drawText("Over", 0, 350, textPaint);

            g.scale(1 / scale, 1 / scale);
            g.translate(-480, -750);

        }
    }

    @Override
    public void setEnabled(boolean enabled) {
        animations.add(new AnimationFloatSqrt(0, 1, 50) {
            @Override
            public void finish() {
                animations.remove(this);
            }

            @Override
            public void setValue() {
                scale = animatable;
            }
        });

        super.setEnabled(enabled);
    }
}
