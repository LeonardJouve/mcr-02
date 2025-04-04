package main.observer;

/**
 * Interface for observers in the Observer pattern.
 *
 * @param <T> the type of subject being observed
 */
public interface Observer<T extends Subject<?>> {

    /**
     * Update the observer with the new state of the subject.
     *
     * @param subject the subject that has changed
     */
    void update(T subject);
}
