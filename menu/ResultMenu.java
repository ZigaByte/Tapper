package com.zigabyte.tapper.menu;

import com.zigabyte.tapper.menu.button.BackButton;

/**
 * Created by Žiga on 30.4.2016.
 */
public class ResultMenu extends Menu{
    @Override
    protected void init() {
        buttons.add(new BackButton());
    }
}
