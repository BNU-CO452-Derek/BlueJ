/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 * 
 * @modifed by Derek Peacock
 * 22/Sep/2020
 */
public class StockDemo
{
    // The stock manager.
    private StockManager manager;

    /**
     * Create a StockManager and populate it with
     * 10 sample products.
     */
    public StockDemo()
    {
        manager = new StockManager();
        
        manager.addProduct(new Product(100,"Apple iPhone 11", 4));
        manager.addProduct(new Product(101,"Samsung Galaxy S10", 7));
        manager.addProduct(new Product(102,"Samsung Galaxy S20", 2));
        manager.addProduct(new Product(103,"Gogle Pixel 4A", 1));
        manager.addProduct(new Product(104,"Motorola G8 Power Lite", 0));
        manager.addProduct(new Product(105,"Motorola G8 Power", 3));
        manager.addProduct(new Product(106,"Huawei Mate 30 Pro", 1));
        manager.addProduct(new Product(107,"Huawei Mate Xs 5G", 1));
        manager.addProduct(new Product(108,"Sony Xperia 5", 8));
        manager.addProduct(new Product(109,"Apple iPhone 12", 10));
    }
    
    public void runDemo()
    {
       System.out.println("\n*******************************");
       System.out.println("  Products Management Demo");
       System.out.println("     by Derek Peacock ");
       System.out.println("*******************************\n");
       
       manager.printAllProducts();
       
       manager.removeProduct(102);
       manager.renameProduct(103, "Google Pixel 4A");
       
       sellProducts();
       
       manager.restockLowProducts(3);
       
       manager.searchProducts("Apple");
    }
    
   
    /**
     * Show details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
    public void printDetails(int id)
    {
        Product product = getProduct(id);
        
        if(product != null) 
        {
            System.out.println(product.toString());
        }
    }
    
    /**
     * Demonstrate that the StockManager can sell
     * products
     */
    public void sellProducts()
    {
        for(int id = 100; id <= 109; id++ )
        {
            sellProduct(id);
        }
    }
    
    /**
     * Sell one of the given product item.
     * Print the before and after status of the product.
     * @param id The ID of the product being sold.
     */
    public void sellProduct(int id)
    {
        Product product = getProduct(id);
        
        if(product != null) 
        {
            System.out.println();
            printDetails(id);
            product.sellOne();
            printDetails(id);
        }
    }
    
    /**
     * Get the product with the given id from the manager.
     * An error message is printed if there is no match.
     * @param id The ID of the product.
     * @return The Product, or null if no matching one is found.
     */
    public Product getProduct(int id)
    {
        Product product = manager.findProduct(id);
        
        if(product == null) 
        {
            System.out.println("Product with ID: " + id +
                               " is not recognised.");
        }
        return product;
    }
    
    /**
     * Demonstrate that the stock manager can increase stock
     * levels for the given product id
     */
    public void reStock(int id, int amount)
    {
        manager.delivery(id, amount);
    }
    
    /**
     * Demonstrate that a product can be removed from
     * the stock by the StockManager
     */
    public void removeProduct(int id)
    {
        manager.printAllProducts();
        manager.removeProduct(id);
        manager.printAllProducts();
    }
    
    
}
