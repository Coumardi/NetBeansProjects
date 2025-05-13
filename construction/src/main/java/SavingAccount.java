/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 13202
 */


public class SavingAccount extends BankAccount implements BankAccountInterface {
    
    private final double annualInterestRate = 0.23;
    
    public SavingAccount(String OwnerName, double OwnerBalance)
    {
        super(OwnerName, OwnerBalance);
    
    }
    
    // override withdraw abstract methode  
   @Override
   public double withdrawal(double amount)
   {
      if(amount > getOwnerBalance()){
          setOwnerBalance(getOwnerBalance()-amount);
          return getOwnerBalance();
      
      }
      else
      {
          setOwnerBalance(getOwnerBalance() - amount);
          return getOwnerBalance();
      
      }
      
   
   }
   
   // monthly interest rate methode
   
   public void depositMontlyInterestRate(){
    
    setOwnerBalance(getOwnerBalance()-(getOwnerBalance()*annualInterestRate));

}
     
    @Override 
    public String toString()
    {
        return String.format("""
                             Account type: Saving Account
                             Owner Name: %s
                             Curent Balance: $%.2f
                             annual interrest rate: $%.2f""",
                getOwnerName(),
                getOwnerBalance(),
                annualInterestRate *100);
                        
                
                           
    }
    
}
