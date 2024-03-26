package org.example.designpatterns.decorator;

public class ChocoScoop implements Icecream{
    private Icecream icecream;

    public ChocoScoop(Icecream icecream){
        this.icecream = icecream;
    }

    @Override
    public String getDescription() {
        return icecream.getDescription()+",Choco Scoop";
    }

    @Override
    public int getCost() {
        return icecream.getCost()+20;
    }
}
