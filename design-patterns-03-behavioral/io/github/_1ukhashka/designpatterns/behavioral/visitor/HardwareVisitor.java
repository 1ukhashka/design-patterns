package io.github._1ukhashka.designpatterns.behavioral.visitor;

public interface HardwareVisitor {
    void visit(CpuHardware cpu);
    void visit(RamHardware ram);
    void visit(SsdHardware ssd);
}
