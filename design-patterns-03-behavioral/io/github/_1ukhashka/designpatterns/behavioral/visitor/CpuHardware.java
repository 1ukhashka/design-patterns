package io.github._1ukhashka.designpatterns.behavioral.visitor;

public class CpuHardware implements HardwareComponent {

    private final String model;

    public CpuHardware(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    @Override
    public void accept(HardwareVisitor visitor) {
        visitor.visit(this);
    }
}
