package com.zigabyte.tapper.menu;

import android.graphics.Canvas;
import android.text.method.BaseKeyListener;

import com.zigabyte.tapper.level.Tile;
import com.zigabyte.tapper.level.ui.Background;
import com.zigabyte.tapper.level.ui.ScoreText;
import com.zigabyte.tapper.level.ui.SkullBitmap;
import com.zigabyte.tapper.menu.button.BackButton;
import com.zigabyte.tapper.menu.button.ContinueButton;
import com.zigabyte.tapper.menu.button.ReplayButton;

import java.util.ArrayList;
import static com.zigabyte.tapper.Game.game;
/**
 * Created by Žiga on 30.4.2016.
 */
public class ResultMenu extends Menu{

    private SkullBitmap skull;
    private ContinueButton continueButton;
    private ReplayButton replayButton;
    private ScoreText scoreText;

    public ResultMenu(ArrayList<Tile> tiles){
        super(null);
        background.populate(tiles);

        // Set animated to false if you want the background tiles
        // to stay as they are, otherwise they start popping and reappearing
        //background.setAnimated(false);

        skull = new SkullBitmap(this);
        continueButton = new ContinueButton(this);
        replayButton = new ReplayButton(this);
        buttons.add(replayButton);
        buttons.add(continueButton);

        scoreText = game.level.getScoreText();
    }

    @Override
    protected void init() {
        super.init();
    }

    public void deactivateButtons(){
        continueButton.deactivate();
        replayButton.deactivate();
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
