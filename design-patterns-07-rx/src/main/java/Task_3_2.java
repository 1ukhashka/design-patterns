package src.main.java;

import io.reactivex.rxjava3.core.Observable;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task_3_2 {
    record FoodOrder(String orderId, List<String> items) {}

    public static void main(String[] args) throws InterruptedException {
        List<FoodOrder> orders = Arrays.asList(
                new FoodOrder("ZAM-01", Arrays.asList("Піца Маргарита", "Кола 0.5л")),
                new FoodOrder("ZAM-02", Arrays.asList("Борщ", "Вареники", "Компот")),
                new FoodOrder("ZAM-03", Arrays.asList("Суші-сет 20шт", "Місо-суп"))
        );

        System.out.println("=== Частина А: flatMap() ===");
        Observable.fromIterable(orders)
                .flatMap(order -> Observable.fromIterable(order.items))
                .subscribe(item -> System.out.println(">> " + item));

        System.out.println("\n=== Частина В: Порівняння поведінки з затримкою ===");
        System.out.println("Запуск flatMap() з затримкою...");
        Observable.fromIterable(orders)
                .flatMap(order -> Observable.fromIterable(order.items).delay(500, TimeUnit.MILLISECONDS))
                .subscribe(item -> System.out.println("[flatMap] " + item));

        Thread.sleep(1500);

        System.out.println("\nЗапуск concatMap() з затримкою...");
        Observable.fromIterable(orders)
                .concatMap(order -> Observable.fromIterable(order.items).delay(500, TimeUnit.MILLISECONDS))
                .subscribe(item -> System.out.println("[concatMap] " + item));

        Thread.sleep(4000);
    }
}