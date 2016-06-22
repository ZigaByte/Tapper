package com.zigabyte.tapper.menu.button;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.zigabyte.tapper.math.Vector2f;
import com.zigabyte.tapper.math.animation.AnimationFloatSin;
import com.zigabyte.tapper.menu.MainMenu;
import com.zigabyte.tapper.menu.Menu;
import com.zigabyte.tapper.resources.Images;

import static com.zigabyte.tapper.Game.game;
import static com.zigabyte.tapper.MyCanvas.SIZE;

/**
 * Created by zvene_000 on 19.5.2016.
 */
public class ContinueButton extends Button{

    private Bitmap icon;
    private Bitmap heart;

    public ContinueButton(Menu menu){
        super(menu);
        animations.add(new AnimationFloatSin(scale, 0.05f, 120) {
            @Override
            public void setValue() {
                scale = animatable;
            }
        });

        bitmap = Images.button_shield;
        icon = Images.button_ads;
        heart = Images.button_heart;
    }

    @Override
    protected void init() {
        size = new Vector2f(240, 400);
        pos = SIZE.div(2).sub(size.div(2)).add(new Vector2f(-120,200));
    }

    @Override
    public void clicked() {
        //game.menu = new MainMenu();
    }

    public void render(Canvas g){
        super.render(g);

        Paint p = new Paint();
        p.setAlpha(alpha);

        translate(g);
        Rect rect = new Rect(-(int)size.x / 2, -(int)size.y / 2, (int)size.x / 2, (int)size.y / 2 );
        g.drawBitmap(icon, null, rect,  p);
        g.drawBitmap(heart, null, rect,  p);
        untranslate(g);
    }


}
