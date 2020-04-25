import java.lang.reflect.*;


/**
 * Represents a buy or sell order for trading a given number of shares of a
 * specified stock.
 *
 * @author Malavika NAir
 * @version April 19, 2020
 * @author Period: 1
 * @author Assignment: JMCh19_SafeTrade
 *
 * @author Sources: none
 */
public class TradeOrder
{
    /**
     * trader who ordered
     */
    private Trader trader;

    /**
     * symbol of stock
     */
    private String symbol;

    /**
     * buy order or not
     */
    private boolean buyOrder;

    /**
     * market order or not
     */
    private boolean marketOrder;

    /**
     * number of shares
     */
    private int numShares;

    /**
     * price
     */
    private double price;


    /**
     * @param trader
     *            - a trader who placed this order.
     * @param symbol
     *            - stock symbol.
     * @param buyOrder
     *            - if true this is a buy order; otherwise this is a sell order.
     * 
     * @param marketOrder
     *            - if true this is a market order; otherwise this is a limit
     *            order.
     * @param numShares
     *            - the number of shares to be traded.
     * @param price
     *            - the bid or ask price, if this is a limit order.
     */
    public TradeOrder(
        Trader trader,
        String symbol,
        boolean buyOrder,
        boolean marketOrder,
        int numShares,
        double price )
    {
        this.trader = trader;
        this.symbol = symbol;
        this.buyOrder = buyOrder;
        this.marketOrder = marketOrder;
        this.numShares = numShares;
        this.price = price;

    }


    /**
     * Returns the price per share for this trade order (used by a limit order).
     * 
     * @return the price per share for this trade order.
     */
    public double getPrice()
    {
        return price;
    }


    /**
     * Returns the number of shares to be traded in this trade order.
     * 
     * @return the number of shares to be traded in this trade order.
     */
    public int getShares()
    {
        return numShares;
    }


    /**
     * Returns the stock symbol for this trade order.
     * 
     * @return the stock symbol for this trade order.
     */
    public String getSymbol()
    {
        return symbol;
    }


    /**
     * Returns the trader for this trade order.
     * 
     * @return the trader who placed this trade order.
     */
    public Trader getTrader()
    {
        return trader;
    }


    /**
     * Returns true if this is a buy order; otherwise returns false.
     * 
     * @return true if this is a buy order; false otherwise.
     */
    public boolean isBuy()
    {
        return buyOrder;
    }


    /**
     * Returns true if this is a sell order; otherwise returns false.
     * 
     * @return true if this is a sell order; false otherwise.
     */
    public boolean isSell()
    {
        return !buyOrder;
    }


    /**
     * Returns true if this is a limit order; otherwise returns false.
     * 
     * @return true if this is a limit order; false otherwise.
     */
    public boolean isLimit()
    {
        return !marketOrder;

    }


    /**
     * Returns true if this is a market order; otherwise returns false.
     * 
     * @return true if this is a market order; false otherwise.
     */
    public boolean isMarket()
    {
        return marketOrder;
    }


    /**
     * Subtracts a given number of shares from the total number of shares in
     * this trade order.
     * 
     * @param shares
     *            - a number of shares to be subtracted.
     */
    public void subtractShares( int shares )
    {
        numShares = numShares - shares;
    }


    //
    // The following are for test purposes only
    //
    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this TradeOrder.
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
