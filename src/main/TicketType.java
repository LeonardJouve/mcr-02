package main;

/**
 * Enum defining the different tickets available.
 */
public enum TicketType {
    ECONOMY("Economy", 1, 1),
    BUSINESS("Business", 2, 5),
    FIRST("First", 5, 30);

    private final String name;
    private final int cashCoefficient;
    private final int milesCoefficient;

    /**
     * Get the name of the ticket type.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the cash coefficient of the ticket type.
     */
    public int getCashCoefficient() {
        return cashCoefficient;
    }

    /**
     * Get the miles coefficient of the ticket type.
     */
    public int getMilesCoefficient() {
        return milesCoefficient;
    }

    TicketType(String name, int cashCoefficient, int milesCoefficient) {
        this.name = name;
        this.cashCoefficient = cashCoefficient;
        this.milesCoefficient = milesCoefficient;
    }
}
