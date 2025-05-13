/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 13202
 */


import javax.swing.*;

public class GUI extends JFrame {
    private CheckingAccount checkingAccount;
    private SavingAccount savingAccount;
    private final JLabel checkingBalanceLabel;
    private final JLabel savingBalanceLabel;
    private JTextField amountField;

    public GUI(CheckingAccount checking, SavingAccount saving) {
        this.checkingAccount = checking;
        this.savingAccount = saving;

        setTitle("Bank Account: Cheick");
        
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Checking Account Balance Label implementation
        checkingBalanceLabel = new JLabel("Checking Balance: $" + checkingAccount.getOwnerBalance());
        checkingBalanceLabel.setBounds(50, 20, 500, 30);
        add(checkingBalanceLabel);

        // Saving Account Balance Label implementation
        savingBalanceLabel = new JLabel("Saving Balance: $" + savingAccount.getOwnerBalance());
        savingBalanceLabel.setBounds(50, 50, 500, 30);
        add(savingBalanceLabel);

        // Text field for  input aount
        amountField = new JTextField();
        amountField.setBounds(50, 80, 200, 30);
        add(amountField);

        // Deposit to Checking Button implementation
        JButton depositCheckingButton = new JButton("Deposit to Checking");
        depositCheckingButton.setBounds(50, 120, 150, 30);
        depositCheckingButton.addActionListener(e -> {
            double amount = Double.parseDouble(amountField.getText());
            checkingAccount.deposit(amount);
            updateBalance();
        });
        add(depositCheckingButton);

        // Withdraw from Checking Button implementation
        JButton withdrawCheckingButton = new JButton("Withdraw from Checking");
        withdrawCheckingButton.setBounds(210, 120, 200, 30);
        withdrawCheckingButton.addActionListener(e -> {
            double amount = Double.parseDouble(amountField.getText());
            checkingAccount.withdrawal(amount);
            updateBalance();
        });
        add(withdrawCheckingButton);

        // Deposit to Saving Button implementation
        JButton depositSavingButton = new JButton("Deposit to Saving");
        depositSavingButton.setBounds(50, 160, 150, 30);
        depositSavingButton.addActionListener(e -> {
            double amount = Double.parseDouble(amountField.getText());
            savingAccount.deposit(amount);
            updateBalance();
        });
        add(depositSavingButton);

        // Withdraw from Saving Button implementation
        JButton withdrawSavingButton = new JButton("Withdraw from Saving");
        withdrawSavingButton.setBounds(210, 160, 200, 30);
        withdrawSavingButton.addActionListener(e -> {
            double amount = Double.parseDouble(amountField.getText());
            savingAccount.withdrawal(amount);
            updateBalance();
        });
        add(withdrawSavingButton);

        setVisible(true);
    }

    private void updateBalance() {
        checkingBalanceLabel.setText("Checking Balance: $" + checkingAccount.getOwnerBalance());
        savingBalanceLabel.setText("Saving Balance: $" + savingAccount.getOwnerBalance());
    }
}
