package de.telran.service;

import de.telran.model.Account;
import de.telran.model.Transaction;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class TransactionServiceTest {

    @Test
    public void testGetSumOfAllCancelledTransactions_returnsSum() {
        Transaction t1 = new Transaction("1", Transaction.CANCELLED, 100, new Date());
        Transaction t2 = new Transaction("1", Transaction.FINISHED, 200, new Date());
        Transaction t3 = new Transaction("1", Transaction.CANCELLED, 300, new Date());
        List<Transaction> transactions = Arrays.asList(t1, t2, t3);

        List<Account> accounts = Arrays.asList(new Account("DE1", 10, transactions));

        TransactionService ts = new TransactionService(accounts);

        assertEquals(400, ts.getSumOfAllCancelledTransactions());
    }

    @Test
    public void testGetSumOfAllCancelledTransactions_noCancelled_returnsNull() {
        Transaction t1 = new Transaction("1", Transaction.FINISHED, 100, new Date());
        Transaction t2 = new Transaction("1", Transaction.PROCESS, 200, new Date());
        Transaction t3 = new Transaction("1", Transaction.FINISHED, 300, new Date());
        List<Transaction> transactions = Arrays.asList(t1, t2, t3);
        Account account1 = new Account("DE1", 10, transactions);

        List<Account> accounts = Arrays.asList(new Account("DE1", 10, transactions));

        TransactionService ts = new TransactionService(accounts);

        assertEquals(0, ts.getSumOfAllCancelledTransactions());
    }

    @Test
    public void testGetSumOfAllCancelledTransactions_balanceNull_returnsNull() {
        Transaction t1 = new Transaction("1", Transaction.CANCELLED, 100, new Date());
        Transaction t2 = new Transaction("1", Transaction.FINISHED, 200, new Date());
        Transaction t3 = new Transaction("1", Transaction.CANCELLED, 300, new Date());
        List<Transaction> transactions = Arrays.asList(t1, t2, t3);

        List<Account> accounts = Arrays.asList(new Account("DE1", 0, transactions));

        TransactionService ts = new TransactionService(accounts);

        assertEquals(0, ts.getSumOfAllCancelledTransactions());
    }
}