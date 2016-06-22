package com.zigabyte.tapper.level.ui;

import android.graphics.Canvas;
import android.util.Log;

import com.zigabyte.tapper.math.animation.AnimationFloatEndable;
import com.zigabyte.tapper.math.animation.AnimationFloatSqrt;

import static com.zigabyte.tapper.Game.game;
import static com.zigabyte.tapper.Game.textPaint;

/**
 * Created by Žiga on 8.5.2016.
 */
public class StageText extends Text{

    private int stage_number;

    public StageText(){

        alpha = 0;
        animations.add(new AnimationFloatSqrt(0,40,30) {
            @Override
            public void finish() {
                game.level.started = true;
                game.level.paused = false;
            }

            @Override
            public void setValue() {
                setAlpha((int)animatable);
            }
        });
    }

    public void update(){
        stage_number = game.level.getStageNumber();
    }

    @Override
    public void render(Canvas g) {
        if(enabled) {
            textPaint.setTextSize(220);
            textPaint.setAlpha(alpha);
            g.drawText("STAGE " + stage_number, 480, 750, textPaint);
        }
    }
}
