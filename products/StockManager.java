import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        stock.add(item);
    }
    
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
    }
    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        int index = 0;
        boolean found = false;
        Product product = null;
        
        while(!found && index < stock.size())
        {
           product = stock.get(index);
           if(product.getID() == id)
           {
               found = true;
           }
           else index++;
        }
        
        return product;
    }
    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        return 0;
    }

    /**
     * Print details of all the products.
     */
    public void printAllProducts()
    {
        for(Product product : stock)
        {
            System.out.println(product);
        }
    }
    
    /**
     * 
    */
    public void printOutofStockProducts()
    {
        int count = 0;
        
        System.out.println(" Printing all out of stock products");
        System.out.println();
        
        for(Product product : stock)
        {
            if(product.getQuantity() == 0)
            {
                count++;
                System.out.println(product);
            }
        }
        
        System.out.println();
        System.out.println(" There were " + count + " out of stock products");
    }
}
