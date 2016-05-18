package com.zigabyte.tapper.math.animation;

import android.util.Log;

/**
 * Created by Žiga on 7.5.2016.
 */
public abstract class AnimationFloatSqrt  extends AnimationFloatEndable{

    public float a;


    public AnimationFloatSqrt(float animatable,  float goal, int time){
        super(animatable, goal, time);
        // 1.15 added since the intervals aren't small enough, there would be some loss
        a = (goal - animatable)*1.15f / (float)(Math.sqrt(time));
    }

    @Override
    public void update() {
        if(t <= time) {
            float step = a / (2 * (float) Math.sqrt(t++));
            animatable += step;
        }else{
            finish();
            animations.remove(this);
        }


        if(animatable >= goal){
            animatable = goal;
        }
    }
}
