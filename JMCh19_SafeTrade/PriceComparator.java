import java.lang.reflect.Field;


/**
 * A price comparator for trade orders.
 *
 * @author Malavika Nair
 * @version April 19, 2020
 * @author Period: 1
 * @author Assignment: JMCh19_SafeTrade
 *
 * @author Sources: None
 */
public class PriceComparator implements java.util.Comparator<TradeOrder>
{
    /**
     * flag to determine whether the comparison is ascending or descending.
     */
    private boolean ascending;


    /**
     * Constructs a price comparator that compares two orders in ascending
     * order. Sets the private boolean ascending flag to true.
     */
    public PriceComparator()
    {
        ascending = true;
    }


    /**
     * @param asc
     *            if true, make an ascending comparator; otherwise make a
     *            descending comparator
     */
    public PriceComparator( boolean asc )
    {
        ascending = asc;

    }


    /**
     * Compares two trade orders.
     * 
     * @param order1
     *            the first order
     * @param order2
     *            the seond order
     * @return 0 if both orders are market orders; -1 if order1 is market and
     *         order2 is limit; 1 if order1 is limit and order2 is market; the
     *         difference in prices, rounded to the nearest cent,
     */
    public int compare( TradeOrder order1, TradeOrder order2 )
    {

        if ( order1.isMarket() && order2.isMarket() )
        {
            return 0;
        }
        else if ( order1.isMarket() && order2.isLimit() )
        {
            return -1;
        }
        else if ( order1.isLimit() && order2.isMarket() )
        {
            return 1;
        }
        else
        {
            if ( !ascending )
            {
                return (int)( ( order2.getPrice() - order1.getPrice() )
                    * 100 );
            }
            else
            {
                return (int)( ( order1.getPrice() - order2.getPrice() )
                    * 100 );
            }
        }
    }


    /**
     * toString method for price Comparator
     * 
     * @return the string of the price comparator
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
