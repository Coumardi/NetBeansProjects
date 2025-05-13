/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.fibonacciseries;

/**
 *
 * @author 13202
 */
public class FibonacciSeries {

    public static void main(String[] args) {
        
        int[] number={0,1, 2, 3,4,5,6,7,8,9,10};
        
        int num1=0;
        int num2=1;
        
        
        for(int i=0; i<number.length; i++){
            int num3=num1+num2;
            
            System.out.println(num3 +" ");
            
            num1=num2;
            num2=num3;
            
            
            
        
        
        }
        
  
        
        
        
        
        
        
    }
}
