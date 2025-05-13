/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author 13202
 */
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        Scanner scanner = new Scanner(System.in);
        
        // get user input , name and email 
        System.out.println("Please provide your name: ");
        String name = scanner.nextLine();
        
        System.out.println(" please provide your email");
        String email = scanner.nextLine();
        
        System.out.println("how much do you want to deposit in to your account");
        double deposit_amount = scanner.nextInt();
        double balance = 0;
        balance = balance + deposit_amount;
        
        // write to a file
        
        try {
            PrintWriter myWriter = new PrintWriter ("SE475.txt");
            // writing user info such as name, email, deposit amount into a file named SE475.txt file
            myWriter.println("User toll info");
            myWriter.println("Name:" + name);
            myWriter.println("Email: " + email);
            myWriter.println("balance: " + balance);
            
            
            double tollsFee = 5;
            
            for (int i= 1; i < 5; i++)
            {
                try{
                    // assert when the balance is less than or equal than 20 
                if (deposit_amount <=20)
                {
                    throw new LowBalanceException("Balance should be greater or equal than $ 20");
                
                }
                // assert detuction tolls fee from the deposit amount which represent balance this will applay only if 
                // the balance is greather than tolls fee 
                balance =balance - tollsFee;
                
                myWriter.write("remaining balance after toll feedecution: $ " + balance);
          
            
            } catch (LowBalanceException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            
            myWriter.close();
            
            System.out.println("Successful write to the file SE475.txt.");
            
            
            
        
        
        } catch (IOException e) {
            
            System.out.println(" An error occured when writing ");
            e.printStackTrace();
        
        
        } 
        
    }
    
}
