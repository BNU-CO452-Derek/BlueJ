
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    public static final int MAX_ENERGY = 100;
    public static final int MIN_ENERGY = 10;
    
    private String name;
    
    private int score;
    
    private int turns;
    
    private int energy;
    
    private boolean alive;
    
    /**
     * Constructor for objects of class Player
     */
    public Player(String name)
    {
        this.name = name;
        
        energy = MAX_ENERGY;
        alive = true;
        
        score = 0;
        turns = 0;
    }

}
