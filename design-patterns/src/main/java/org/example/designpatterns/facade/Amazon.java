package org.example.designpatterns.facade;

public class Amazon {
    private InventoryHelper inventoryHelper;
    private ShipTrackHelper shipTrackHelper;

    public void placeOrder(){
        inventoryHelper.checkStockAndUpdate();
        shipTrackHelper.shipTrackOrder();

    }

}
