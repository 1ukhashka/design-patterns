package io.github._1ukhashka.designpatterns.structural.facade;

public class ComputerFacade {

    private final Cpu cpu = new Cpu();
    private final Ram ram = new Ram();
    private final HardDrive hardDrive = new HardDrive();

    public void pressStartButton() {
        System.out.println("-- Powering ON --");
        cpu.start();
        ram.load();
        hardDrive.spin();
    }

    public void pressShutdownButton() {
        System.out.println("-- Powering OFF --");
        hardDrive.stop();
        ram.clear();
        cpu.shutdown();
    }
}
