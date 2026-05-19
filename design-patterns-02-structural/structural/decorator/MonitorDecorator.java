package io.github._1ukhashka.designpatterns.structural.decorator;

public abstract class MonitorDecorator implements Display {

    protected final Display display;

    public MonitorDecorator(Display display) {
        this.display = display;
    }

    @Override
    public String getDescription() {
        return display.getDescription();
    }

    @Override
    public double getCost() {
        return display.getCost();
    }
}
