/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 13202
 * 
 */



public class CheckingAccount extends AbstractBankAcount implements InterfaceBankAccount{
    
    private double insufficientFundsFee;
    
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
             setOwnerBalance(getOwnerBalance() - insufficientFundsFee);
         }
         else
         {
             withdrawal(checkAmount);
             
         
         }
            
         
    }
  
    @Override
    public double withdrawal(double amount)
            
    {
       if (getOwnerBalance()>= amount)
       {
           setOwnerBalance(getOwnerBalance()- amount);
           return getOwnerBalance();
                  
       }
       else
       {
           setOwnerBalance(getOwnerBalance()- insufficientFundsFee);
           return getOwnerBalance();
       }
    }
    
    @Override 
    public String toString()
    {
        return String.format("""
                             Account type: checking
                             Owner Name: %s
                             Curent Balance: $%.2f
                             Insufficient Funds Fee: $%.2f""",
                getOwnerName(),
                getOwnerBalance(),
                insufficientFundsFee);
                        
                
                           
    } 
}
    
    
     
      
        
        
    
    
    
    
    
   
    
    
    
    
