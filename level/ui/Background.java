package com.zigabyte.tapper.level.ui;

import android.graphics.Canvas;

import com.zigabyte.tapper.level.Tile;
import com.zigabyte.tapper.math.Vector2f;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by zvene_000 on 19.5.2016.
 */
public class Background {

    private final Random random;
    private ArrayList<Tile> tiles = new ArrayList<Tile>();

    private int time;
    private boolean animated = true;
    private boolean clearing = false; // Clear 1 tile with every update

    private static final int NUMBER_ACTIVATED = 24;

    public Background(){
        random = new Random();

        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                tiles.add(new Tile(new Vector2f(x * (960 / 4), y * (1600 / 4)), new Vector2f((960 / 4), (1600 / 4)), false));
            }
        }

        for(int i = 0; i < 15; i++){
            int ran = random.nextInt(tiles.size());
            tiles.get(ran).activate();
        }
    }

    public void populate(ArrayList<Tile> tiles){
        this.tiles.clear();
        for(Tile t: tiles)
            this.tiles.add(t);
    }

    public void update(){
        if(animated){

            // Activate a random tile
            if (time++ % 60== 0) {
                ArrayList<Tile> toUpdate = new ArrayList<Tile>();

                int sum = 0;
                for(Tile t : tiles){
                    sum += t.stage;
                    if(t.stage < 3)toUpdate.add(t);
                }
                // Don't activate if there are too many, speed up the process
                if(sum > NUMBER_ACTIVATED + 1) {
                    time += 25;
                    return;
                }

                if(toUpdate.size() > 0){
                    int ran = random.nextInt(toUpdate.size());
                    toUpdate.get(ran).activate();
                }
            }

            // Deactivate a random tile
            if (time % 60 == 30 || clearing) {
                ArrayList<Tile> toDeactivate = new ArrayList<Tile>();

                int sum = 0;
                for(Tile t : tiles){
                    sum += t.stage;
                    if(t.stage > 0) toDeactivate.add(t);
                }
                // Don't deactivate if there aren't enough activated
                if(sum < NUMBER_ACTIVATED - 1 && !clearing) {
                    time += 25;
                    return;
                }

                if(toDeactivate.size() > 0){
                    int ran = random.nextInt(toDeactivate.size());
                    toDeactivate.get(ran).clicked();
                }
            }
        }
    }

    public void render(Canvas g){
        for (Tile t : tiles) {
            t.render(g);
        }
    }

    public void removeBlueTile(){
        for (Tile t : tiles){
            if(t.getBlue())t.stopBlue();
        }
    }

    public void setAnimated(boolean animated){
        this.animated = animated;
    }

    public void setClearing(boolean clearing) {
        this.clearing = clearing;
    }
}
