package io.github._1ukhashka.designpatterns.behavioral.observer;

public class SystemLogger implements TemperatureObserver {

    @Override
    public void onTemperatureChanged(int temperature) {
        System.out.println("SystemLogger: logged temperature " + temperature + "°C");
        if (temperature > 90) {
            System.out.println("SystemLogger: WARNING - critical temperature!");
        }
    }
}
