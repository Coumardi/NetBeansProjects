/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author 13202
 */
// Main.java
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class Main {
    public static void main(String[] args) {
        // Test database connection
        try (Connection connection = MySQLConnection.connect()) {
            System.out.println("Connected to the MySQL database successfully.");
            
            // Launch the GUI application
            SwingUtilities.invokeLater(() -> {
                new App();
            });
        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
