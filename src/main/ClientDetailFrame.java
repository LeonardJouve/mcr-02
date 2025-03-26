package main;

import javax.swing.*;

import main.observer.Observer;

import java.awt.*;

public class ClientDetailFrame extends JFrame implements Observer {
    private static final int WIDTH = 300;
    private static final int HEIGHT = 200;

    private Client client;

    JLabel lastNameLabel = new JLabel("Last name:");
    JTextField lastNameField = new JTextField(20);
    JLabel firstNameLabel = new JLabel("First name:");
    JTextField firstNameField = new JTextField(20);
    JLabel creditsLabel = new JLabel("Credits:");
    JTextField creditsField = new JTextField(20);
    JLabel milesLabel = new JLabel("Nb miles:");
    JTextField milesField = new JTextField(20);
    JLabel statusLabel = new JLabel("Status:");
    JTextField statusField = new JTextField(20);
    JLabel lastActionLabel = new JLabel("Last action:");
    JTextField lastActionField = new JTextField(20);

    private void addContent() {
        lastNameField.setEditable(false);
        this.add(lastNameLabel);
        this.add(lastNameField);

        firstNameField.setEditable(false);
        this.add(firstNameLabel);
        this.add(firstNameField);

        creditsField.setEditable(false);
        this.add(creditsLabel);
        this.add(creditsField);

        milesField.setEditable(false);
        this.add(milesLabel);
        this.add(milesField);

        statusField.setEditable(false);
        this.add(statusLabel);
        this.add(statusField);

        lastActionField.setEditable(false);
        this.add(lastActionLabel);
        this.add(lastActionField);
    }

    public ClientDetailFrame(Client client) {
        this.client = client;
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Client Details");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
