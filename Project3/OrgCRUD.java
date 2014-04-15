package Project3;

import java.util.*;
import java.io.*;

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
    
    public OrgCRUD (String fileName) {
        super(fileName);
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
        try(Scanner input = new Scanner(new File("project3.txt"))) {
            while (input.hasNext()) {
            words.add(input.nextLine());
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
        Record r = (Record)orgC;  //A record consists of an organization and an arraylist of branches
        
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
        return true;
    }
    
    
}
