package main;

import main.observer.Observer;
import main.observer.Subject;
import main.state.Silver;
import main.state.State;

import java.util.ArrayList;
import java.util.List;

public class Account implements Subject {
    private State state;
    private final List<Observer> observers;

    public Account() {
        this.state = new Silver(this);
        this.observers = new ArrayList<>();
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
        notifyObservers();
    }

    public boolean depositCash(int amount) {
        boolean ok = state.depositCash(amount);
        if (ok) {
            notifyObservers();
        }

        return ok;
    }

    public boolean depositMiles(int amount) {
        boolean ok = state.depositMiles(amount);
        if (ok) {
            notifyObservers();
        }

        return ok;
    }

    public boolean withdrawCash(int amount) {
        boolean ok = state.withdrawCash(amount);
        if (ok) {
            notifyObservers();
        }

        return ok;
    }

    public boolean withdrawMiles(int amount) {
        boolean ok = state.withdrawMiles(amount);
        if (ok) {
            notifyObservers();
        }

        return ok;
    }

    @Override
    public void attachObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detachObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}
