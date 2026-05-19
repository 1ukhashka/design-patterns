package io.github._1ukhashka.designpatterns.structural.bridge;

public class OfficeMonitor extends Monitor {

    public OfficeMonitor(Connection connection) {
        super(connection);
    }

    @Override
    public void display() {
        System.out.print("Office monitor (60Hz): ");
        connection.transmit();
    }
}
