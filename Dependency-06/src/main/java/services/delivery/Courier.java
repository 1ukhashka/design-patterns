package services.delivery;
import javax.inject.Inject;

public class Courier {
    private final Scooter scooter;

    @Inject
    public Courier(Scooter scooter) {
        this.scooter = scooter;
    }

    public void deliver() {
        System.out.println("[Кур'єр] Забираю коробку...");
        scooter.drive();
        System.out.println("[Кур'єр] Піцу успішно доставлено клієнту! Отримано чайові.");
    }
}