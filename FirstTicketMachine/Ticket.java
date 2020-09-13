/**
 * Write a description of class Ticket here.
 * 
 * @author Dr Derek Peacock 
 * @version 16 Apr 2016
 */
public class Ticket
{
    // Price of ticket in pence
    private int price;
    // Maximum time allowed in hours
    private String destination;

    /**
     * Constructor for objects of class Ticket
     */
    public Ticket( String destination, int price)
    {
        // initialise instance variables
        this.price = price;
        this.destination = destination;
    }

    /**
     * Return the price of the ticket in pence
     */
    public int getPrice()
    {
        return price;
    }
    
    /**
     * Return the name of the destination
     */
    public String getDestination()
    {
        return destination;
    }
    
}
