import java.util.ArrayList;

public class ComputerPlayer extends Player
{
    private String name;
    private Chips [] chip;    
    public ArrayList<Card> hand = new ArrayList<Card>();
    public ComputerPlayer (String name, Chips [] chip, Card card, Card card1, Card card2, Card card3, Card card4)
    {
        super (name, chip, card, card1 ,card2, card3, card4);
    }
   public void gStrat(ArrayList<Card> hand) {
       
       
   }
    

    

}
