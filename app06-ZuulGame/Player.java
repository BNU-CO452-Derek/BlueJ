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
    
    private String name;
    
    private int score;
    
    private int turns;
    
    private int energy;
    
    private boolean alive;
    
    private ArrayList<ItemTypes> items;
    
    /**
     * Constructor for objects of class Player
     */
    public Player(String name)
    {
        this.name = name;
        items = new ArrayList<ItemTypes>();
        
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

    public void incScore(int amount)
    {
        score = score + amount;
    }//end method setScore

    public void decScore(int amount)
    {
        score = score - amount;
    }//end method setScore
    
    public int getTurns()
    {
        return this.turns;
    }//end method getTurns

    public void incTurns()
    {
        this.turns++;
        this.energy--;
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
        if(energy < MIN_ENERGY)
            alive = false;
    }//end method setEnergy
    
    public boolean getAlive()
    {
        return this.alive;
    }//end method getAlive

    public void setAlive()
    {
        this.alive = true;
    }//end method setAlive

    public ArrayList<ItemTypes> getItems()
    {
        return this.items;
    }//end method getItems

    public void addItem(ItemTypes item)
    {
        this.items.add(item);
    }//end method setItems

    public void removeItem(ItemTypes item)
    {
        this.items.remove(item);
    }//end method setItems    

    public String toString()
    {
        String output = "\n " + name + ": Turn " + turns + " Energy = " + energy;
        output += " Score = " + score;
        
        return output;
    }
}
