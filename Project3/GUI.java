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
    protected JTextField recTypeField, numField, typeORlocationField, nameORcontactNumField;
    protected JLabel label, recTypeLabel, numLabel, typeORlocationLabel, nameORcontactNumLabel;
    protected JButton create, edit, delete;
    //private JPanel mainarea, secondarea, thirdarea, formpanel;
    
    public GUI (AbstractCRUD abc) 
    {
        int load = abc.loadDataFile();
        //Universal panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0,1));
        
        /*A main area in which a listing of all organizations is displayed one per row.  
        //You can decide exactly what data will be displayed in the listing;*/
        JPanel mainarea = new JPanel();
        //Read from file using a while loop; determine if a record is an organzization
        //store each record as a string removing spaces.
        //Add the organization string to a radio button and add it to the main area panel
        /*for (Record r : abc.getAllRecords()) {
            //JRadioButton l = new JRadioButton(r);
            //mainarea.add(l);
        }*/
        
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
        
        recTypeField = new JTextField(20);
        numField = new JTextField(20);
        typeORlocationField = new JTextField(20);
        nameORcontactNumField = new JTextField(20);
        
        recTypeLabel = new JLabel("Record Type: ");
        numLabel = new JLabel("Registration number/ Branch number: ");
        typeORlocationLabel = new JLabel("Type/ Location: ");
        nameORcontactNumLabel = new JLabel("Name/ Contact number: ");
        create = new JButton("create");
        edit = new JButton("edit");
        delete = new JButton("delete");
        
        editarea.add(recTypeLabel);
        editarea.add(recTypeField);
        editarea.add(numLabel);
        editarea.add(numField);
        editarea.add(typeORlocationLabel);
        editarea.add(typeORlocationField);
        editarea.add(nameORcontactNumLabel);
        editarea.add(nameORcontactNumField);
        
        editarea.add(create);
        editarea.add(edit);
        editarea.add(delete);
        ProviderListener al = new ProviderListener();
        create.addActionListener(al);
        edit.addActionListener(al);
        delete.addActionListener(al);
        
        editarea.setLayout(new GridLayout(0,2));
        
        
        formPanel.add(mainarea);
        formPanel.add(secondarea);
        formPanel.add(editarea);
        add(formPanel);
    }
    
    private class AreaListener implements ActionListener 
    {
        public void actionPerformed (ActionEvent event) 
        {
            //if organization is selected then show all branches for this.
            //This will be done using a for each loop
            /*for (Organization org : organization) {
                if (event.getSource == org) {
                    setText(org.getBranches());
                }
            }*/
        }
    }
    
    private class ProviderListener implements ActionListener 
    {
        public void actionPerformed (ActionEvent event)
        {
            
            //If edit button is clicked overide existing data and allow the user to create new record.
            if (event.getSource() == edit) {
                recTypeLabel.setText("EDIT!!!");
                //deleteRecord();
            //If create button is clicked provide the user with necessary text fields
            }else if (event.getSource() == create) {
                recTypeLabel.setText("EDIT!!!");
                //createRecord();
            //If delete button is clicked delete record from file
            }else if (event.getSource() == delete) {
                recTypeLabel.setText("EDIT!!!");
                //eleteRecord();
            }
        }
    }
}

