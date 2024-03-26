package org.example.designpatterns.factory;

import org.example.designpatterns.factory.components.button.AndroidButton;
import org.example.designpatterns.factory.components.button.Button;
import org.example.designpatterns.factory.components.dropdown.AndroidDropDown;
import org.example.designpatterns.factory.components.dropdown.DropDown;
import org.example.designpatterns.factory.components.menu.Menu;
import org.example.designpatterns.factory.components.menu.WindowsMenu;

public class AndroidFactory implements UIfactory{
    @Override
    public Menu createMenu() {
        return new WindowsMenu();
    }

    @Override
    public Button createButton() {
        return new AndroidButton();
    }

    @Override
    public DropDown createDropDown() {
        return new AndroidDropDown();
    }

}
