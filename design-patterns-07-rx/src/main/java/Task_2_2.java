package src.main.java;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import java.util.concurrent.TimeUnit;

public class Task_2_2 {
    public static void main(String[] args) throws InterruptedException {
        String[] scores = {
                "Динамо 2:1 Шахтар",
                "Шахтар 3:0 Металіст",
                "Зоря 1:1 Ворскла",
                "Дніпро 2:0 Чорноморець",
                "Рух 0:0 Колос"
        };

        System.out.println("=== Частина A: Холодний Observable ===");
        Observable<String> coldObservable = Observable.fromArray(scores);

        coldObservable.subscribe(score -> System.out.println("Підписник 1 (Холодний): " + score));
        coldObservable.subscribe(score -> System.out.println("Підписник 2 (Холодний): " + score));

        System.out.println("\n=== Частина В: Гарячий Observable ===");
        // Використовуємо zip з interval для емуляції затримки часу
        Observable<String> timedScores = Observable.zip(
                Observable.fromArray(scores),
                Observable.interval(1, TimeUnit.SECONDS),
                (score, time) -> score
        );

        ConnectableObservable<String> hotObservable = timedScores.publish();

        hotObservable.subscribe(score -> System.out.println("Підписник 1 (Гарячий): " + score));
        hotObservable.connect(); // Запуск емісії

        Thread.sleep(2500); // Чекаємо 2.5 сек (перші 2 результати вже пройдуть)

        hotObservable.subscribe(score -> System.out.println("Підписник 2 (Гарячий, пізній): " + score));

        Thread.sleep(4000); // Чекаємо завершення потоку
    }
}