package cards;

public class Deck {

    private Card[] cards;   // the 52 cards
    private int top;        // index of card to draw

    public Deck() { //constructor
        cards = new Card[52];
        top = 0;

        int index = 0;
        for (int suit = 0; suit < 4; suit++) {
            for (int value = 0; value < 13; value++) {
                cards[index] = new Card(suit, value);
                index++;
            }
        }
    }

    public void shuffle() {
        for (int i = 0; i < cards.length; i++) {
            int randomIndex = (int)(Math.random() * 52);

            // swap cards[i] and cards[randomIndex], this will happen for the card length (inspiration was from Anish)
            Card temp = cards[i];
            cards[i] = cards[randomIndex];
            cards[randomIndex] = temp;
        }
    }

    public void cut(int n) {
        // Only works if deck is full (top is 0)
        if (n < 0 || n > 51 || top != 0) {
            return;
        }

        Card[] newDeck = new Card[52];
        int index = 0;

        // copy cards from n to end
        for (int i = n; i < 52; i++) {
            newDeck[index] = cards[i];
            index++;
        }

        // copy cards from 0 to n-1
        for (int i = 0; i < n; i++) {
            newDeck[index] = cards[i];
            index++;
        }

        cards = newDeck;
    }

    public Card draw() {
        if (top >= 52) {
            return null; // if deck empty
        }
        Card c = cards[top];
        top++;
        return c;
    }

    public void print(int n) {
        for (int i = 0; i <= n && i < 52; i++) {
            System.out.print(cards[i].toString() + " ");
        }
        System.out.println();
    }

}
