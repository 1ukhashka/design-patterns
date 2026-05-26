package services.kitchen;
import javax.inject.Inject;

public class DoughMixer {
    @Inject public DoughMixer() {}
    public void mix() { System.out.println("[-] Тістоміс: ідеальне тісто замішано."); }
}