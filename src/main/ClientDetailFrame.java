package main;

import main.observer.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Displays all information of a client.
 * Implements the Observer pattern to update client details.
 */
public class ClientDetailFrame extends JFrame implements Observer<Client> {
    private static final int WIDTH = 300;
    private static final int HEIGHT = 200;

    private final JLabel lastNameLabel = new JLabel();
    private final JLabel firstNameLabel = new JLabel();
    private final JLabel creditsLabel = new JLabel();
    private final JLabel milesLabel = new JLabel();
    private final JLabel statusLabel = new JLabel();
    private final JLabel lastActionLabel = new JLabel();

    /**
     * Adds all labels to the frame.
     */
    private void addContent() {
        this.add(lastNameLabel);
        this.add(firstNameLabel);
        this.add(creditsLabel);
        this.add(milesLabel);
        this.add(statusLabel);
        this.add(lastActionLabel);
    }

    public ClientDetailFrame(Client client) {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Client Details");
        this.setVisible(true);
        this.setLayout(new GridLayout(6, 1));
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
        lastNameLabel.setText("Last name: " + client.getLastName());
        firstNameLabel.setText("First name: " + client.getFirstName());
        creditsLabel.setText("Credits: " + client.getBalance());
        milesLabel.setText("Nb miles: " + client.getMiles());
        statusLabel.setText("Status: " + client.getState().toString());
        lastActionLabel.setText("Last action: " + client.getLastAction());
    }
}
