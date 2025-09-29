package dnd.hippolinc.dmstuff;

public class Player{
    private String name;
    private String suit;
    private int priotityNumber;


    public Player(String name, String suit, int priotityNumber)
    {
        this.name = name;
        this.suit = suit;
        this.priotityNumber = priotityNumber;
    }

    public String getName() {
        return name;
    }
    
    public String getSuit() {
        return suit;
    }  
    
    public int getPriotityNumber() {
        return priotityNumber;
    }

    public void setSuit(String suit) {
    this.suit = suit;
    } 
}