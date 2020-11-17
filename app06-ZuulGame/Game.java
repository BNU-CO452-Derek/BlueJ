/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. 
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method or run the Program.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * 
 * Modified and extended by Derek Peacock
 * October 26th 2020
 * Version 0.1
 */

public class Game 
{
    public static final int TAKE_SCORE = 10;
    public static final int MOVE_ENERGY = 10;
    public static final int WATER_ENERGY = 10;
    public static final int COMMAND_ENERGY = 2;
    
    public static final char CLEAR_SCREEN ='\u000C';
    
    private Parser parser;
    private Room currentRoom;
    private Player player;
    private Map map;
    
    /**
     * Create the game and initialise its internal map.
     */
    public Game(String playerName) 
    {
        player = new Player(playerName);
        
        map = new Map();
        currentRoom = map.getStartRoom();
        
        parser = new Parser();
    }


    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        
        while (! finished) 
        {
            Command command = parser.getCommand();
            finished = processCommand(command);
            
            if(!player.isAlive())
            {
                System.out.println(" \nYou have died of lack of water or food!\n");
                finished = true;
            }
        }
        
        System.out.println(" Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println(CLEAR_SCREEN);
        System.out.println(" Welcome to the World of Zuul!");
        System.out.println(" World of Zuul is a new, incredibly exiting adventure game.");
        System.out.println(" Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        
        System.out.println(player);
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;
        player.decEnergy(COMMAND_ENERGY);
        
        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) 
        {
            case UNKNOWN:
                System.out.println(" I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case LOOK:
                System.out.println(currentRoom.getLongDescription());
                break;

            case TAKE:
                takeItem(command);
                break;
                
            case FILL:
                fill(command);
                break;
                
            case QUIT:
                wantToQuit = quit(command);
                break;
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println(player);
        System.out.println(" You are currently " + currentRoom.getShortDescription());
        System.out.println();
        System.out.println(" Your command words are:");
        
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) 
        {
            // if there is no second word, we don't know where to go...
            System.out.println(" Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) 
        {
            System.out.println(" There is no exit!");
        }
        else 
        {
            currentRoom = nextRoom;
            
            player.decEnergy(MOVE_ENERGY);
            player.incMoves();
            
            System.out.println(player);
            System.out.println(currentRoom.getShortDescription());
        }
    }

    public void takeItem(Command command)
    {
        ItemTypes item = currentRoom.getItem();
        
        if(item == ItemTypes.NONE)
        {
            System.out.println("\n There is nothing here to take!");
        }
        else
        {
            String object = command.getSecondWord();
            if(object != null)
            {
                String stringItem = item.toString();
                
                if(object.equals(stringItem))
                {
                    currentRoom.removeItem();

                    player.addItem(item);
                    player.incScore(TAKE_SCORE);
                    
                    System.out.println("\n You have taken the " + item);
                    System.out.println(player);
                    System.out.println(currentRoom.getShortDescription());                    
                }
                else
                {
                    System.out.println("\n You can't take the " + object);
                }
            }
        }
    }
    
    private void fill(Command command)
    {
        if(currentRoom.getID() == 0)
        {
            String object = command.getSecondWord();
            
            if(object.equals(ItemTypes.BOTTLE.toString()))
            {
                player.addItem(ItemTypes.WATER);
                player.incEnergy(WATER_ENERGY);
                player.incScore(TAKE_SCORE);
                
                System.out.println(player);
                System.out.println(currentRoom.getShortDescription());                
            }
            else
            {
                System.out.println(" You do not have a bottle!");
            }
        }
        else
        {
            System.out.println(" There is no water here!");
        }
    }
    
    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) 
        {
            System.out.println("Quit what?");
            return false;
        }
        else 
        {
            return true;  // signal that we want to quit
        }
    }
}
