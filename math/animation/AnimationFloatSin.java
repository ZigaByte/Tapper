package com.zigabyte.tapper.math.animation;

/**
 * Created by zvene_000 on 19.5.2016.
 */
public abstract class AnimationFloatSin extends AnimationFloat{

    public float time;
    private float time_step;

    private float min;
    private float mid;
    private float max;
    private float delta;

    public AnimationFloatSin(float animatable, float delta, int time){
        super(animatable, 0);
        time_step = 360 / time;

        this.delta = delta;
        this.min = animatable - delta;
        this.mid = animatable;
        this.max = animatable + delta;
    }

    public void update(){
        time+= time_step;
        animatable = (float)Math.sin(Math.toRadians(time)) * delta + mid;
    }
}
