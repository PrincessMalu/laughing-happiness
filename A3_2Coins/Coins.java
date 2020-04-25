import java.lang.reflect.Field;
import java.util.Scanner;


/**
 * Coins: This class accepts a certain amount of monetary change (in cents). The
 * output is a list of the number of quarters, dimes, nickels, and pennies that
 * will make that amount of change with the least number of coins possible.
 *
 * @author Malavika Nair
 * @version September 3, 2019
 * @author Period: 1st Period
 * 
 * @author Assignment: Lab Activity 3.2 - Coins
 * 
 * @author Sources: None
 */
public class Coins
{
    private int myChange;


    /**
     * @param change
     *            user input amount of cents
     */
    public Coins( int change )
    {
        myChange = change;
    }


    /**
     * Calculates the number of quarters. nickels, dimes and pennies that should
     * be given back to the customer from the entered amount of change.
     */
    public void calculate()
    {
        int quarter = 0;
        int dime = 0;
        int nickels = 0;
        int penny = 0;
        int rem = 0;
        int rem1 = 0;
        int rem2 = 0;
        quarter = myChange / 25;
        rem = myChange % 25;
        dime = rem / 10;
        rem1 = rem % 10;
        nickels = rem1 / 5;
        rem2 = rem1 % 5;
        penny = rem2;
        System.out.println( myChange + " ==>" );
        System.out.println( "Quarter(s)    " + quarter );
        System.out.println( "Dime(s)       " + dime );
        System.out.println( "Nickel(s)     " + nickels );
        System.out.println( "Penny(s)      " + penny );

    }


    /**
     * Intended only for debugging.
     * 
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Easter.
     */
    public String toString()
    {
        String str = this.getClass().getName() + "[";
        String separator = "";

        Field[] fields = this.getClass().getDeclaredFields();

        for ( Field field : fields )
        {
            try
            {
                str += separator + field.getType().getName() + " " + 
                field.getName() + ":"+ field.get( this );
            }
            catch ( IllegalAccessException ex )
            {
                System.out.println( ex );
            }
            separator = ", ";
        }
        return str + "]";
    }


    /**
     * Tester for the Coins class.
     * 
     * @param args
     *            command line arguments - not used
     */
    public static void main( String[] args )
    {
        Scanner console = new Scanner( System.in );

        System.out.print( "Please enter the number of cents --> " );
        int cents = console.nextInt();

        Coins change = new Coins( cents );
        change.calculate();
    }
}
