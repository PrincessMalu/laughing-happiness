import java.util.*;
import java.lang.reflect.*;
import java.text.DecimalFormat;


/**
 * Represents a stock in the SafeTrade project
 *
 * @author Malavika Nair
 * @version April 19, 2020
 * @author Period: 1
 * @author Assignment: JMCh19_SafeTrade
 *
 * @author Sources: None
 */
public class Stock
{
    /**
     * formatting for money
     */
    private static DecimalFormat money = new DecimalFormat( "0.00" );

    /**
     * symbol of the stock
     */
    private String stockSymbol;

    /**
     * name of the company
     */
    private String companyName;

    /**
     * prices for the day
     */
    private double lastPrice;

    /**
     * prices for the day
     */
    private double loPrice;

    /**
     * prices for the day
     */
    private double hiPrice;

    /**
     * how much stock
     */
    private int volume;

    /**
     * priority queue of sell orders
     */
    private PriorityQueue<TradeOrder> sellOrders;

    /**
     * priority queue of buy orders
     */
    private PriorityQueue<TradeOrder> buyOrders;


    /**
     * @param symbol
     *            - the stock symbol
     * @param name
     *            - full company name
     * @param price
     *            - opening price for this stack
     */
    public Stock( String symbol, String name, double price )
    {
        stockSymbol = symbol;
        companyName = name;
        loPrice = price;
        hiPrice = price;
        lastPrice = price;
        volume = 0;
        buyOrders = new PriorityQueue<TradeOrder>( 10,
            new PriceComparator( false ) );
        sellOrders = new PriorityQueue<TradeOrder>( 10,
            new PriceComparator() );

    }


    /**
     * Returns a quote string for this stock. The quote includes: the company
     * name for this stock; the stock symbol; last sale price; the lowest and
     * highest day prices; the lowest price in a sell order (or "market") and
     * the number of shares in it (or "none" if there are no sell orders); the
     * highest price in a buy order (or "market") and the number of shares in it
     * (or "none" if there are no buy orders).
     * 
     * @return Returns a quote string for this stock.
     */
    public String getQuote()
    {
        String quote = companyName + " (" + stockSymbol + ")" + "\n"
            + "Price: " + lastPrice + " hi: " + hiPrice + " lo: " + loPrice
            + " vol: " + volume + "\n";
        String ask = "Ask: none";
        String bid = "Bid: none";
        if ( sellOrders.peek() != null )
        {
            ask = "Ask: " + sellOrders.peek().getPrice() + " size: "
                + sellOrders.peek().getShares();
        }
        if ( buyOrders.peek() != null )
        {
            bid = "Bid: " + buyOrders.peek().getPrice() + " size: "
                + buyOrders.peek().getShares();
        }
        return quote + ask + " " + bid;

    }


    /**
     * Places a trading order for this stock. Adds the order to the appropriate
     * priority queue depending on whether this is a buy or sell order. Notifies
     * the trader who placed the order that the order has been placed, by
     * sending a message to that trader.
     * 
     * @param order
     *            - a trading order to be placed
     */
    public void placeOrder( TradeOrder order )
    {
        String str = "New Order: ";
        if ( order == null )
        {

            return;
        }
        if ( order.isBuy() )
        {
            buyOrders.add( order );
            str += "Buy " + order.getSymbol() + " (" + this.companyName + ")"
                + "\n" + order.getShares() + " shares at ";
            if ( !order.isMarket() )
            {
                str += money.format( order.getPrice() );
            }
            else
            {
                str += "market";
            }
        }
        else
        {
            sellOrders.add( order );
            str += "Sell " + order.getSymbol() + " (" + this.companyName + ") "
                + "\n" + order.getShares() + " shares at ";
            if ( !order.isMarket() )
            {
                str += money.format( order.getPrice() );
            }
            else
            {
                str += "market";
            }
        }

        order.getTrader().receiveMessage( str );
        executeOrders();
    }


    /**
     * Executes as many pending orders as possible.
     */
    public void executeOrders()
    {
        if ( buyOrders.isEmpty() || sellOrders.isEmpty() )
        {
            return;
        }

        TradeOrder buy = buyOrders.peek();
        TradeOrder sell = sellOrders.peek();

        Trader buyer = buy.getTrader();
        Trader seller = sell.getTrader();

        double price = 0;

        if ( buy.isLimit() && sell.isLimit()
            && buy.getPrice() >= sell.getPrice() )
        {
            price = sell.getPrice();
        }

        else if ( buy.isMarket() && sell.isMarket() )
        {
            price = lastPrice;
        }

        else if ( buy.isLimit() && sell.isMarket() )
        {

            price = buy.getPrice();
        }

        else if ( buy.isMarket() && sell.isLimit() )
        {

            price = sell.getPrice();
        }

        else
        {
            return;
        }

        int nShares = Math.min( buy.getShares(), sell.getShares() );

        buy.subtractShares( nShares );
        sell.subtractShares( nShares );

        if ( buy.getShares() == 0 )
        {
            buyOrders.remove( buy );
        }

        if ( sell.getShares() == 0 )
        {
            sellOrders.remove( sell );
        }

        if ( price < loPrice )
        {
            loPrice = price;
        }

        if ( price > hiPrice )
        {
            hiPrice = price;
        }

        volume += nShares;
        lastPrice = price;

        buyer.receiveMessage( "You bought: " + nShares + " " + stockSymbol
            + " at " + money.format( price ) + " amt "
            + money.format( nShares * price ) );
        seller.receiveMessage( "You sold: " + nShares + " " + stockSymbol
            + " at " + money.format( price ) + " amt "
            + money.format( nShares * price ) );

        if ( !buyOrders.isEmpty() && !sellOrders.isEmpty() )
        {
            executeOrders();
        }
    }
    //
    // The following are for test purposes only
    //


    /**
     * get stock symbol
     * 
     * @return stock symbol
     */
    protected String getStockSymbol()
    {
        return stockSymbol;
    }


    /**
     * get company name
     * 
     * @return company name
     */
    protected String getCompanyName()
    {
        return companyName;
    }


    /**
     * get low price
     * 
     * @return low price
     */
    protected double getLoPrice()
    {
        return loPrice;
    }


    /**
     * get high price
     * 
     * @return price
     */
    protected double getHiPrice()
    {
        return hiPrice;
    }


    /**
     * get last price
     * 
     * @return last price
     */
    protected double getLastPrice()
    {
        return lastPrice;
    }


    /**
     * get volume
     * 
     * @return volume
     */
    protected int getVolume()
    {
        return volume;
    }


    /**
     * gets buy orders
     * 
     * @return buy orders
     */
    protected PriorityQueue<TradeOrder> getBuyOrders()
    {
        return buyOrders;
    }


    /**
     * Gets sell orders
     * 
     * @return sellorder
     */
    protected PriorityQueue<TradeOrder> getSellOrders()
    {
        return sellOrders;
    }


    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Stock.
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
