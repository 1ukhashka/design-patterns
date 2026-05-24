package io.github._1ukhashka.designpatterns.behavioral.templatemethod;

public class LinuxOs extends OperatingSystem {

    @Override
    protected void loadKernel() {
        System.out.println("Linux: loading kernel from /boot/vmlinuz...");
    }

    @Override
    protected void startUserInterface() {
        System.out.println("Linux: starting display manager...");
    }
}
