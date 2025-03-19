
public class Client {
    private String name;
    private String firstName;
    private int id;

    private String lastAction;
    private Account account;

    private static int nextId = 1;

    public Client(String name, String firstName) {
        this.name = name;
        this.firstName = firstName;
        this.id = nextId++;
    }
}
