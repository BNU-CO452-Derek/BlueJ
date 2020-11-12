                                                                                                                                                                    
/**
 * Write a description of class Map here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Map
{
    private Room building;
    private Room start;
    private Room eastForest;
    private Room westForest;
    private Room valley;
    private Room slit;
    private Room grate;
    
    private String description;
    
    /**
     * Constructor for objects of class Map
     */
    public Map()
    {
        createStart();
        createBuilding();
        createEastForest();
        createWestForest();
        createValley();
        createSlit();
        createGrate();
    }
    
    /**
     * Create all the rooms and link their exits together.
     * and return the current room for the player to start
     */
    public Room createTestRooms()
    {
        Room outside, theater, pub, lab, office;
      
        // create the rooms
        outside = new Room(" outside the main entrance of the university");
        theater = new Room(" in a lecture theater");
        pub = new Room(" in the campus pub");
        lab = new Room(" in a computing lab");
        office = new Room(" in the computing admin office");
        
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
    
    /**
     * This is the room the player starts in
     */
    private void createStart()
    {
        start = new Room(" outside Brick Building");

        description =  " standing at the end of a road before a small\n";
        description += " brick building. Around you is a forest.  A small\n";
        description += " stream flows out of the building and down a gully\n.";
        description += " There is an empty bottle on the ground.";
        
        start.setDescription(description);
        start.setItem(ItemTypes.BOTTLE);
    }
    
    /**
     * The building is North of the Start and contains
     * important items that need to be picked up
     */
    private void createBuilding()
    {
        building = new Room("inside Brick Building");
        
        description =  " in a well house for a large spring. ";
        description += "\nThere are some keys on the ground here.";
        
        building.setDescription(description);
        building.setItem(ItemTypes.KEY);
        connectRooms(start, "north", building);
    }

    private void createEastForest()
    {
        eastForest = new Room("lost in thick Forest");
        
        description =  " up a hill, still in the forest.  \nThe road";
        description += " slopes back down the other side of the hill.";
        description += " \nThere is a building in the distance";
        
        eastForest.setDescription(description);        
        
        //eastForest.setExit("west", start);
        //start.setExit("east", eastForest);
        connectRooms(start, "east", eastForest);        
    }
    
    private void createWestForest()
    {
        westForest = new Room("lost in open Forest");
        
        description =  " in open forest, with a deep valley to one side";
        westForest.setDescription(description);        
        
        connectRooms(start, "west", westForest);
    }
    
    /**
     * 
     */
    private void createValley()
    {
        valley = new Room("in a valley");
        
        description = " in a valley in the forest beside a stream";
        description += "\n tumbling along a rocky bed.";
        
        valley.setDescription(description);
        
        connectRooms(start, "south", valley);
        
        Room forest = cloneRoom(eastForest);
        connectRooms(valley, "east", forest);
        
        forest = cloneRoom(westForest);
        connectRooms(valley, "west", forest);        
    }

    private void createSlit()
    {
        slit = new Room("at slit in streambed");
        
        description = "standing, at your feet all the water of the stream";
        description += " \n splashes into a 2-inch slit in the rock.  ";
        description += " \n Downstream the streambed is bare rock";
        
        slit.setDescription(description);
        connectRooms(slit, "north", valley);
    }
    
    private void createGrate()
    {
        grate = new Room("beside a grate");
        
        description = " You are in a 20-foot depression floored ";
        description += " \n with bare dirt.  Set into the dirt ";
        description += " \n is a strong steel grate. The grate is locked";

        grate.setDescription(description);
        connectRooms(grate, "north", slit);
    }
    
    private void connectRooms(Room room, String direction, Room otherRoom)
    {
        room.setExit(direction, otherRoom);
        
        if(direction.equals("east"))
        {
            otherRoom.setExit("west", room);
        }
        else if(direction.equals("west"))
        {
            otherRoom.setExit("east", room);
        }
        else if(direction.equals("north"))
        {
            otherRoom.setExit("south", room);
        }
        else if(direction.equals("south"))
        {
            otherRoom.setExit("north", room);
        }        
    }
    
    private Room cloneRoom(Room toClone)
    {
        Room room = new Room(toClone.getName());
        room.setDescription(toClone.getDescription());

        return room;
    }
}
