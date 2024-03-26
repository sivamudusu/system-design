package org.example.designpatterns.decorator;

public class VanillaScoop implements Icecream{
    private Icecream icecream;

    public VanillaScoop(Icecream icecream){
        this.icecream = icecream;
    }

    @Override
    public String getDescription() {
        return icecream.getDescription()+",Vanilla Scoop";
    }

    @Override
    public int getCost() {
        return icecream.getCost()+35;
    }
}
