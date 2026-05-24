package io.github._1ukhashka.designpatterns.behavioral.observer;

public class CoolerFan implements TemperatureObserver {

    @Override
    public void onTemperatureChanged(int temperature) {
        if (temperature > 80) {
            System.out.println("CoolerFan: TURBO mode activated!");
        } else if (temperature > 60) {
            System.out.println("CoolerFan: speed increased.");
        } else {
            System.out.println("CoolerFan: normal speed.");
        }
    }
}
