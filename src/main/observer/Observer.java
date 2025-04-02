package main.observer;

/**
 * Interface for observers in the Observer pattern.
 *
 * @param <T> the type of subject being observed
 */
public interface Observer<T extends Subject> {

    /**
     * Update method to be called when the subject changes.
     *
     * @param subject the subject that has changed
     */
    void update(T subject);
}
