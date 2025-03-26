package main;

import main.observer.*;

import java.util.ArrayList;
import java.util.List;

public class Client implements Subject, Observer {
    private String lastName;
    private String firstName;
    private int id;

    private String lastAction;
    private Account account;

    private List<Observer> observers = new ArrayList<>();

    private static int nextId = 1;

    public Client(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.id = nextId++;

        this.account = new Account();
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

    public Account getAccount() {
        return account;
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

    @Override
    public void update(Subject subject) {
        notifyObservers();
    }
}
