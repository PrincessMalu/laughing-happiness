import java.lang.reflect.*;
import java.util.*;


/**
 *  Represents a brokerage.
 *
 *  @author  Malavika Nair
 *  @version April 19, 2020
 *  @author  Period: 1
 *  @author  Assignment: JMCh19_SafeTrade
 *
 *  @author  Sources:  None
 */
public class Brokerage implements Login
{
    /**
     * hashmap of all the traders
     */
    private Map<String, Trader> traders;

    /**
     * all the traders logged in
     * 
     */
    private Set<Trader> loggedTraders;

    /**
     * hashmap with all the stocks
     */
    private StockExchange exchange;


    /**
     * @param exchange
     *            stock exchange to be used
     */
    public Brokerage( StockExchange exchange )
    {

        loggedTraders = new TreeSet<Trader>();
        this.exchange = exchange;
        traders = new TreeMap<String, Trader>();

    }


    /**
     * Requests a quote for a given stock from the stock exachange and passes it
     * along to the trader by calling trader's receiveMessage method.
     * 
     * @param symbol
     *            - the stock symbol
     * @param other
     *            - the trader who requested a quote
     */
    public void getQuote( String symbol, Trader other )
    {
        String quote = exchange.getQuote( symbol );
        other.receiveMessage( quote );
    }


    /**
     * Places an order at the stock exchange.
     * 
     * @param order
     *            - an order to be placed at the stock exchange.
     */
    public void placeOrder( TradeOrder order )
    {
        exchange.placeOrder( order );
    }


    /**
     * Removes a specified trader from the set of logged-in traders.
     * 
     * @param trader
     *            the trader that logs out
     */
    public void logout( Trader trader )
    {
        loggedTraders.remove( trader );
    }


    /**
     * Tries to login a trader with a given screen name and password.
     * 
     * @param name
     *            screen name of the trader
     * @param password
     *            the password for the trader
     * @return 0 if successful, or an error code (a negative integer) if failed:
     *         -1 -- screen name not found -2 -- invalid password -3 -- user is
     *         already logged in.
     */
    public int login( String name, String password )
    {
        Trader person = traders.get( name );
        if ( person == null )
        {
            return -1;
        }
        else if ( loggedTraders.contains( person ) )
        {
            return -3;
        }
        else if ( !person.getPassword().equals( password ) )
        {
            return -2;
        }
        else
        {
            person.receiveMessage( "Welcome to SafeTrade!" );
            person.openWindow();
            loggedTraders.add( person );
            return 0;
        }

    }


    /**
     * Tries to register a new trader with a given screen name and password.
     * 
     * @param name
     *            screen name of the trader
     * @param password
     *            the password for the trader
     * @return 0 if successful, or an error code (a negative integer) if failed:
     *         -1 -- invalid screen name (must be 4-10 chars) -2 -- invalid
     *         password (must be 2-10 chars) -3 -- the screen name is already
     *         taken.
     * 
     */
    public int addUser( String name, String password )
    {
        if ( name.length() > 10 || name.length() < 4 )
        {
            return -1;
        }
        else if ( password.length() > 10 || password.length() < 2 )
        {
            return -2;
        }
        else if ( traders.get( name ) != null )
        {
            return -3;
        }
        traders.put( name, new Trader( this, name, password ) );
        return 0;
    }


    //
    // The following are for test purposes only
    //
    /**
     * get a hashmap of all the traders
     * 
     * @return all traders
     */
    protected Map<String, Trader> getTraders()
    {
        return traders;
    }


    /**
     * get logged traders
     * 
     * @return all logged in traders
     */
    protected Set<Trader> getLoggedTraders()
    {
        return loggedTraders;
    }


    /**
     * gets Stock Exchange
     * 
     * @return stock exchange to be used
     */
    protected StockExchange getExchange()
    {
        return exchange;
    }


    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Brokerage.
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
                str += separator + field.getType().getName() + " "
                    + field.getName() + ":" + field.get( this );
            }
            catch ( IllegalAccessException ex )
            {
                System.out.println( ex );
            }

            separator = ", ";
        }

        return str + "]";
    }
}
