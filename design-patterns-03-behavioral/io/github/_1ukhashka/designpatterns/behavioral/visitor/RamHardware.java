package io.github._1ukhashka.designpatterns.behavioral.visitor;

public class RamHardware implements HardwareComponent {

    private final int capacityGb;

    public RamHardware(int capacityGb) {
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
