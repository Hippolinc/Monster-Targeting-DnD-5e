package dnd.hippolinc.dmstuff;

public class Monster{
    private String name;
    private String suit;
    private int monstersInSuit;
    private int timesFailed;


    public Monster(String name, String suit, int monstersInSuit, int timesFailed)
    {
        this.name = name;
        this.suit = suit;
        this.monstersInSuit = monstersInSuit;
        this.timesFailed = timesFailed;
    }

    public String getName() {
        return name;
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

    public void setName(String name) {
    this.name = name;
    }

    public void setSuit(String suit) {
    this.suit = suit;
    }
    
    public void setMonsterInSuit(int monstersInSuit) {
        this.monstersInSuit = monstersInSuit;
    }

    public void setTimesFailed(int timesFailed) {
        this.timesFailed = timesFailed;
    }

    public void increaseMonstersInSuit() {
        monstersInSuit += 1;
    }
    
    public void increaseTimesFailed() {
        timesFailed += 1;
    }
}

