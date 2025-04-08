package main;

public class Main {
    private final static Client[] clients = {
            new Client("Doe", "John"),
            new Client("Smith", "Jane"),
            new Client("John", "Smith"),
            new Client("Mary", "Jane"),
    };

    private final static Flight[] flights = {
            new Flight("Flight 1", 1200, 300),
            new Flight("Flight 2", 8000, 1000),
            new Flight("Flight 3", 3000, 300),
            new Flight("Flight 4", 4000, 400),
    };

    public static void main(String... args) {
        new MainFrame(clients, flights);
    }
}
