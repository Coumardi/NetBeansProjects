
import java.util.Vector;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 13202
 */
public class myVector {
    
     public static Vector union(Vector vec1, Vector vec2) {
        Vector res = new Vector();

        if (vec1 != null) {
            res.addAll(vec1);
        }
        if (vec2 != null) {
            res.addAll(vec2);
        }

        return res;
    }
     
    
          
       
}
