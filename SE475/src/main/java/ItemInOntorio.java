/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 13202
 */
public class ItemInOntorio extends ItemPeopleCanBuy{
    double PST_TAXE = 0.08;
    double GST_TAXE = 0.07;
        
    
    
    public ItemInOntorio(String itemId, String itemName, int itemQuantity, float itemPrice) {
        
        super(itemId, itemName, itemQuantity, itemPrice);
    
    }
    
    // implementing the abstract methode declare in the abstract class ItemPeople can bay
    @Override
    public float getTotalPrice() {
        float totalInOntorio = getItemQuantity() * getItemPrice();
        float totalTax = (float) (getItemQuantity() * (PST_TAXE + GST_TAXE));
        return (float) (totalInOntorio + totalTax);
    
    
    }
    @Override
    public String toString() {
        return getItemQuantity() + getItemName() + "($" + getItemPrice() +") = $" + getTotalPrice() + "(ontorip taxes include)";
    
    
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
