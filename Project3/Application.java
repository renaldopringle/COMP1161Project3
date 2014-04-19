package Project3;


import java.util.*;

/**
 * Write a description of class Application here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Application
{
    public static void main(String[] args) {
        Organization[] organization = new Organization[5];
        int regNum, num;
        String location, contact;
        
        Organization bank1 = new Bank("1001","The First Bank","B");
        Organization bank2 = new Bank("1002","The National Bank","B");
        Organization school1 = new School("1003","The First School","S");
        Organization school2 = new School("1004","The National School","S");
        Organization school3 = new School("1005","Home School","S");
        
        organization[0] = bank1;
        organization[1] = bank2;
        organization[2] = school1;
        organization[3] = school2;
        organization[4] = school3;

        
        Scanner scan = new Scanner(System.in);
        Scanner scanLocation = new Scanner(System.in);
        Scanner scanContact = new Scanner(System.in);
        
        for (Organization org : organization) {
            System.out.print("\nEnter the nuber of branches for " + org.getName() + " oranization: ");
            num = scan.nextInt();
            for (int i = 0; i < num; i++) {
                System.out.print("\nPlease enter registration number: ");
                regNum = scan.nextInt();
                System.out.print("Please enter location: ");
                location = scanLocation.nextLine();
                System.out.print("Please enter contact number: ");
                contact = scanContact.nextLine();
                org.addBranch(regNum,location,contact);
            }
        }
        
        Sorting.selectionSort(organization);
        
        for (Organization organizations : organization) {
            System.out.println("============================================");
            System.out.println(organizations);
        }
    }
}

