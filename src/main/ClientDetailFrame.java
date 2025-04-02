package main;

import javax.swing.*;

import main.observer.Observer;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClientDetailFrame extends JFrame implements Observer<Client> {
    private static final int WIDTH = 300;
    private static final int HEIGHT = 200;

    private final JLabel lastNameLabel = new JLabel("Last name:");
    private final JLabel lastNameValue = new JLabel();
    private final JLabel firstNameLabel = new JLabel("First name:");
    private final JLabel firstNameValue = new JLabel();
    private final JLabel creditsLabel = new JLabel("Credits:");
    private final JLabel creditsValue = new JLabel();
    private final JLabel milesLabel = new JLabel("Nb miles:");
    private final JLabel milesValue = new JLabel();
    private final JLabel statusLabel = new JLabel("Status:");
    private final JLabel statusValue = new JLabel();
    private final JLabel lastActionLabel = new JLabel("Last action:");
    private final JLabel lastActionValue = new JLabel();

    private void addContent() {
        this.add(lastNameLabel);
        this.add(lastNameValue);

        this.add(firstNameLabel);
        this.add(firstNameValue);

        this.add(creditsLabel);
        this.add(creditsValue);

        this.add(milesLabel);
        this.add(milesValue);

        this.add(statusLabel);
        this.add(statusValue);

        this.add(lastActionLabel);
        this.add(lastActionValue);
    }

    public ClientDetailFrame(Client client) {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Client Details");
        this.setVisible(true);
        this.setLayout(new GridLayout(6, 2));
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                client.detachObserver(ClientDetailFrame.this);
            }
        });
        client.attachObserver(this);
        this.addContent();
        this.update(client);
    }

    @Override
    public void update(Client client) {
        lastNameValue.setText(client.getLastName());
        firstNameValue.setText(client.getFirstName());
        creditsValue.setText(String.valueOf(client.getBalance()));
        milesValue.setText(String.valueOf(client.getMiles()));
        statusValue.setText(client.getState().toString());
        lastActionValue.setText(client.getLastAction());
    }
}
