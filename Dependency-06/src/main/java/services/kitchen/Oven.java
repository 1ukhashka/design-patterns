package services.kitchen;
import javax.inject.Inject;

public class Oven {
    @Inject public Oven() {}
    public void bake() { System.out.println("[-] Піч: розігріта до 300°C, піца печеться."); }
}