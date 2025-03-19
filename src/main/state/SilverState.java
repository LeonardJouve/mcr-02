package main.state;

import main.Account;

public class SilverState extends State {
    private static final double MILES_COEFFICIENT = 0.1;
    private static final int GOLD_MILES_THRESHOLD = 1000;

    SilverState(Account account) {
        super(account);
    }

    @Override
    public boolean depositCash(int amount) {
        return true;
    }

    @Override
    public boolean depositMiles(int amount) {
        return true;
    }

    @Override
    public boolean withdrawCash(int amount) {
        return true;
    }

    @Override
    public boolean withdrawMiles(int amount) {
        return true;
    }

    @Override
    public double getMilesCoefficient() {
        return MILES_COEFFICIENT;
    }
}
