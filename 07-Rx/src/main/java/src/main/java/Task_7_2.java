package src.main.java;

import io.reactivex.rxjava3.core.Observable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Task_7_2 {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger attemptCount = new AtomicInteger(0);

        Observable<String> unstableApiCall = Observable.create(emitter -> {
            int attempt = attemptCount.incrementAndGet();
            System.out.println("[ПОВТОР] Спроба #" + attempt);
            if (attempt < 4) {
                emitter.onError(new IOException("Connection timeout"));
            } else {
                emitter.onNext("(+) Відповідь API: {status: 'ok', data: [...]}");
                emitter.onComplete();
            }
        });

        unstableApiCall
                .retryWhen(errors -> errors
                        .zipWith(Observable.range(1, 4), (err, retryCount) -> retryCount)
                        .flatMap(retryCount -> {
                            long delay = (long) Math.pow(2, retryCount - 1); // 1, 2, 4 сек
                            if (retryCount < 4) {
                                System.out.println("Очікуємо " + delay + " сек перед повтором...");
                                return Observable.timer(delay, TimeUnit.SECONDS);
                            }
                            return Observable.error(new IOException("Вичерпано ліміт спроб"));
                        })
                )
                .subscribe(
                        System.out::println,
                        err -> System.out.println("(-) Фінальна помилка: " + err.getMessage())
                );

        Thread.sleep(10000);
    }
}