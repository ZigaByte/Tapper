package com.zigabyte.tapper.level.stage;

import android.graphics.Canvas;

import com.zigabyte.tapper.math.animation.Animatable;
import com.zigabyte.tapper.math.animation.AnimationFloatEndable;

import static com.zigabyte.tapper.Game.game;
import static com.zigabyte.tapper.Game.textPaint;

/**
 * Created by Žiga on 30.4.2016.
 */
public class Stage implements Animatable{
    public final int CLICKS_NEEDED;
    public final int STAGE_NUMBER;
    public final int SPAWN_SPEED;

    public int time;
    public int clicks;

    private boolean onPattern = false;
    private boolean ended;

    private Pattern pattern;

    public Stage(int stageNumber, int clicksNeeded, int spawnSpeed){
        CLICKS_NEEDED = clicksNeeded;
        STAGE_NUMBER = stageNumber;
        SPAWN_SPEED = spawnSpeed;

        time = 0;
        clicks = 0;

        pattern = new Pattern(this);
    }

    public void endStage(){
        // Only allow the stage to end once
        if(ended)return;

        ended = true;
        animations.add(new AnimationFloatEndable(0,1,120) {
            @Override
            public void finish() {
                game.level.nextStage();
                animations.remove(this);
            }
            @Override
            public void setValue() {}
        });
    }

    public void activatePatern(){
        onPattern = true;
        pattern.started = true;
    }

    public void endPattern(){
        onPattern = false;
        pattern.ended = true;
    }

    public Pattern getPattern(){
        return pattern;
    }

    public boolean isOnPattern(){
        return onPattern;
    }

    public boolean isEnded(){return ended;}

}
