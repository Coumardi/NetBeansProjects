/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 13202
 */


public class DatabaseConfig {
    // Replace the Properties and static initialization block with hardcoded values
    private static final String DB_URL = "jdbc:mysql://localhost:3306/books";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "mysql";
    
    public static String getDbUrl() {
        return DB_URL;
    }
    
    public static String getDbUsername() {
        return DB_USERNAME;
    }
    
    public static String getDbPassword() {
        return DB_PASSWORD;
    }
}