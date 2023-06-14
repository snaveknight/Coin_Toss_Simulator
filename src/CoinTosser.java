

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Random;
import java.util.HashMap;

public class CoinTosser extends JFrame implements ActionListener {
    private JLabel  resultLabel;
    private JButton tossButton;
    private Map<Boolean, Integer> statistics;

    public CoinTosser() {
        setTitle("Coin Toss Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        tossButton = new JButton("Toss Silver Coin");
        tossButton.addActionListener(this);
        add(tossButton);

        resultLabel = new JLabel();
        add(resultLabel);

        statistics = new HashMap<>();
        statistics.put(true, 0); // Heads count
        statistics.put(false, 0); // Tails count
        
        pack();
        setLocationRelativeTo (null); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tossButton) {
            // Simulate a coin toss
            boolean isHeads = performCoinToss();

            // Update statistics
            int count = statistics.get(isHeads);
            statistics.put(isHeads, count + 1);

            // Display the result
            String resultText = isHeads ? "Heads" : "Tails";
            resultLabel.setText("Result: " + resultText);

            // Print statistics
            printStatistics();
        }
    }

    private boolean performCoinToss() {
        Random random = new Random();
        return random.nextBoolean();
    }
    
    private void printStatistics() {
        int headsCount = statistics.get(true);
        int tailsCount = statistics.get(false);
        int totalCount = headsCount + tailsCount;

        System.out.println("Statistics:");
        System.out.println("Heads: " + headsCount);
        System.out.println("Tails: " + tailsCount);
        System.out.println("Total: " + totalCount);
        System.out.println("Percentage of Heads: " + calculatePercentage(headsCount, totalCount) + "%");
        System.out.println("Percentage of Tails: " + calculatePercentage(tailsCount, totalCount) + "%");
        System.out.println();
    }
    
    private double calculatePercentage(int count, int totalCount) {
        return (double) count / totalCount * 100;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CoinTosser app = new CoinTosser();
                app.setVisible(true);
            }
        });
    }
}








