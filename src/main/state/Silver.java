package main.state;

import main.Client;

import java.awt.*;

/**
 * Represents the Silver state of a client as part of the State design pattern.
 * Can go up to Gold with enough miles.
 */
public class Silver extends State {
    private static final double MILES_COEFFICIENT = 0.1;

    public Silver(Client client) {
        super(client);
    }

    protected Silver(State state) {
        super(state);
    }

    @Override
    public double getMilesCoefficient() {
        return MILES_COEFFICIENT;
    }

    @Override
    protected void checkStateChange() {
        if (Gold.checkThreshold(this)) {
            setState(new Gold(this));
        }
    }

    @Override
    public String toString() {
        return "SILVER";
    }

    @Override
    public Color getColor() {
        return new Color(0xC0C0C0);
    }
}
