/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 13202
 */
public class Account {
    private int accountNumber;
    private double balance;
    private final Customer customer;
    
    
     // account cunstructor
    public Account(Customer customer, int accountNumber){
        this.accountNumber=accountNumber;
        this.balance = 0.00;
        this.customer= customer;
          
    }  
    // setter and getter for accountNumber and balance
    
    
    public void setaccountNumber(int accountNumber){
        this.accountNumber=accountNumber;
    
    }
    public int getaccountNumber(){
        return accountNumber;
    
    }
    
    public void setbalance(double balance){
        this.balance=balance;
        
    
    }
    public double getbalance(){
        return balance;
    
    }
    
    public Customer setCustomer(){
        return customer;
    
    }

    
    
   
    
}
