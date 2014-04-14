package Project3;


/**
 * Write a description of class OrgCRUD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OrgCRUD extends AbstractCRUD
{
    public OrgCRUD (AbstractCRUD ab) 
    {
        
    }
    
    public boolean deleteRecord (String key) 
    {
        if (retrieveRecord().contans(key)) {
            return true;
        }else{
            return false;
        }
    }
    
    public boolean updateRecord (Record r) 
    {
        if (r) {
            return true;
        }else{
            return false;
        }
    }
    
    public Record retrieveRecord (String key) 
    {
        if (retrieveRecord().contans(key)) {
            return record;
        }
    }
    
    public boolean createRecord (Record r) 
    {
        if (retrieveRecord().contans(key)) {
            return true;
        }else{
            return false;
        }
    }
}
