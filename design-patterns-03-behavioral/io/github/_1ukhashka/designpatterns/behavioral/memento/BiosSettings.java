package io.github._1ukhashka.designpatterns.behavioral.memento;

public class BiosSettings {

    private int fanSpeed;
    private boolean overclockEnabled;

    public BiosSettings(int fanSpeed, boolean overclockEnabled) {
        this.fanSpeed = fanSpeed;
        this.overclockEnabled = overclockEnabled;
    }

    public void setFanSpeed(int fanSpeed) {
        this.fanSpeed = fanSpeed;
    }

    public void setOverclockEnabled(boolean overclockEnabled) {
        this.overclockEnabled = overclockEnabled;
    }

    public BiosMemento save() {
        return new BiosMemento(fanSpeed, overclockEnabled);
    }

    public void restore(BiosMemento memento) {
        this.fanSpeed = memento.getFanSpeed();
        this.overclockEnabled = memento.isOverclockEnabled();
    }

    @Override
    public String toString() {
        return "BiosSettings{fanSpeed=" + fanSpeed + ", overclock=" + overclockEnabled + "}";
    }
}
