package io.github._1ukhashka.designpatterns.structural.decorator;

public class StandDecorator extends MonitorDecorator {

    public StandDecorator(Display display) {
        super(display);
    }

    @Override
    public String getDescription() {
        return display.getDescription() + " + adjustable stand";
    }

    @Override
    public double getCost() {
        return display.getCost() + 45.0;
    }
}
