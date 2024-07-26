import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATM {
    private JFrame f;
    private double bal;
    private JTextField amtField;

    public ATM() {
        bal = 1000;
        f = new JFrame("ATM");

        f.getContentPane().setBackground(Color.LIGHT_GRAY);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH); // Set to fullscreen

        f.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title label
        JLabel title = new JLabel("WELCOME TO ATM", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 44));
        title.setForeground(Color.RED);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        f.add(title, gbc);

        // Amount label
        JLabel amountLabel = new JLabel("Enter amount:");
        amountLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        amountLabel.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        f.add(amountLabel, gbc);

        // Amount text field
        amtField = new JTextField(20);
        amtField.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.gridx = 1;
        gbc.gridy = 1;
        f.add(amtField, gbc);

        // Deposit button
        JButton depBtn = new JButton("Deposit");
        depBtn.setFont(new Font("Arial", Font.BOLD, 18));
        depBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deposit();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        f.add(depBtn, gbc);

        // Withdraw button
        JButton withBtn = new JButton("Withdraw");
        withBtn.setFont(new Font("Arial", Font.BOLD, 18));
        withBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withdraw();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        f.add(withBtn, gbc);

        // Check Balance button
        JButton chkBalBtn = new JButton("Check Balance");
        chkBalBtn.setFont(new Font("Arial", Font.BOLD, 18));
        chkBalBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkBalance();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        f.add(chkBalBtn, gbc);

        // Exit button
        JButton exitBtn = new JButton("Exit");
        exitBtn.setFont(new Font("Arial", Font.BOLD, 18));
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        f.add(exitBtn, gbc);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    // method for deposition
    private void deposit() {
        String amtStr = amtField.getText();
        if (amtStr != null && !amtStr.isEmpty()) {
            try {
                double amt = Double.parseDouble(amtStr);
                if (amt > 0) {
                    bal += amt;
                    amtField.setText("");
                    JOptionPane.showMessageDialog(f, "Deposit Successful !! ");
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(f, "Please enter a valid amount", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    // Method for withdrawal
    private void withdraw() {
        String amtStr = amtField.getText();
        if (amtStr != null && !amtStr.isEmpty()) {
            try {
                double amt = Double.parseDouble(amtStr);
                if (amt > 0 && amt <= bal) {
                    bal -= amt;
                    amtField.setText("");
                    JOptionPane.showMessageDialog(f, "Withdrawal Successful !! ");
                } else if (amt > bal) {
                    JOptionPane.showMessageDialog(f, "Insufficient balance", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(f, "Please enter a valid amount", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    // Method
    private void checkBalance() {
        JOptionPane.showMessageDialog(f, "Your current balance is: $" + bal);
    }

    public static void main(String[] args) {
        new ATM();
    }
}
