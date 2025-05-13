/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 13202
 */

public abstract class BankAccount {
    private String name;
    private double balance;
    
    // constructor
    
    public BankAccount(String OwnerName, double OwnerBalance)
    {
        name = OwnerName;
        balance = OwnerBalance;
    
    }
       
    // setter and getter for Owner name and balance
    
    public void setOwnerName(String OwnerName)
    {
        name = OwnerName;
    }
    
    public String getOwnerName()
    {
        return name;
    }
    
    public void setOwnerBalance(double OwnerBalance)
    {
        balance = OwnerBalance;
    }
    
    public double getOwnerBalance()
    {
        return balance;
              
    }
    
   // deposit methode 
    public double deposit(double amount)
    {
        
      setOwnerBalance(getOwnerBalance() + amount);
      return getOwnerBalance();
      
    
    }
    
    // overide tostring for BankAcount abject
    @Override
    public String toString()
    {
        return String.format("owner Name: %s, Balance: $%.2f",
                
                        getOwnerName() ,
                        getOwnerBalance()
         );
        
    }
                 
    // abstract class that will be implemented in the subclass checking acouunt 
    // and saving account
    public abstract double withdrawal(double amount);
    
}
