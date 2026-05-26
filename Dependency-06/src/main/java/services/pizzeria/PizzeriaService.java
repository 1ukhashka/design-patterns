package services.pizzeria;
import services.management.OrderManager;
import services.kitchen.Chef;
import services.delivery.Courier;
import javax.inject.Inject;

public class PizzeriaService {
    private final OrderManager orderManager;
    private final Chef chef;
    private final Courier courier;

    @Inject
    public PizzeriaService(OrderManager orderManager, Chef chef, Courier courier) {
        this.orderManager = orderManager;
        this.chef = chef;
        this.courier = courier;
    }

    public void serveCustomer() {
        System.out.println(">>> НОВЕ ЗАМОВЛЕННЯ <<<");
        orderManager.processOrder();
        chef.cookPizza();
        courier.deliver();
        System.out.println(">>> КЛІЄНТ СИТИЙ І ЩАСЛИВИЙ <<<");
    }
}