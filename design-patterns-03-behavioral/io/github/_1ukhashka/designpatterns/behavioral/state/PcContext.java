package io.github._1ukhashka.designpatterns.behavioral.state;

public class PcContext {

    private PcState state;

    public PcContext() {
        this.state = new OffState();
    }

    public void setState(PcState state) {
        System.out.println("PC state: " + this.state.getStateName() + " -> " + state.getStateName());
        this.state = state;
    }

    public void pressPowerButton() {
        state.pressPowerButton(this);
    }

    public void pressSleepButton() {
        state.pressSleepButton(this);
    }
}
