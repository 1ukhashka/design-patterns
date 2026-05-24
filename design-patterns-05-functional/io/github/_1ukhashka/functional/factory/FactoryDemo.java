package io.github._1ukhashka.functional.factory;

import java.util.Map;
import java.util.function.Supplier;

public class FactoryDemo {

    private static final Map<String, Supplier<BankAccount>> registry = Map.of(
            "current", CurrentAccount::new,
            "deposit", DepositAccount::new,
            "credit",  CreditAccount::new
    );

    public static BankAccount createAccount(String type) {
        Supplier<BankAccount> supplier = registry.get(type.toLowerCase());
        if (supplier == null) {
            throw new IllegalArgumentException("Невідомий тип рахунку: " + type);
        }
        return supplier.get();
    }

    public static void run() {
        BankAccount current = createAccount("current");
        BankAccount deposit = createAccount("deposit");
        BankAccount credit  = createAccount("credit");

        current.showInfo();
        deposit.showInfo();
        credit.showInfo();
    }
}
