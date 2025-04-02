package main;

import main.observer.*;
import main.state.Silver;
import main.state.State;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a client in the system.
 * Implements the Subject interface for the Observer pattern.
 * Is observed by ClientDetailsFrame.
 */
public class Client implements Subject<Client> {
    private final String lastName;
    private final String firstName;
    private final int id;

    private State state;

    private String lastAction;

    private final List<Observer<Client>> observers = new ArrayList<>();

    private static int nextId = 1;

    public Client(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.id = nextId++;

        this.state = new Silver(this);
    }

    public void bookFlightCash(Flight flight, TicketType ticketType) {
        double cost = flight.price() * ticketType.getCashCoefficient();
        if (!state.withdrawCash(cost)) {
            this.lastAction = String.format("Not enough credits (%.2f needed) to book %s in %s class", cost, flight.name(), ticketType.getName());
            notifyObservers();
            return;
        }

        state.depositMiles(flight.distance() * state.getMilesCoefficient());
        this.lastAction = String.format("Booked %s in %s class, using credits", flight.name(), ticketType.getName());
        notifyObservers();
    }

    public void bookFlightMiles(Flight flight, TicketType ticketType) {
        double cost = flight.distance() * ticketType.getMilesCoefficient();
        if (!state.withdrawMiles(cost)) {
            this.lastAction = String.format("Not enough miles (%.2f needed) to book %s in %s class", cost, flight.name(), ticketType.getName());
            notifyObservers();
            return;
        }

        this.lastAction = String.format("Booked %s in %s class, using miles", flight.name(), ticketType.getName());
        notifyObservers();
    }

    /**
     * Getter for the last name of the client.
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Getter for the first name of the client.
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Getter for the id of the client.
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Getter for the last action of the client.
     *
     * @return
     */
    public String getLastAction() {
        return lastAction;
    }

    /**
     * Getter for the balance of the client.
     *
     * @return
     */
    public double getBalance() {
        return state.getBalance();
    }

    /**
     * Getter for the miles of the client.
     *
     * @return
     */
    public double getMiles() {
        return state.getMiles();
    }

    /**
     * Getter for the state of the client.
     *
     * @return
     */
    public State getState() {
        return state;
    }

    /**
     * Setter for the state of the client.
     *
     * @param state
     */
    public void setState(State state) {
        this.state = state;
        notifyObservers();
    }

    /**
     * Add an amount of cash to the client's balance. Updates the state if necessary.
     * Then notifies the observers.
     *
     * @param amount of cash/credit to add
     */
    public void depositCash(double amount) {
        state.depositCash(amount);
        notifyObservers();
    }

    /**
     * Add an amount of miles to the client's miles. Updates the state if necessary.
     * Then notifies the observers.
     *
     * @param amount of miles to add
     */
    public void depositMiles(double amount) {
        state.depositMiles(amount);
        notifyObservers();
    }

    /**
     * Withdraw an amount of cash from the client's balance. Updates the state if necessary.
     * Then notifies the observers.
     *
     * @param amount of cash/credit to withdraw
     * @return true if the operation was successful, false otherwise
     */
    public boolean withdrawCash(double amount) {
        boolean ok = state.withdrawCash(amount);
        if (ok) {
            notifyObservers();
        }

        return ok;
    }

    /**
     * Withdraw an amount of miles from the client's miles. Updates the state if necessary.
     * Then notifies the observers.
     *
     * @param amount of miles to withdraw
     * @return true if the operation was successful, false otherwise
     */
    public boolean withdrawMiles(double amount) {
        boolean ok = state.withdrawMiles(amount);
        if (ok) {
            notifyObservers();
        }

        return ok;
    }

    /**
     * @return the string representation of the client.
     */
    public String toString() {
        return lastName + " " + firstName;
    }

    @Override
    public void attachObserver(Observer<Client> observer) {
        observers.add(observer);
    }

    @Override
    public void detachObserver(Observer<Client> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer<Client> observer : observers) {
            observer.update(this);
        }
    }
}
