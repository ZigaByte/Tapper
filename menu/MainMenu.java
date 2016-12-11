package com.zigabyte.tapper.menu;

import com.zigabyte.tapper.menu.button.AchievementsButton;
import com.zigabyte.tapper.menu.button.PlayButton;
import com.zigabyte.tapper.menu.button.RateButton;
import com.zigabyte.tapper.menu.button.ScoreButton;
import com.zigabyte.tapper.menu.button.SoundButton;

/**
 * Created by Žiga on 29.4.2016.
 */
public class MainMenu extends Menu {

    public MainMenu(Menu previous){
        super(previous);
    }

    @Override
    protected void init() {
        super.init();
        buttons.add(new PlayButton(this));

        buttons.add(new SoundButton(this));
        buttons.add(new RateButton(this));
        buttons.add(new AchievementsButton(this));
        buttons.add(new ScoreButton(this));

        background.removeBlueTile();
    }
}
