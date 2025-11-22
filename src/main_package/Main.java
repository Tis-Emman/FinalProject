package main_package;

import java.util.Scanner;


public class Main {
   
    public static void main(String[] args) {
        DatabaseManager dbManager = new DatabaseManager();
    
    String rememberedEmail = dbManager.getRememberedUser();

    if (rememberedEmail != null) {
        // Auto-login remembered user
        DashboardFrame dashboard = new DashboardFrame(true, rememberedEmail);
        dashboard.setVisible(true);
    } else {
        // No remembered user → show login frame
        DashboardFrame dbFrame = new DashboardFrame(false, "");
        dbFrame.setVisible(true);
    }
    
    }
    
    public static void displayItemsId(){
        System.out.println("\nID 1 = Zesto");
        System.out.println("ID 2 = C2");
        System.out.println("ID 3 = Ethyl Alcohol");
    }
}
