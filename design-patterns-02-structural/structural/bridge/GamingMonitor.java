package io.github._1ukhashka.designpatterns.structural.bridge;

public class GamingMonitor extends Monitor {

    public GamingMonitor(Connection connection) {
        super(connection);
    }

    @Override
    public void display() {
        System.out.print("Gaming monitor (144Hz): ");
        connection.transmit();
    }
}
