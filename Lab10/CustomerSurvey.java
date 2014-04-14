package Lab10;

import javax.swing.JFrame;
import java.awt.*;

/**
 * Write a description of class CustomerSurvey here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CustomerSurvey
{
    public static void main (String[] args) {
        JFrame frame = new JFrame("Mobile Customer Survey");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SurveyPanel survey = new SurveyPanel();
        frame.getContentPane().add(survey);
        frame.pack();
        frame.setVisible(true);
    }
}
