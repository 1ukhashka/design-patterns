package io.github._1ukhashka.designpatterns.behavioral.state;

public class RunningState implements PcState {

    @Override
    public void pressPowerButton(PcContext context) {
        System.out.println("Shutting down...");
        context.setState(new OffState());
    }

    @Override
    public void pressSleepButton(PcContext context) {
        System.out.println("Going to sleep...");
        context.setState(new SleepState());
    }

    @Override
    public String getStateName() {
        return "RUNNING";
    }
}
