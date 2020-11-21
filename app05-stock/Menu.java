
/**
 * Write a description of class Menu here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Menu
{
    private static InputReader reader = new InputReader();
    
    public static int getChoice(String [] choices)
    {
        int choice = 0;
        
        printChoices(choices);
        choice = reader.getInt("\n    Enter choice number > ");
        
        return choice;
    }
    
    private static void printChoices(String [] choices)
    {
        for(int index = 0; index < choices.length; index++)
        {
            System.out.println("    " + (index + 1) + ". " + choices[index]);
        }
    }
}
