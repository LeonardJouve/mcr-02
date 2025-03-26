package main;

import main.observer.*;
import main.state.Silver;
import main.state.State;

import java.util.ArrayList;
import java.util.List;

public class Client implements Subject {
    private final String lastName;
    private final String firstName;
    private final int id;

    private State state;

    private String lastAction;

    private final List<Observer> observers = new ArrayList<>();

    private static int nextId = 1;

    public Client(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.id = nextId++;

        this.state = new Silver(this);
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getId() {
        return id;
    }

    public String getLastAction() {
        return lastAction;
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

    public String toString() {
        return lastName + " " + firstName;
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
