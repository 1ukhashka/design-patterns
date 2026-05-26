package services.delivery;
import javax.inject.Inject;

public class Scooter {
    @Inject public Scooter() {}
    public void drive() { System.out.println("[-] Скутер: заведений, мчимо крізь затори."); }
}