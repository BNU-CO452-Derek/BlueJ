
/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Derek Peacock
 * @version 0.1
 */
public class StockApp
{
    // instance variables - replace the example below with your own
    private StockManager manager;

    private InputReader input;
    
    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        manager = new StockManager();
        input = new InputReader();
    }


    
    public void run()
    {
        printHeading();
        getMenuChoice();
    }
    
    /**
     * 
     */
    public void getMenuChoice()
    {
        boolean finished = false;
        
        while(!finished)
        {
            printHeading();
            printMenuChoices();
            String choice = input.getInput();
            executeMenuChoice(choice);
        }
    }
    
    /**
     * Call on methods of the StockManager to
     * execute the selected menu choice
     */
    private void executeMenuChoice(String choice)
    {
        
        
    }
    
    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println("Add:      Add a new product");
        System.out.println("Remove:   Remove an old product");
        System.out.println("PrintAll: Print all products");
        System.out.println("Quit:     Quit the program");
        
    }
    
    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        System.out.println("******************************");
        System.out.println(" Stock Management Application ");
        System.out.println("    App05: by Derek Peacock");
        System.out.println("******************************");
    }
}
