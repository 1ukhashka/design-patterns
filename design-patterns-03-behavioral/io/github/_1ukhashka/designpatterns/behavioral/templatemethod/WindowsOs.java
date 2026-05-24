package io.github._1ukhashka.designpatterns.behavioral.templatemethod;

public class WindowsOs extends OperatingSystem {

    @Override
    protected void loadKernel() {
        System.out.println("Windows: loading NT kernel...");
    }

    @Override
    protected void startUserInterface() {
        System.out.println("Windows: starting Explorer shell...");
    }
}
