package com.zigabyte.tapper.resources;

import android.media.MediaPlayer;

import com.zigabyte.tapper.Game;
import com.zigabyte.tapper.R;

import java.util.ArrayList;

/**
 * Created by Žiga on 30.6.2016.
 */
public class Sound {

    private static ArrayList<Sound> playing = new ArrayList<Sound>();

    public static Sound music = new Sound(R.raw.try12, true);

    private MediaPlayer mp;

    public Sound(int id, boolean looping){
        mp = MediaPlayer.create(Game.game.getContext(), id);
        mp.setLooping(looping);
    }

    public void start(){
        mp.start();
        playing.add(this);
    }

    public void stop(){
        mp.stop();
        playing.remove(this);
    }

    public static void stopAll(){
        while(playing.size() > 0){
            playing.get(0).stop();
        }
    }

}
