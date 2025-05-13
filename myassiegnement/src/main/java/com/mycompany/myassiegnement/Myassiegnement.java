/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.myassiegnement;

/**
 *
 * @author 13202
 */
public class Myassiegnement {

    public static void main(String[] args) {
        
        Myassiegnement obj = new Myassiegnement();
        
        obj.iterate();      
    }
    
    
    // boolean to check if the number is prime or not
    public boolean isPrimeNumber(int p){
         
       if (p==1){
           return false;
       
       }
       if (p==2 || p==3)
       {
           return true;
       
       }
       if (p%2==0 || p%3==0)
       {
           return false;
       
       
       }
       for (int i =5; i<=Math.sqrt(p); i=i+6)
       {
           if(p%i==0 || p%(i+2)==0)
           {
               return false;
           
           }
       
       }
       return true;
 
    }
     // interator function that will iterate in the list
    public void iterate(){
        
        int[] numbers= {7, 10, 13};
        
        for (int numb: numbers)
        {
            
                System.out.println(toString(numb));
        }
    }
    
    // tosting methode 
    public String toString(int numb){
   
        String word = "";
        switch(numb){
            case 7 -> word = "seven";
            case 10 -> word ="ten";
            case 13 -> word = "thirten";
        }
        
        if (isPrimeNumber(numb)){
            return  numb +" -->" + word + "  is prime number";
        
        }
        else
        {
            return  numb +" -->" + word + "  is not a prime number";
        
        }
           
    }
}
