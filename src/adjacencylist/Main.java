package adjacencylist;

import java.util.Scanner;


public class Main {
   
    public static void main(String[] args) {
        
        DatabaseManager dbManager = new DatabaseManager();   
         new SignUpFrame().setVisible(true);
    }
    
    public static void displayItemsId(){
        System.out.println("\nID 1 = Zesto");
        System.out.println("ID 2 = C2");
        System.out.println("ID 3 = Ethyl Alcohol");
    }
}
