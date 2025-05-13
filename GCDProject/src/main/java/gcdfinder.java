/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 13202
 */
public class gcdfinder {
    public int findgcd(int a, int b){
        
        // for 2 given number a and b if a > b take a-b and replace a value with a-b 
        
        while (a!=b)
        {
            if(a>b)
            {
                a=a-b;
            
            }
            else
            {
                b=b-a;
            
            }
        
        
        }
        return a;
    
    
    }
    
}
