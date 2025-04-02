package main;

import main.observer.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatusFrame extends JFrame implements Observer<Client> {
    private static final int WIDTH = 300;
    private static final int HEIGHT = 200;

    private final Map<Integer, JLabel> labels;

    private String formatClient(Client client) {
        return client + " " + client.getState();
    }

    private void addContent(List<Client> clients) {
        List<Client> sortedClients = clients.stream()
                .sorted(Comparator.comparing(Client::toString))
                .toList();
        for (Client client : sortedClients) {
            JLabel label = new JLabel(formatClient(client));
            label.setForeground(client.getState().getColor());
            this.add(label);
            labels.put(client.getId(), label);
        }
    }

    public StatusFrame(List<Client> clients) {
        this.labels = new HashMap<>();
        for (Client client : clients) {
            client.attachObserver(this);
        }

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                for (Client client : clients) {
                    client.detachObserver(StatusFrame.this);
                }
            }
        });

        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Statuses");
        this.setVisible(true);
        setLayout(new GridLayout(clients.size(), 1));
        this.addContent(clients);
    }

    @Override
    public void update(Client client) {
        JLabel label = labels.get(client.getId());
        if (label == null) return;

        label.setText(formatClient(client));
        label.setForeground(client.getState().getColor());
    }
}
