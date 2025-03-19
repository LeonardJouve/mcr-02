package main;

import main.state.State;

public class Account {
    private double balance;
    private double miles;

    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void depositCash(int amount) {
        balance += amount;
    }

    public void depositMiles(int amount) {
        miles += amount;
    }

    public void withdrawCash(int amount) throws IllegalArgumentException {
        if (amount > balance) throw new IllegalArgumentException();

        balance -= amount;
    }

    public void withdrawMiles(int amount) throws IllegalArgumentException {
        if (amount > miles) throw new IllegalArgumentException();

        miles -= amount;
    }
}
