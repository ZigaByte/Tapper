package com.zigabyte.tapper.level;

import android.graphics.Canvas;
import android.util.Log;

import com.zigabyte.tapper.input.Input;
import com.zigabyte.tapper.level.stage.Pattern;
import com.zigabyte.tapper.level.stage.Stage;
import com.zigabyte.tapper.level.ui.GameOverText;
import com.zigabyte.tapper.level.ui.ScoreText;
import com.zigabyte.tapper.level.ui.StageText;
import com.zigabyte.tapper.math.Vector2f;
import com.zigabyte.tapper.math.animation.Animatable;
import com.zigabyte.tapper.math.animation.Animation;

import java.util.ArrayList;
import java.util.Random;

import static com.zigabyte.tapper.Game.game;
import static com.zigabyte.tapper.Game.textPaint;
/**
 * Created by Žiga on 19.4.2016.
 */
public class Level implements Animatable{

    private final Random random;
    private ArrayList<Tile> tiles = new ArrayList<Tile>();

    private ArrayList<Stage> stages = new ArrayList<Stage>();
    private Stage currentStage;
    private int stage;

    private ScoreText scoreText;
    private StageText stageText;

    public boolean started = false;
    public boolean paused = true;
    public boolean ended = false;

    private int time;
    private int endedTime;

    public int score = 0;

    public Level() {
        random = new Random();

        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                tiles.add(new Tile(new Vector2f(x * (960 / 4), y * (1600 / 4)), new Vector2f((960 / 4), (1600 / 4))));
            }
        }
        stages.add(new Stage(1, 20, 15));
        stages.add(new Stage(2, 20, 12));
        stages.add(new Stage(3, 50, 10));
        stages.add(new Stage(4, 50, 8));
        stages.add(new Stage(5, 50, 6));

        stage = 0;
        currentStage = stages.get(0);

        scoreText = new ScoreText();
        stageText = new StageText();
    }

    public void checkInput(){
        Vector2f input = Input.getInput();
        if (input != null) {
            if(!ended){
                input = input.div(new Vector2f(960 / 4, 1600 / 4));
                Log.e("Input", input.x + " || " + input.y + " ||| " + (4 * input.getXi() + input.getYi()) );

                boolean legal = tiles.get(4 * input.getXi() + input.getYi()).clicked();
                if(legal){
                    score++;
                    currentStage.clicks++;
                }else{
                    endLevel();
                }
            }
        }
    }

    public void activateTiles(){
        currentStage.time++;
        if (time++ % currentStage.SPAWN_SPEED == 0 && started) {

            // Activate a part of the pattern
            if(currentStage.isOnPattern())
                currentStage.getPattern().spawn(tiles);

            // Activate a random one
            else if(!currentStage.isEnded()){
                ArrayList<Tile> toUpdate = new ArrayList<Tile>();
                for (Tile t : tiles) {
                    if (t.stage < 3) toUpdate.add(t);
                }
                if (toUpdate.size() == 0) {
                    endLevel();
                } else {
                    int ran = random.nextInt(toUpdate.size());
                    toUpdate.get(ran).activate();
                }
            }
        }
    }

    public void nextStage(){
        currentStage = stages.get(++stage);
        currentStage.activatePatern();
    }

    public void endLevel(){
        //game.end();
        if(!ended){
            ended = true;
            endedTime = time;
            stageText.setEnabled(false);
            game.end();
        }
    }

    public void update() {
        // Input
        checkInput();

        // Update tiles
        for(Tile t : tiles){
            t.update();
        }

        // Activate new tiles
        activateTiles();

        // Check stages
        if(currentStage.clicks >= currentStage.CLICKS_NEEDED){
            if(stage >= stages.size()){
                // oh well, no more stages
            }else{
                // End the stage with a grace period
                currentStage.endStage();
            }
        }

        // Update other UI
        scoreText.update();
        stageText.update();
    }

    public void render(Canvas g) {
        for (Tile t : tiles) {
            t.render(g);
        }

        stageText.render(g);
        scoreText.render(g);
    }

    public int getStageNumber(){
        return currentStage.STAGE_NUMBER;
    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }

    public ScoreText getScoreText() {
        return scoreText;
    }

}
