package main.state;

import java.awt.*;

/**
 * Represents the Permanent Platinum state of a client as part of the State design pattern.
 * This state is achieved when the client is in Platinum state and has enough cash/credit.
 * It is a permanent state and cannot be changed.
 */
public class PermanentPlatinum extends State {
    private static final double MILES_COEFFICIENT = 1;
    private static final int PERMANENT_PLATINUM_CREDIT_THRESHOLD = 100_000;

    protected PermanentPlatinum(State state) {
        super(state);
    }

    @Override
    public double getMilesCoefficient() {
        return MILES_COEFFICIENT;
    }

    /**
     * Check if the client has enough cash/credit to be in Permanent Platinum state.
     * @param state the current state of the client
     * @return true if the client has enough cash/credit, false otherwise
     */
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

    @Override
    public Color getColor() {
        return new Color(0xE5E4E2);
    }
}
