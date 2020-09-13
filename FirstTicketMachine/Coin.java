
/**
 * Enumeration class Coin - 
 * @author Dr Derek Peacock
 * @version 16/Apr/2016
 */
public enum Coin
{
    TEN_P (10),
    TWENTY_P (20),
    FIFTY_P (50),
    ONE_POUND (100),
    TWO_POUND (200);
    
    private final int value;
    
    private Coin(int value)
    {
        this.value = value;
    }
    
    public int getPenceValue()
    {
        return value;
    }
    
    public double getPoundValue()
    {
        return (double) value/100.0;
    }
}
