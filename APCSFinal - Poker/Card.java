import java.util.*;


/**
 * 
 * This class
 *
 * @author Shreedevi and Malavika
 * @version Apr 27, 2020
 * @author Period: 1
 * @author Assignment: PokerFinalProject
 *
 * @author Sources:
 */
public class Card
{
    private char[] suit = { 's', 'c', 'h', 'd' };

    private char mySuit;

    private static String[] rank = { "A","1", "2", "3", "4", "5", "6", "7", "8", "9",
        "10", "J", "Q", "K" };

    private String myRank;


    public Card( char s, String r )
    {
        mySuit = s;
        myRank = r;

        int counter = 0;
        for ( int count = 0; count < suit.length; count++ )
        {
            if ( s == suit[count] )
            {
                counter++;
                break;
            }
        }

        if ( counter == 0 )
        {
            throw new IllegalArgumentException();
        }

        int number = 0;
        for ( int num = 0; num < suit.length; num++ )
        {
            if ( s == suit[num] )
            {
                number++;
                break;
            }
        }

        if ( number == 0 )
        {
            throw new IllegalArgumentException();
        }

    }


    public char getSuit()
    {
        return mySuit;
    }


    public String getRank() {
        
        return myRank;

   }



    public int getValue()
    {
        if ( myRank.equals( "A" ) )
        {
            return 1;
        }
        if ( myRank.equals( "J" ) )
        {
            return 11;
        }
        if ( myRank.equals( "Q" ) )
        {
            return 12;
        }
        if ( myRank.equals( "K" ) )
        {
            return 13;
        }
        if (myRank.equals( "10" )) {
            return 10;
        }
        else
        {
            Character num = myRank.charAt( 0 );
            return num.getNumericValue( num );

        }

    }


    public static String rankAsString( int __rank )
    {

        return rank[__rank];

    }


    public String toString()
    {
        String s = "";
        if (myRank.equals("A") )
        {
            s += "Ace";
        }
        else if (myRank.equals( "K" ))
        {
            s += "King";
        }
        else if (myRank.equals("J") )
        {
            s += "Jack";
        }
        else
        {
            s += "" + myRank;
        }
        s += " of ";
        if (mySuit == 's')
        {
            s+= "spades";
        }
        else if (mySuit == 'c')
        {
            s += "clubs";
        }
        else if (mySuit == 'h')
        {
            s += "heart";
        }
        else if (mySuit == 'd')
        {
            s += "diamond";
        }
        return s;
    }

}
