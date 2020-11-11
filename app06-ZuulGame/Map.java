
/**
 * Write a description of class Map here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Map
{
    private Room start;
    
    private String description;
    
    /**
     * Constructor for objects of class Map
     */
    public Map()
    {
        createStart();
        createBuilding();
    }
    
    /**
     * Create all the rooms and link their exits together.
     * and return the current room for the player to start
     */
    public Room createTestRooms()
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
    
    public Room getStartRoom()
    {
        return start;
    }
    
    private void createStart()
    {
        start = new Room("outside Brick Building");

        description =  "standing at the end of a road before a small\n";
        description += "brick building. Around you is a forest.  A small\n";
        description += "stream flows out of the building and down a gully\n.";
        
        start.setDescription(description);
    }
    
    /**
     * The building is North of the Start and contains
     * important items that need to be picked up
     */
    private void createBuilding()
    {
        Room building = new Room("inside Brick Building");
        
        description =  "in a well house for a large spring. ";
        description += "There are some keys on the ground here.";
        
        building.setDescription(description);
        
        start.setExit("north", building);
        building.setExit("south", start);
    }

}
