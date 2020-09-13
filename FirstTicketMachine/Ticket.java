/**
 * Write a description of class Ticket here.
 * 
 * @author Dr Derek Peacock 
 * @version 16 Apr 2016
 */
public class Ticket
{
    // The extra time in minutes on top of the allowed time
    public static final int EXTRA_TIME = 10;
    // Cost of ticket in pence
    private int cost;
    // Maximum time allowed in hours
    private int maxTime;

    /**
     * Constructor for objects of class Ticket
     */
    public Ticket(int cost, int time)
    {
        // initialise instance variables
        this.cost = cost;
        this.maxTime = time;
    }

    /**
     * Return the cost of the ticket in pence
     */
    public int getCost()
    {
        return cost;
    }
    
    /**
     * Return the maximum time allowed in hours
     */
    public int getMaxTime()
    {
        return maxTime;
    }
    
}
