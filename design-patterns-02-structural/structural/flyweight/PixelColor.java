package io.github._1ukhashka.designpatterns.structural.flyweight;

public class PixelColor {

    private final String color;

    public PixelColor(String color) {
        this.color = color;
        System.out.println("Creating PixelColor object for: " + color);
    }

    public void draw(int x, int y) {
        System.out.println("Drawing pixel [" + x + "," + y + "] with color: " + color);
    }
}
