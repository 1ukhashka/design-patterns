package src.main.java;

import io.reactivex.rxjava3.core.Observable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Task_1_2 {
    public static void main(String[] args) {
        List<String> cities = Arrays.asList(
                "Київ", "Харків", "Одеса", "Дніпро", "Запоріжжя",
                "Кривий Ріг", "Миколаїв", "Херсон", "Кропивницький",
                "Черкаси", "Суми", "Хмельницький", "Чернівці", "Каховка"
        );

        System.out.println("=== Імперативний підхід ===");
        List<String> imperativeList = new ArrayList<>();
        for (String city : cities) {
            if (city.startsWith("К")) {
                imperativeList.add(city.toUpperCase());
            }
        }
        Collections.sort(imperativeList);
        for (String c : imperativeList) {
            System.out.println(c);
        }

        System.out.println("\n=== Функціональний підхід (Streams) ===");
        cities.stream()
                .filter(city -> city.startsWith("К"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

        System.out.println("\n=== Реактивний підхід (RxJava) ===");
        Observable.fromIterable(cities)
                .filter(city -> city.startsWith("К"))
                .map(String::toUpperCase)
                .sorted()
                .subscribe(System.out::println);
    }
}