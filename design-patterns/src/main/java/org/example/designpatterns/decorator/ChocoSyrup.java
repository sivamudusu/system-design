package org.example.designpatterns.decorator;

public class ChocoSyrup implements Icecream{
    private Icecream icecream;

    public ChocoSyrup(Icecream icecream){
        this.icecream = icecream;
    }

    @Override
    public String getDescription() {
        return icecream.getDescription() + ",Choco Syrup";
    }

    @Override
    public int getCost() {
        return icecream.getCost()+ 15;
    }
}
