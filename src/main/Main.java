package main;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Main {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    private final static Client[] clients = {
            new Client("Doe", "John"),
            new Client("Smith", "Jane"),
            new Client("John", "Smith"),
            new Client("Mary", "Jane"),
    };

    private final static Flight[] flights = {
            new Flight("Flight 1", 1200, 300),
            new Flight("Flight 2", 8000, 1000),
            new Flight("Flight 3", 3000, 300),
            new Flight("Flight 4", 4000, 400),
    };

    public static void main(String... args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(true);

        frame.setLayout(new GridLayout(4, 1));

        JPanel clientPanel = new JPanel();
        clientPanel.setLayout(new GridLayout(1, 3));
        clientPanel.add(new JLabel("Client"));

        JComboBox<Client> clientComboBox = new JComboBox<>(clients);
        clientPanel.add(clientComboBox);

        JButton detailsButton = new JButton("Details");
        detailsButton.addActionListener(e -> {
            Client client = (Client) clientComboBox.getSelectedItem();
            if (client == null) return;

            new ClientDetailFrame(client);
        });
        clientPanel.add(detailsButton);

        frame.add(clientPanel);

        JPanel creditsPanel = new JPanel();
        creditsPanel.setLayout(new GridLayout(1, 3));
        creditsPanel.add(new JLabel("Credits"));

        JTextField creditsField = new JTextField();
        creditsPanel.add(creditsField);

        JButton creditsAddButton = new JButton("Add");
        creditsAddButton.addActionListener(e -> {
            Client selectedClient = (Client) clientComboBox.getSelectedItem();
            if (selectedClient == null) return;

            try {
                double credits = Double.parseDouble(creditsField.getText());
                selectedClient.depositCash(credits);
                creditsField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid number format", "Error", JOptionPane.ERROR_MESSAGE);
                creditsField.setText("");
            }
        });
        creditsPanel.add(creditsAddButton);

        frame.add(creditsPanel);

        JPanel flightPanel = new JPanel();
        flightPanel.setLayout(new GridLayout(1, 5));
        flightPanel.add(new JLabel("Flight"));

        JComboBox<Flight> flightComboBox = new JComboBox<>(flights);
        flightPanel.add(flightComboBox);

        JComboBox<TicketType> ticketTypeComboBox = new JComboBox<>(TicketType.values());
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
            Client client = (Client) clientComboBox.getSelectedItem();
            Flight flight = (Flight) flightComboBox.getSelectedItem();
            TicketType ticketType = (TicketType) ticketTypeComboBox.getSelectedItem();

            if (client == null || flight == null || ticketType == null) return;

            client.bookFlightCash(flight, ticketType);
        });
        flightPanel.add(bookFlightCash);

        JButton bookFlightMiles = new JButton("Book (miles)");
        bookFlightMiles.addActionListener(e -> {
            Client client = (Client) clientComboBox.getSelectedItem();
            Flight flight = (Flight) flightComboBox.getSelectedItem();
            TicketType ticketType = (TicketType) ticketTypeComboBox.getSelectedItem();

            if (client == null || flight == null || ticketType == null) return;

            client.bookFlightMiles(flight, ticketType);
        });
        flightPanel.add(bookFlightMiles);

        frame.add(flightPanel);

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

        frame.add(actionsPanel);

        frame.pack();
        frame.setVisible(true);

        frame.setTitle("Clients Manager");
    }
}
