package Project3;


/**
 * Write a description of class Branch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Branch
{
    private String branchNum;
    private String location;
    private String contactNum;
    
    public Branch(String branchNum, String location, String contactNum) 
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
    
    public String getBranchNum() {
        return this.branchNum;
    }
    
    public String toString() {
        return ("B" + "|" + branchNum + "|" + location + "|" + contactNum);
    }
    
    public String getKey() {
        return this.branchNum;
    }
}
