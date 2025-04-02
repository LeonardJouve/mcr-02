package main;

public enum TicketType {
    ECONOMY("Economy", 1, 1),
    BUSINESS("Business", 2, 5),
    FIRST("First", 5, 30);

    private final String name;
    private final int cashCoefficient;
    private final int milesCoefficient;

    public String getName() {
        return name;
    }

    public int getCashCoefficient() {
        return cashCoefficient;
    }

    public int getMilesCoefficient() {
        return milesCoefficient;
    }

    TicketType(String name, int cashCoefficient, int milesCoefficient) {
        this.name = name;
        this.cashCoefficient = cashCoefficient;
        this.milesCoefficient = milesCoefficient;
    }
}
