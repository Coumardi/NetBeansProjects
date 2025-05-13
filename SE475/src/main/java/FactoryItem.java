/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 13202
 */
public interface FactoryItem {
    // factory interface in this interface we are creating an item with the given stock id name and quantity
    Item createItem(String itemId, String itemName, int itemQuantity, float itemPrice);
    
}
