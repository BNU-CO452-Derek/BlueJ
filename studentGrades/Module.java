
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
    public static final int CREDIT = 20;
    
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
    
    public boolean isComplete()
    {
        return complete;
    }
}
