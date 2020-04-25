import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.regex.*;

import org.junit.*;

import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;


/**
 * SafeTrade tests: TradeOrder PriceComparator Trader Brokerage StockExchange
 * Stock
 *
 * @author Malavika Nair
 * @author TODO Name of group member
 * @author TODO Name of group member
 * @version TODO date
 * @author Assignment: JM Chapter 19 - SafeTrade
 * 
 * @author Sources: TODO sources
 *
 */
public class JUSafeTradeTest
{
    // --Test TradeOrder
    /**
     * TradeOrder tests: TradeOrderConstructor - constructs TradeOrder and then
     * compare toString TradeOrderGetTrader - compares value returned to
     * constructed value TradeOrderGetSymbol - compares value returned to
     * constructed value TradeOrderIsBuy - compares value returned to
     * constructed value TradeOrderIsSell - compares value returned to
     * constructed value TradeOrderIsMarket - compares value returned to
     * constructed value TradeOrderIsLimit - compares value returned to
     * constructed value TradeOrderGetShares - compares value returned to
     * constructed value TradeOrderGetPrice - compares value returned to
     * constructed value TradeOrderSubtractShares - subtracts known value &
     * compares result returned by getShares to expected value
     */
    private String symbol = "GGGL";

    private boolean buyOrder = true;

    private boolean marketOrder = true;

    private int numShares = 123;

    private int numToSubtract = 24;

    private double price = 123.45;

    private String name = "Nasty Loops Inc.";

    private String password = "pas";


    @Test
    public void tradeOrderConstructor()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        String toStr = to.toString();

