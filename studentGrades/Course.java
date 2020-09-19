
/**
 * This class stores information about a course
 * that enrolled students may want to complete
 *
 * @author Derek Peacock
 * @version 0.1 11/Sep/2020
 */
public class Course
{
    // instance variables - replace the example below with your own
    private String codeNo;
    private String title;
    
    private int noModules;
    private int totalCredits;
    private int totalMark;
    private boolean complete;
    
    private Module module1;
    private Module module2;
    private Module module3;
    private Module module4;

    /**
     * Constructor for objects of class Course
     */
    public Course(String codeNo, String title)
    {
        this.codeNo = codeNo;
        this.title = title;
        
        noModules = 0;
        totalMark = 0;
        totalCredits = 0;
        complete = false;
    }

    /**
     * Add module 1 to 4 to the Course
     */
    public void addModule(int number, Module module)
    {
        if((number >= 1) && (number <= 4)) noModules++;
        
        switch(number)
        {
            case 1: module1 = module; 
            case 2: module2 = module;
            case 3: module3 = module;
            case 4: module4 = module;
        }
    }
    
    /**
     * Prints out the details of a course
     */
    public void print()
    {
        // put your code here
        System.out.println("Course " + codeNo + " - " + title);
    }
    
    /**
     * Print out all the module that exist in this course
     */
    public void printModules()
    {
        module1.print();
        module2.print();
        module3.print();
        module4.print();
    }
    
   public void printGrade()
   {
       if(noModules == 4)
       {
           totalMark = 0;
           
           addMark(module1);
           addMark(module2);
           addMark(module3);
           addMark(module4);
           
           if(totalCredits == 120)
           {
               System.out.println("Your final grade is " + 
               calculateGrade());
           }
           else
           {
               System.out.println("You have not completed the course yet!");
            }
       }
   }
   
   private void addMark(Module module)
   {
       if(module.isComplete())
       {
           totalMark = totalMark + module.getMark();
           totalCredits += module.CREDIT;
       }
   }
   
   private String calculateGrade()
   {
       if(totalMark <= 40)
       {
           return "F";
       }
       else if(totalMark <= 50)
       {
           return "D";
       }
       else if(totalMark <= 60)
       {
           return "C";
       }
       else if(totalMark <= 70)
       {
           return "B";
       }
       else return "A";
   }
}
