package com.zigabyte.tapper.level.stage;

import com.zigabyte.tapper.level.Tile;

import java.util.ArrayList;

/**
 * Created by zvene_000 on 20.5.2016.
 */
public class Pattern {

    public int[][] values = {{0,0,0},{1,5,9},{2},{3},{4},{5},{6,7},{7,6},{8},{9},{10},{11},{12},{13},{14},{15}};

    public int current = 0;

    public boolean ended = false;
    public boolean started = false;

    private Stage stage;

    public Pattern(Stage stage){
        this.stage = stage;
    }

    public void spawn(ArrayList<Tile> tiles){
        if(current >= values.length){
            stage.endPattern();
            return;
        }
        for(int i = 0; i < values[current].length; i++) {
            tiles.get(values[current][i]).activate();
        }
        current++;

    }

}
