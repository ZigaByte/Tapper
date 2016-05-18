package com.zigabyte.tapper.level.ui;

import android.graphics.Canvas;

import static com.zigabyte.tapper.Game.game;
import static com.zigabyte.tapper.Game.textPaint;

/**
 * Created by Žiga on 8.5.2016.
 */
public class StageText extends Text{

    private int stage_number;

    public void update(){
        stage_number = game.level.getStageNumber();
    }

    @Override
    public void render(Canvas g) {
        if(enabled) {
            textPaint.setTextSize(220);
            textPaint.setAlpha(40);
            g.drawText("STAGE " + stage_number, 480, 750, textPaint);
        }
    }
}
