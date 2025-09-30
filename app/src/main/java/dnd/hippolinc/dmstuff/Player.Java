package dnd.hippolinc.dmstuff;

public class Player{
    private String name;
    private String suit;
    private int priotityNumber;
    private boolean alive;


    public Player(String name, String suit, int priotityNumber, boolean alive)
    {
        this.name = name;
        this.suit = suit;
        this.priotityNumber = priotityNumber;
        this.alive = alive;
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

    public boolean getStatus() {
        return alive;
    }

    public void setSuit(String suit) {
    this.suit = suit;
    } 

    public void died() {
    alive = false;
    } 
}