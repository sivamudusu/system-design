package org.example.designpatterns.factory;

import org.example.designpatterns.factory.components.button.Button;
import org.example.designpatterns.factory.components.button.WindowsButton;
import org.example.designpatterns.factory.components.dropdown.DropDown;
import org.example.designpatterns.factory.components.dropdown.WindowsDropDown;
import org.example.designpatterns.factory.components.menu.Menu;
import org.example.designpatterns.factory.components.menu.WindowsMenu;

public class WindowsFactory implements UIfactory{

    @Override
    public Menu createMenu() {
        return new WindowsMenu();
    }

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public DropDown createDropDown() {
        return new WindowsDropDown();
    }
}
