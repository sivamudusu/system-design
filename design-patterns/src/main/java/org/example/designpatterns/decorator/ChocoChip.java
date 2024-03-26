package org.example.designpatterns.decorator;

public class ChocoChip implements Icecream{

    private Icecream icecream;

    public ChocoChip(Icecream icecream){
        this.icecream = icecream;
    }

    @Override
    public String getDescription() {
        return icecream.getDescription() + ",Choco Chip";
    }

    @Override
    public int getCost() {
        return icecream.getCost()+ 10;
    }
}
