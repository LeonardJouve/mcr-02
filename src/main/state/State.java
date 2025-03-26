package main.state;

import main.Account;

public abstract class State {
    private final Account account;
    private double balance;
    private double miles;

    protected State(Account account) {
        this.account = account;
        this.balance = 0;
        this.miles = 0;
    }

    protected State(State state) {
        this.account = state.account;
        this.balance = state.balance;
        this.miles = state.miles;
    }

    protected void setState(State state) {
        account.setState(state);
    }

    public double getBalance() {
        return balance;
    }

    public double getMiles() {
        return miles;
    }

    public boolean depositCash(int amount) {
        balance += amount;
        checkStateChange();
        return true;
    }

    public boolean depositMiles(int amount) {
        miles += amount;
        checkStateChange();
        return true;
    }

    public boolean withdrawCash(int amount) {
        if (amount > balance) return false;
        balance -= amount;
        miles += getMilesCoefficient() * amount;
        checkStateChange();
        return true;
    }

    public boolean withdrawMiles(int amount) {
        if (amount > miles) return false;
        miles -= amount;
        checkStateChange();
        return true;
    }

    protected abstract double getMilesCoefficient();

    protected abstract void checkStateChange();

    public abstract String toString();
}
