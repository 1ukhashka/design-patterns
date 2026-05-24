package io.github._1ukhashka.functional.decorator;

import java.util.function.Function;

public class DecoratorDemo {

    public static void run() {
        Function<Double, Double> validate = amount -> {
            if (amount <= 0) throw new IllegalArgumentException("Сума має бути більше 0");
            System.out.println("[Валідація] Сума " + amount + " грн — OK");
            return amount;
        };

        Function<Double, Double> log = amount -> {
            System.out.println("[Логування] Транзакція на суму: " + amount + " грн");
            return amount;
        };

        Function<Double, Double> convertToUsd = amount -> {
            double usd = amount / 41.0;
            System.out.printf("[Конвертація] %.2f грн = %.2f USD%n", amount, usd);
            return usd;
        };

        TransactionProcessor processor = new TransactionProcessor(validate, log, convertToUsd);

        System.out.println("Результат: " + processor.process(1230.0) + " USD");
    }
}
