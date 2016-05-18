package com.zigabyte.tapper.math.animation;

import android.util.Log;

/**
 * Created by Žiga on 30.4.2016.
 */
public abstract class AnimationFloatEndable extends  AnimationFloat{

    public float goal;
    public int t;
    public final int time;

    public AnimationFloatEndable(float animatable,  float goal, int time){
        super(animatable, (goal - animatable) / time);
        this.goal = goal;
        this.time = time;
        t = 1;
    }

    @Override
    public void update() {
        if(t++ <= time) {
            animatable += step;
        }else{
            finish();
            animations.remove(this);
        }

        if(animatable >= goal){
            animatable = goal;
        }
    }

    public abstract void finish();
}
