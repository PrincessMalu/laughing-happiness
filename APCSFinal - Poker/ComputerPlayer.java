import java.util.ArrayList;


public class ComputerPlayer extends Player
{
    private String name;

    private Chips[] chip = new Chips[30];

    public ArrayList<Card> hand = new ArrayList<Card>();


    public ComputerPlayer(
        String name,
        Chips[] chip,
        Card card,
        Card card1,
        Card card2,
        Card card3,
        Card card4 )
    {
        super( name, chip, card, card1, card2, card3, card4 );
    }


    public void gStrat( ArrayList<Card> hand, Deck deck )
    {
        Deck uDeck = new Deck( hand );
        Hands userhand = new Hands( uDeck );
        int size = hand.size();
        if ( userhand.display().contains( "pair of" ) )
        {
            for ( int count = 0; count < hand.size(); )
            {
                if ( !userhand.display()
                    .contains( hand.get( count ).getRank().toString() ) )
                {
                    hand.remove( count );
                }
                else
                {
                    count++;
                }
            }
            for ( int x = 0; x < size - hand.size(); x++ )
            {
                hand.add( x, deck.deal() );
            }

            /*
             * for (int x = 0; x <hand.size(); x++) { System.out.println
             * (hand.get(x).toString()); }
             */

        }
        else if ( userhand.display().contains( "three of a kind" ) )
        {
            for ( int count = 0; count < hand.size(); )
            {
                if ( !userhand.display()
                    .contains( hand.get( count ).getRank().toString() ) )
                {
                    hand.remove( count );

                }
                else
                {
                    count++;
                }

                // for (int x = 0; x <hand.size(); x++)
                // {
                // System.out.println (hand.get(x).toString());
                // }
            }
            for ( int x = 0; x < size - hand.size(); x++ )
            {
                this.setHand( deck.deal(), x );
            }

        }
        else if ( userhand.display().contains( "two pair" ) )
        {
            for ( int count = 0; count < hand.size(); )
            {
                if ( !userhand.display()
                    .contains( hand.get( count ).getRank().toString() ) )
                {
                    hand.remove( count );

                }
                else
                {
                    count++;
                }
                // for (int x = 0; x <hand.size(); x++)
                // {
                // System.out.println (hand.get(x).toString());
                // }

            }
            for ( int x = 0; x < size - hand.size(); x++ )
            {
                this.setHand( deck.deal(), x );
            }
        }

    }


    public void betStrat( ArrayList<Card> hand, Deck deck, int bet )
    {
        Deck uDeck = new Deck( hand );
        Hands userhand = new Hands( uDeck );
        if ( userhand.display().contains( "pair of" )
            || userhand.display().contains( "two pair" )
            || userhand.display().contains( "three of a kind" ) )
        {
            match( bet );
        }
        else if ( userhand.display().contains( "high straight" )
            || userhand.display().contains( "full house" ) )
        {
            raise( bet + 15 );
        }
        else if ( userhand.display().contains( "straight flush" )
            || userhand.display().contains( "flush" )
            || userhand.display().contains( "four of a kind" ) )
        {
            raise( bet + 50);
        }
    }

}
