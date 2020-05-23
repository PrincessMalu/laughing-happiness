import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


public class HumanPlayer extends Player implements MouseListener
{
    private String name;

    private Chips[] chip;

    public ArrayList<Card> hand = new ArrayList<Card>();

    private int amount;

    private boolean myTurn;


    public HumanPlayer(
        String name,
        Chips[] chip,
        Card card,
        Card card1,
        Card card2,
        Card card3,
        Card card4 )
    {
        super( name, chip, card, card1, card2, card3, card4 );
        for ( Chips ch : chip )

            if ( ch.getColor().equals( Color.RED ) )
            {
                amount += 5;
            }
            else if ( ch.getColor().equals( Color.BLUE ) )
            {
                amount += 10;
            }
            else if ( ch.getColor().equals( Color.GREEN ) )
            {
                amount += 25;
            }
            else if ( ch.getColor().equals( Color.BLACK ) )
            {
                amount += 100;
            }
    }


    public String addName( String s )
    {
        name = s;
        return name;
    }


    public String getTurn()
    {
        myTurn = true;
        return "Your turn";
    }


    public String getWinMessage()
    {
        return "You won!";
    }


    public String getLoseMessage()
    {
        return "You Lose! Better Luck next time!";
    }


    public String getMoneyMessage()
    {
        return "You have $" + amount;
    }


    public void makeBet( int c )
    {
        super.bet( c );

    }


    public void mouseClicked( MouseEvent e )
    {
        // TODO Auto-generated method stub

    }


    public void mouseEntered( MouseEvent e )
    {
        // TODO Auto-generated method stub

    }


    public void mouseExited( MouseEvent e )
    {
        // TODO Auto-generated method stub

    }


    public void mousePressed( MouseEvent e )
    {
        // TODO Auto-generated method stub

    }


    @Override
    public void mouseReleased( MouseEvent e )
    {
        if ( !myTurn )
        {
            return;
        }

    }

}