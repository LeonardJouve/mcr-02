package main.state;

import main.Account;

public class PermanentPlatinum extends State {
    private static final double MILES_COEFFICIENT = 1;
    private static final int PERMANENT_PLATINUM_CREDIT_THRESHOLD = 100000;

    protected PermanentPlatinum(Account account) {
        super(account);
    }

    @Override
    public double getMilesCoefficient() {
        return MILES_COEFFICIENT;
    }

    @Override
    public boolean checkThreshold(double amount) {
        return amount >= PERMANENT_PLATINUM_CREDIT_THRESHOLD;
    }
}
