/**
 * BlackJack
 */

import java.util.*;

public class BlackJack {
    // Class instances
    private HashSet<PlayingCard> deck;
    private HashSet<PlayingCard> player1;
    private HashSet<PlayingCard> player2;
    private HashSet<PlayingCard> dealer;
    
    public BlackJack() {
        this.deck = new HashSet<PlayingCard>();
        buildDeck();
        this.player1 = new HashSet<PlayingCard>();
        this.player2 = new HashSet<PlayingCard>();
        
    }

    private void buildDeck() {
        for (int i = 1; i <= 13; i++) {
            this.deck.add(new PlayingCard(i, "Diamond"));
            this.deck.add(new PlayingCard(i, "Clover"));
            this.deck.add(new PlayingCard(i, "Heart"));
            this.deck.add(new PlayingCard(i, "Spade"));
        }
    }

    public void deal(HashSet<PlayingCard> player) {
        // player.add(this.deck.remove(get))
    }

    // Helper method to randomly take card from the deck
    private static <E> E getRandomElement(Set<? extends E> set){
        
        /*
         * Generate a random number using nextInt
         * method of the Random class.
         */
        Random random = new Random();
        
        //this will generate a random number between 0 and HashSet.size - 1
        int randomNumber = random.nextInt(set.size());
 
        //get an iterator
        Iterator<? extends E> iterator = set.iterator();
        
        int currentIndex = 0;
        E randomElement = null;
        
        //iterate the HashSet
        while(iterator.hasNext()){            
                
            randomElement = iterator.next();
            
            //if current index is equal to random number
            if(currentIndex == randomNumber)
                return randomElement;            
            
            //increase the current index
            currentIndex++;
        }
        
        return randomElement;
    }

    // Main method for debugging
    public static void main(String[] args) {
        BlackJack game = new BlackJack();
    }
}
