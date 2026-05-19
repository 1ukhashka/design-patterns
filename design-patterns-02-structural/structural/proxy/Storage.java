package io.github._1ukhashka.designpatterns.structural.proxy;

public interface Storage {
    void readData(String filename);
    void writeData(String filename, String content);
}
