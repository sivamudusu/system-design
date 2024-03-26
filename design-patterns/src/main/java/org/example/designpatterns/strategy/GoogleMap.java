package org.example.designpatterns.strategy;

public class GoogleMap {

    public void findPath(String source, String destination,Mode mode){
        PathCalculator pathCalculator = PathCalcFactory.getpathCalculator(mode);

        pathCalculator.findPath(source,destination);

    }
}
