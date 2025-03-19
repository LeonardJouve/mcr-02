package main.state;
import main.Account;

public abstract class State {
    protected final Account account;

    protected State(Account account) {
        this.account = account;
    }

    protected void setState(State state) {
        account.setState(state);
    }

    public boolean depositCash(int amount) {
        account.depositCash(amount);
        return true;
    }

    public boolean depositMiles(int amount) {
        account.depositMiles(amount);
        return true;
    }

    public boolean withdrawCash(int amount) {
        return true;
    }

    public boolean withdrawMiles(int amount) {
        return true;
    }

    public abstract double getMilesCoefficient();

    public abstract boolean checkThreshold(double amount);
}
