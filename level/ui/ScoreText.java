package com.zigabyte.tapper.level.ui;

import android.graphics.Canvas;

import com.zigabyte.tapper.math.animation.AnimationFloatSqrt;

import static com.zigabyte.tapper.Game.game;
import static com.zigabyte.tapper.Game.textPaint;

/**
 * Created by Žiga on 30.4.2016.
 */
public class ScoreText extends Text{

    private int score;

    public ScoreText(){

        alpha = 0;
        animations.add(new AnimationFloatSqrt(0,40,30) {
            @Override
            public void finish() {}

            @Override
            public void setValue() {
                setAlpha((int)animatable);
            }
        });
    }

    public void update(){
        score = game.level.score;
    }

    @Override
    public void render(Canvas g) {
        String scoreString = String.format("%04d", score);
        textPaint.setTextSize(425);
        textPaint.setAlpha(alpha);
        g.drawText(scoreString + "", 480, 1550, textPaint);
    }
}
