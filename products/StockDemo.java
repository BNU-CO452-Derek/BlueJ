/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
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
        manager.addProduct(new Product(103,"Google Pixel 4A", 1));
        manager.addProduct(new Product(104,"Motorola G8 Power Lite", 0));
        manager.addProduct(new Product(105,"Motorola G8 Power", 3));
        manager.addProduct(new Product(106,"Huawei Mate 30 Pro", 1));
        manager.addProduct(new Product(107,"Huawei Mate Xs 5G", 1));
        manager.addProduct(new Product(108,"Sony Xperia 5", 8));
        manager.addProduct(new Product(109,"Apple iPhone 12", 10));
    }
    
    /**
     * Provide a very simple demonstration of how a StockManager
     * might be used. Details of one product are shown, the
     * product is restocked, and then the details are shown again.
     */
    public void printAllProducts()
    {
        // Show details of all of the products.
        manager.printAllProducts();
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
    
    public void printOutofStocks()
    {
        manager.printOutofStockProducts();
    }
    
    /**
     * Sell one of the given item.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
    public void sellProduct(int id)
    {
        Product product = getProduct(id);
        
        if(product != null) 
        {
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
     * Demonstrate that the manager can increate stock
     * levels for the given product id
     */
    public void reStock(int id, int amount)
    {
        manager.delivery(id, amount);
    }
    
    public void removeProduct(int id)
    {
        printAllProducts();
        manager.removeProduct(id);
        printAllProducts();
    }
    
    
}
