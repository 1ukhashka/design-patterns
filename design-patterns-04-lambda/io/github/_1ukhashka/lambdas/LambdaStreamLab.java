package io.github._1ukhashka.lambdas;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LambdaStreamLab {

    public static void main(String[] args) {
        System.out.println("=== Лабораторна робота №4 ===");

        // Завдання 1: Відфільтрувати непарні числа
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("1. Непарні числа: " + filterOddNumbers(integers));

        // Завдання 2: Знайти середнє зі списку дійсних значень
        List<Double> doubles = Arrays.asList(1.5, 2.5, 3.5, 4.5);
        System.out.println("2. Середнє значення: " + findAverage(doubles));

        // Завдання 3: Сортування списку рядків в алфавітному порядку
        List<String> strings = Arrays.asList("Banana", "Apple", "Cherry", "Date");
        System.out.println("3. Алфавітне сортування: " + sortAlphabetically(strings));

        // Завдання 4: Обчислення суми всіх парних чисел
        System.out.println("4. Сума парних чисел: " + sumOfEvenNumbers(integers));

        // Завдання 5: Обчислити факторіал заданого числа
        int n = 5;
        System.out.println("5. Факторіал числа " + n + ": " + calculateFactorial(n));

        // Завдання 6: Множення та підсумовування всіх елементів
        System.out.println("6. Сума елементів: " + sumAllElements(integers));
        System.out.println("   Множення елементів: " + multiplyAllElements(integers));

        // Завдання 7: Квадрат кожного числа
        System.out.println("7. Квадрати чисел: " + calculateSquares(integers));

        // Завдання 8: Сортування рядків за довжиною (зростання)
        List<String> words = Arrays.asList("Elephant", "Cat", "Dog", "Hippopotamus");
        System.out.println("8. Сортування за довжиною: " + sortByLength(words));

        // Завдання 9: Підрахувати кількість слів у реченні
        String sentence = "Це речення містить п'ять слів";
        System.out.println("9. Кількість слів у реченні: " + countWords(sentence));

        // Завдання 10: Знайти перший непорожній рядок
        List<String> stringsWithEmpties = Arrays.asList("", "  ", "First Valid", "Second");
        Optional<String> firstValid = findFirstNonEmpty(stringsWithEmpties);
        firstValid.ifPresent(s -> System.out.println("10. Перший непорожній рядок: '" + s + "'"));

        // Завдання 11: Перевірити, чи всі рядки починаються з великої літери
        List<String> capitalizedStrings = Arrays.asList("Apple", "Banana", "Cherry");
        System.out.println("11. Всі починаються з великої: " + allStartWithCapital(capitalizedStrings));

        // Завдання 12: Знайти друге за величиною число
        List<Integer> randomIntegers = Arrays.asList(10, 5, 20, 20, 15);
        Optional<Integer> secondLargest = findSecondLargest(randomIntegers);
        secondLargest.ifPresent(val -> System.out.println("12. Друге за величиною число: " + val));

        // Завдання 13: Знайти найбільше парне число
        Optional<Integer> maxEven = findMaxEven(randomIntegers);
        maxEven.ifPresent(val -> System.out.println("13. Найбільше парне число: " + val));
    }

    // 1. Відфільтрувати непарні числа
    public static List<Integer> filterOddNumbers(List<Integer> list) {
        return list.stream()
                .filter(n -> n % 2 != 0)
                .collect(Collectors.toList());
    }

    // 2. Знайти середнє з списку дійсних значен
    public static double findAverage(List<Double> list) {
        return list.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }

    // 3. Сортування списку рядків в алфавітному порядку
    public static List<String> sortAlphabetically(List<String> list) {
        return list.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    // 4. Обчислення суми всіх парних чисе
    public static int sumOfEvenNumbers(List<Integer> list) {
        return list.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    // 5. Обчислити факторіал заданого числа
    public static long calculateFactorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Факторіал від'ємного числа не існує");
        return LongStream.rangeClosed(1, n)
                .reduce(1, (a, b) -> a * b);
    }

    // 6.1 Розрахувати підсумовування всіх елементів
    public static int sumAllElements(List<Integer> list) {
        return list.stream()
                .reduce(0, Integer::sum);
    }

    // 6.2 Розрахувати множення всіх елементів
    public static long multiplyAllElements(List<Integer> list) {
        return list.stream()
                .mapToLong(Integer::longValue)
                .reduce(1, (a, b) -> a * b);
    }

    // 7. Розрахувати квадрат кожного числа
    public static List<Integer> calculateSquares(List<Integer> list) {
        return list.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
    }

    // 8. Сортування рядків на основі їх довжини в порядку зростання
    public static List<String> sortByLength(List<String> list) {
        return list.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    // 9. Підрахуйте кількість слів у реченні
    public static long countWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) return 0;
        return Arrays.stream(sentence.trim().split("\\s+"))
                .count();
    }

    // 10. Знайти перший непорожній рядок у списку
    public static Optional<String> findFirstNonEmpty(List<String> list) {
        return list.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .findFirst();
    }

    // 11 Перевірити, чи всі рядки починаються з великої літери
    public static boolean allStartWithCapital(List<String> list) {
        return list.stream()
                .filter(s -> s != null && !s.isEmpty())
                .allMatch(s -> Character.isUpperCase(s.charAt(0)));
    }

    // 122 Знайти друге за величиною число
    public static Optional<Integer> findSecondLargest(List<Integer> list) {
        return list.stream()
                .distinct() // Відкидаємо дублікати (напр., якщо є дві 20)
                .sorted(Comparator.reverseOrder())
                .skip(1)    // Пропускаємо перше найбільше
                .findFirst();
    }

    // 13. Знайти найбільше парне число
    public static Optional<Integer> findMaxEven(List<Integer> list) {
        return list.stream()
                .filter(n -> n % 2 == 0)
                .max(Integer::compareTo);
    }
}