package com.zigabyte.tapper.menu;

import com.zigabyte.tapper.menu.Menu;
import com.zigabyte.tapper.menu.button.BackButton;
import com.zigabyte.tapper.menu.button.SettingsButton;

/**
 * Created by Žiga on 29.4.2016.
 */
public class SettingsMenu extends Menu {

    public SettingsMenu(Menu previous){
        super (previous);
    }

    @Override
    protected void init() {
        super.init();
        buttons.add(new BackButton(this));
    }
}
