package dnd.hippolinc.dmstuff;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        ArrayList<Monster> monsters = new ArrayList<Monster>();
        ArrayList<Player> players = new ArrayList<Player>();

        System.out.println("Hello this is Lincoln's auto targeting program to find out who in your wonderful party is being targeted");
        System.out.println("This does use a deck of cards, high number is targeted first and the monsters only target creatures in their suit");
        System.out.println("You will need at least one player and one monster");
        System.out.println();

        System.out.println("You can do the following with this program: ");
        System.out.println("Create a player, create a monster, update the hunt status, list all monsters(or players), or even find out who is being targeted");
        System.out.println("Enter the following words for each differnt program function: 'create player', 'create monster', 'update hunt', or 'list (monster or player)', 'target'");
        System.out.println("You can also enter stop to stop the program");

        for (int i = 0; i >= 0;){
            Main.userPrompt();
            String choice = input.nextLine();

            if (choice.equalsIgnoreCase("create monster")){
                System.out.println("Please enter the name of the creature:");
                String name = input.nextLine(); 
                System.out.println("Please enter the suit of the creauture:");
                String suit = input.nextLine();
                System.out.println("Please enter the number of creatures in the same suit:");
                int monstersInSuit = input.nextInt();
                System.out.println("Please enter the number of times this creature has failed the hunt since the last time it changed suit:");
                int timesFailed = input.nextInt();
                System.out.println("Does the creature hunt the weak?");
                boolean hunt = input.nextBoolean();
                Monster monster = new Monster(name, suit, monstersInSuit, timesFailed, hunt);
                monsters.add(monster);
                input.nextLine();

            }
            else if (choice.equalsIgnoreCase("create player")){
                System.out.println("Please enter the name of the player:");
                String name = input.nextLine(); 
                System.out.println("Please enter the suit of the player:");
                String suit = input.nextLine();
                System.out.println("Please enter the number on their card:");
                int priotityNumber = input.nextInt();
                Player player = new Player(name, suit, priotityNumber, true);
                players.add(player);
                input.nextLine();
            }
            else if (choice.equalsIgnoreCase("update hunt")){
                Main.updateHuntStatus(monsters);
            }
            else if (choice.equalsIgnoreCase("target")){
                System.out.println();
                for (int j = 0; j < monsters.size(); j++){
                    System.out.println(Main.target(players, monsters, j));
                    System.out.println("");
                } 
            }
            else if (choice.equalsIgnoreCase("list monsters")){
                Main.listMonsters(monsters);
            }
            else if (choice.equalsIgnoreCase("list players")){
                Main.listPlayers(players);
            }
            else if (choice.equalsIgnoreCase("presets")){
                //If you want to use this between sessions or even just not want to type out each character/monster everyime just change this method
                //Monsters
                Monster cyan = new Monster("Cyan", "Clubs", 2, 0, true);
                monsters.add(cyan);

                Monster magenta = new Monster("Magenta", "Clubs", 2, 0, false);
                monsters.add(magenta);

                Monster green = new Monster("Green", "Hearts", 1, 0, true);
                monsters.add(green);
                
                Monster orange = new Monster("orange", "Spades", 2, 0, false);
                monsters.add(orange);

                Monster black = new Monster("Black", "Spades", 2, 0, false);
                monsters.add(black);
                //Players
                Player cypress = new Player("Cypress", "Diamonds", 10, true);
                players.add(cypress);

                Player phoebe = new Player("Phoebe", "Hearts", 9, true);
                players.add(phoebe);

                Player justin = new Player("Justin", "Hearts", 6, true);
                players.add(justin);

                Player jayda = new Player("Jayda", "Clubs", 10, true);
                players.add(jayda);

                Player charlie = new Player("Charlie", "Spades", 12, true);
                players.add(charlie);
            }
            else if (choice.equalsIgnoreCase("commands")){
                System.out.println();
                System.out.println("'create player', 'create monster', 'update hunt', or 'list (monster or player)', 'target', 'stop'");
            }
            else if (choice.equalsIgnoreCase("stop")){
                break;
            }
        }
    }

    
    
    private static String target(ArrayList<Player> players, ArrayList<Monster> monsters, int monsterID) {
        int currentPrioityNumber = 0;
        String name = "no one";
        for (int j = 0; j < players.size(); j++){
            if (monsters.get(monsterID).getHuntsTheWeak()){ //checking if this creature should hunt a low priotity creature or high
                if (players.get(j).getSuit().equalsIgnoreCase(monsters.get(monsterID).getSuit()) && players.get(j).getStatus() == true){
                    if (currentPrioityNumber == 0){
                        currentPrioityNumber = 20; //This is so it will actully check all creatures and not presume there is a lower then zero
                    }
                    if (players.get(j).getPriotityNumber() < currentPrioityNumber){
                        currentPrioityNumber = players.get(j).getPriotityNumber();
                        name = players.get(j).getName();
                    }
                }
            }
            else if (!monsters.get(monsterID).getHuntsTheWeak()){ //checking if this creature should hunt a low priotity creature or high
                if (players.get(j).getSuit().equalsIgnoreCase(monsters.get(monsterID).getSuit()) && players.get(j).getStatus() == true){
                    if (players.get(j).getPriotityNumber() > currentPrioityNumber){
                        currentPrioityNumber = players.get(j).getPriotityNumber();
                        name = players.get(j).getName();
                    }
                }
            }
        }
        if (currentPrioityNumber == 0){
            return "No alive creatures in the suit";
        }
        else {
            return monsters.get(monsterID).getName() + " is targeting " + name;
        }
    }



    public static void updateHuntStatus (ArrayList<Monster> monsters){
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the name of the creature");
        String name = input.nextLine(); 
        for (int j = 0; j < monsters.size(); j++){
            if (name.equalsIgnoreCase(monsters.get(j).getName())){
                int timesNeededToSwitch = 4 - monsters.get(j).getMonsterInSuit();
                if (monsters.get(j).getTimesFailed() >= timesNeededToSwitch){
                    System.out.println("Creature failed too many times");
                    System.out.println("Draw a new card and enter the suit");
                    String oldSuit = monsters.get(j).getSuit();
                    String suit = input.nextLine();
                    String newSuit = suit;
                    monsters.get(j).setSuit(suit);
                    Main.changeAllSuits(monsters, oldSuit, newSuit);
                    monsters.get(j).setMonsterInSuit(Main.numberInSuit(monsters, newSuit));
                    break;
                } 
            else {
                System.out.println("Creature hasen't failed enough");
                monsters.get(j).increaseTimesFailed();
                break;
                }
            }
            else  {
                System.out.println("No creature with that name");
            }
        }
    }
    
    public static void listMonsters(ArrayList<Monster> monsters){
        System.out.println();
        for (int j = 0; j < monsters.size(); j++){
            String name = monsters.get(j).getName();
            System.out.println("The name of this monster is: " + name);
            System.out.println("The suit of " + name + " is: " + monsters.get(j).getSuit());
            System.out.println("The number of monsters sharing suits with " + name + " is: " + monsters.get(j).getMonsterInSuit());
            System.out.println("The number of times " + name + " has failed its hunt since last switch: " + monsters.get(j).getTimesFailed());
            System.out.println("Does " + name + " hunt strong creatures? " + monsters.get(j).getHuntsTheWeak());
            System.out.println();
        }
    }

    public static void listPlayers(ArrayList<Player> players){
        System.out.println();
        for (int j = 0; j < players.size(); j++){
            System.out.println(players.get(j).getName());
            System.out.println(players.get(j).getSuit());
            System.out.println(players.get(j).getPriotityNumber());
            System.out.println();

        }
    }

    public static void changeAllSuits(ArrayList<Monster> monsters, String oldSuit, String newSuit) {
        for (int i = 0; i < monsters.size(); i++){
            if (monsters.get(i).getSuit().equalsIgnoreCase(oldSuit)){
                monsters.get(i).reduceMonstersInSuit();
            }
            else if (monsters.get(i).getSuit().equalsIgnoreCase(newSuit)){
                monsters.get(i).increaseMonstersInSuit();
            }
            }
    }

    public static int numberInSuit(ArrayList<Monster> monsters, String suit) {
        int numberIn = 0;
        for (int i = 0; i < monsters.size(); i++){
            if (monsters.get(i).getSuit().equalsIgnoreCase(suit)){
                numberIn += 1;
            }
        }
        return numberIn;
    }

    public static void userPrompt(){
            System.out.println();
            System.out.println("Please enter if you would like to create a player, create a monster, update the hunt status, print out all monsters or players");
            System.out.println("If you forgot the commands you can also use 'commands'");
            System.out.println("Or even find out what monster is targeting who! Addtionally you can always stop!");
    }
}
