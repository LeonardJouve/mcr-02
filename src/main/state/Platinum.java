package main.state;

import java.awt.*;

/**
 * Represents the Platinum state in the state pattern.
 * Can go up to PermanentPlatinum with enough cash/credit.
 * Can go down to Gold if miles are below the threshold.
 */
public class Platinum extends State {
    private static final double MILES_COEFFICIENT = 1;
    private static final int PLATINUM_MILES_THRESHOLD = 10_000;

    protected Platinum(State state) {
        super(state);
    }

    @Override
    public double getMilesCoefficient() {
        return MILES_COEFFICIENT;
    }

    /**
     * Check if the client has enough miles to be in Platinum state.
     *
     * @param state the current state of the client
     * @return true if the client has enough miles, false otherwise
     */
    protected static boolean checkThreshold(State state) {
        return state.getMiles() >= PLATINUM_MILES_THRESHOLD;
    }

    @Override
    protected void checkStateChange() {
        if (PermanentPlatinum.checkThreshold(this)) {
            setState(new PermanentPlatinum(this));
        } else if (!checkThreshold(this)) {
            setState(new Gold(this));
        }
    }

    @Override
    public String toString() {
        return "PLATINUM";
    }

    @Override
    public Color getColor() {
        return new Color(0xE5E4E2);
    }
}
