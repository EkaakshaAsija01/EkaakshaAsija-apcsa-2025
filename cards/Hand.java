package cards;

public class Hand {
    private Card[] cards; // holds all the cards
    private int length;   // current card count

    public Hand(int maxCards) {
        cards = new Card[maxCards]; // make card array
        length = 0; // start with zero
    }

    public void add(Card card) {
        // add card if space
        if (length < cards.length) {
            cards[length] = card; // place card here
            length++; // increase count
        }
    }

    public int length() {
        return length; // return card amount
    }

    public Card get(int index) {
        // get card by index
        if (index >= 0 && index < length) {
            return cards[index]; // return this card
        }
        return null; // invalid index case
    }

    public Card remove(int index) {
        // remove card at index
        if (index < 0 || index >= length) return null;
        Card removed = cards[index]; // save removed card

        // shift cards leftwards
        for (int i = index; i < length - 1; i++) {
            cards[i] = cards[i + 1]; // move card left
        }

        cards[length - 1] = null; // clear last spot
        length--; // reduce card count
        return removed; // return removed card
    }

    public String toString() {
        // convert hand to string
        String result = "";
        for (int i = 0; i < length; i++) {
            result += cards[i]; // add card text
            if (i < length - 1) result += " "; // add space here
        }
        return result;
    }
}
