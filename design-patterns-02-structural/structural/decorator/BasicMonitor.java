package io.github._1ukhashka.designpatterns.structural.decorator;

public class BasicMonitor implements Display {

    @Override
    public String getDescription() {
        return "Basic monitor";
    }

    @Override
    public double getCost() {
        return 200.0;
    }
}
