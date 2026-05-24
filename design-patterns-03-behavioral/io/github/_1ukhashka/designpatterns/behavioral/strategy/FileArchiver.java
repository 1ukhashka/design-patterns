package io.github._1ukhashka.designpatterns.behavioral.strategy;

public class FileArchiver {

    private CompressionStrategy strategy;

    public FileArchiver(CompressionStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(CompressionStrategy strategy) {
        this.strategy = strategy;
    }

    public void archiveFile(String filename) {
        strategy.compress(filename);
    }
}
