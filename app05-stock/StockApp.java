
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
    public static final String ADD = "Add Product";
    public static final String DELIVER = "Deliver Product";
    public static final String SELL = "Sell Product";
    public static final String SEARCH = "Search for Product";
    public static final String REMOVE = "Remove Product";
    public static final String PRINT_LOW_STOCK = "Print Low Stock";
    public static final String PRINT_ALL = "Print All Products";
    public static final String QUIT = "Quit";
    
    // instance variables - replace the example below with your own
    private StockManager manager;

    private InputReader reader;
    
    private String[] menuChoices;
    
    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        menuChoices = new String[] 
        { 
            ADD, DELIVER, SELL,
            SEARCH, REMOVE, PRINT_LOW_STOCK,
            PRINT_ALL, QUIT
        };

        manager = new StockManager();
        StockDemo demo = new StockDemo(manager);
        
        reader = new InputReader();
        
    }

    
    public void run()
    {
        boolean finished = false;
        
        while(!finished)
        {
            printHeading();

            int choice = Menu.getIntChoice(menuChoices);
            //String choice = Menu.getStringChoice(menuChoices);
            
            finished = executeIntChoice(choice);
            //finished = executeStringChoice(choice);
        }
    }
    
    /**
     * Call on methods of the StockManager to
     * execute the selected menu choice
     */
    private boolean executeIntChoice(int choice)
    {
        
        switch(choice)
        {
            case 1: addProduct(); break;
            case 2: deliverProduct(); break;
            case 3: sellProduct(); break;
            case 4: searchProducts(); break;
            case 5: removeProduct(); break;
            case 6: printLowStock(); break;
            case 7: manager.printAllProducts(); break;
            case 8: return true;
            
            default: System.out.println(
                "    Please enter a choice between 1 and " + menuChoices.length);
        }
        
        return false;
    }
    
    private boolean executeStringChoice(String choice)
    {
        if(choice.equals(ADD.toLowerCase()))
        {
            addProduct();
        }
        else if(choice.equals(REMOVE.toLowerCase()))
        {
            removeProduct();
        }  
        else if(choice.equals(SELL.toLowerCase()))
        {
            sellProduct();
        }  
        else if(choice.equals(DELIVER.toLowerCase()))
        {
            deliverProduct();
        }          
        else if(choice.equals(PRINT_ALL.toLowerCase()))
        {
            manager.printAllProducts();
        }           
        else if(choice.equals(QUIT.toLowerCase()))
        {
            return true;
        }
        
        return false;
    }
    
    private void addProduct()
    {
        System.out.println(" Adding a new Product\n");
        
        String prompt = "\n Please enter the product ID number > ";
        int id = reader.getInt(prompt);

        prompt = "\n Please enter the product name > ";
        String name = reader.getString(prompt);    
        
        Product product = new Product(id, name);
        manager.addProduct(product);
        manager.takeDelivery(id,1);
        
        System.out.println("\n" + product + " added!\n");
        
    }

    /**
     * This method will ask the user to input a product id
     * and it will look for the product and if found will then
     * remove it from stock.
     */
    private void deliverProduct()
    {
        System.out.println(" Deliver an amount of an existing Product\n");
        Product product = getProduct();
        
        if(product != null)
        {
            String prompt = "\n Please enter the order quantity > ";
            int quantity = reader.getInt(prompt);
            
            manager.takeDelivery(product.getID(), quantity);
            System.out.println("\n" + quantity + " of " + 
                product + " delivered!\n");
        }
    }

    /**
     * This method will ask the user to input a product id
     * and it will look for the product and if found will then
     * remove it from stock.
     */
    private void removeProduct()
    {
        System.out.println(" Removing an old Product\n");
        Product product = getProduct();
        
        if(product != null)
        {
            manager.removeProduct(product.getID());
            System.out.println("\n" + product + " removed!\n");
        }
    }
    
    /**
     * This method will ask the user to input a product id
     * and it will look for the product and if found will then
     * remove it from stock.
     */
    private void sellProduct()
    {
        System.out.println(" Deliver an amount of an existing Product\n");
        Product product = getProduct();
        
        if(product != null)
        {
            String prompt = "\n    Please enter the order quantity > ";
            int quantity = reader.getInt(prompt);
        
            manager.sellProduct(product.getID(), quantity);
            System.out.println("\n    " + product + " " + quantity + " sold!\n");
        }
    }
    
    /**
     * This method will ask the user to input a product id
     * and it will look for the product and if found will then
     * remove it from stock.
     */
    private void printLowStock()
    {
        String prompt = "\n Please enter the minimum stock level > ";
        int minimum = reader.getInt(prompt);
        
        System.out.println(" Printing Stock with levels lower than " 
                           + minimum + "\n");
                           
        manager.printLowStockProducts(minimum);
    }
    
    /**
     * This method will ask the user to input a product id
     * and it will look for the product and if found will then
     * remove it from stock.
     */
    private void searchProducts()
    {
        String prompt = "\n Please enter search term > ";
        String target = reader.getString(prompt);
        
        System.out.println(" Printing products matching " 
                           + target + "\n");
                           
        manager.searchProducts(target);
    }

    
    private Product getProduct()
    {
        String prompt = "\n Please enter the product ID number > ";
        
        int id = reader.getInt(prompt);
        Product product = manager.findProduct(id);
        
        if(product == null)
            System.out.println("    Product " + id + " not found!");
            
        return product;
    }
    
    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("    Add:         Add a new product");
        System.out.println("    Deliver:     Deliver a product");
        System.out.println("    Sell  :      Sell a product");
        System.out.println("    Search:      Search products by name");
        System.out.println("    Remove:      Remove an old product");
        System.out.println("    Low Stock:   Print low stock products");
        System.out.println("    Print:       Print all products");
        System.out.println("    Quit:        Quit the program");
        System.out.println();
    }
    
    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        // System.out.print(ConsoleColours.ANSI_BRIGHT_GREEN + 
                         // ConsoleColours.ANSI_BRIGHT_BG_YELLOW + "  Colours  ");
                           
        System.out.println("    ******************************");
        System.out.println("     Stock Management Application ");
        System.out.println("       App05: by Derek Peacock");
        System.out.println("    ******************************\n");
    }
}
