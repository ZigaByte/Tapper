package com.zigabyte.tapper.level.ui;

import android.graphics.Canvas;

import com.zigabyte.tapper.math.animation.Animatable;

/**
 * Created by Žiga on 30.4.2016.
 */
public abstract class Text implements Animatable{

    protected boolean enabled = true;

    public abstract void render(Canvas g);

    public void setEnabled(boolean enabled){
        this.enabled = enabled;
    }
}
