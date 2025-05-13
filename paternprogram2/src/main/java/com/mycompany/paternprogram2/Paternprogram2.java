/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.paternprogram2;

/**
 *
 * @author 13202
 */
public class Paternprogram2 {

    public static void main(String[] args) {
        
        int count = 1;
        
        for(int j = 0; j<5; j++){
            
            for (int i =0; i<5; i++){
                
                if(count <10)
                {
                   System.out.print("0");
                
                }
                
                
                System.out.print(count++ + " ");
            
            
            
            }
            System.out.println();
        
        
        }
        
        
    }
}
