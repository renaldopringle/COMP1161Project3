package Project3;


/**
 * Abstract class AbstractCRUD - A generic CRUD application
 * 
 * @author COMP1161
 * @version 1.0
 */

import java.util.ArrayList;

public abstract class AbstractCRUD
{
    protected String fileName;                    // file from which data is to be loaded
    protected ArrayList<Record> listOfRecords;   // the collection of records
    
    
    public AbstractCRUD(String fileName)
    {
        this.fileName = fileName;
    }
    
    /**
     * Load data from a file and populate list if records
     * The file name was specified in constructor
     * @parameter - none
     * @return count of the number of records loaded
     */
    public abstract int loadDataFile();
    
    
    /**
     * Save records in the list to a file
     * The file is the same one from which the data was loaded
     * @return count of the number of records saved
     */
    public abstract int saveData();
  
    
    /**
     * Add a record to the list of records.
     * @parameter r the record to be added
     * @return void
     */
    public abstract void createRecord(Record r);
    
    /**
     * Locate a record by its key value
     * @parameter key key value of the record to be retrieved
     * @reurn record, if loccated, otherwise null
     */
    public abstract Record retrieveRecord(String key);
    
    
    /**
     * Update a record in the list with another record (based on key value)
     * @parameter r the new record
     * @return true if the update was successful, false otherwise
     */
    public abstract boolean updateRecord(Record r);
    
    
    /**
     * Delete the record with the specified key value
     * @parameter key the key value of the record that is to be deleted
     * @return true if the record is deleted, false otherwise
     */
    public abstract boolean deleteRecord(String key);
    
    
    /**
     * Get a list of all records
     * @parameter nono
     * @return list containing all records
     */
    public ArrayList<Record> getAllRecords()
    {
        return listOfRecords;
    }
    
    
    public String toString()
    {
        return "Number of records: " + listOfRecords.size();
    }
    
}
