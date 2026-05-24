package io.github._1ukhashka.functional.strategy;

import java.util.List;

public class StrategyDemo {

    public static double calculateTotal(List<Double> amounts, InterestStrategy strategy) {
        return amounts.stream()
                .mapToDouble(strategy::calculate)
                .sum();
    }

    public static void run() {
        List<Double> accounts = List.of(1000.0, 2000.0, 3500.0);

        InterestStrategy deposit     = amount -> amount * 0.05;  // 5% депозит
        InterestStrategy credit      = amount -> amount * 0.15;  // 15% кредит
        InterestStrategy savings     = amount -> amount * 0.08;  // 8% накопичувальний

        System.out.println("Депозитні відсотки:       " + calculateTotal(accounts, deposit));
        System.out.println("Кредитні відсотки:        " + calculateTotal(accounts, credit));
        System.out.println("Накопичувальні відсотки:  " + calculateTotal(accounts, savings));
    }
}
