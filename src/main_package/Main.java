package main_package;

import java.util.Scanner;


public class Main {
   
    public static void main(String[] args) {
        
       DatabaseManager dbManager = new DatabaseManager();   
        //new SignUpFrame().setVisible(true);
        //new LoginFrame(null).setVisible(true);
        new TestLoginFrame().setVisible(true);
       // new DashboardFrame(false, null).setVisible(true);
       String username = dbManager.retrieveUsername("emman123@gmail.com");
       
       if(username != null){
             System.out.println(username);
       }else{
           System.out.println("WADAPAK");
       }
       
       //new AdminPage().setVisible(true);
    }
    
    public static void displayItemsId(){
        System.out.println("\nID 1 = Zesto");
        System.out.println("ID 2 = C2");
        System.out.println("ID 3 = Ethyl Alcohol");
    }
}
