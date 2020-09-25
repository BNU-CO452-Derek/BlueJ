
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

    private InputReader reader;
    
    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        manager = new StockManager();
        reader = new InputReader();
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
            
            String prompt = "\nEnter your choice > ";
            String choice = reader.getInput(prompt).toLowerCase();
            
            if(choice.startsWith("quit"))
            {
                finished = true;
            }
            else
            {
                executeMenuChoice(choice);
            }
        }
    }
    
    /**
     * Call on methods of the StockManager to
     * execute the selected menu choice
     */
    private void executeMenuChoice(String choice)
    {
        if(choice.startsWith("add"))
        {
            addProduct();
        }
    }
    
    private void addProduct()
    {
        System.out.println(" Adding a new Product\n");
        
        String prompt = "\n Please enter the product code > ";
        int code = reader.getInt(prompt);

        prompt = "\n Please enter the product name > ";
        String name = reader.getInput(prompt);    
        
        Product product = new Product(code, name);
        manager.addProduct(product);
        
        System.out.println("\n" + product + " added!\n");
        
    }
    
    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("    Add:         Add a new product");
        System.out.println("    Remove:      Remove an old product");
        System.out.println("    PrintAll:    Print all products");
        System.out.println("    Quit:        Quit the program");
        System.out.println();
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
