/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 13202
 */
import java.util.*;

public class Inverter {
    
    private final Map<String, List<Integer>> IndexInvertor = new HashMap<>();
    
   
    
    public void addIndex(String word, int Id){
        word = word.toLowerCase();
        
        IndexInvertor.putIfAbsent(word, new ArrayList<>());
        
            IndexInvertor.get(word).add(Id);
        
    
    }
    public List<Integer> search(String word){
        if(word == null|| word.isEmpty() || !IndexInvertor.containsKey(word)) {
            
            return new ArrayList<>();
        
        
        }
        return IndexInvertor.get(word);
    
    
    }
    
    public void displayIndex() {
    for (String word : new TreeSet<>(IndexInvertor.keySet())) { 
        List<Integer> id_list = IndexInvertor.get(word);
        System.out.print(word + ": ");
        for (int id : id_list) {
            System.out.print(id + " ");
        }
        System.out.println(); 
    }
}
    public String getIndexString() {
    StringBuilder res = new StringBuilder();
    for (String word : IndexInvertor.keySet()) {
        res.append(word).append(": ");
        for (int id : IndexInvertor.get(word)) {
            res.append(id).append(" ");
        }
        res.append("\n");
    }
    return res.toString();
}


    
}
