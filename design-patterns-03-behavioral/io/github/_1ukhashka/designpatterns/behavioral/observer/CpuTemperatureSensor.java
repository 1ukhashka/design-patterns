package io.github._1ukhashka.designpatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class CpuTemperatureSensor {

    private final List<TemperatureObserver> observers = new ArrayList<>();
    private int temperature;

    public void addObserver(TemperatureObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(TemperatureObserver observer) {
        observers.remove(observer);
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("CPU temperature: " + temperature + "°C");
        notifyObservers();
    }

    private void notifyObservers() {
        observers.forEach(o -> o.onTemperatureChanged(temperature));
    }
}
