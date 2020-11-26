import java.io.IOException;
/**
 * This class creates an instance of the StockApp
 * and then calls on its run method.
 *
 * @author Derek Peacock
 * @version 0.1
 */
public class Program
{
    private static StockApp app;

    /**
     * This class creates and runs an instance of
     * the StockApp class
     */
    public static void main() throws IOException
    {
        char escCode = 0x1B;
        int row = 10, col = 20;
        System.out.print(String.format("%c[%d;%df",escCode,row, col));
        System.out.println("XXX");
        
        // app = new StockApp();
        // app.run();
        
        // InputReader reader = new InputReader();
        // //char c = reader.getChar();
        // int letter = System.in.read();
        // System.out.println("Character = " + letter);
        
    }
}
