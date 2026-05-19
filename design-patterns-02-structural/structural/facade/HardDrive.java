package io.github._1ukhashka.designpatterns.structural.facade;

public class HardDrive {

    public void spin() {
        System.out.println("HDD: spinning up...");
    }

    public void stop() {
        System.out.println("HDD: stopping...");
    }
}
