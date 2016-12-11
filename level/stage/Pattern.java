package com.zigabyte.tapper.level.stage;

import com.zigabyte.tapper.level.Tile;

import java.util.ArrayList;

/**
 * Created by zvene_000 on 20.5.2016.
 */
public class Pattern {

    public int[][] values = {};
    public int[][] values1 = {{3,15},{2,14},{1,13},{0,12},{4,8},{5,9},{6,10},{7,11}};
    public int[][] values2 = {{0},{4},{8},{12},{13},{14},{15},{11},{7},{3},{2},{1},{5},{9},{10},{6},{5},{9},{10},{6},{2},{1},{0},{4},{8},{12},{13},{14},{15},{11},{7},{3}};
    public int[][] values3 = {{0},{1,4},{2,5,8},{2,6,9,12},{7,10,13},{11,14},{15},{12},{8,13},{4,9,14},{0,5,10,15},{1,6,11},{2,7},{3}};

    public int current = 0;

    public boolean ended = false;
    public boolean started = false;

    private Stage stage;

    public Pattern(Stage stage){
        this.stage = stage;

        switch (stage.STAGE_NUMBER){
            case 1: values = values1;break;
            case 2: values = values2;break;
            case 3: values = values3;break;
        }

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
