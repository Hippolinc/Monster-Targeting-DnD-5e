package dnd.hippolinc.dmstuff;

public class Monster {
    private String color;
    private String suit;
    private int monstersInSuit;
    private int timesFailed;


    public Monster(String color, String suit, int monstersInSuit, int timesFailed)
    {
        this.color = color;
        this.suit = suit;
        this.monstersInSuit = monstersInSuit;
        this.timesFailed = timesFailed;
    }

    public String getColor() {
        return color;
    }
    
    public String getSuit() {
        return suit;
    }  
    
    public int getMonsterInSuit() {
        return monstersInSuit;
    }

    public int getTimesFailed() {
        return timesFailed;
    }

    public void setSuit(String suit) {
    this.suit = suit;
    } 
}

