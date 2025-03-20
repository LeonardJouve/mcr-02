package main.state;

import main.Account;

public class PlatinumState extends State {
    private static final double MILES_COEFFICIENT = 1;
    private static final int PLATINUM_CREDIT_THRESHOLD = 10000;

    public PlatinumState(Account account) {
        super(account);
    }

    @Override
    public double getMilesCoefficient() {
        return MILES_COEFFICIENT;
    }

    @Override
    public boolean checkThreshold(double amount) {
        return amount >= PLATINUM_CREDIT_THRESHOLD;
    }
}
