/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main_package;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author user
 */



public class Listener {
    
       static DashboardFrame frame = new DashboardFrame(false, null);
       
    public static void addLabelListener(JLabel label, JFrame currentFrame, JFrame targetedFrame){
        label.addMouseListener(new java.awt.event.MouseAdapter(){
            
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
                targetedFrame.setVisible(true);
                targetedFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                currentFrame.dispose();
            }
        });
    }
    
     public static void addLabelListenerDontClose(JLabel label, JFrame currentFrame, JFrame targetedFrame){
        label.addMouseListener(new java.awt.event.MouseAdapter(){
            
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
                targetedFrame.setVisible(true);
                targetedFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
    }
    
    public static void showPanel(JLabel label, JPanel panelToShow){
        label.addMouseListener(new java.awt.event.MouseAdapter(){
            
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
              panelToShow.setVisible(true);
              frame.hideAllPanels();
              
            }
        });
    }    
}
