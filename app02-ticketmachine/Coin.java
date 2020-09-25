
/**
 * Enumeration class Coin - This simulates coins
 * of value 10, 20, 100 and 200 pence.
 * 
 * @author Dr Derek Peacock
 * @version 16/Apr/2016, modified 16/09/2020
 */
public enum Coin
{
    P10 (10),
    P20 (20),
    P100 (100),
    P200 (200);
    
    private final int value;
    
    private Coin(int value)
    {
        this.value = value;
    }
    
    public int getValue()
    {
        return value;
    }
 }
