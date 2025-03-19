import javax.swing.*;
import java.awt.*;

public class Main {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    public static void main(String... args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(true);

        frame.setLayout(new GridLayout(4, 1));

        JPanel clientPanel = new JPanel();
        clientPanel.setLayout(new GridLayout(1, 3));
        clientPanel.add(new JLabel("Client"));
        clientPanel.add(new JButton("Details"));
        frame.add(clientPanel);

        JPanel creditsPanel = new JPanel();
        creditsPanel.setLayout(new GridLayout(1, 3));
        creditsPanel.add(new JLabel("Credits"));
        creditsPanel.add(new JTextField(20));
        creditsPanel.add(new JButton("Add"));
        frame.add(creditsPanel);

        JPanel flightPanel = new JPanel();
        flightPanel.setLayout(new GridLayout(1, 5));
        flightPanel.add(new JLabel("Flight"));
        flightPanel.add(new JButton("Book (cash)"));
        flightPanel.add(new JButton("Book (miles)"));
        flightPanel.add(new JButton("Book (miles)"));
        frame.add(flightPanel);

        JPanel actionsPanel = new JPanel();
        actionsPanel.setLayout(new GridLayout(1, 2));
        actionsPanel.add(new JButton("Statuses"));
        actionsPanel.add(new JButton("Quit"));
        frame.add(actionsPanel);

        frame.pack();
        frame.setVisible(true);

        frame.setTitle("Clients Manager");
    }
}
