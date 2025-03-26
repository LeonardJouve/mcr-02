package main.state;

import main.Client;

public abstract class State {
    private final Client client;
    private double balance;
    private double miles;

    protected State(Client client) {
        this.client = client;
        this.balance = 0;
        this.miles = 0;
    }

    protected State(State state) {
        this.client = state.client;
        this.balance = state.balance;
        this.miles = state.miles;
    }

    protected void setState(State state) {
        client.setState(state);
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
