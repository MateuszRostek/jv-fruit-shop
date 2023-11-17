package strategy;

import model.FruitTransaction;
import storage.Storage;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction fruitTransaction) {
        Integer quantity = Storage.fruitQuantities.get(fruitTransaction.getFruit());
        Integer newQuantity = quantity - fruitTransaction.getQuantity();
        if (newQuantity < 0) {
            throw new RuntimeException("Balance can't be negative!");
        }
        Storage.fruitQuantities.put(fruitTransaction.getFruit(), newQuantity);
    }
}
