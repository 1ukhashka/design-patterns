package io.github._1ukhashka.designpatterns.structural.decorator;

public class BlueLightFilterDecorator extends MonitorDecorator {

    public BlueLightFilterDecorator(Display display) {
        super(display);
    }

    @Override
    public String getDescription() {
        return display.getDescription() + " + blue light filter";
    }

    @Override
    public double getCost() {
        return display.getCost() + 20.0;
    }
}
