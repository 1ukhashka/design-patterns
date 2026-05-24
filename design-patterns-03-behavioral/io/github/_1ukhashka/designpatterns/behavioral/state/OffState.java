package io.github._1ukhashka.designpatterns.behavioral.state;

public class OffState implements PcState {

    @Override
    public void pressPowerButton(PcContext context) {
        System.out.println("Booting up...");
        context.setState(new RunningState());
    }

    @Override
    public void pressSleepButton(PcContext context) {
        System.out.println("PC is off, sleep button ignored.");
    }

    @Override
    public String getStateName() {
        return "OFF";
    }
}
