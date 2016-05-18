package com.zigabyte.tapper.math.animation;

import com.zigabyte.tapper.math.Vector2f;

/**
 * Created by Žiga on 27.4.2016.
 */
public abstract class AnimationVector extends Animation{
    public Vector2f animatable;
    public Vector2f step;

    public AnimationVector(Vector2f animatable, Vector2f step){
        this.animatable = animatable;
        this.step = step;
    }

    @Override
    public void update() {
        animatable = animatable.add(step);
    }
}
