package io.github._1ukhashka.designpatterns.behavioral.chainofresponsibility;

public class SupportRequest {

    private final String description;
    private final int level;

    public SupportRequest(String description, int level) {
        this.description = description;
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public int getLevel() {
        return level;
    }
}
