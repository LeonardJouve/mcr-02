package main.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for observed objects for the Observer pattern.
 */
public abstract class Subject<T extends Subject<?>> {
    private final List<Observer<T>> observers = new ArrayList<>();

    /**
     * Attach an observer to the subject.
     */
    public void attachObserver(Observer<T> observer) {
        if (observer == null) {
            throw new IllegalArgumentException("Observer cannot be null");
        }
        observers.add(observer);
    }

    /**
     * Detach an observer from the subject.
     */
    public void detachObserver(Observer<T> observer) {
        if (observer == null) {
            throw new IllegalArgumentException("Observer cannot be null");
        }
        observers.remove(observer);
    }

    /**
     * Notify all observers of a change in the subject. (calls update on each observer)
     */
    public void notifyObservers() {
        for (Observer<T> observer : observers) {
            observer.update((T) this);
        }
    }
}
