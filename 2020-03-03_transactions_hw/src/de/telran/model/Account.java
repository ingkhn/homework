package de.telran.model;

import java.util.List;

public class Account {
    private String number;
    private long balance;
    private List<Transaction> transactions;

    public Account(String number, long balance, List<Transaction> transactions) {
        this.number = number;
        this.balance = balance;
        this.transactions = transactions;
    }

    public String getNumber() {
        return number;
    }

    public long getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

   /* public void setTransactions(Transaction transaction) {
        transactions.add(transaction);
        if (transaction.getState() == Transaction.FINISHED)
            balance += transaction.getSum();
    }*/
}
