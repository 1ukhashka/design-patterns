package io.github._1ukhashka.designpatterns.behavioral.visitor;

public class SsdHardware implements HardwareComponent {

    private final int capacityGb;

    public SsdHardware(int capacityGb) {
        this.capacityGb = capacityGb;
    }

    public int getCapacityGb() {
        return capacityGb;
    }

    @Override
    public void accept(HardwareVisitor visitor) {
        visitor.visit(this);
    }
}
