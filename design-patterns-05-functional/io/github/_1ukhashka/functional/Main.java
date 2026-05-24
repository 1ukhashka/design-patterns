package io.github._1ukhashka.functional;

import io.github._1ukhashka.functional.decorator.DecoratorDemo;
import io.github._1ukhashka.functional.executearound.ExecuteAroundDemo;
import io.github._1ukhashka.functional.factory.FactoryDemo;
import io.github._1ukhashka.functional.strategy.StrategyDemo;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== 1. Стратегія (Strategy) ===");
        StrategyDemo.run();

        System.out.println("\n=== 2. Фабричний метод (Factory Method) ===");
        FactoryDemo.run();

        System.out.println("\n=== 3. Декоратор (Decorator) ===");
        DecoratorDemo.run();

        System.out.println("\n=== 4. Навколишнє виконання (Execute Around) ===");
        ExecuteAroundDemo.run();
    }
}