        assertTrue( "<< Invalid TradeOrder Constructor >>",
            toStr.contains( "TradeOrder[Trader trader:null" )
                && toStr.contains( "java.lang.String symbol:" + symbol )
                && toStr.contains( "boolean buyOrder:" + buyOrder )
                && toStr.contains( "boolean marketOrder:" + marketOrder )
                && toStr.contains( "int numShares:" + numShares )
                && toStr.contains( "double price:" + price ) );
    }


    @Test
    public void TradeOrderToString()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        assertNotNull( to.toString() );
    }


    @Test
    public void tradeOrderGetTrader()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        assertNull( "<< TradeOrder: " + to.getTrader() + " should be null >>",
            to.getTrader() );
    }


    @Test
    public void tradeOrderGetSymbol()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        assertEquals( "<< TradeOrder: " + to.getTrader() + " should be "
            + symbol + " >>", symbol, to.getSymbol() );
    }


    @Test
    public void tradeOrderIsBuy()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );

        assertTrue(
            "<< TradeOrder: " + to.isBuy() + " should be " + buyOrder + " >>",
            to.isBuy() );
    }


    @Test
    public void tradeOrderIsSell()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        assertFalse(
            "<< TradeOrder: " + to.isSell() + " should be " + !buyOrder
                + " >>",
            to.isSell() );
    }


    @Test
    public void tradeOrderIsMarket()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        assertTrue(
            "<< TradeOrder: " + to.isMarket() + " should be " + marketOrder
                + " >>",
            to.isMarket() );
    }


    @Test
    public void tradeOrderIsLimit()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );

        assertFalse(
            "<< TradeOrder: " + to.isLimit() + " should be " + !marketOrder
                + ">>",
            to.isLimit() );
    }


    @Test
    public void tradeOrderGetShares()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        assertTrue(
            "<< TradeOrder: " + to.getShares() + " should be " + numShares
                + ">>",
            numShares == to.getShares()
                || ( numShares - numToSubtract ) == to.getShares() );
    }


    @Test
    public void tradeOrderGetPrice()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        assertEquals( "<< TradeOrder: " + to.getPrice() + " should be " + price
            + ">>", price, to.getPrice(), 0.0 );
    }


    @Test
    public void tradeOrderSubtractShares()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        to.subtractShares( numToSubtract );
        assertEquals(
            "<< TradeOrder: subtractShares(" + numToSubtract + ") should be "
                + ( numShares - numToSubtract ) + ">>",
            numShares - numToSubtract,
            to.getShares() );
    }


    // --Test TraderWindow Stub
    @Test
    public void traderWindowConstructor()
    {
        TraderWindow tw = new TraderWindow( null );
        assertNotNull( tw );
    }


    @Test
    public void traderWindowShowMessage()
    {
        TraderWindow tw = new TraderWindow( null );
        assertNotNull( tw );
        tw.showMessage( null );
    }


    // --Test PriceComparator

    @Test
    public void priceComparatorConstructor()
    {
        PriceComparator p = new PriceComparator();
        String toStr = p.toString();

        assertTrue( "<< Invalid PriceComparator Constructor >>",
            toStr.contains( "boolean ascending:true" ) );
    }


    @Test
    public void priceComparatorConstructorBoolean()
    {
        PriceComparator p = new PriceComparator( false );
        String toStr = p.toString();

        assertTrue( "<< Invalid PriceComparator Constructor >>",
            toStr.contains( "boolean ascending:false" ) );
    }


    @Test
    public void priceComparatortoStringTest()
    {
        PriceComparator pc = new PriceComparator();
        assertNotNull( pc.toString() );
    }

    // --Test Trader


    @Test
    public void traderConstructor()

    {

        StockExchange exchange = new StockExchange();

        Brokerage brokerage = new Brokerage( exchange );

        exchange.listStock( "NSTL", "Nasty Loops Inc.", 10.00 );

        Trader t = new Trader( brokerage, name, password );

        String str = t.toString();

        assertTrue( "<< Invalid Trader Constructor >>",

            str.contains( "Trader[" ) );

    }


    @Test
    public void traderHasMessages()

    {

        StockExchange exchange = new StockExchange();

        Brokerage brokerage = new Brokerage( exchange );

        exchange.listStock( "NSTL", "Nasty Loops Inc.", 10.00 );

        Trader t = new Trader( brokerage, name, password );

        assertFalse( "<< Trader should have no messages >>", t.hasMessages() );

    }


    @Test
    public void traderQuit()

    {

        StockExchange exchange = new StockExchange();

        Brokerage brokerage = new Brokerage( exchange );

        exchange.listStock( "NSTL", "Nasty Loops Inc.", 10.00 );

        Trader t = new Trader( brokerage, name, password );

        t.quit();

        assertFalse( "<< invalid recieves messages >>",

            brokerage.getLoggedTraders().contains( t ) );

    }


    // --Test Brokerage
    @Test
    public void brokerageGetQuote()

    {

        StockExchange exchange = new StockExchange();

        exchange.listStock( "NSTL", "Nasty Loops Inc.", 10.00 );

        Brokerage b = new Brokerage( exchange );

        Trader t = new Trader( b, name, password );

        b.getQuote( symbol, t );

        assertTrue( "<< Invalid Brokerage getQuote >>", t.hasMessages() );

    }


    @Test
    public void brokerageLogout()

    {
        StockExchange exchange = new StockExchange();

        exchange.listStock( "NSTL", "Nasty Loops Inc.", 10.00 );

        Brokerage b = new Brokerage( exchange );

        b.addUser( "harry", "potter" );

        b.login( "harry", "potter" );

        b.logout( b.getTraders().get( "harry" ) );

        assertFalse( "<< Invalid brokerage logout >>",
            b.getLoggedTraders().contains( b.getTraders().get( "harry" ) ) );

    }


    @Test
    public void brokerageLogin()

    {
        StockExchange exchange = new StockExchange();

        exchange.listStock( "NSTL", "Nasty Loops Inc.", 10.00 );

        Brokerage broke = new Brokerage( exchange );

        String n = "harry";

        String p = "potter";

        broke.addUser( n, p );

        assertTrue( "<< invalid brokerage login >>",
            broke.login( "user", p ) == -1 );

        assertTrue( "<< invalid brokerage login >>",
            broke.login( n, "invalid" ) == -2 );

        assertTrue( "<< invalid brokerage login >>",
            broke.login( n, p ) == 0
                && !broke.getTraders().get( n ).hasMessages()
                && broke.getLoggedTraders()
                    .contains( broke.getTraders().get( n ) ) );

        broke.login( n, p );

        assertTrue( "<< invalid brokerage login >>",
            broke.login( n, p ) == -3 );

    }


    @Test
    public void brokeragePlaceOrder()

    {
        StockExchange exchange = new StockExchange();

        exchange.listStock( "NSTL", "Nasty Loops Inc.", 10.00 );

        Brokerage broke = new Brokerage( exchange );

        Trader trade = new Trader( broke, name, password );

        TradeOrder order = new TradeOrder( trade,
            symbol,
            true,
            false,
            10,
            10.0 );

        broke.placeOrder( order );

        assertTrue( "<< Invalid Brokerage getQuote >>", trade.hasMessages() );

        trade.openWindow();

        broke.placeOrder( order );

        assertFalse( "<< Invalid Brokerage getQuote >>", trade.hasMessages() );

    }


    @Test
    public void brokerageToString()

    {
        StockExchange exchange = new StockExchange();

        exchange.listStock( "NSTL", "Nasty Loops Inc.", 10.00 );

        Brokerage b = new Brokerage( exchange );

        assertNotNull( b.toString() );
    }


    // --Test StockExchange
    @Test
    public void stockExchangeConstructor()

    {
        StockExchange stckE = new StockExchange();

        String toStr = stckE.toString();

        assertTrue( "<< Invalid StockExchange Constructor >>",
            toStr.contains( "StockExchange[" ) );

    }


    @Test
    public void stockExchangeGetQuote()

    {
        StockExchange stckE = new StockExchange();

        stckE.listStock( "CMCT", "comcast", 10.0 );

        String quote = stckE.getQuote( "CMCT" );

        assertTrue( "<< Invalid StockExchange getQuote >>",

            quote != null );

    }


    @Test
    public void stockExchangeListStock()

    {
        StockExchange stckE = new StockExchange();

        stckE.listStock( "CMCT", "comcast", 10.0 );

        Map<String, Stock> listedStocks = stckE.getListedStocks();

        assertTrue( "<< Invalid StockExchange listStock >>",
            listedStocks.containsKey( "CMCT" ) );

    }


    @Test
    public void stockExchangeToString()

    {
        StockExchange to = new StockExchange();

        assertNotNull( to.toString() );

    }


    // --Test Stock

    public void stockConstructor()
    {
        PriorityQueue<TradeOrder> buyOrders = new PriorityQueue<TradeOrder>(
            10,
            new PriceComparator( false ) );
        PriorityQueue<TradeOrder> sellOrders = new PriorityQueue<TradeOrder>(
            10,
            new PriceComparator() );
        int volume = 0;
        Stock s = new Stock( symbol, name, price );

        String toStr = s.toString();

        assertTrue( "<< Invalid Stock Constructor >>",
            toStr.contains( "String stockSymbol:" + symbol )
                && toStr.contains( "String companyName:" + name )
                && toStr.contains( "PriorityQueue buyOrders:" + buyOrders )
                && toStr.contains( "double hiPrice:" + price )
                && toStr.contains( "double loPrice:" + price )
                && toStr.contains( "int volume:" + volume )
                && toStr.contains( "double lastPrice:" + price )

                && toStr
                    .contains( "PriorityQueue sellOrders:" + sellOrders ) );
    }


    @Test
    public void StockGetQuote()

    {

        Stock stock = new Stock( symbol, "name", price );

        assertEquals( "Message",
            stock.getQuote(),
            "name (" + symbol + ")\nPrice: " + price + " hi: " + price
                + " lo: " + price + " vol: 0\nAsk: none Bid: none" );

    }


    @Test
    public void stockToStringTest()
    {
        Stock s = new Stock( symbol, name, price );
        assertNotNull( s.toString() );
    }

    // Remove block comment below to run JUnit test in console
    /*
     * public static junit.framework.Test suite() { return new
     * JUnit4TestAdapter( JUSafeTradeTest.class ); }
     * 
     * public static void main( String args[] ) {
     * org.junit.runner.JUnitCore.main( "JUSafeTradeTest" ); }
     */
}
