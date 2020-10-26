import java.util.ArrayList;

/**
 * This class stores information about the player
 * including the player's current state in terms
 * of energy, score and the number of turns so far.
 * The player can carry a number of items up to 
 * the maximum weight.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    public static final int MAX_ENERGY = 100;
    public static final int MIN_ENERGY = 10;
    public static final int MAX_WEIGHT = 100;
    
    private String name;
    
    private int score;
    
    private int turns;
    
    private int energy;
    
    private boolean alive;
    
    private ArrayList<Item> items;
    
    /**
     * Constructor for objects of class Player
     */
    public Player(String name)
    {
        this.name = name;
        items = new ArrayList<Item>();
        
        energy = MAX_ENERGY;
        alive = true;
        
        score = 0;
        turns = 0;
    }

    public String getName()
    {
        return this.name;
    }//end method getName

    public void setName(String name)
    {
        this.name = name;
    }//end method setName

    public int getScore()
    {
        return this.score;
    }//end method getScore

    public void setScore(int score)
    {
        this.score = score;
    }//end method setScore

    public int getTurns()
    {
        return this.turns;
    }//end method getTurns

    public void incTurns()
    {
        this.turns++;
    }//end method setTurns

    public int getEnergy()
    {
        return this.energy;
    }//end method getEnergy

    public void incEnergy(int increase)
    {
        this.energy += increase;
    }//end method setEnergy

    public void decEnergy(int decrease)
    {
        this.energy -= decrease;
    }//end method setEnergy
    
    public boolean getAlive()
    {
        return this.alive;
    }//end method getAlive

    public void setAlive()
    {
        this.alive = true;
    }//end method setAlive

    public ArrayList<Item> getItems()
    {
        return this.items;
    }//end method getItems

    public void addItem(Item item)
    {
        this.items.add(item);
    }//end method setItems

    public void removeItem(Item item)
    {
        this.items.remove(item);
    }//end method setItems    
    //End GetterSetterExtension Source Code
//!
}