/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 13202
 */

public class CheckingAccount extends BankAccount implements BankAccountInterface {
    private double insufficientFundsFee = 32;
    
    public CheckingAccount(String OwnerName, double OwnerBalance)
    {
        super(OwnerName, OwnerBalance);
    
    }
    
    // getter and setter for insufficientFundsFee
    
    public void setInsufficientFundsFee(double fee){
        
        insufficientFundsFee = fee;
    
    }
     
    public double getInsufficientFundsFee(){
        
        return insufficientFundsFee;
    
    }
    
      
      // process method 
    public void processCheck(CheckingAccount checkToProcess)
    {
         double checkAmount = checkToProcess.getOwnerBalance();
         
         if (checkAmount > getOwnerBalance())
         {
             System.out.println("Insufficient Found fee will be apply");
             setOwnerBalance(getOwnerBalance() - insufficientFundsFee);
         }
         else
         {
             withdrawal(checkAmount);
             
         
         }
            
         
    }
    
    // override withdral abstract methode declared in the Abstract BankAccount class 
  
    @Override
    public double withdrawal(double amount)
            
    {
       if(amount > getOwnerBalance()){
          setOwnerBalance(getOwnerBalance() - (insufficientFundsFee + amount));
          return getOwnerBalance();
      
      }
       else{
          setOwnerBalance(getOwnerBalance() - amount);
          return getOwnerBalance();
       }
    }
    
    @Override 
    public String toString()
    {
        return String.format("""
                             Account type: checking Account
                             Owner Name: %s
                             Curent Balance: $%.2f
                             Insufficient Funds Fee: $%.2f""",
                getOwnerName(),
                getOwnerBalance(),
                insufficientFundsFee);
                        
                
                           
    } 
    
}
