package io.github._1ukhashka.functional.executearound;

public class ExecuteAroundDemo {

    public static void run() {
        BankTransaction.use("TXN-001", tx -> {
            tx.execute("Зняття 500 грн з рахунку UA001");
            tx.execute("Зарахування 500 грн на рахунок UA002");
        });
    }
}
