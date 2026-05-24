package io.github._1ukhashka.functional.factory;

public interface BankAccount {
    void showInfo();
}

class CurrentAccount implements BankAccount {
    public void showInfo() {
        System.out.println("Поточний рахунок: без відсотків, вільне зняття коштів");
    }
}

class DepositAccount implements BankAccount {
    public void showInfo() {
        System.out.println("Депозитний рахунок: 5% річних, кошти заблоковані на термін");
    }
}

class CreditAccount implements BankAccount {
    public void showInfo() {
        System.out.println("Кредитний рахунок: ліміт 50000 грн, 15% річних");
    }
}
