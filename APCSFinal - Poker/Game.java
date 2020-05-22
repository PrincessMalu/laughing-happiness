import java.awt.Color;
import java.util.Scanner;

/**
 *  TODO Write a one-sentence summary of your class here.
 *  TODO Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author  Shreedevi and Malavika 
 *  @version May 20, 2020
 *  @author  Period: TODO
 *  @author  Assignment: PokerFinalProject
 *
 *  @author  Sources: TODO
 */
public class Game
{
   static Chips [] chip = new Chips [30];
   private static int bigBlind;
   private static int smallBlind;
   static Deck deck = new  Deck ();
   private static int pot = 0;
 
   
   public static Chips [] fillChips ()
   {
  
       for (int count = 0; count < chip.length; count++)
       {
           if (count>= 0 && count < 8)
           {

               chip [count] = new Chips (5, Color.RED);
           }
           else if (count >=8 && count < 18 )
           {
               chip [count] = new Chips (10, Color.BLUE);
           }
           else if (count >=18 && count < 24)
           {
               chip [count] = new Chips (25, Color.GREEN);
           }
           else if (count >= 24 && count < 30)
           {
               chip [count] = new Chips (100, Color.BLACK);
           }
       }
       return chip;
   }

  /* private Player pickRandomPlayer (Player one, Player two, Player three, Player four)
   {
       Player [] play = {one, two, three, four};
       int x = (int)Math.random() * 4;
       return play [x];
       
       }
       */
   
   public static void play ()
    {
      chip = fillChips ();
      deck.shuffle();
    
      Player player1 = new Player ("Kim", chip, deck.deal(), deck.deal());
      Player user = new Player (null, chip, null, null);
      
      System.out.println ("What is your name?");
      Scanner input = new Scanner (System.in);
      user.addName( input.next() );
      
      
      
      System.out.println ("How much do you want to bet");
      smallBlind = input.nextInt();
      pot+= smallBlind;
      
      System.out.println ("How much do you want to bet");
      bigBlind = input.nextInt();
      pot += bigBlind; 
      
      
      
        
      

    }
   
  
   
    
   
     
       

  public static void main (String [] args)
  {
      play();
  }
  }