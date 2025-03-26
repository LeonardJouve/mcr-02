package main.state;

import main.Account;

public class Platinum extends State {
    private static final double MILES_COEFFICIENT = 1;
    private static final int PLATINUM_CREDIT_THRESHOLD = 10000;

    protected Platinum(State state) {
        super(state);
    }

    @Override
    public double getMilesCoefficient() {
        return MILES_COEFFICIENT;
    }

    public static boolean checkThreshold(State state) {
        return state.getBalance() >= PLATINUM_CREDIT_THRESHOLD;
    }

    @Override
    public void checkStateChange() {
        if (PermanentPlatinum.checkThreshold(this)) {
            setState(new PermanentPlatinum(this));
        }
    }
}
