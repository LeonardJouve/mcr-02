package main;

import main.state.Silver;
import main.state.State;

public class Account {
    private State state;

    public Account() {
        this.state = new Silver(this);
    }

    public double getBalance() {
        return state.getBalance();
    }

    public double getMiles() {
        return state.getMiles();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public boolean depositCash(int amount) {
        return state.depositCash(amount);
    }

    public boolean depositMiles(int amount) {
        return state.depositMiles(amount);
    }

    public boolean withdrawCash(int amount) {
        return state.withdrawCash(amount);
    }

    public boolean withdrawMiles(int amount) {
        return state.withdrawMiles(amount);
    }

}
