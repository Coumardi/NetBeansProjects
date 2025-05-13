/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 13202
 */
import java.io.*;



public class FileReader {
    
    public void readFiles(String[] fileNames, Inverter index) throws IOException {
        
        for (int Id = 0; Id < fileNames.length; Id++) {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(fileNames[Id]));
            
            String line;
            
            while((line = reader.readLine()) !=null){
                
                String[] words = line.toLowerCase().split("[\\W_]+");

                
                for(String word : words) {
                    if(!word.isEmpty())
                    { 
                        index.addIndex(word, Id);
                    
                    }
                        
                    
                
                
                }
                 
            }
            reader.close();
        
        
        }
    
    
    }
    
}
