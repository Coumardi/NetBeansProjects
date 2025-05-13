/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 13202
 */
public class Customer {
    private int customerId;
    private String customerName;
    private String customerAddress;
    private int customerPhoneNumber;
    
    
    // constractor for customer 
    public Customer(int customerId, String customerName, String customerAddress, int customerPhoneNumber){
        this.customerName= customerName;
        this.customerAddress=customerAddress;
        this.customerId=customerId;
        this.customerPhoneNumber= customerPhoneNumber;
    
    }
    // setter and getter for customerid, customerName, customerAddress, customerNumer
    public void setcustomerId(int customerId){
        this.customerId =customerId; 
    }
    public int getcustomerId(){
        return customerId; 
    }
    
    public void setcustomerName(String customerName){
        this.customerName= customerName;
    
    }
    public String getcustomerName(){
        return customerName;
    
    }
    
    public void setcustomerAddress(String customerAddress){
        this.customerAddress=customerAddress;
    
    }
    public String getcustomerAddress(){
        return customerAddress;
    
    }
    
     public void setcustomerPhoneNumber(int customerPhoneNumber){
        this.customerPhoneNumber=customerPhoneNumber;
    
    }
    public int getcustomerPhoneNumber(){
        return customerPhoneNumber;
    
    }
    

}


    
    
     
    

