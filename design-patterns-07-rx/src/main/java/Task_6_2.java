package src.main.java;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import java.util.concurrent.atomic.AtomicInteger;

public class Task_6_2 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Частина А: buffer() ===");
        Observable<String> events = Observable.fromArray(
                "LOGIN:user1", "CLICK:btn_buy", "VIEW:product_42", "LOGIN:user2", "LOGOUT:user1",
                "CLICK:btn_cart", "VIEW:product_7", "LOGIN:user3", "CLICK:btn_pay", "LOGOUT:user2",
                "LOGIN:user4", "VIEW:product_1"
        );

        AtomicInteger batchCount = new AtomicInteger(1);
        events.buffer(5)
                .subscribe(batch -> {
                    System.out.println("[DB] Batch INSERT #" + batchCount.getAndIncrement() + ": " + batch);
                }, err -> {}, () -> System.out.println("(+) Збережено подій: 12"));

        System.out.println("\n=== Частина В: Flowable з DROP ===");
        AtomicInteger processed = new AtomicInteger(0);
        AtomicInteger dropped = new AtomicInteger(0);

        Flowable<Integer> fastProducer = Flowable.create(emitter -> {
            for (int i = 1; i <= 1000; i++) {
                emitter.onNext(i);
            }
            emitter.onComplete();
        }, BackpressureStrategy.DROP);

        fastProducer
                .onBackpressureDrop(item -> dropped.incrementAndGet())
                .observeOn(Schedulers.io(), false, 128) // розмір буфера
                .subscribe(
                        item -> {
                            Thread.sleep(10); // Повільний обробник
                            processed.incrementAndGet();
                        },
                        Throwable::printStackTrace,
                        () -> {
                            System.out.println("[ЗВІТ] Оброблено: ~" + processed.get());
                            System.out.println("[ЗВІТ] Відкинуто: ~" + dropped.get());
                            System.out.println("(!) Стратегія DROP: частину елементів втрачено");
                        }
                );

        Thread.sleep(3000); // Чекаємо на обробку
    }
}