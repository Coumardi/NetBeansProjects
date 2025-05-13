/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 13202
 */
public class Transaction {
    private int transactionID;
    private String transactionType;
    private final Account account;
    
    // transaction custractor
    public Transaction(int transactionID, String transactionType, Account account){
        this.transactionID=transactionID;
        this.transactionType=transactionType;
        this.account=account;
    
    }
    
    // getter and setter for transactionID and transactionType
    
    public void settransactionID(int transactionID){
        this.transactionID=transactionID;
    
    }
    public int gettransactionID(){
        return transactionID;
    
    }
    public void settransactionType(String transactionType){
        this.transactionType=transactionType;
    
    }
    public String gettransactionType(){
        return transactionType;
    
    }
    
    // deposit function that will update the balance in thr sccount class
           
    public void Deposit(double amount){
        
        if (amount >0)
        {
           
           account.setbalance(account.getbalance()+amount);
           //System.out.println("succesful deposit: actual balance: $" + account.getbalance());
           
        
        }
        else
        {
            System.out.println("deposit amount should be positive number");
            
        
        }
    
    }
    
    // withdrawal methode that will update the balanace in the account class 
    
    
    public double Withdraw(double amount){
        
        
        if (amount > account.getbalance())
        {
            if(account.getbalance()-amount>=-1000)
            {
                account.setbalance(account.getbalance()-amount);
                System.out.println("Overdraft but can overdraft up to 1000" + account.getbalance());
                return account.getbalance();
            }
            else
            {
                 System.out.println("overdraft limit");
                        return account.getbalance()-amount;

                
                        
                        
            }
                
            
            
            
}      
                

            
        
        else 
        {
             account.setbalance(account.getbalance()-amount);
                System.out.println("withdrawal successful");
                return account.getbalance();
            
        
        }
             
            
        }
       

        
    
    
    
    // function to check balance 
    public double CheckBalance(){
        
        return account.getbalance();
    
    }
}
