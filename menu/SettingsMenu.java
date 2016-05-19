package com.zigabyte.tapper.menu;

import com.zigabyte.tapper.menu.Menu;
import com.zigabyte.tapper.menu.button.BackButton;

/**
 * Created by Žiga on 29.4.2016.
 */
public class SettingsMenu extends Menu {
    @Override
    protected void init() {
        super.init();
        buttons.add(new BackButton());
    }
}
