package src.main.java;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

public class Task_4_2 {

    // Частина А
    public static Maybe<String> findInCache(String key) {
        return switch (key) {
            case "user:1" -> Maybe.just("{'name': 'Леся', 'age':28}");
            case "user:2" -> Maybe.empty();
            case "user:error" -> Maybe.error(new RuntimeException("Redis недоступний"));
            default -> Maybe.empty();
        };
    }

    // Частина В
    public static Completable validateInput(boolean isValid) {
        return isValid ? Completable.fromAction(() -> System.out.println("[ПОШУК] Перевірка даних...\n(+) Дані валідні"))
                : Completable.error(new RuntimeException("Невалідні дані"));
    }

    public static Completable saveToDatabase(boolean isSuccess) {
        return isSuccess ? Completable.fromAction(() -> System.out.println("[DB] Збереження в БД...\n(+) Збережено"))
                : Completable.error(new RuntimeException("Помилка збереження"));
    }

    public static Single<String> generateToken() {
        return Single.just("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.demo")
                .doOnSuccess(token -> System.out.println("[ТОКЕН] Токен: " + token));
    }

    public static void main(String[] args) {
        System.out.println("=== Частина А (Maybe) ===");
        String[] keys = {"user:1", "user:2", "user:error"};
        for (String key : keys) {
            findInCache(key)
                    .defaultIfEmpty("Завантажено з БД")
                    .subscribe(
                            val -> {
                                if (val.equals("Завантажено з БД")) System.out.println("[КЕШ (-)] Кеш-міс. Значення: " + val);
                                else System.out.println("[КЕШ (+)] Знайдено: " + val);
                            },
                            err -> System.out.println("[КЕШ (!)] Помилка: " + err.getMessage())
                    );
        }

        System.out.println("\n=== Частина В (Completable) ===");
        validateInput(true)
                .andThen(saveToDatabase(true))
                .andThen(generateToken())
                .subscribe(
                        token -> System.out.println("(+) Реєстрацію завершено успішно!"),
                        err -> System.out.println("(-) Помилка реєстрації: " + err.getMessage())
                );
    }
}