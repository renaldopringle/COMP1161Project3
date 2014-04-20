package Project3;

import java.util.*;
import java.io.*;
import javax.swing.*;

/**
 * Write a description of class OrgCRUD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OrgCRUD extends AbstractCRUD
{
    private int loadcount = 0;
    private int savecount = 0;
    private ArrayList<Organization> organization = new ArrayList<Organization>();
    
    public OrgCRUD (String fileName) {
        super(fileName);
    }
    
    /**
     * 
     * @param recType This is the type of record O - Organization, B - Branch
     * @param num registration number of the organization or branch number of a brach
     * @return void
     */
    public void Record (String recType, String num, String two, String three) 
    {
        if (recType.equals("O")) {
            String type = JOptionPane.showInputDialog("Enter type of Organization");
            if (type.equals("S")) {
                    organization.add(new School(num,two,three));
            }else if (type.equals("B")) {
                    organization.add(new Bank(num,two,three));
            }
        }else{
            
            //retrieveRecord().addBranch(num,two,three);
        }
    }
    
    /**
     * Load data from a file and populate list if records
     * The file name was specified in constructor
     * @parameter - none
     * @return count of the number of records loaded
     */
    public int loadDataFile () 
    {
        ArrayList<String> words = new ArrayList<String>();
        String formatrec, rest, regNum, name, type, branchNum, location, contactNum;
        int index;
        loadcount = 0;
        try(Scanner input = new Scanner(new File(fileName))) {
            while (input.hasNext()) {
                    //Should include an if statement to filter the comments in the file "project3.txt"
                    formatrec = input.nextLine();
                    formatrec = formatrec.replace("|", " ");
                    words.add(formatrec);
                    loadcount++;
            }
            for (String word : words) {
                System.out.println(word);
            }
            //create an organization and add it to an array
            for (String rec : words) {
                if (rec.substring(0,1).equals("O")) {
                    index = rec.indexOf(" ");
                    rest = rec.substring(index);
                    index = rest.indexOf(" ");
                    regNum = rest.substring(0,index);
                    rest = rest.substring(rec.indexOf(" "));
                    index = rest.indexOf(" ");
                    type = rest.substring(0,index);
                    rest = rest.substring(index);
                    name = rest;
                    regNum = regNum.replace(" ","");
                    type = type.replace(" ","");
                    name = name.replace(" ","");
                    System.out.println(regNum + " " + type + " " + name);   
                    if (rec.substring(0,1).equals("S")) {
                        organization.add(new School(regNum,name,type));
                    }else{
                        organization.add(new Bank(regNum,name,type));
                    }
                }
                if (rec.substring(0,1).equals("B")) {
                    index = rec.indexOf(" ");
                    rest = rec.substring(index);
                    index = rest.indexOf(" ");
                    branchNum = rest.substring(0,index);
                    rest = rest.substring(rec.indexOf(" "));
                    index = rest.indexOf(" ");
                    location = rest.substring(0,index);
                    rest = rest.substring(index);
                    contactNum = rest;
                    branchNum = branchNum.replace(" ","");
                    location = location.replace(" ","");
                    contactNum = contactNum.replace(" ","");
                    System.out.println(branchNum + " " + location + " " + contactNum);
                }
            }
        }
        
        catch (Exception e){}
        
        return loadcount;
    }
    
    
    /**
     * Save records in the list to a file
     * The file is the same one from which the data was loaded
     * @return count of the number of records saved
     */
    public int saveData () 
    {
        try{
            PrintWriter write = new PrintWriter(fileName, "UTF-8");
            for (Organization org : organization) {
                write.println(org);
                savecount++;
            }
        }
        catch (Exception e) {}
        
        return savecount;
    }
    
    
    /**
     * Add a record to the list of records.
     * @parameter r the record to be added
     * @return void
     */
    public void createRecord (Record r) 
    {
        
    }
    
    
    /**
     * Locate a record by its key value
     * @parameter key key value of the record to be retrieved
     * @reurn record, if loccated, otherwise null
     */
    public Record retrieveRecord (String key) 
    {
        OrgCRUD orgC = new OrgCRUD(fileName);
        Record r = (Record)orgC;
        
        return r;
    }
    
    
    /**
     * Update a record in the list with another record (based on key value)
     * @parameter r the new record
     * @return true if the update was successful, false otherwise
     */
    public boolean updateRecord (Record r) 
    {
        return true;
    }
    
    
    /**
     * Delete the record with the specified key value
     * @parameter key the key value of the record that is to be deleted
     * @return true if the record is deleted, false otherwise
     */
    public boolean deleteRecord (String key) 
    {
        for (Organization org : organization) {
            if (key.equals(org.getRegNum())) {
                organization.remove(org);
                return true;
            }
        }
        return false;
    }
}
