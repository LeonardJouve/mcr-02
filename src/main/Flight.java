package main;

/**
 * Represents a flight in the system.
 * @param name the name of the flight
 * @param distance in miles
 * @param price in dollars
 */
public record Flight(String name, double distance, double price) {
    public String toString() {
        return name + " (" + distance + " miles)";
    }
}
