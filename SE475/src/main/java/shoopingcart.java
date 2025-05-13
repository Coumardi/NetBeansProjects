/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 13202
 */
public interface shoopingcart {
    // a shopping bsaket interface
    void addItem(Item item);
    void removeItem(Item item);
    float getTotalPrice();
    Item getItem(String itemId);
    int getItemnumber();
    
}
