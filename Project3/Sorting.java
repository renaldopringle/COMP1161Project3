package Project3;


/**
 * Write a description of class Sorting here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sorting
{
    public static void selectionSort (Organization[] list)
    {
        int min;
        Organization temp;
        
        for (int index = 0; index < list.length-1; index++) {
            min = index ;
            for (int scan = index + 1; scan < list.length; scan++) {
                if (list[scan].compareTo(list[min]) < 0) {
                    min = scan;
                }
                temp = list[min];
                list[min] = list[index];
                list[index] = temp;
            }
        }
    }
}

