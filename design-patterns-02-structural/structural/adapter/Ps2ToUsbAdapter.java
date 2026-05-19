package io.github._1ukhashka.designpatterns.structural.adapter;

public class Ps2ToUsbAdapter implements UsbDevice {

    private final Ps2Keyboard ps2Keyboard;

    public Ps2ToUsbAdapter(Ps2Keyboard ps2Keyboard) {
        this.ps2Keyboard = ps2Keyboard;
    }

    @Override
    public void connectViaUsb() {
        ps2Keyboard.connectViaPs2();
    }
}
