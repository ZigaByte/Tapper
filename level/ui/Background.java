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

    public Background(){
        random = new Random();

        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                tiles.add(new Tile(new Vector2f(x * (960 / 4), y * (1600 / 4)), new Vector2f((960 / 4), (1600 / 4)), false));
            }
        }

        for(int i = 0; i < 24; i++){
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
            if (time++ % 60== 0) {
                ArrayList<Tile> toUpdate = new ArrayList<Tile>();

                for(Tile t : tiles){
                    if(t.stage < 3)toUpdate.add(t);
                }
                if(toUpdate.size() > 0){
                    int ran = random.nextInt(toUpdate.size());
                    toUpdate.get(ran).activate();


                }
            }

            if (time % 60 == 30) {
                ArrayList<Tile> toDeactivate = new ArrayList<Tile>();
                for(Tile t : tiles){
                    if(t.stage > 0) toDeactivate.add(t);
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

    public void setAnimated(boolean animated){
        this.animated = animated;
    }
}
