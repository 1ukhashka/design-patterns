package io.github._1ukhashka.designpatterns.behavioral.visitor;

public class DiagnosticVisitor implements HardwareVisitor {

    @Override
    public void visit(CpuHardware cpu) {
        System.out.println("Diagnostic: CPU model=" + cpu.getModel() + " -> OK");
    }

    @Override
    public void visit(RamHardware ram) {
        System.out.println("Diagnostic: RAM capacity=" + ram.getCapacityGb() + "GB -> OK");
    }

    @Override
    public void visit(SsdHardware ssd) {
        System.out.println("Diagnostic: SSD capacity=" + ssd.getCapacityGb() + "GB -> OK");
    }
}
