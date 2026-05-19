package io.github._1ukhashka.designpatterns.structural.composite;

public class ComputerPart implements ComputerComponent {

    private final String name;
    private final double price;

    public ComputerPart(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void showDetails() {
        System.out.println("  Part: " + name + " - $" + price);
    }

    @Override
    public double getPrice() {
        return price;
    }
}
