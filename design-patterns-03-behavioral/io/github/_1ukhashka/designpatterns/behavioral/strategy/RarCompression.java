package io.github._1ukhashka.designpatterns.behavioral.strategy;

public class RarCompression implements CompressionStrategy {

    @Override
    public void compress(String filename) {
        System.out.println("Compressing '" + filename + "' using RAR algorithm");
    }
}
