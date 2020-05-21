

/**
 * Description: A list of Card; used for a player's hand or a deck of cards
 * 
 * - cards - list of card; starts out empty Methods - shuffle() - randomly
 * shuffle all the card in the list - deal() - deal the 'top' card from the
 * hand/deck - add(card) - add card to the list of cards - __str__() - returns
 * string of all the cards in the hand like '[4d 10h As]'
 *
 * @author Malavika Nair
 * @version April 19, 2020
 * @author Period: 1
 * @author Assignment: Final Project
 *
 * @author Sources: None
 */
public class Deck
{

    import random
    import card


    public Deck() {
        this.cards = []
    }


    public char deckToString() {
            char s = '['
            for (card c: this.cards ):
                if (this.cards.length == 1) {
                    s = s + str(card)
                }
                else {
                    s = s + ' ' + str(card)
                }
            s = s + ']'
            return(s)
    }


   public add(self, card) {
        this.cards.append(card)
                    
    }


   public card deal(self) {
            return this.cards.pop(0)
    }


   public shuffle() {
         random.shuffle(this.cards)
    }

}
