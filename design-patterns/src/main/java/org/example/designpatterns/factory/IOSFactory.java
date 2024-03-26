package org.example.designpatterns.factory;

import org.example.designpatterns.factory.components.button.Button;
import org.example.designpatterns.factory.components.button.IOSButton;
import org.example.designpatterns.factory.components.dropdown.DropDown;
import org.example.designpatterns.factory.components.dropdown.IOSDropDown;
import org.example.designpatterns.factory.components.menu.IOSMenu;
import org.example.designpatterns.factory.components.menu.Menu;

public class IOSFactory implements UIfactory{

    @Override
    public Menu createMenu() {
        return new IOSMenu();
    }

    @Override
    public Button createButton() {
        return new IOSButton();
    }

    @Override
    public DropDown createDropDown() {
        return new IOSDropDown();
    }
}
