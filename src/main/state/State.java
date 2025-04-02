package main.state;

import main.Client;

import java.awt.*;

/**
 * Represents the state of a client as part of the State design pattern.
 */
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

    /**
     * Change the state of the client.
     *
     * @param state
     */
    protected void setState(State state) {
        client.setState(state);
    }

    /**
     * Getter for balance.
     *
     * @return
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Getter for the amount of miles.
     *
     * @return
     */
    public double getMiles() {
        return miles;
    }

    /**
     * Add an amount of cash to the client's balance. Updates the state if necessary.
     *
     * @param amount of cash/credit to add
     */
    public void depositCash(double amount) {
        balance += amount;
        checkStateChange();
    }

    /**
     * Add an amount of miles to the client's miles. Updates the state if necessary.
     *
     * @param amount of miles to add
     */
    public void depositMiles(double amount) {
        miles += amount;
        checkStateChange();
    }

    /**
     * Withdraw an amount of cash from the client's balance. Updates the state if necessary.
     * Then notifies the observers.
     *
     * @param amount of cash/credit to withdraw
     * @return true if the withdrawal was successful, false otherwise
     */
    public boolean withdrawCash(double amount) {
        if (amount > balance) return false;
        balance -= amount;
        checkStateChange();
        return true;
    }

    /**
     * Withdraw an amount of miles from the client's miles. Updates the state if necessary.
     * Then notifies the observers.
     *
     * @param amount of miles to withdraw
     * @return true if the withdrawal was successful, false otherwise
     */
    public boolean withdrawMiles(double amount) {
        if (amount > miles) return false;
        miles -= amount;
        checkStateChange();
        return true;
    }

    /**
     * Getter for miles coefficient of the state this method is called on.
     *
     * @return
     */
    public abstract double getMilesCoefficient();

    /**
     * Manage any change of state that should happen based on amount of miles or balance.
     * This method should be overridden by subclasses to implement specific state change logic.
     */
    protected abstract void checkStateChange();

    /**
     * String representation of the state.
     *
     * @return The name of the state as a String.
     */
    public abstract String toString();

    public abstract Color getColor();
}
