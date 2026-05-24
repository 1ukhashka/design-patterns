package io.github._1ukhashka.designpatterns.behavioral.state;

public interface PcState {
    void pressPowerButton(PcContext context);
    void pressSleepButton(PcContext context);
    String getStateName();
}
