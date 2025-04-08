package main;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Main window frame.
 */
public class MainFrame extends JFrame {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private final Client[] clients;
    private final Flight[] flights;
    private Client selectedClient = null;

    /**
     * Create client panel row.
     */
    private void createClientPanel() {
        JPanel clientPanel = new JPanel();
        clientPanel.setLayout(new GridLayout(1, 3));
        clientPanel.add(new JLabel("Client"));

        JComboBox<Client> clientComboBox = new JComboBox<>(clients);

        // Set initial selectedClient value and update on select
        selectedClient = (Client) clientComboBox.getSelectedItem();
        clientComboBox.addActionListener(e -> {
            selectedClient = (Client) clientComboBox.getSelectedItem();
        });

        clientPanel.add(clientComboBox);

        JButton detailsButton = new JButton("Details");
        detailsButton.addActionListener(e -> {
            if (selectedClient == null) return;

            new ClientDetailFrame(selectedClient);
        });
        clientPanel.add(detailsButton);

        this.add(clientPanel);
    }

    /**
     * Create credits panel row.
     */
    private void createCreditsPanel() {
        JPanel creditsPanel = new JPanel();
        creditsPanel.setLayout(new GridLayout(1, 3));
        creditsPanel.add(new JLabel("Credits"));

        JTextField creditsField = new JTextField();
        creditsPanel.add(creditsField);

        JButton creditsAddButton = new JButton("Add");
        creditsAddButton.addActionListener(e -> {
            if (selectedClient == null) return;

            try {
                double credits = Double.parseDouble(creditsField.getText());
                selectedClient.depositCash(credits);
                creditsField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid number format", "Error", JOptionPane.ERROR_MESSAGE);
                creditsField.setText("");
            }
        });
        creditsPanel.add(creditsAddButton);

        this.add(creditsPanel);
    }

    /**
     * Create flight panel row.
     */
    private void createFlightPanel() {
        JPanel flightPanel = new JPanel();
        flightPanel.setLayout(new GridLayout(1, 5));
        flightPanel.add(new JLabel("Flight"));

        JComboBox<Flight> flightComboBox = new JComboBox<>(flights);
        flightPanel.add(flightComboBox);

        JComboBox<TicketType> ticketTypeComboBox = new JComboBox<>(TicketType.values());

        // Render ticket option as required
        ticketTypeComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean hasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, hasFocus);

                Flight flight = (Flight) flightComboBox.getSelectedItem();
                if (value instanceof TicketType ticketType && flight != null) {
                    setText(ticketType.getName() + " " + flight.price() * ticketType.getCashCoefficient() + "$");
                }

                return this;
            }
        });
        flightComboBox.addActionListener(e -> {
            ticketTypeComboBox.repaint();
        });

        flightPanel.add(ticketTypeComboBox);

        JButton bookFlightCash = new JButton("Book (cash)");
        bookFlightCash.addActionListener(e -> {
            Flight flight = (Flight) flightComboBox.getSelectedItem();
            TicketType ticketType = (TicketType) ticketTypeComboBox.getSelectedItem();

            if (selectedClient == null || flight == null || ticketType == null) return;

            selectedClient.bookFlightCash(flight, ticketType);
        });
        flightPanel.add(bookFlightCash);

        JButton bookFlightMiles = new JButton("Book (miles)");
        bookFlightMiles.addActionListener(e -> {
            Flight flight = (Flight) flightComboBox.getSelectedItem();
            TicketType ticketType = (TicketType) ticketTypeComboBox.getSelectedItem();

            if (selectedClient == null || flight == null || ticketType == null) return;

            selectedClient.bookFlightMiles(flight, ticketType);
        });
        flightPanel.add(bookFlightMiles);

        this.add(flightPanel);
    }

    /**
     * Create action panel row.
     */
    private void createActionPanel() {
        JPanel actionsPanel = new JPanel();
        actionsPanel.setLayout(new GridLayout(1, 2));

        JButton statusesButton = new JButton("Statuses");
        statusesButton.addActionListener(e -> {
            new StatusFrame(List.of(clients));
        });
        actionsPanel.add(statusesButton);

        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(e -> System.exit(0));
        actionsPanel.add(quitButton);

        this.add(actionsPanel);
    }

    public MainFrame(Client[] clients, Flight[] flights) {
        this.clients = clients;
        this.flights = flights;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setResizable(true);
        this.setTitle("Clients Manager");

        this.setLayout(new GridLayout(4, 1));

        this.createClientPanel();
        this.createCreditsPanel();
        this.createFlightPanel();
        this.createActionPanel();

        this.pack();
        this.setVisible(true);
    }
}
