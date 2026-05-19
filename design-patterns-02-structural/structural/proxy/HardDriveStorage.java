package io.github._1ukhashka.designpatterns.structural.proxy;

public class HardDriveStorage implements Storage {

    @Override
    public void readData(String filename) {
        System.out.println("HDD: reading file '" + filename + "'");
    }

    @Override
    public void writeData(String filename, String content) {
        System.out.println("HDD: writing to file '" + filename + "': " + content);
    }
}
