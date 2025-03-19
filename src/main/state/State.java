package main.state;
import main.Account;

public abstract class State {
    private final Account account;

    protected State(Account account) {
        this.account = account;
    }

    public abstract void deposit(int amount);

    public abstract void withdraw(int amount);
}
