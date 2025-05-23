/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package zenfit_group5_37a;
import database.*;
/**
 *
 * @author ACER
 */
public class ZenFit_Group5_37A {

    /**
     * @param args the command line arguments
     */
 
        // TODO code application logic here
        public static void main(String[] args) {
        Database db = new MySqlConnection(); 
        if (db.openConnection() != null) {
            System.out.println("Database connected successfully!");
        } else {
            System.out.println("Failed connect to database!");
        
    }
    }
    
}
