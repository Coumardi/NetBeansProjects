/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author 13202
 * 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class NewMain extends JFrame {
    private JTextField amount_Field;
    private JLabel balanceLabel;
    private final JButton depositButton, withdrawButton, checkBalanceButton;
    
    private final Customer customer;
    private final Account account;
    private Transaction transaction;

    public NewMain() {
        // create objects for Customer and Account
        customer = new Customer(111, "Cheick", "8th Avenue", 124345244);
        account = new Account(customer, 1001);
        transaction = new Transaction(1001, "deposit", account);
        
        // JFrame set up
        setTitle("Bank Account System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Components
        JLabel amountLabel = new JLabel("Enter Amount:");
        amount_Field = new JTextField(10);
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        checkBalanceButton = new JButton("Check Balance");
        balanceLabel = new JLabel("Current Balance: $" + transaction.CheckBalance());

        // Add components to JFrame
        add(amountLabel);
        add(amount_Field);
        add(depositButton);
        add(withdrawButton);
        add(checkBalanceButton);
        add(balanceLabel);

        // deposit Button Actions
        depositButton.addActionListener((ActionEvent e) -> {
            double amount = Double.parseDouble(amount_Field.getText());
            transaction.Deposit(amount);
            JOptionPane.showMessageDialog(null, "Successful Deposited of: $" + amount);
        });
       // withdraw button
   withdrawButton.addActionListener((ActionEvent e) -> {
    double amount = Double.parseDouble(amount_Field.getText());
    double updatedBalance = transaction.Withdraw(amount); 
    if (updatedBalance < 0) { // Check if the account is overdrafted
        if (updatedBalance >= -1000) { 
            int choice = JOptionPane.showConfirmDialog(null, 
                "your account is about to be overdraft  $" + updatedBalance + 
                "\nDo you want to proceed?", "Overdraft Confirmation", 
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (choice == JOptionPane.YES_OPTION) { 
                
                JOptionPane.showMessageDialog(null, "Successful Withdrawal of: $" + amount);
            } else { 
                JOptionPane.showMessageDialog(null, "Transaction Cancelled.");
            }
        } else { 
            JOptionPane.showMessageDialog(null, "Overdraft limit exceeded! .");
        }
    } else { 
        
        JOptionPane.showMessageDialog(null, "Successful Withdrawal of: $" + amount);
    }
});
   
   // check balance button
   checkBalanceButton.addActionListener((ActionEvent e)->{
       balanceLabel.setText("Current balance : $" + transaction.CheckBalance());
   
   
   });

        // Set JFrame visibility
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> new NewMain());
    }
}