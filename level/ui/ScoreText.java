package com.zigabyte.tapper.level.ui;

import android.graphics.Canvas;

import static com.zigabyte.tapper.Game.game;
import static com.zigabyte.tapper.Game.textPaint;

/**
 * Created by Žiga on 30.4.2016.
 */
public class ScoreText extends Text{

    private int score;

    public void update(){
        score = game.level.score;
    }

    @Override
    public void render(Canvas g) {
        String scoreString = String.format("%04d", score);
        textPaint.setTextSize(425);
        textPaint.setAlpha(game.level.started ? 50 : 0);
        g.drawText(scoreString + "", 480, 1550, textPaint);
    }
}
