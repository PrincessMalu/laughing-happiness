import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 *
 * @author Shreedevi and Malavika
 * @version May 20, 2020
 * @author Period: TODO
 * @author Assignment: PokerFinalProject
 *
 * @author Sources: TODO
 */
public class Game
{
    static Chips[] chip = new Chips[30];

    private static int ante;

    static Deck deck = new Deck();

    private static int pot = 0;

    private static Scanner input = new Scanner( System.in );

    private static int rounds;

    private static ComputerPlayer player1;

    private static HumanPlayer user;


    public Game()
    {
        player1 = new ComputerPlayer( "Kim",
            chip,
            null,
            null,
            null,
            null,
            null );
        user = new HumanPlayer( null,
            chip,
            null,
            null,
            null,
            null,
            null );
    }


    public static Chips[] fillChips()
    {

        for ( int count = 0; count < chip.length; count++ )
        {
            if ( count >= 0 && count < 8 )
            {

                chip[count] = new Chips( 5, Color.RED );
            }
            else if ( count >= 8 && count < 18 )
            {
                chip[count] = new Chips( 10, Color.BLUE );
            }
            else if ( count >= 18 && count < 24 )
            {
                chip[count] = new Chips( 25, Color.GREEN );
            }
            else if ( count >= 24 && count < 30 )
            {
                chip[count] = new Chips( 100, Color.BLACK );
            }
        }
        return chip;
    }


    /*
     * private Player pickRandomPlayer (Player one, Player two, Player three,
     * Player four) { Player [] play = {one, two, three, four}; int x =
     * (int)Math.random() * 4; return play [x];
     * 
     * }
     */

    public static void play()
    {
        chip = fillChips();

        System.out.println( user.getMoneyMessage() );
        System.out.println( "What is your name?" );

        String name = input.next();
        user.addName( name );
        System.out.println( "Hello " + name + "!" );

        System.out.println( "How much do you want to bet?" );
        ante = input.nextInt();
        if ( ante > user.getAmount() )
        {
            System.out.println(
                "You do not have that much money. Enter a valid amount." );
        }
        System.out.println( "How much do you want to bet?" );
        ante = input.nextInt();
        pot += ante;
        user.bet( ante );
        player1.bet( ante );
        deck.shuffle();

        for ( int count = 0; count <= 4; count++ )
        {
            user.setHand( deck.deal(), count );
            player1.setHand( deck.deal(), count );
        }
        // System.out.println (deck.deal().toString());
        ArrayList<Card> compHand = player1.getHand();
        ArrayList<Card> hand = user.getHand();
        // for (int x = 0; x < hand.size(); x++)
        // {
        // System.out.println (hand.get( x).toString());
        // }

        Deck uDeck = new Deck( hand );
        Deck cDeck = new Deck( compHand );
        Hands userhand = new Hands( uDeck );
        Hands compHand1 = new Hands( cDeck );
        userhand.display();

        userhand.displayAll();

        // compHand1.display();

        // compHand1.displayAll();
        // boolean marker = false;
        // while (marker = false)
        // {
        System.out.println( "Do you want to raise, check, call or fold?" );
        String s = input.next();
        if ( s.contains( "fold" ) )
        {
            user.getLoseMessage();
            // marker = true;
        }
        else if ( s.contains( "raise" ) )
        {
            System.out.println( "How much do you want to raise?" );
            int bet = input.nextInt();
            pot += bet;
            user.bet( bet );
            // marker = true;
        }
        else if ( s.contains( "call" ) )
        {
            pot += ante;
            user.bet( ante );
        }
        else if ( s.contains( "check" ) )
        {
            // marker = true;
        }
        else if ( !s.contains( "check" ) )
        {
            System.out
                .println( "Please type in either check, raise, or fold" );
        }

        // }

    }
    /*
     * public void bettingRound () {
     * 
     * }
     * 
     * }
     */


public static void drawRound() {
    System.out.println("Would you like to remove cards?");
    String s = input.next();
    if (s.contains( "yes" )) 
    {
        System.out.println("How many cards would you like to exchange?");
        int numCards = input.nextInt();
        ArrayList<Card> toRemove = new ArrayList<Card>();
        for (int i = 0; i <numCards; i++) {
            System.out.println("Please enter the card you would like to remove."
                + "Enter the Rank of the card followed by the suit of the card.");
            String str = input.next();
            for (int k = 0; k< user.getHand().size();k++) {
                if (str.contains( user.getHand().get(k).toString() )) {
                  user.getHand().remove(k);  
                }
            }
        }
            
        
    }
                    
}


    public static void main( String[] args )
    {
        // BoardPanel hello = new BoardPanel ();
Game game = new Game();
        play();
        drawRound();

    }
}
