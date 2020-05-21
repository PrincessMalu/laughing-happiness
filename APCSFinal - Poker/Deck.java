import java.util.*;


/**
 * Description: A list of Card; used for a player's hand or a deck of cards
 * 
 * - cards - list of card; starts out empty Methods - shuffle() - randomly
 * shuffle all the card in the list - deal() - deal the 'top' card from the
 * hand/deck - add(card) - add card to the list of cards - __str__() - returns
 * string of all the cards in the hand like '[4d 10h As]'
 *
 * @author Malavika Nair and Shreedevi Rao
 * @version April 19, 2020
 * @author Period: 1
 * @author Assignment: Final Project
 *
 * @author Sources: None
 */
public class Deck
{

    public ArrayList<Card> deck;


    public Deck()
    {
        deck = new ArrayList<Card>();
    }


    public String deckToString()
    {
        String s = "[";
        for ( Card c : deck )
        {
            if ( deck.size() == 1 )
            {
                s = s + c.toString();
            }

            else
            {
                s = s + ' ' + c.toString();
            }

        }
        s = s + "]";

        return s;
    }


    public void add( Card card1 )
    {
        deck.add( card1 );

    }


    public ArrayList<Card> getDeck()
    {
        return deck;
    }


    public Card deal() 
       {
         this.shuffle();
         Card c = deck.remove(0);
         return c;
       }


    public void shuffle() 
       {
            Collections.shuffle( deck );
       }
       
     /*  public Card [] getTwoCards ()
       {
           Card [] playerCards = new Card [2];
           int x = (int)Math.random() * 52;
           int c = (int)Math.random ()* 52;
           if (deck [x]!= null)
           {
               playerCards [0] = deck [x];
           }
        
           if (x != c)
           {
               playerCards[1] = deck [c];
               deck [c] = null;
           }
           
           else
           {
               playerCards [1] = deck [c + 5];
               deck [c + 5] = null;
           }
           deck [x] = null;
           
           
           return playerCards;
           
          
                          
       }
       */

    }
