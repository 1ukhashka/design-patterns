package io.github._1ukhashka.designpatterns.structural.bridge;

public abstract class Monitor {

    protected Connection connection;

    public Monitor(Connection connection) {
        this.connection = connection;
    }

    public abstract void display();
}
