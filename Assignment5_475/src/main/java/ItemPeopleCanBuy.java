/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 13202
 */
public abstract class ItemPeopleCanBuy implements Item {
    
    private final String itemId; 
    private final String itemName; 
    private final int itemQuantity;
    private final float itemUnitPrice;
    
    // constructor to initialize initial value of item id, item name, item quantity, item unit price
    public ItemPeopleCanBuy(String itemId, String itemName, int itemQuantity, float itemUnitPrice) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemUnitPrice = itemUnitPrice;
    
    }
    
    // get item function that will return the number of units of the item
    @Override
    public int getQuantity() {
        
        return itemQuantity; 
    }
    
    // a get item id that will return a unique id for the item
    @Override
    public String getItemId() {
        
        return itemId;
    
    
    }
    
    // a get id function that will return the non-unique straing name of the item
    @Override
    public String getItemName() {
        
        return itemName;
    
    }
    
    // a function that will return the unite price of the item before tax 
    @Override
    public float getUnitPrice() {
        
        return itemUnitPrice;
    
    }
    
    // a function that will calculate the toal price which is unit cost * number of units with applicable taxe added
    @Override
    public float getTotalPrice () {
        
        float TotalBeforeTax = itemQuantity * itemUnitPrice;
        return TotalBeforeTax + Tax;
       
    }
    
    @Override
    public String toString() {
        
        return itemName + (" + itemQuantity + "  + itemUnitPrice + ") = $" + getTotalPrice());
    
    
    }
          
    
}
