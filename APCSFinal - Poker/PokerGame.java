import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Scanner;


public class PokerGame

{
    static Chips[] chip = new Chips[30];

    private static int ante;

    static Deck deck = new Deck();

    private static int pot = 0;

    private static Scanner input = new Scanner( System.in );

    private static int rounds;

    private static ComputerPlayer player1;

    private static HumanPlayer user;

    private static ArrayList<Card> compHand;

    private static ArrayList<Card> hand;

    private static String playerBetDecision;

    private static Integer round;

    private static boolean folded = false;

    private static int temp = 0;

    private static Deck uDeck;

    private static Deck cDeck;

    private static Hands userhand;

    private static Hands compHand1;


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


    public PokerGame()
    {
        chip = fillChips();
        player1 = new ComputerPlayer( "Kim",
            chip,
            null,
            null,
            null,
            null,
            null );
        user = new HumanPlayer( null, chip, null, null, null, null, null );

    }


    public static void play()
    {
        chip = fillChips();

        System.out.println( user.getMoneyMessage() );

        System.out.println( "How much do you want to bet?" );
        ante = input.nextInt();
        while ( ante > user.getAmount() )
        {
            System.out.println(
                "You do not have that much money. Enter a valid amount." );
            ante = input.nextInt();

        }
        // System.out.println( "How much do you want to bet?" );
        // ante = input.nextInt();
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
        compHand = player1.getHand();
        hand = user.getHand();
        // for (int x = 0; x < hand.size(); x++)
        // {
        // System.out.println (hand.get( x).toString());
        // }

        uDeck = new Deck( hand );
        cDeck = new Deck( compHand );
        userhand = new Hands( uDeck );
        compHand1 = new Hands( cDeck );
        userhand.display();

        userhand.displayAll();

        // compHand1.display();

        // compHand1.displayAll();
        // boolean marker = false;
        // while (marker = false)
        // {

        // }
        

    }


    public static void bettinground()
    {
        System.out.println( "Do you want to raise, check, match or fold?" );
        String string = input.next();
        while ( !string.equals( "fold" ) && !string.equals( "raise" )
            && !string.equals( "check" ) )
        {
            System.out.println(
                "Please type in either check, call, raise, or fold" );
            string = input.next();
        }
        if ( string.contains( "fold" ) )
        {
            System.out.println( getRoundWinner() );
            folded = true;
            player1.addMoney( pot );
            reset();
            playerBetDecision = "fold";
            return;

        }
        else if ( string.contains( "raise" ) )
        {
            System.out.println( "How much do you want to raise?" );
            int bet = input.nextInt() + ante;
            pot += bet;
            user.raise( bet );
            playerBetDecision = "raise";

        }
        else if ( string.contains( "match" ) )
        {
            pot += ante;
            user.match( ante );
            folded = false;
            playerBetDecision = "match";
        }
        else if ( string.contains( "check" ) )
        {
            folded = false;
            System.out.println( "It's now the computer's turn" );
            playerBetDecision = "check";

        }
        player1.betStrat( compHand, ante, playerBetDecision );

    }


    public static void drawRound()
    {
        if ( folded )
        {
            return;
        }
        System.out.println( "Would you like to remove cards?" );
        String s = input.next();
        if ( s.contains( "yes" ) )
        {
            System.out.println( "How many cards would you like to exchange?" );
            int numCards = input.nextInt();
            // ArrayList<Card> toRemove = new ArrayList<Card>();
            for ( int i = 0; i < numCards; i++ )
            {
                System.out
                    .println( "Please enter the card you would like to remove."
                        + " Enter the Rank of the card followed by the suit of the card." );
                String str = input.nextLine();
                str = input.nextLine();
                // System.out.println("This is the string" + str);
                for ( int k = 0; k < user.getHand().size(); )
                {
                    if ( str.equals( user.getHand().get( k ).toString() ) )
                    {
                        user.getHand().remove( k );
                        // System.out.println("Hi");
                    }
                    else
                    {
                        k++;
                    }
                }

            } // System.out.println("Hi 3");

            for ( int i = 0; i < numCards; i++ )
            {
                user.getHand().add( i, deck.deal() );
            }

            System.out.println( "These are your new cards:" );
            for ( int x = 0; x < user.getHand().size(); x++ )
            {
                System.out.println( user.getHand().get( x ).toString() );
            }

        }else {
            System.out.println("It's the computer's turn!");
        }
        player1.gStrat( compHand, deck );
    }


    public static String betDecision( ComputerPlayer player1 )
    {
        return player1.betStrat( compHand, ante, playerBetDecision );
    }


    public static String getRoundWinner()
    {
        if ( folded )
        {
            return "";
        }
        else if ( userhand.compareTo( compHand1 ) == -1 && temp < round )
        {
            player1.addMoney( pot );
            pot = 0;
            return user.getLoseRoundMessage();
        }
        else if ( user.getAmount() < player1.getAmount() && temp == round )
        {
            pot = 0;
            return user.getLoseGameMessage();

        }
        else if ( userhand.compareTo( compHand1 ) == 1 && temp < round )
        {
            user.addMoney( pot );
            pot = 0;
            return user.getRoundWinMessage();

        }
        else if ( user.getAmount() > player1.getAmount() && temp == round )
        {
            pot = 0;
            return user.getWinGameMessage();
        }
        else
        {
            return "";
        }
    }


    public static void reset()
    {
        for ( int count = 0; count < user.getHand().size(); count++ )
        {
            user.setHand( null, count );
            player1.setHand( null, count );
        }
        pot = 0;
        deck = new Deck();

    }


    public static void main( String[] args )
    {
        PokerGame poker = new PokerGame();
        System.out.println(
            "How many rounds do you want to play? Please input an integer under 5." );
        round = input.nextInt();
        System.out.println( "What is your name?" );

        String name = input.next();

        System.out.println( "Hello " + name + "!" );
        for ( int count = 0; count < round; count++ )
        {
            temp++;
            play();
            bettinground();
            drawRound();
            bettinground();
            System.out.println( getRoundWinner() );

        }

    }
}