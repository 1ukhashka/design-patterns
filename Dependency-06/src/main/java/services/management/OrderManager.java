package services.management;
import javax.inject.Inject;

public class OrderManager {
    @Inject public OrderManager() {}
    public void processOrder() { System.out.println("[-] Менеджер: замовлення прийнято, чек пробито, передано на кухню."); }
}