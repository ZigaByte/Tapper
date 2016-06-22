package com.zigabyte.tapper.menu;

import com.zigabyte.tapper.menu.Menu;
import com.zigabyte.tapper.menu.button.Button;
import com.zigabyte.tapper.menu.button.ModeButton;
import com.zigabyte.tapper.menu.button.PlayButton;
import com.zigabyte.tapper.menu.button.ScoreButton;
import com.zigabyte.tapper.menu.button.SettingsButton;
import com.zigabyte.tapper.menu.button.ShopButton;
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
        //buttons.add(new SettingsButton());
        buttons.add(new SoundButton(this));
        buttons.add(new ModeButton(this));
        buttons.add(new ShopButton(this));
        buttons.add(new ScoreButton(this));
    }
}
