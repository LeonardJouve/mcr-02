package main.state;

public class PermanentPlatinum extends State {
    private static final double MILES_COEFFICIENT = 1;
    private static final int PERMANENT_PLATINUM_CREDIT_THRESHOLD = 100000;

    protected PermanentPlatinum(State state) {
        super(state);
    }

    @Override
    protected double getMilesCoefficient() {
        return MILES_COEFFICIENT;
    }

    protected static boolean checkThreshold(State state) {
        return state.getBalance() >= PERMANENT_PLATINUM_CREDIT_THRESHOLD;
    }

    @Override
    protected void checkStateChange() {
    }

    @Override
    public String toString() {
        return "PERMANENT PLATINUM";
    }
}
