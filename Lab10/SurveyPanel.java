package Lab10;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Write a description of class SurveyPanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SurveyPanel extends JPanel
{
    private JTextField name;
    private JButton lime, digicel, reset;
    private JLabel namelabel, surveyarea, choice, numLime, numDigi, numOfLime, numOfDigi, pl;
    private JRadioButton kingston, portmore, spantown;
    protected int lButton, dButton, rButton;

    public SurveyPanel()
    {
        lButton = 0;
        dButton = 0;
        rButton = 0;
        name = new JTextField(20);
        namelabel = new JLabel("Name: ");
        
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.PAGE_AXIS));

        JPanel panel1 = new JPanel(new GridLayout(0,2));
        panel1.add(namelabel);
        panel1.add(name);
        //panel1.setPreferredSize(new Dimension(500, 50));

        JPanel panel2 = new JPanel();
        surveyarea = new JLabel("Survey Area: ");
        panel2.add(surveyarea);
        
        JPanel panel3 = new JPanel();
        //panel3.setLayout(new BoxLayout(panel3,BoxLayout.LINE_AXIS));
        kingston = new JRadioButton("Kingston");
        portmore = new JRadioButton("Portmore");
        spantown = new JRadioButton("Spanish Town");
        ButtonGroup place = new ButtonGroup();
        place.add(kingston);
        place.add(portmore);
        place.add(spantown);
        AreaListener rLis = new AreaListener();
        kingston.addActionListener(rLis);
        portmore.addActionListener(rLis);
        spantown.addActionListener(rLis);
        panel3.add(kingston);
        panel3.add(portmore);
        panel3.add(spantown);

        JPanel panel4 = new JPanel(new GridLayout(2,3));
        choice = new JLabel("Click the button below  indicating the service provider \n of EACH person questioned. ");
        lime = new JButton("LIME");
        digicel = new JButton("DIGICEL");
        reset = new JButton("Reset");
        ProviderListener listNR = new ProviderListener();
        lime.addActionListener(listNR);
        digicel.addActionListener(listNR);
        reset.addActionListener(listNR);
        panel4.add(choice);
        JPanel buttons = new JPanel(new GridLayout(0,3));
        buttons.add(lime);
        buttons.add(digicel);
        buttons.add(reset);
        //buttons.setPreferredSize(new Dimension(100,100));
        //panel4.setPreferredSize(new Dimension(100, 100));

        JPanel panel5 = new JPanel(new GridLayout(0,1));
        numLime = new JLabel("No. of LIME customers: ");
        numDigi = new JLabel("No. of DIGICEL customer: ");
        numOfLime = new JLabel("<<value here>>");
        numOfDigi = new JLabel("<<value here>>");
        panel5.add(numLime);
        panel5.add(numOfLime);
        panel5.add(numDigi);
        panel5.add(numOfDigi);
        panel5.setPreferredSize(new Dimension(100, 50));
        
        JPanel panel6 = new JPanel(new GridLayout(0,1));
        pl = new JLabel("");
        panel6.add(pl);
        panel6.setPreferredSize(new Dimension(200, 100));
        

        formPanel.add(panel1);
        formPanel.add(panel2);
        formPanel.add(panel3);
        formPanel.add(panel4);
        formPanel.add(buttons);
        formPanel.add(panel5);
        formPanel.add(panel6);
        
        add(formPanel);
    }

    private class AreaListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == kingston)
            {
                String k = "Kingston";
                rButton = 1;
                pl.setText(k);
            }
            else if(event.getSource() == portmore)
            {
                String p = "Portmore";
                rButton = 1;
                pl.setText(p);
            }else 
            {    
                String s = "Spanish Town";
                rButton = 1;
                pl.setText(s);
            }
        }
    }

    private class ProviderListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == lime)
            {
                lButton += 1;
                numOfLime.setText("" + lButton);
            }else if(event.getSource() == digicel)
            {
                dButton += 1;
                numOfDigi.setText("" + dButton);
            }else
            {
                lButton = 0;
                numOfLime.setText("" + lButton);
                dButton = 0;
                numOfDigi.setText("" + dButton);
            }
        }
    }
}