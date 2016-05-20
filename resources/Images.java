package com.zigabyte.tapper.resources;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.zigabyte.tapper.R;


public class Images {
	public static Bitmap logo;

    public static Bitmap button_play;
    public static Bitmap button_mode;
    public static Bitmap button_shop;
    public static Bitmap button_sound;
    public static Bitmap button_scores;

    public static Bitmap button_shield;
    public static Bitmap button_ads;
    public static Bitmap button_diamond;
    public static Bitmap button_heart;
    public static Bitmap button_knife;

    public static Bitmap defeat_bones;
    public static Bitmap defeat_skull;

    public static void init(Context x) {
        button_play = BitmapFactory.decodeResource(x.getResources(), R.drawable.button_play);
        button_mode = BitmapFactory.decodeResource(x.getResources(), R.drawable.button_mode);
        button_shop = BitmapFactory.decodeResource(x.getResources(), R.drawable.button_shop);
        button_sound = BitmapFactory.decodeResource(x.getResources(), R.drawable.button_sound);
        button_scores = BitmapFactory.decodeResource(x.getResources(), R.drawable.button_scores);

        button_shield = BitmapFactory.decodeResource(x.getResources(), R.drawable.button_shield);
        button_ads = BitmapFactory.decodeResource(x.getResources(), R.drawable.button_ads);
        button_diamond = BitmapFactory.decodeResource(x.getResources(), R.drawable.button_diamond);
        button_heart = BitmapFactory.decodeResource(x.getResources(), R.drawable.button_heart);
        button_knife = BitmapFactory.decodeResource(x.getResources(), R.drawable.button_knife);

        defeat_bones = BitmapFactory.decodeResource(x.getResources(), R.drawable.defeat_bones);
        defeat_skull = BitmapFactory.decodeResource(x.getResources(), R.drawable.defeat_skull);
    }
}
