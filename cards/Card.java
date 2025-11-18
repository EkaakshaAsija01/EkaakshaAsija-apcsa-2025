package cards;

public class Card {
private int value;
private int suit;
private String[] SUITS = {"♦","♣","♥","♠"}
private String[] VALUES = {"A","2", "3","4","5","6","7","8","9","10","J","Q","K"}
public Card(int suit, int value)
{
    this.suit=suit;
    this.value=value;
}
public int getValue()
{
    return value;
}
public String toString()
{
    return ""+ SUITS[suit]+VALUES[value];
}

}
