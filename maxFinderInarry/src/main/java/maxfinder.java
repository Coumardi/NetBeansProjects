/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 13202
 */
public class maxfinder {
    
    
    public static int maxx(int[] ar){
    
    
    
    int max = 0;
    
    for (int i =0; i<ar.length; i++)
    {
      if (max <ar[i])
      {
          max=ar[i];
     
      }
    
    }
    return max;
    }
}
