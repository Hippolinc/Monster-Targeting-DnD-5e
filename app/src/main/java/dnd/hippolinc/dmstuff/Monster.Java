package dnd.hippolinc.dmstuff;

public class Monster{
    private final String name;
    private String suit;
    private int monstersInSuit;
    private int timesFailed;
    private final boolean huntWeak;


    public Monster(String name, String suit, int monstersInSuit, int timesFailed, boolean huntWeak)
    {
        this.name = name;
        this.suit = suit;
        this.monstersInSuit = monstersInSuit;
        this.timesFailed = timesFailed;
        this.huntWeak = huntWeak;
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

     public boolean getHuntsTheWeak() {
        return huntWeak;
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

    public void reduceMonstersInSuit() {
        monstersInSuit -= 1;
    }
    
    public void increaseTimesFailed() {
        timesFailed += 1;
    }
}

