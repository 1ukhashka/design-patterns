package io.github._1ukhashka.designpatterns.behavioral.templatemethod;

public abstract class OperatingSystem {

    // Template method
    public final void boot() {
        postTest();
        loadBootloader();
        loadKernel();
        startUserInterface();
    }

    private void postTest() {
        System.out.println("Running POST (Power-On Self Test)...");
    }

    private void loadBootloader() {
        System.out.println("Loading bootloader...");
    }

    protected abstract void loadKernel();

    protected abstract void startUserInterface();
}
