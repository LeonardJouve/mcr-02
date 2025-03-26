package main.state;

public class Gold extends State {
    private static final double MILES_COEFFICIENT = 0.5;
    private static final int GOLD_MILES_THRESHOLD = 1_000;

    protected Gold(State state) {
        super(state);
    }

    @Override
    protected double getMilesCoefficient() {
        return MILES_COEFFICIENT;
    }

    protected static boolean checkThreshold(State state) {
        return state.getMiles() >= GOLD_MILES_THRESHOLD;
    }

    @Override
    protected void checkStateChange() {
        if (Platinum.checkThreshold(this)) {
            setState(new Platinum(this));
        } else if (!checkThreshold(this)) {
            setState(new Silver(this));
        }
    }

    @Override
    public String toString() {
        return "GOLD";
    }
}
