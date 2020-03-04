package de.telran.service;

import de.telran.model.Account;
import de.telran.model.Transaction;

import java.util.List;

public class TransactionService {

    private List<Account> accounts;

    public TransactionService(List<Account> accounts) {
        this.accounts = accounts;
    }

    public long getSumOfAllCancelledTransactions() {
        return accounts.stream().filter(account -> account.getBalance() > 0)
                .flatMap(account -> account.getTransactions().stream())
                .filter(transaction -> transaction.getState() == Transaction.CANCELLED)
                .map(Transaction::getSum)
                .reduce((t1, t2) -> t1 + t2)
                .orElse((long) 0);
    }
}
