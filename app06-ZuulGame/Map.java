                                                                                                                                                                    
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
    private Room chamber;
    
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
        createChamber();
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
        start = new Room(0, " outside Brick Building");

        description =  
        " standing at the end of a road before a brick \n" +
        " building. Around you is a forest. A small stream\n" +
        " flows out of the building and down a gully.";
        
        start.setWater();
        start.setDescription(description);
        start.setItem(ItemTypes.BOTTLE, "\n There is an empty bottle on the ground");
    }
    
    /**
     * The building is North of the Start and contains
     * important items that need to be picked up
     */
    private void createBuilding()
    {
        building = new Room(2, "inside Brick Building");
        
        description =  " in a well house for a large spring. ";
        
        building.setDescription(description);
        building.setItem(ItemTypes.KEY, "\n There are some keys on the ground here.");
        connectRooms(start, "north", building);
    }

    private void createEastForest()
    {
        eastForest = new Room(3, "lost in thick Forest");
        
        description =  " up a hill, still in the forest.  \n The road";
        description += " slopes back down the other side of the hill.";
        description += " \n There is a building in the distance";
        
        eastForest.setDescription(description);        
        
        //eastForest.setExit("west", start);
        //start.setExit("east", eastForest);
        connectRooms(start, "east", eastForest);        
    }
    
    private void createWestForest()
    {
        westForest = new Room(4, "lost in open Forest");
        
        description =  " in open forest, with a deep valley to one side";
        westForest.setDescription(description);        
        
        connectRooms(start, "west", westForest);
    }
    
    /**
     * 
     */
    private void createValley()
    {
        valley = new Room(5, "in a valley");
        
        description = " in a valley in the forest beside a stream";
        description += "\n tumbling along a rocky bed.";
        valley.setDescription(description);
        
        valley.setWater();
        valley.setItem(ItemTypes.FOOD,
            "\n There are a couple of apple trees with fruit");
            
        connectRooms(start, "south", valley);
        
        Room forest = cloneRoom(6, eastForest);
        connectRooms(valley, "east", forest);
        
        forest = cloneRoom(7, westForest);
        connectRooms(valley, "west", forest);        
    }

    private void createSlit()
    {
        slit = new Room(8, "at slit in streambed");
        
        description = "standing, at your feet all the water of the stream";
        description += " \n splashes into a 2-inch slit in the rock.  ";
        description += " \n Downstream the streambed is bare rock";
        
        slit.setDescription(description);
        slit.setWater();
        connectRooms(slit, "north", valley);
    }
    
    private void createGrate()
    {
        grate = new Room(9, "beside a grate");
        
        description = " You are in a 20-foot depression floored ";
        description += " \n with bare dirt.  Set into the dirt ";
        description += " \n is a strong steel grate. The grate is locked";

        grate.setDescription(description);
        connectRooms(grate, "north", slit);
    }
    
    private void createChamber()
    {
        chamber = new Room(10, "in a chamber");
        
        description = "You are in a small chamber beneath a 3x3 steel";
        description.join("\ngrate to the surface.",
            "\nA low crawl over cobbles leads inward to the west.");
        
        chamber.setDescription(description);
        connectRooms(grate, "down", chamber);
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
        else if(direction.equals("down"))
        {
            otherRoom.setExit("up", room);
        }
    }
    
    private Room cloneRoom(int id, Room toClone)
    {
        Room room = new Room(id, toClone.getName());
        room.setDescription(toClone.getDescription());

        return room;
    }
    
    /**
     * Create all the rooms and link their exits together.
     * and return the current room for the player to start
     */
    public Room createTestRooms()
    {
        Room outside, theater, pub, lab, office;
      
        // create the rooms
        outside = new Room(1, " outside the main entrance of the university");
        theater = new Room(2, " in a lecture theater");
        pub = new Room(3, " in the campus pub");
        lab = new Room(4, " in a computing lab");
        office = new Room(5, " in the computing admin office");
        
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
}
