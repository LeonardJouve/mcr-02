package main;

public record Flight(String name, double distance, double price) {
    public String toString() {
        return name + " (" + distance + " miles)";
    }
}
