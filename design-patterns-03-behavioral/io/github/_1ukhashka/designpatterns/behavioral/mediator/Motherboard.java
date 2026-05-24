package io.github._1ukhashka.designpatterns.behavioral.mediator;

public class Motherboard implements Mediator {

    private CpuComponent cpu;
    private RamComponent ram;

    public void setCpu(CpuComponent cpu) {
        this.cpu = cpu;
    }

    public void setRam(RamComponent ram) {
        this.ram = ram;
    }

    @Override
    public void notify(Component sender, String event) {
        System.out.println("Motherboard: routing event '" + event + "' from " + sender.getName());
        if (event.equals("MEMORY_REQUEST")) {
            ram.sendData();
        } else if (event.equals("DATA_READY")) {
            cpu.receiveData("16GB DDR5 block");
        }
    }
}
