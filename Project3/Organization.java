package Project3;

import java.util.*;

/**
 * Abstract class Organization - write a description of the class here
 * 
 * @author Renaldo Pringle - 620067065
 * @author Antonio Fearon - 620065389
 * @version April/17/14
 */
public abstract class Organization implements Record
{
    protected String regNum;
    protected String name;
    protected String type;
    protected ArrayList<Branch> branchList = new ArrayList<Branch>();
    protected int countBank;
    protected int countSchool;
    
    /**
     * @param regNum organization registration number
     * @param name organization name
     * @param type type of organization
     */
    public Organization(String regNum, String type, String name) 
    {
        this.regNum = regNum;
        this.name = name;
        this.type = type;
    }
    
    /**
     * @param branchNum branch number
     * @param location branch location
     * @param contact branch contact information
     */
    public void addBranch(int branchNum, String location, String contact) {
        Branch branch = new Branch(branchNum,location,contact);
        branchList.add(branch);
    }
    
    /**
     * @param
     */
    public boolean equals(Organization org1, Organization org2) {
        if (org1.getRegNum() == (org2.getRegNum())) {
            return true;
        }else{
            return false;
        }
    }
    
    public String getRegNum() {
        return this.regNum;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void incCountBank() {
        countBank += 1;
    }
    
    public void incCountSchool() {
        countSchool += 1;
    }
    
    public int compareTo(Organization org) {
        if ((this.regNum.compareTo(org.getRegNum())) == 0) {
            return 1;
        }else{
            return -1;
        }
    }
    
    public String getBranches() {
        String branches = "";
        for (Branch branch : branchList) {
            branches += ("\n\n" + branch);
        }
        return branches;
    }
    
    public String toString() {
        return ("O" + "|" + regNum + "|" + type + "|" + name);
    }
}