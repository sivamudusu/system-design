package org.example.designpatterns.strategy;

public class Main {
    public static void main(String[] args) {
        GoogleMap googleMap = new GoogleMap();

        googleMap.findPath("delhi","chennai",Mode.WALK);
    }
}
