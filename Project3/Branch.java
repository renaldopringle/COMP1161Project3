package Project3;


/**
 * Write a description of class Branch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Branch
{
    private int branchNum;
    private String location;
    private String contactNum;
    
    public Branch(int branchNum, String location, String contactNum) 
    {
        this.branchNum = branchNum;
        this.location = location;
        this.contactNum = contactNum;
    }
    
    public boolean equals(Branch branch1, Branch branch2) {
        if (branch1.getBranchNum() == branch2.getBranchNum()) {
            return true;
        }else{
            return false;
        }
    }
    
    public int getBranchNum() {
        return this.branchNum;
    }
    
    public String toString() {
        return ("Branch Number: " + branchNum + "\nLocation: " + location + "\nContact Number: " + contactNum+ "\n");
    }
}
