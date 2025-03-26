package main;

import javax.swing.*;

import main.observer.Observer;

import java.awt.*;

public class ClientDetailFrame extends JFrame implements Observer {
    private static final int WIDTH = 300;
    private static final int HEIGHT = 200;

    private Client client;

    private JLabel lastNameLabel = new JLabel("Last name:");
    private JLabel lastNameField = new JLabel();
    private JLabel firstNameLabel = new JLabel("First name:");
    private JLabel firstNameField = new JLabel();
    private JLabel creditsLabel = new JLabel("Credits:");
    private JLabel creditsField = new JLabel();
    private JLabel milesLabel = new JLabel("Nb miles:");
    private JLabel milesField = new JLabel();
    private JLabel statusLabel = new JLabel("Status:");
    private JLabel statusField = new JLabel();
    private JLabel lastActionLabel = new JLabel("Last action:");
    private JLabel lastActionField = new JLabel();

    private void addContent() {
        this.add(lastNameLabel);
        this.add(lastNameField);

        this.add(firstNameLabel);
        this.add(firstNameField);

        this.add(creditsLabel);
        this.add(creditsField);

        this.add(milesLabel);
        this.add(milesField);

        this.add(statusLabel);
        this.add(statusField);

        this.add(lastActionLabel);
        this.add(lastActionField);
    }

    public ClientDetailFrame(Client client) {
        this.client = client;
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Client Details");
        this.setVisible(true);
        this.setLayout(new GridLayout(6, 1));

        this.addContent();
        this.update();
    }

    @Override
    public void update() {
        lastNameField.setText(client.getLastName());
        firstNameField.setText(client.getFirstName());
        creditsField.setText(String.valueOf(client.getAccount().getBalance()));
        milesField.setText(String.valueOf(client.getAccount().getMiles()));
        statusField.setText(client.getAccount().getState().toString());
        lastActionField.setText(client.getLastAction());
    }
}
