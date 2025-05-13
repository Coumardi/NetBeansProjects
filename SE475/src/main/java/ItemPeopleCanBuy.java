/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 13202
 */
public abstract class ItemPeopleCanBuy implements Item {
    
    // this abtract class implement Item interface 
    
    private  String itemId;
    private  String itemName;
    private  int itemQuantity;
    private  float itemPrice;
    
    
    
    
    // abstract methode that will be implemented in the subclasses
    public abstract float getTotalPrice();
    
    // constructor for item that people can buy
    public ItemPeopleCanBuy(String itemId, String itemName, int itemQuantity, float itemPrice) {
        
        
     this.itemId = itemId;
     this.itemName = itemName;
     this.itemQuantity = itemQuantity;
     this.itemPrice = itemPrice;
    
    
    }
    
    //getter and setter 
     public int getItemQuantity() {
        return itemQuantity;
    
    }
    
    public void setItemQuantity (int itemQuantity) {
        this.itemQuantity = itemQuantity;
    
    
    }
    
    public String getItemId() {
        
        return itemId;
    
    }
    
    public void setItemId(String itemId) {
        this.itemId = itemId;
    
    
    }
    
    public String getItemName() {
        
        return itemName;
    
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    
    
    }
    
    public float getItemPrice() {
        return itemPrice;
   
    }
    public void setItemPrice(float itemPrice) {
        this.itemPrice = itemPrice;
    
    
    }
}
