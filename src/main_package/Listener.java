/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main_package;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author user
 */
public class Listener {
        
    public static void addLabelListener(JLabel label, JFrame currentFrame, JFrame targetedFrame){
        label.addMouseListener(new java.awt.event.MouseAdapter(){
            
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
                targetedFrame.setVisible(true);
                targetedFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                currentFrame.dispose();
            }
        });
    }
}
