package com.zigabyte.tapper.level.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

import com.zigabyte.tapper.math.animation.Animatable;
import com.zigabyte.tapper.math.animation.AnimationFloatSin;
import com.zigabyte.tapper.math.animation.AnimationFloatSqrt;
import com.zigabyte.tapper.resources.Images;

/**
 * Created by zvene_000 on 19.5.2016.
 */
public class SkullBitmap implements Animatable{

    private Bitmap skull;
    private Bitmap bones;

    private int x = 480;
    private int y = 500;

    private int offset;
    private int offset_sin;
    private int transparent = 0;

    public SkullBitmap(){
        skull = Images.defeat_skull;
        bones = Images.defeat_bones;

        animations.add(new AnimationFloatSqrt(0, 255, 80) {
            @Override
            public void finish() {
                transparent = 255;

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
        int size = 560;
        Rect rect = new Rect(-size/2, -size/2, size/2, size/2);
        Paint p = new Paint();
        p.setAlpha(transparent);

        g.translate(x , y - offset - offset_sin);
        g.drawBitmap(skull, null, rect, p);
        g.translate(-x , -y + offset + offset_sin);

        g.translate(x , y + offset + offset_sin / 2);
        g.drawBitmap(bones, null, rect, p);
        g.translate(-x , -y - offset - offset_sin / 2);
    }
}
