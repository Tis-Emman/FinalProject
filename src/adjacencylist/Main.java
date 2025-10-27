package adjacencylist;

import java.util.Scanner;

public class Main {
   
    public static void main(String[] args) {
        
        DatabaseManager dbManager = new DatabaseManager();   
         new FunctionFrame().setVisible(true);
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your calculation: ");
        System.out.println("1 - Add quantity");
        System.out.println("2 - Subtract quantity");
        int choice = scanner.nextInt();
        
        if(choice == 1){
            System.out.print("Enter quantity to add: ");
            int quantityToAdd = scanner.nextInt();
            displayItemsId();
            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            
            dbManager.addQnty(quantityToAdd, id);
            
        }else if(choice == 2){
            System.out.print("Enter quantity to subtract: ");
            int quantityToAdd = scanner.nextInt();
            displayItemsId();
            System.out.print("Enter ID: ");
            int id = scanner.nextInt(); 
            dbManager.subtractQnty(quantityToAdd, id);   
            
        } else{
            System.out.println("Please enter a specific value!");
        } 
    }
    
    public static void displayItemsId(){
        System.out.println("\nID 1 = Zesto");
        System.out.println("ID 2 = C2");
        System.out.println("ID 3 = Ethyl Alcohol");
    }
}
