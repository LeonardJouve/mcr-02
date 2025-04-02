package main.observer;

/**
 * Interface for observed objects for the Observer pattern.
 */
public interface Subject<T extends Subject> {

    /**
     * Attach an observer to the subject.
     *
     * @param observer
     */
    void attachObserver(Observer<T> observer);

    /**
     * Detach an observer from the subject.
     *
     * @param observer
     */
    void detachObserver(Observer<T> observer);

    /**
     * Notify all observers of a change in the subject. (calls update on each observer)
     */
    void notifyObservers();
}
