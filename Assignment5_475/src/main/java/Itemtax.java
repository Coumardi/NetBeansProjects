/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 13202
 */
public abstract class Itemtax {
    public static final double PTS_TAX = 0.07;
    public static final double GST_TAX = 0.08;
    
    public abstract float ItemPriceAfterTaxpts(double itemUnitPrice );
    public abstract float ItemPriceAfterTaxgst(double itemUnitPrice);
    
   
    
}
