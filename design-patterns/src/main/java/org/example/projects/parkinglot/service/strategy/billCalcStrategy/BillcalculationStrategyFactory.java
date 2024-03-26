package org.example.projects.parkinglot.service.strategy.billCalcStrategy;

public class BillcalculationStrategyFactory {

    public static BillCalculationStrategy getbillCalculationStrategy(){
        return new SimpleBillCalculationStrategy();
    }
}
