package io.github._1ukhashka.designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class ComputerAssembly implements ComputerComponent {

    private final String name;
    private final List<ComputerComponent> components = new ArrayList<>();

    public ComputerAssembly(String name) {
        this.name = name;
    }

    public void add(ComputerComponent component) {
        components.add(component);
    }

    public void remove(ComputerComponent component) {
        components.remove(component);
    }

    @Override
    public void showDetails() {
        System.out.println("[" + name + "] total: $" + getPrice());
        components.forEach(ComputerComponent::showDetails);
    }

    @Override
    public double getPrice() {
        return components.stream().mapToDouble(ComputerComponent::getPrice).sum();
    }
}
