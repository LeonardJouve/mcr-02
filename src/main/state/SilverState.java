package main.state;

import main.Account;

public class SilverState extends State {
    private static final double MILES_COEFFICIENT = 0.1;
    private static final int GOLD_MILES_THRESHOLD = 1000;

    public SilverState(Account account) {
        super(account);
    }

    @Override
    public double getMilesCoefficient() {
        return MILES_COEFFICIENT;
    }

    @Override
    public boolean checkThreshold(double amount) {
        return amount < GOLD_MILES_THRESHOLD;
    }
}
