package src.main.java;

import java.util.Arrays;
import java.util.List;
import java.util.DoubleSummaryStatistics;

public class Task_1_1 {
    enum Status { DELIVERED, PENDING, CANCELLED }
    record Order(String id, Status status, double amount) {}

    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order("O-001", Status.DELIVERED, 1500.00),
                new Order("O-002", Status.PENDING, 300.00),
                new Order("O-003", Status.CANCELLED, 75.00),
                new Order("O-004", Status.DELIVERED, 2200.00),
                new Order("O-005", Status.PENDING, 450.00),
                new Order("O-006", Status.DELIVERED, 980.00)
        );

        // === ФУНКЦІОНАЛЬНИЙ СТИЛЬ ===
        DoubleSummaryStatistics stats = orders.stream()
                .filter(order -> order.status() == Status.DELIVERED)
                .mapToDouble(Order::amount)
                .summaryStatistics();

        System.out.println("Виконаних замовлень: " + stats.getCount());
        System.out.println("Загальна сума: " + stats.getSum());
    }
}