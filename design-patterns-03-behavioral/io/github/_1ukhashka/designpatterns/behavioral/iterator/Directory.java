package io.github._1ukhashka.designpatterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

public class Directory {

    private final String name;
    private final List<String> files = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void addFile(String filename) {
        files.add(filename);
    }

    public String getName() {
        return name;
    }

    public FileIterator iterator() {
        return new DirectoryIterator(files);
    }
}
