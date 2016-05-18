package com.zigabyte.tapper.math.animation;

import com.zigabyte.tapper.math.Vector2f;

import java.util.Vector;

public abstract class Animation implements Animatable{

    public Vector2f animatable;

    public float step;

   /* public Animation(Vector2f animatable, Vector2f step){
        this.animatable = animatable;
        this.step = step;
    }*/


    public abstract void update();

    public abstract void setValue();

    public static void updateAnimations(){
        for(int i = 0;i < animations.size(); i++){
            animations.get(i).setValue();
            animations.get(i).update();
        }
    }


}
