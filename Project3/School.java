package Project3;


/**
 * Write a description of class School here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class School extends Organization
{
    private int numStudent;
    private int numStaff;
    
    public School(String regNum, String name, String type) 
    {
        super(regNum,name,type);
        this.numStudent = numStudent;
        this.numStaff = numStaff;
    }
    
    public String toString() {
        return (super.toString() + "\nNumber of Students: " + numStudent + "\nNumber of staff: " + numStaff + getBranches());
    }
    
    public String getKey(){
    	return "-----";
    }
}

