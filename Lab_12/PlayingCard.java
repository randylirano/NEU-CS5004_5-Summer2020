/**
 * PlayingCard.java
 */

public class PlayingCard {
    // Class instances
    private int rank;   // Ace is 1 and king is 13
    private String suit;    // "Diamond", "Clover", "Heart", or "Spade"
    
    // Class constructor
    public PlayingCard(int rank, String suit) {
        setRank(rank);
        setSuit(suit);
    }

    // Getter methods
    public int getRank() {
        return this.rank;
    }

    public String getSuit() {
        return this.suit;
    }

    // Setter methods
    public boolean setRank(int rank) {
        if (rank < 1 || rank > 13) {
            return false;
        } else {
            this.rank = rank;
            return true;
        }
    }

    public boolean setSuit(String suit) {
        if (suit.equalsIgnoreCase("Diamond") || suit.equalsIgnoreCase("Clover") || suit.equalsIgnoreCase("Heart") || suit.equalsIgnoreCase("Spade")) {
            this.suit = suit;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int res = Integer.hashCode(this.rank);
        res = 31 * res + this.suit.hashCode();
        return res;
    }

    @Override
    public String toString() {
        return getRank() + " of " + getSuit();
    }

    @Override
    public boolean equals(Object otherObj) {
        if (otherObj == null) {
            return false;
        } else if (!(getClass() == otherObj.getClass())) {
            return false;
        } else {
            PlayingCard other = (PlayingCard) otherObj;
            return this.getRank() == other.getRank() && this.getSuit().equalsIgnoreCase(other.getSuit()) && this.hashCode() == other.hashCode();
        }
    }
}

/*
Question:
How big should the hash table be to balance good performance versus size, given that there are exactly 52 unique PlayingCards?

>> 13 x 4 hash table should provide a proper balance between performance versus size giving there are 52 unique PlayingCards
*/