
/**
 * Write a description of class Map here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Map
{
    /**
     * Constructor for objects of class Map
     */
    public Map()
    {
    }
    
    /**
     * Create all the rooms and link their exits together.
     * and return the current room for the player to start
     */
    public Room createRooms()
    {
        Room outside, theater, pub, lab, office;
      
        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        
        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theater.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        return outside;  // start game outside
    }
    
    public Room create()
    {
        Room outside = new Room("outside Brick Building");

        String description;
        description = "standing at the end of a road before a small\n";
        description += "brick building. Around you is a forest.  A small\n";
        description += "stream flows out of the building and down a gully\n.";
        
        outside.setDescription(description);
        
        Room building = new Room("inside Brick Building");
        
        description = "in a well house for a large spring.  There are some\n";
        description += "keys on the ground here.";
        
        building.setDescription(description);
        outside.setExit("north", building);
        building.setExit("south", outside);
        
        return outside;
    }
    

}
