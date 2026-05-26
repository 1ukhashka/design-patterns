import services.di.DaggerPizzeriaComponent;
import services.di.PizzeriaComponent;
import services.pizzeria.PizzeriaService;

public class MainDependency {
    public static void main(String[] args) {
        // Dagger створює магію тут
        PizzeriaComponent component = DaggerPizzeriaComponent.create();

        // Отримуємо готову піцерію, де всі залежності вже "впорснуті"
        PizzeriaService pizzeria = component.getPizzeriaService();

        // Робимо замовлення
        pizzeria.serveCustomer();
    }
}