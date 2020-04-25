'''
Created on Feb 6, 2019

@author: Nancy and Malavika Period 2 
Added round system 
'''
from card import Card
from cards import Cards
from player import Player
import time 

# make a BlackjackCard Class inherit from Card
# make a BlackjackCard Class inherit from Card
class BlackjackCard(Card):
    def getValue(self):
        if self.rank == 'A':
            return(11)
        elif self.rank == 'J':
            return(10)
        elif self.rank == 'Q':
            return(10)
        elif self.rank == 'K':
            return(10)
        elif self.rank in '23456789' or self.rank == '10':
            return(int(self.rank))
        else:
            raise ValueError('{} is of unkwown value'.format(self.rank))
       
# make a BlackjackHand Class
class BlackjackHand(Cards):
    def getTotalWithAce(self):
        hand = 0
        for card in self.cards:
            if card.rank not in "A":
                hand = hand + card.getValue()               
            else:
                if hand + 11 <= 21:
                    hand = hand + 11
                else:
                    hand = hand + 1
        return(hand)
    def bust(self):
        if self.getTotalWithAce() > 21:
            return True
        
# make a BlackjackPlayer Class
class BlackjackPlayer(Player):
    
    def askHit(self, dealercard):
        x = input(self.name + ", would you like to hit? (y/n): ")
        if x == "y":
            return True
        elif x == "n":
            return False
        else:
            y = input("What you entered is invalid. Please respond with y or n.")
            if x == "y":
                return True
            elif x == "n":
                return False
            
# make a BlackjackDealer Class 
class BlackjackDealer(BlackjackPlayer):
     def BlackjackPlayer(self):
         if self.hand.getTotalWithAce() < 17:
             return True
         else:
             return False
         
     def initialDisplay(self):
        s = str(self.hand)
        v = s.find(' ')
        p = s[1:v] + ' ??]' 
        #print(p)
        return(p)#prints out name and the hand of cards    
    
