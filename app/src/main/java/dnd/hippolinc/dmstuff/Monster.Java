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

    public static String getColor() {
        return color;
    }
    
    public static String getSuit() {
        return suit;
    }  
    
    public static int getMonsterInSuit() {
        return monstersInSuit;
    }

    public static int getTimesFailed() {
        return timesFailed;
    }
}