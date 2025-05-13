/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 13202
 */
public class factoryItemAlberta implements FactoryItem {
    
    @Override
      public Item createItem(String itemId, String itemName, int itemQuantity, float itemPrice){
          
      return new ItemInAlberta(itemId, itemName, itemQuantity, itemPrice);
      
      }
    
    
    
    
}
