import java.util.*;
/**
 * 
 *  This class 
 *
 *  @author  Shreedevi and Malavika
 *  @version Apr 27, 2020
 *  @author  Period: 1
 *  @author  Assignment: PokerFinalProject
 *
 *  @author  Sources: 
 */
public class Card
{
    private char [] suit = {'s', 'c', 'h', 'd'};
    private char mySuit;
    private String [] rank = {"A", "1", "2", "3", "4","5", "6", "7","8","9","10","J","Q","K"} ;
    private String myRank;
    public Card (char s, String r)
    {
        mySuit = s;
        myRank = r;
        
        int counter = 0;
        for (int count = 0; count < suit.length; count++)
        {
            if (s == suit[count])
            {
                counter++;
                break;
            }
        }
        
        if (counter == 0)
        {
            throw new IllegalArgumentException();
        }
        
        int number = 0;
        for (int num = 0; num < suit.length; num++)
        {
            if (s == suit[num])
            {
                number++;
                break;
            }
        }
        
        if (number == 0)
        {
            throw new IllegalArgumentException();
        }
      
    }
    
    public char getSuit ()
    {
        return mySuit;
    }
    
    public int getValue (String s)
    {
        if (s.equals("A") )
        {
            return 1;  
        }
        if (s.equals("J") )
        {
            return 11;  
        }
        if (s.equals("Q") )
        {
            return 12;  
        }
        if (s.equals("K") )
        {
            return 13;  
        }
        else
        {
            Character num = s.charAt( 0 );
            return num.getNumericValue( num );
           
        }
    }
    
    public String toString()
    {
        String s = mySuit + " , " + myRank;
        return s;
    }
    

}