# make a BlackjackGame function
def BlackjackGame():
        
    # make the 2 players
    playerscore = 0
    dealerscore = 0 
    deckPlayer = BlackjackHand()  # make empty deck
    deckDealer = BlackjackHand()
    deck = Cards()

    def makeDeck():
        deckType = input("Deck type - Enter 1 for regular deck or 2 for 6-deck shoe:")
        while deckType not in "2" and deckType not in "1":
            deckType = input("Please enter either 1 or 2.")    #Makes the deck based on user's choice of deck 
        deckType = int(deckType)
        if deckType == 1:
            for suit in ['h', 'd', 's', 'c']:
                for rank in ['A', '2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K']:
                    c = BlackjackCard(rank, suit)
                    deck.add(c)        
                    deck.shuffle()
        if deckType == 2:
            for i in range(6):
                for suit in ['h', 'd', 's', 'c']:
                    for rank in ['A', '2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K']:
                        c = BlackjackCard(rank, suit)
                        deck.add(c)        
                        deck.shuffle()    
    makeDeck()
    print("Welcome to Blackjack!!")   #Initial welcoming and name
    def name():
        time.sleep(0.5)
        name = input("What is your name?")
        print("Hi",name+"!")
        time.sleep(0.5)
        return name
    name = name()
    
    def bet():            # find out how much money the player would like to bet. 
        bet = input("How much money do you want to bet every round?")
        while not bet.isnumeric():
            bet = input("How much money would you like to bet? Please enter a valid integer.")
        bet = int(bet)
        return bet
    bet = bet()
    
    amount = 0 - bet #takes away bet from money 
    player = BlackjackPlayer(str(name), amount)
    dealer = BlackjackDealer("Dealer", amount)
    def rounds(): #asks how many rounds to play 
        rounds = input("How many rounds would you like to play?")
        while not rounds.isnumeric():
            rounds = input("How many rounds would you like to play? Please enter a valid integer.")
        return rounds
    rounds = rounds()
    
    for round in range(1, (int(rounds)+1) ):       
        print("* SHUFFLING NEW DECK *")
        deck.shuffle()    
        dealer.tossHand()    # reset the hands from old round if applicable
        player.tossHand()
        deckPlayer = BlackjackHand()  # make empty hand
        deckDealer = BlackjackHand()
        naturalwin = False
        win = False
        tie = False
        
        def dealCards():     # deal cards at the beginning of every round to the player and dealer.
            print("Round [",round, "] Score: Dealer", dealerscore, "vs.", name, playerscore)
            for i in range (2): 
                v = deck.deal()
                deckPlayer.add(v)
                player.addCard(deckPlayer)      

                v = deck.deal()
                deckDealer.add(v)
                dealer.addCard(deckDealer)
            return v
        v = dealCards()    
    
        print("Your hand:", deckPlayer)         # Inform the player of their hand 
        print("Dealer's hand:", dealer.initialDisplay())    # reveal one card of the dealer
    
        if (deckPlayer.getTotalWithAce()) == 21:           # decide if dealer of player has a natural 21
            print(name + ":",deckPlayer, "=> Natural 21!") 
            win= True
            naturalwin = True
        elif (deckDealer.getTotalWithAce()) == 21:
            win = False
            print(name + ":",deckPlayer, "=> ",deckPlayer.getTotalWithAce())
        else:
            totalDealer = deckDealer.getTotalWithAce() 
            print(name + ":",deckPlayer, "=> ",deckPlayer.getTotalWithAce())  
   
        while not deckPlayer.bust() and not deckDealer.bust() and deckDealer.getTotalWithAce() <= 21 and deckPlayer.getTotalWithAce() <= 21 and not naturalwin:
            t = player.askHit(v)     # Asks if the player would like to hit 
            if t == True:
                v = deck.deal()
                deckPlayer.add(v)
                player.addCard(deckPlayer) 
                newPTotal = deckPlayer.getTotalWithAce() # New Player total after hitting
                print(name+":",deckPlayer,":", newPTotal )
                if newPTotal > 21:
                    win = False
 
            elif t == False:
                startDealer = deckDealer.getTotalWithAce()
                print("Dealer:", deckDealer,"=>",startDealer) #Dealer side 
                nDealer = deckDealer.getTotalWithAce()
                while nDealer < 17:
                    v = deck.deal()
                    deckDealer.add(v)
                    dealer.addCard(deckDealer) 
                    nDealer = deckDealer.getTotalWithAce()
                    print("Dealer: ",deckDealer,"=>", nDealer )
                break
            
        def decideWinner(win,tie):            # figures out who won
            FinalPlayer = deckPlayer.getTotalWithAce()
            FinalDealer = deckDealer.getTotalWithAce()
            if FinalPlayer > FinalDealer and FinalPlayer <= 21:
                print("Yay!! You won this round.",FinalPlayer, "vs.", FinalDealer)
                win = True
            elif FinalDealer > 21:
                print("The Dealer busts with "+ str(FinalDealer)+ ". You win!")
                win = True
            elif int(FinalPlayer) == int(FinalDealer) and not naturalwin:
                print("Push: You tied with the Dealer.",FinalPlayer, "vs.", FinalDealer)
                tie = True  
            elif FinalDealer == 21:
                print("Dealer has 21: You Lose" , FinalPlayer,"vs.",FinalDealer)
                win = False
            elif FinalPlayer < 21 and FinalDealer < 21 and FinalDealer > FinalPlayer:
                print("Ooops! you lost this round. Better luck next time.")
                win = False
            elif FinalPlayer > 21:
                print("Oops, you busted,", FinalPlayer," the dealer wins.")
            return (win,tie)
        (win,tie) = decideWinner(win,tie)
        
        
        if tie: 
            if playerscore == 1:
                player.addMoney(bet) #players bet is given back, nothing lost or gained
            
        elif win: 
            playerscore +=1        # figure out the player score
            if naturalwin:
                player.addMoney(bet + bet*1.5)           # Adds or takes away money 
                print("You won extra from your natural 21 ${}".format(bet*1.5))
            else:
                if playerscore == 1:
                    player.addMoney(bet*2)
                else:
                    player.addMoney(bet)
                print("You won ${}".format(bet))
        else:
            dealerscore +=1
            player.addMoney(-bet)
            print("You lost ${}".format(bet))
        print("")
 
        time.sleep(1) 
    def finalPrint(name, playerscore):         # print out final standings for the player (money, score)
        print("------------------------------------- ")
        print("| Final Score: Dealer", dealerscore, "vs.", name, playerscore,"|")
        if player.money <0: 
            print("| You ended with: -${}             |".format(abs(player.money)))
        else: 
            print("| You ended with: ${}              |".format(player.money))
        print("------------------------------------- ")
    finalPrint(name, playerscore)


def main():
    BlackjackGame()
    
    
if __name__ == "__main__":
    main()
        

