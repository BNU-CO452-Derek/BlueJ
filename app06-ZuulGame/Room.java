import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Room 
{
    private int id;
    
    private String name;
    
    private String description;
    
    private HashMap<String, Room> exits;        // stores exits of this room.
    
    private ItemTypes item;

    /**
     * Create a room named "name". Initially, it has
     * no exits. "name" is something like "kitchen" or
     * "Court Yard".
     * @param name The room's name.
     */
    public Room(int id, String name) 
    {
        this.name = name;
        this.description = name;
        this.id = id;
        
        exits = new HashMap<>();
        item = ItemTypes.NONE;
    }

    public int getID()
    {
        return id;
    }
    
    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return "You are  " + name;
    }

    /**
     * Return a description of the room in the form:
     * 
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return " You are " + name + "\n\n You are " + 
               description + ".\n" + getExitString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "\n Exits:";
        Set<String> keys = exits.keySet();
        
        for(String exit : keys) 
        {
            returnString += " " + exit;
        }
        
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public void setItem(ItemTypes item)
    {
        this.item = item;
    }
    
    public ItemTypes getItem()
    {
        return item;
    }
}

