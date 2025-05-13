/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 13202
 */

import java.util.Hashtable;

public class HashTbaleForShooping implements shoopingcart {
    
    private Hashtable < String, Item> items;
    
    public HashTbaleForShooping() {
        
        items = new Hashtable<>();
      
    }
    @Override
    public void addItem(Item item) {
        items.put(item.getItemId(), item);
    
    
    }
    
    @Override
    public void removeItem(Item item) {
        items.remove(item.getItemId());
    
    
    }
    
    @Override
    public float getTotalPrice() {
        float total = 0;
        for (Item item: items.values()) {
            total = total + item.getTotalPrice();
        
        
        }
        return total;
    
    }
    @Override
    public Item getItem(String itemId) {
        return items.get(itemId);
    
    
    }
    
    @Override
    public int getItemnumber() {
        return items.size();
    
    }
    @Override
    public String toString() {
    StringBuilder st = new StringBuilder("Shopping cart:\n");
    for(Item item: items.values()) {
        st.append("- ").append(item.toString()).append("\n");
    }
    st.append("Total: $").append(getTotalPrice());
    return st.toString();
    }
}
    
  
