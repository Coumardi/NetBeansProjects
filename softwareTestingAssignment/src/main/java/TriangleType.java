/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 13202
 */


public class TriangleType {
    
    /**
     * @param s1, s2, s3:  sides of the putative triangle
     * @return enum describing type of triangle
     */
    
    public static Triangle triangle (int s1, int s2, int s3)
    {
        // Reject non-positive sides
        if (s1 <= 0 || s2 <= 0 || s3 <= 0)
            return (Triangle.INVALID);

        // Check triangle inequality
        if (s1+s2 <= s3 || s2+s3 <= s1 || s1+s3 <= s2)
            return (Triangle.INVALID);
    
        // Identify equilateral triangles
        if ((s1 == s2) && (s2 == s3))
            return Triangle.EQUILATERAL;
    
        // Identify isosceles triangles
        if ((s1 == s2) || (s2 == s3) || (s1 == s3))
            return Triangle.ISOSCELES;

        return (Triangle.SCALENE);
    }
    
}
