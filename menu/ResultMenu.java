package com.zigabyte.tapper.menu;

import android.graphics.Canvas;

import com.zigabyte.tapper.level.Tile;
import com.zigabyte.tapper.level.ui.ScoreText;
import com.zigabyte.tapper.level.ui.SkullBitmap;
import com.zigabyte.tapper.menu.button.ButtonBack;
import com.zigabyte.tapper.menu.button.ButtonRetry;

import java.util.ArrayList;
import static com.zigabyte.tapper.Game.game;
/**
 * Created by Žiga on 30.4.2016.
 */
public class ResultMenu extends Menu{

    private SkullBitmap skull;
    private ButtonBack backButton;
    private ButtonRetry retryButton;
    private ScoreText scoreText;

    public ResultMenu(ArrayList<Tile> tiles){
        super(null);
        background.populate(tiles);

        // Set animated to false if you want the background tiles
        // to stay as they are, otherwise they start popping and reappearing
        //background.setAnimated(false);

        skull = new SkullBitmap(this);
        backButton = new ButtonBack(this);
        retryButton = new ButtonRetry(this);
        buttons.add(backButton);
        buttons.add(retryButton);

        scoreText = game.level.getScoreText();
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void render(Canvas g) {
        super.render(g);
        skull.render(g);
        scoreText.render(g);
    }
}
