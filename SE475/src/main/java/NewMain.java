/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author 13202
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        FactoryItem ontoF = new factoryItemOntorio();
        shoopingcart onto = new HashTbaleForShooping();
        
        // items with ontorio taxes apply
        
        Item cup = ontoF.createItem("32r4p", " water cup ", 5, 15);
        Item pen = ontoF.createItem("1234p", " school pen ", 2, 30);
        onto.addItem(cup);
        onto.addItem(pen);
        
        System.out.println(onto);
        
        
        // item with alberta taxes
        
        FactoryItem albF = new factoryItemAlberta();
        shoopingcart alb = new HashTbaleForShooping();
        
        alb.addItem(albF.createItem("32r4p", " water cup ", 5, 15));
        alb.addItem(albF.createItem("1234p", " school pen ", 2, 30));
        
        System.out.println("\n" + alb);
        
        
        
        
        
        
        
    }
    
}
