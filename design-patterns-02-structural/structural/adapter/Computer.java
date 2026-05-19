package io.github._1ukhashka.designpatterns.structural.adapter;

public class Computer {

    private final UsbDevice usbDevice;

    public Computer(UsbDevice usbDevice) {
        this.usbDevice = usbDevice;
    }

    public void plugIn() {
        usbDevice.connectViaUsb();
    }
}
