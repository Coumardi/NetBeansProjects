/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 13202
 */
public class ItemInAlberta extends ItemPeopleCanBuy {
    
    double GST_TAXE = 0.07;
    
      public ItemInAlberta(String itemId, String itemName, int itemQuantity, float itemPrice) {
        
        super(itemId, itemName, itemQuantity, itemPrice);
      }
        
        
          // implementing the abstract methode declare in the abstract class ItemPeople can bay
    @Override
    public float getTotalPrice() {
        float totalInAlberta = getItemQuantity() * getItemPrice();
        float totalTax = (float) (getItemQuantity() * GST_TAXE);
        return (float) (totalInAlberta + totalTax);
    
    
    }
    @Override
    public String toString() {
        return getItemQuantity() + getItemName() + "($" + getItemPrice() +") = $" + getTotalPrice() + "(Alberta taxes include)";
    
    
    }

    @Override
    public int getQuantity() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public float getUnitPrice() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
