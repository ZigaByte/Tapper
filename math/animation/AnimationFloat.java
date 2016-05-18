package com.zigabyte.tapper.math.animation;

/**
 * Created by Žiga on 27.4.2016.
 */
public abstract class AnimationFloat extends Animation{
    public float animatable;
    public float step;

    public AnimationFloat(float animatable, float step){
        this.animatable = animatable;
        this.step = step;
    }

    @Override
    public void update() {
        animatable += step;
    }
}
