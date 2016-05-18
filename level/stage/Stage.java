package com.zigabyte.tapper.level.stage;

import android.graphics.Canvas;

import static com.zigabyte.tapper.Game.textPaint;

/**
 * Created by Žiga on 30.4.2016.
 */
public class Stage{
    public final int CLICKS_NEEDED;
    public final int STAGE_NUMBER;
    public final int SPAWN_SPEED;

    public int time;
    public int clicks;

    public Stage(int stageNumber, int clicksNeeded, int spawnSpeed){
        CLICKS_NEEDED = clicksNeeded;
        STAGE_NUMBER = stageNumber;
        SPAWN_SPEED = spawnSpeed;

        time = 0;
        clicks = 0;
    }
}
