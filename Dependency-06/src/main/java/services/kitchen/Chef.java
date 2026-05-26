package services.kitchen;
import javax.inject.Inject;

public class Chef {
    private final DoughMixer mixer;
    private final Oven oven;

    @Inject
    public Chef(DoughMixer mixer, Oven oven) {
        this.mixer = mixer;
        this.oven = oven;
    }

    public void cookPizza() {
        System.out.println("[Кухар] Починаю готувати піцу...");
        mixer.mix();
        oven.bake();
        System.out.println("[Кухар] Маргарита готова, пахне неймовірно!");
    }
}