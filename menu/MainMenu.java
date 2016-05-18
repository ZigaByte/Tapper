package com.zigabyte.tapper.menu;

import com.zigabyte.tapper.menu.Menu;
import com.zigabyte.tapper.menu.button.Button;
import com.zigabyte.tapper.menu.button.PlayButton;
import com.zigabyte.tapper.menu.button.SettingsButton;

/**
 * Created by Žiga on 29.4.2016.
 */
public class MainMenu extends Menu {

    @Override
    protected void init() {
        buttons.add(new PlayButton());
        //buttons.add(new Button());
        buttons.add(new SettingsButton());
    }
}
