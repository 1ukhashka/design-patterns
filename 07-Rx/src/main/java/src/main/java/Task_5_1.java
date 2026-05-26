package src.main.java;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Task_5_1 {
    public static void main(String[] args) throws InterruptedException {
        Observable<String> images = Observable.just("photo_1.jpg", "photo_2.jpg", "photo_3.jpg");

        images
                .subscribeOn(Schedulers.io())
                .map(img -> {
                    Thread.sleep(1000);
                    System.out.printf("[%s] [ЗАВАНТ] Завантаження: %s\n", Thread.currentThread().getName(), img);
                    return img;
                })
                .observeOn(Schedulers.computation())
                .map(img -> {
                    Thread.sleep(500);
                    System.out.printf("[%s] [СТИСК] Стиснення: %s\n", Thread.currentThread().getName(), img);
                    return img;
                })
                .observeOn(Schedulers.trampoline())
                .subscribe(img -> {
                    System.out.printf("[%s] [ФОТО] Відображення: %s\n", Thread.currentThread().getName(), img);
                });

        Thread.sleep(5000);
    }
}