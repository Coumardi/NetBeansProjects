/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author 13202
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author 13202
 */


import javax.swing.SwingUtilities;

public class NewMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CheckingAccount checking = new CheckingAccount("cheick", 300);
            SavingAccount saving = new SavingAccount("cheick", 100);
            new GUI(checking, saving);
        });
    }
}

