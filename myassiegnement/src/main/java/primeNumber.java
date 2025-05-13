/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 13202
 */
public class primeNumber {
    
    int[] numbers={ 2, 4, 5, 13};
    
    public boolean isPrimeNumber(int p){
        
        for (int i =2; i<numbers.length; i++){
            
            if (p%i==0){
                return false;
            
            
            }
        
        
        }
        return true;
 
    }
    
}
