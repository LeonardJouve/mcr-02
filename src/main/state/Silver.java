package main.state;

import main.Account;

public class Silver extends State {
    private static final double MILES_COEFFICIENT = 0.1;

    public Silver(Account account) {
        super(account);
    }

    protected Silver(State state) {
        super(state);
    }

    @Override
    public double getMilesCoefficient() {
        return MILES_COEFFICIENT;
    }

    @Override
    public void checkStateChange() {
        if (Gold.checkThreshold(this)) {
            setState(new Gold(this));
        }
    }

    @Override
    public String toString() {
        return "SILVER";
    }
}
