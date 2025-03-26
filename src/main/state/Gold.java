package main.state;

import main.Account;

public class Gold extends State {
    private static final double MILES_COEFFICIENT = 0.5;
    private static final int GOLD_MILES_THRESHOLD = 1000;

    protected Gold(State state) {
        super(state);
    }

    @Override
    public double getMilesCoefficient() {
        return MILES_COEFFICIENT;
    }

    public static boolean checkThreshold(State state) {
        return state.getMilesCoefficient() >= GOLD_MILES_THRESHOLD;
    }

    @Override
    public void checkStateChange() {
        if (Platinum.checkThreshold(this)) {
            setState(new Platinum(this));
        } else if (!checkThreshold(this)) {
            setState(new Silver(this));
        }
    }
}
