package main.state;

public class Platinum extends State {
    private static final double MILES_COEFFICIENT = 1;
    private static final int PLATINUM_MILES_THRESHOLD = 10_000;

    protected Platinum(State state) {
        super(state);
    }

    @Override
    protected double getMilesCoefficient() {
        return MILES_COEFFICIENT;
    }

    protected static boolean checkThreshold(State state) {
        return state.getMiles() >= PLATINUM_MILES_THRESHOLD;
    }

    @Override
    protected void checkStateChange() {
        if (PermanentPlatinum.checkThreshold(this)) {
            setState(new PermanentPlatinum(this));
        }
    }

    @Override
    public String toString() {
        return "PLATINUM";
    }
}
