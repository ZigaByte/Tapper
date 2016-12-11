package com.zigabyte.tapper.level.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.zigabyte.tapper.math.animation.Animatable;
import com.zigabyte.tapper.math.animation.AnimationFloatEndable;
import com.zigabyte.tapper.math.animation.AnimationFloatSin;
import com.zigabyte.tapper.math.animation.AnimationFloatSqrt;
import com.zigabyte.tapper.menu.ResultMenu;
import com.zigabyte.tapper.resources.Images;

/**
 * Created by zvene_000 on 19.5.2016.
 */
public class SkullBitmap implements Animatable{

    private ResultMenu resultMenu;

    private Bitmap skull;
    private Bitmap bones;

    private int x = 480;
    private int y = 460;

    private int offset;
    private int offset_sin;
    private int offset_enlarge;
    private int transparent = 0;
    private float scale = 1;

    public SkullBitmap(ResultMenu menu){
        resultMenu = menu;

        skull = Images.defeat_skull;
        bones = Images.defeat_bones;

        // Animation to get the skull on screen
        animations.add(new AnimationFloatSqrt(0, 255, 80) {
            @Override
            public void finish() {
                transparent = 255;
                offset = 0;
                animations.add(new AnimationFloatSin(0, -10, 120) {
                    @Override
                    public void setValue() {
                        offset_sin = (int)animatable;
                    }
                });
            }

            @Override
            public void setValue() {
                offset = 255 - (int)animatable * 1;
                transparent = (int) animatable;
                if(transparent > 255) transparent = 255;
            }
        });
    }

    public void render(Canvas g){
        int size = 700;
        Rect rect = new Rect(-size/2, -size/2, size/2, size/2);
        Paint p = new Paint();
        p.setAlpha(transparent);

        g.translate(x , y - offset - offset_sin + offset_enlarge);
        g.scale(scale, scale);
        g.drawBitmap(skull, null, rect, p);
        g.scale(1/scale, 1/scale);
        g.translate(-x , -y + offset + offset_sin - offset_enlarge);

        g.translate(x , y + offset + offset_sin / 2 + offset_enlarge);
        g.scale(scale, scale);
        g.drawBitmap(bones, null, rect, p);
        g.scale(1/scale, 1/scale);
        g.translate(-x , -y - offset - offset_sin / 2 - offset_enlarge);
    }
}
