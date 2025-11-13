/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main_package;

import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
    
    public static void gotoRegisterPanel(JLabel label, JFrame currentFrame, JFrame targetedFrame, JPanel panelToHide, JPanel panelToShow){
        label.addMouseListener(new java.awt.event.MouseAdapter(){
            
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
                targetedFrame.setVisible(true);
                targetedFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                currentFrame.dispose();
                panelToHide.setVisible(false);
                panelToShow.setVisible(true);
                
                TestLoginFrame.gotoLoginButton.setBackground(new Color(252,239,216));
                TestLoginFrame.gotoRegisterButton.setBackground(new Color(137,102,38));
                
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
