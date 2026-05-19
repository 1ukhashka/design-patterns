package io.github._1ukhashka.designpatterns.structural.bridge;

public class DisplayPortConnection implements Connection {

    @Override
    public void transmit() {
        System.out.println("Transmitting signal via DisplayPort");
    }
}
