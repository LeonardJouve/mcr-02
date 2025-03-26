package main.state;

import main.Client;

public class Silver extends State {
    private static final double MILES_COEFFICIENT = 0.1;

    public Silver(Client client) {
        super(client);
    }

    protected Silver(State state) {
        super(state);
    }

    @Override
    protected double getMilesCoefficient() {
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
}
