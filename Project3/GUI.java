package Project3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Write a description of class GUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GUI extends JPanel
{
    private JTextField regNumField, nameField, typeField, branchNumField, locationField, contactField;
    private JLabel label;
    private JButton create, edit, delete;
    //private JPanel mainarea, secondarea, thirdarea, formpanel;
    
    public GUI (AbstractCRUD abc) 
    {
        //Universal panel
        JPanel formPanel = new JPanel();
        
        /*A main area in which a listing of all organizations is displayed one per row.  
        //You can decide exactly what data will be displayed in the listing;*/
        JPanel mainarea = new JPanel();
        //Read from file using a while loop; determine if a record is an organzization
        //store each record as a string removing spaces.
        //Add the organization string to a radio button and add it to the main area panel
        
        
        
        /*A second area in which all branches for a selected organization will be displayed.
        //This area should be automatically updated as you scroll through the listing of organizations.*/
        JPanel secondarea = new JPanel();
        //Read from file using a while loop; determine if a record is an branch
        //store each record as a string removing spaces.
        //#When a radio button for an organization is pressed a list of all its branches is shown.
        
        
        
        
        /*A third area, called the edit area, in which a simple form containing all the data that is stored 
        //for an organization shall be created (or edited). 
        //This area shall also be used to input  data for a branch.*/
        JPanel editarea = new JPanel();
        
        regNumField = new JTextField();
        nameField = new JTextField();
        typeField = new JTextField();
        branchNumField = new JTextField();
        locationField = new JTextField();
        contactField = new JTextField();
        
        create = new JButton("create");
        edit = new JButton("edit");
        delete = new JButton("delete");
    }
    
    private class AreaListener implements ActionListener 
    {
        public void actionPerformed (ActionEvent event) 
        {
            //if organization is selected then show all branches for this.
            
            
        }
    }
    
    private class ProviderListener implements ActionListener 
    {
        public void actionPerformed (ActionEvent event)
        {
            //If edit button is clicked overide existing data and allow the user to create new record.
            
            //If create button is clicked provide the user with necessary text fields
            
            //If delete button is clicked delete record from file
        }
    }
}
