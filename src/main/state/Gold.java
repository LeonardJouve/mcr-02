package main.state;

import java.awt.*;

/**
 * Represents the Gold state in the state pattern.
 * Can go up to Platinum with enough miles.
 * Can go down to Silver if miles are below the threshold.
 */
public class Gold extends State {
    private static final double MILES_COEFFICIENT = 0.5;
    private static final int GOLD_MILES_THRESHOLD = 1_000;

    protected Gold(State state) {
        super(state);
    }

    @Override
    public double getMilesCoefficient() {
        return MILES_COEFFICIENT;
    }

    /**
     * Check if the client has enough miles to be in Gold state.
     *
     * @param state the current state of the client
     * @return true if the client has enough miles, false otherwise
     */
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

    @Override
    public Color getColor() {
        return new Color(0xFFD700);
    }
}
