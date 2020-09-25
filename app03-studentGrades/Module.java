
/**
 * A Module is part of a course that a Student
 * will complete.  When complete a Module is awarded
 * a mark and providing it is a pass mark students
 * gain credit for completing the Module
 *
 * @author Derek Peacock
 * @version 0.1
 */
public class Module
{
    public static final int CREDIT = 30;
    
    private String code;
    private String title;
    
    private int mark;
    private boolean complete;
    
    /**
     * Constructor for objects of class Module
     */
    public Module(String code, String title)
    {
        this.code = code;
        this.title = title;
        
        complete = false;
        mark = -1;
    }

    /**
     * Return a mark between 0 and 100.  A mark less
     * than zero indicates that no mark has yet been
     * awarded
     */
    public int getMark()
    {
        // put your code here
        return mark;
    }
    
    /***
     * A mark has been awarded and the module is
     * completed
     */
    public boolean isComplete()
    {
        return complete;
    }
    
    public void awardMark(int mark)
    {
        if((mark >= 0) && (mark <= 100))
        {
            this.mark = mark;
            complete = true;
        }
    }
    
    public void print()
    {
        System.out.print("\tModule " + code);
        System.out.print(" " + title);
           
        if(isComplete())
        {
            System.out.println(" mark = " + mark);
        }
        else
        {
            System.out.println(" is not completed yet!");
        }
        
    }    
}
