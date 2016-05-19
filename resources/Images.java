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

    public static Bitmap button_continue;
    public static Bitmap button_replay;

    public static Bitmap defeat_bones;
    public static Bitmap defeat_skull;

    public static void init(Context x) {
        button_play = BitmapFactory.decodeResource(x.getResources(), R.drawable.button_play);
        button_mode = BitmapFactory.decodeResource(x.getResources(), R.drawable.button_mode);
        button_shop = BitmapFactory.decodeResource(x.getResources(), R.drawable.button_shop);
        button_sound = BitmapFactory.decodeResource(x.getResources(), R.drawable.button_sound);
        button_scores = BitmapFactory.decodeResource(x.getResources(), R.drawable.button_scores);

        button_continue = BitmapFactory.decodeResource(x.getResources(), R.drawable.button_continue);
        button_replay = BitmapFactory.decodeResource(x.getResources(), R.drawable.button_replay);

        defeat_bones = BitmapFactory.decodeResource(x.getResources(), R.drawable.defeat_bones);
        defeat_skull = BitmapFactory.decodeResource(x.getResources(), R.drawable.defeat_skull);
    }
}
