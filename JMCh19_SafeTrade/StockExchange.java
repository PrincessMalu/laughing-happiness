import java.lang.reflect.*;
import java.util.*;


/**
 * Represents a stock exchange. A <code>StockExchange</code> keeps a
 * <code>HashMap</code> of stocks, keyed by a stock symbol. It has methods to
 * list a new stock, request a quote for a given stock symbol, and to place a
 * specified trade order.
 *
 * @author Malavika Nair
 * @version April 19, 2020
 * @author Period: 1
 * @author Assignment: JMCh19_SafeTrade
 *
 * @author Sources: None
 */
public class StockExchange
{
    /**
     * Hash map of Stocks
     */
    private Map<String, Stock> listedStocks;


    /**
     * Constructs a new stock exchange object. Initializes listed stocks to an
     * empty map (a HashMap).
     */
    public StockExchange()
    {
        listedStocks = new HashMap<String, Stock>();
    }


    /**
     * Returns a quote for a given stock.
     * 
     * @param symbol
     *            symbol of the stock
     * @return a text message that contains the quote
     */
    public String getQuote( String symbol )
    {
        if ( symbol == null )
        {
            return "";
        }
        Stock s = listedStocks.get( symbol );
        if ( s != null )
        {
            return s.getQuote();
        }
        return symbol + " not found";
    }


    /**
     * Adds a new stock with given parameters to the listed stocks.
     * 
     * @param symbol
     *            symbol of the stock
     * @param name
     *            name of the stock
     * @param price
     *            price of the stock
     */
    public void listStock( String symbol, String name, double price )
    {
        if ( symbol.isEmpty() )
        {
            return;
        }
        listedStocks.put( symbol, new Stock( symbol, name, price ) );

    }


    /**
     * Places a trade order by calling stock.placeOrder for the stock specified
     * by the stock symbol in the trade order.
     * 
     * @param order
     *            what the trader's order is.
     */
    public void placeOrder( TradeOrder order )
    {
        if ( order == null )
        {
            return;
        }
        Stock stock = listedStocks.get( order.getSymbol() );
        if ( stock != null )
        {
            stock.placeOrder( order );
            return;
        }

        String str = order.getSymbol() + " not found";
        order.getTrader().receiveMessage( str );
    }


    //
    // The following are for test purposes only
    //
    /**
     * get listed stocks
     * 
     * @return listed stocks
     */
    protected Map<String, Stock> getListedStocks()
    {
        return listedStocks;
    }


    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this StockExchange.
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
