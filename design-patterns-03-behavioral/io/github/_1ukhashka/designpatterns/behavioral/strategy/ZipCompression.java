package io.github._1ukhashka.designpatterns.behavioral.strategy;

public class ZipCompression implements CompressionStrategy {

    @Override
    public void compress(String filename) {
        System.out.println("Compressing '" + filename + "' using ZIP algorithm");
    }
}
