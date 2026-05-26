package src.main.java;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task_5_2 {
    record ServiceCall(String serviceName, int delayMs) {}

    public static void main(String[] args) throws InterruptedException {
        List<ServiceCall> services = Arrays.asList(
                new ServiceCall("UserService", 800),
                new ServiceCall("OrderService", 1200),
                new ServiceCall("RecommendationService", 600)
        );

        System.out.println("=== Частина А: Послідовне завантаження (concatMap) ===");
        long startSeq = System.currentTimeMillis();
        Observable.fromIterable(services)
                .concatMap(s -> Observable.just(s)
                        .delay(s.delayMs, TimeUnit.MILLISECONDS)
                        .map(res -> "(+) " + res.serviceName + " відповів за " + res.delayMs + " мс"))
                .blockingSubscribe(System.out::println);
        System.out.println("Загальний час (послідовно): ~" + (System.currentTimeMillis() - startSeq) + " мс");

        System.out.println("\n=== Частина В: Паралельне завантаження (flatMap) ===");
        long startPar = System.currentTimeMillis();
        Observable.fromIterable(services)
                .flatMap(s -> Observable.just(s)
                        .subscribeOn(Schedulers.io())
                        .delay(s.delayMs, TimeUnit.MILLISECONDS)
                        .map(res -> "[" + Thread.currentThread().getName() + "] (+) " + res.serviceName + " відповів за " + res.delayMs + " мс"))
                .blockingSubscribe(System.out::println);
        System.out.println("Загальний час (паралельно): ~" + (System.currentTimeMillis() - startPar) + " мс");
    }
}