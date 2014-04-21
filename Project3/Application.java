package Project3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 * Write a description of class Application here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Application
{
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Organization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI gui = new GUI(new OrgCRUD("project3.txt"));
        frame.getContentPane().add(gui);
        frame.pack();
        frame.setVisible(true);
        
    }
}
