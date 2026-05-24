package io.github._1ukhashka.designpatterns.behavioral.memento;

public class BiosMemento {

    private final int fanSpeed;
    private final boolean overclockEnabled;

    public BiosMemento(int fanSpeed, boolean overclockEnabled) {
        this.fanSpeed = fanSpeed;
        this.overclockEnabled = overclockEnabled;
    }

    public int getFanSpeed() {
        return fanSpeed;
    }

    public boolean isOverclockEnabled() {
        return overclockEnabled;
    }
}
