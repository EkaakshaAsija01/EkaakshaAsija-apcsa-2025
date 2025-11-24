package cards;

public class Card { //all done during class so I'm not going super into detail.
private int value;
private int suit;
private String[] SUITS = {"♦","♣","♥","♠"}; //arrays for the Suits and Values, I will be matching these with the integers.
private String[] VALUES = {"A","2", "3","4","5","6","7","8","9","10","J","Q","K"};
public Card(int suit, int value)//constructor
{
    this.suit=suit;
    this.value=value;
}
public int getValue()//methods we need // this was so i could commit
{
    return value;
}
public String toString() //method.
{
    return ""+ SUITS[suit]+VALUES[value];
}

}
