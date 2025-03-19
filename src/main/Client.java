package main;

public class Client {
    private String lastName;
    private String firstName;
    private int id;

    private String lastAction;
    private Account account;

    private static int nextId = 1;

    public Client(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.id = nextId++;
    }
}
