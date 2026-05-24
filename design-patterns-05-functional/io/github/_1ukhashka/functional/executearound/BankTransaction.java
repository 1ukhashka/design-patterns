package io.github._1ukhashka.functional.executearound;

import java.util.function.Consumer;

public class BankTransaction {

    private final String transactionId;

    private BankTransaction(String transactionId) {
        this.transactionId = transactionId;
        System.out.println("[TX:" + transactionId + "] Транзакцію відкрито.");
    }

    public void execute(String operation) {
        System.out.println("[TX:" + transactionId + "] " + operation);
    }

    private void commit() {
        System.out.println("[TX:" + transactionId + "] Транзакцію успішно закрито (commit).");
    }

    private void rollback() {
        System.out.println("[TX:" + transactionId + "] Транзакцію відкочено (rollback).");
    }

    public static void use(String id, Consumer<BankTransaction> block) {
        BankTransaction tx = new BankTransaction(id);
        try {
            block.accept(tx);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }
}
