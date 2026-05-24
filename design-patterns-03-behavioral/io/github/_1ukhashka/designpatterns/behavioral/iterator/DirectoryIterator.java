package io.github._1ukhashka.designpatterns.behavioral.iterator;

import java.util.List;

public class DirectoryIterator implements FileIterator {

    private final List<String> files;
    private int index = 0;

    public DirectoryIterator(List<String> files) {
        this.files = files;
    }

    @Override
    public boolean hasNext() {
        return index < files.size();
    }

    @Override
    public String next() {
        return files.get(index++);
    }
}
