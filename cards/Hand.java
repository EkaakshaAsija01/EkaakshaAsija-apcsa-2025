package cards;

public class Hand {
    private Card[] cards;
    private int length;

    public Hand(int maxCards) {
        cards = new Card[maxCards];
        length = 0;
    }

    public void add(Card card) {
        if (length < cards.length) {
            cards[length] = card;
            length++;
        }
    }

    public int length() {
        return length;
    }

    public Card get(int index) {
        if (index >= 0 && index < length) {
            return cards[index];
        }
        return null;
    }

    public Card remove(int index) {
        if (index < 0 || index >= length) return null;
        Card removed = cards[index];
        for (int i = index; i < length - 1; i++) {
            cards[i] = cards[i + 1];
        }
        cards[length - 1] = null;
        length--;
        return removed;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < length; i++) {
            result += cards[i];
            if (i < length - 1) result += " ";
        }
        return result;
    }
}
