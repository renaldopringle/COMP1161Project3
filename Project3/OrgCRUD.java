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
    private String recType;
    private String num;
    private String two;
    private String three;
    private int loadcount = 0;
    private int savecount = 0;
    private ArrayList<Organization> organization = new ArrayList<Organization>();
    private int orgCount;
    
    public OrgCRUD (String fileName) {
        super(fileName);
    }
    
    /**
     * 
     * @param recType This is the type of record O - Organization, B - Branch
     * @param num Registration number of the organization or branch number of a brach
     * @param two This is either the location of a branch or the type of an organization
     * @return void
     */
    public void Record (String recType, String num, String two, String three) 
    {
        /*if (recType.equals("O")) {
            if (two.equals("S")) {
                    organization.add(new School(num,two,three));
            }else if (two.equals("B")) {
                    organization.add(new Bank(num,two,three));
            }
        }else{
            
            //retrieveRecord().addBranch(num,two,three);
        }*/
        //code above creates a new organization and adds it to the organization arrayList
        //code is supposed to create a new record
        this.recType = recType;
        this.num = num;
        this.two = two;
        this.three = three;
    }
    
    /**
     * Load data from a file and populate list if records
     * The file name was specified in constructor
     * @parameter - none
     * @return count of the number of records loaded
     */
    public int loadDataFile () 
    {
        ArrayList<String> records = new ArrayList<String>();
        String formatrec, rest, regNum, name, type, branchNum, location, contactNum;
        int index;
        loadcount = 0;
        orgCount = 0;
        try(Scanner input = new Scanner(new File(fileName))) {
            while (input.hasNext()) {
                    //Should include an if statement to filter the comments in the file "project3.txt"
                    formatrec = input.nextLine();
                    formatrec = formatrec.replace("|", " ");
                    records.add(formatrec);
                    loadcount++;
            }
            /* print all items in file
            for (String rec : records) {
                System.out.println(rec);
            }
            */
            //create an organization and add it to an array
            for (String rec : records) {
                if (rec.substring(0,1).equals("O")) {
                    orgCount++;
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
                    //System.out.println(regNum + " " + type + " " + name);   
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
                    organization.get(orgCount-1).addBranch(branchNum,location,contactNum);
                    //System.out.println(branchNum + " " + location + " " + contactNum);
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
        listOfRecords.add(r);
    }
    
    
    /**
     * Locate a record by its key value
     * @parameter key key value of the record to be retrieved
     * @reurn record, if loccated, otherwise null
     */
    public Record retrieveRecord (String key) 
    {
        for (Record rec : listOfRecords) {
            if (rec.getKey().equals(key)) {
                return rec;
            }
        }
        return null;
    }
    
    
    /**
     * Update a record in the list with another record (based on key value)
     * @parameter r the new record
     * @return true if the update was successful, false otherwise
     */
    public boolean updateRecord (Record r) 
    {
        //Find the record by using the key and replace it in the file
        /*The code reads each line of a file. 
        //If that line doesn't contain the name, The line will be written to a temporary file. 
        //If the line contains the name, it will not be written to temp file. 
        //In the end the temp file is renamed to the original file.*/
        try {
            File inputFile = new File(fileName);   // Your file  
            File tempFile = new File("TempFile.txt");// temp file
            
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter firstName");
            String firstName = scanner.nextLine();
            System.out.println("Enter lastName");
            String lastName = scanner.nextLine();
            
            String currentLine;
            
            while((currentLine = reader.readLine()) != null) {
            
                if(currentLine.contains(firstName) 
                     && currentLine.contains(lastName)) continue;
            
                writer.write(currentLine);
            }
            
            writer.close();
            boolean successful = tempFile.renameTo(inputFile);
        }
        catch (Exception e){}
                
        return true;
    }
    
    
    /**
     * Delete the record with the specified key value
     * @parameter key the key value of the record that is to be deleted
     * @return true if the record is deleted, false otherwise
     */
    public boolean deleteRecord (String key) 
    {
        for (Record rec : listOfRecords) {
            if (rec.getKey().equals(key)) {
                listOfRecords.remove(rec);
                return true;
            }
        }
        return false;
    }
}
