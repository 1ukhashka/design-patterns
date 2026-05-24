package io.github._1ukhashka.designpatterns.behavioral.state;

public class SleepState implements PcState {

    @Override
    public void pressPowerButton(PcContext context) {
        System.out.println("Waking up...");
        context.setState(new RunningState());
    }

    @Override
    public void pressSleepButton(PcContext context) {
        System.out.println("Already sleeping.");
    }

    @Override
    public String getStateName() {
        return "SLEEP";
    }
}
