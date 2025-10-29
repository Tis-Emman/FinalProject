/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main_package;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author user
 */
public class ImageManager {
    
    public void scaleImage(String src, JLabel labelImg) {
    ImageIcon icon = new ImageIcon(getClass().getResource(src));
    Image img = icon.getImage();
    Image imgScale = img.getScaledInstance(labelImg.getWidth(), labelImg.getHeight(), Image.SCALE_SMOOTH);
    ImageIcon scaledIcon = new ImageIcon(imgScale);
    labelImg.setIcon(scaledIcon);
}
    
}
