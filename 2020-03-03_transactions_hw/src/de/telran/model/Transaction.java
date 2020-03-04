package de.telran.model;

import java.util.Date;

public class Transaction {

    public final static int CANCELLED = 1;
    public final static int FINISHED = 2;
    public final static int PROCESS = 3;

    private String uuid;
    private int state;
    private long sum;
    private Date created;

    public Transaction(String uuid, int state, long sum, Date created) {
        this.uuid = uuid;
        this.state = state;
        this.sum = sum;
        this.created = created;
    }

    public String getUuid() {
        return uuid;
    }

    public int getState() {
        return state;
    }

    public long getSum() {
        return sum;
    }

    public Date getCreated() {
        return created;
    }
}
