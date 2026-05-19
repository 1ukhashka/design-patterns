package io.github._1ukhashka.designpatterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class PixelColorFactory {

    private static final Map<String, PixelColor> cache = new HashMap<>();

    public static PixelColor getPixelColor(String color) {
        return cache.computeIfAbsent(color, PixelColor::new);
    }

    public static int getCachedCount() {
        return cache.size();
    }
}
