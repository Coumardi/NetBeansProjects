/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 13202
 */
public class ItemSoldInAlberta extends Itemtax {
    
    @Override
    public float ItemPriceAfterTaxpts(double itemUnitePrice){
         throw new UnsupportedOperationException("Not supported yet.");      
    }
    @Override
    public float ItemPriceAfterTaxgst(double itemUnitPrice) {
        
        float totalPriceAftergst = (float)(itemUnitPrice * GST_TAX);
        return totalPriceAftergst;
    
    
    }
    
}
