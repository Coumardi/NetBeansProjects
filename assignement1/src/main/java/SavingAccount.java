/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 13202
 */
public class SavingAccount extends AbstractBankAcount implements InterfaceBankAccount{
    
    
    private double annualInterestRate;
    
    public SavingAccount(String OwnerName, double OwnerBalance)
    {
        super(OwnerName, OwnerBalance);
    
    }
    
      
   @Override
   
   public double withdrawal(double amount)
   {
       setOwnerBalance(getOwnerBalance() - annualInterestRate);
      return getOwnerBalance();
   
   }
   
    @Override 
    public String toString()
    {
        return String.format("""
                             Account type: checking
                             Owner Name: %s
                             Curent Balance: $%.2f
                             annual interrest rate: $%.2f""",
                getOwnerName(),
                getOwnerBalance(),
                annualInterestRate);
                        
                
                           
    }

    
    
    
}
