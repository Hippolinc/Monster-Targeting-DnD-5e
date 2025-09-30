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
        System.out.println("You will need atleast one player and one monster");
        System.out.println("You can do the following with this program like create a player, create a monster, or update the hunt status");
        System.out.println("Enter the following words for each differnt program function: player, monster, or hunt");
        System.out.println("You can also enter stop to stop the program");
        for (int i = 0; i >= 0; i+=1){
            System.out.println("Please enter if you would like to create a player, create a monster, update the hunt status, or stop");
            String choice = input.nextLine();
            if (choice.equalsIgnoreCase("monster")){
                System.out.println("Please enter the name of the creature:");
                String name = input.nextLine(); 
                System.out.println("Please enter the suit of the creauture:");
                String suit = input.nextLine();
                System.out.println("Please enter the number of creatures in the same suit:");
                int monstersInSuit = input.nextInt();
                System.out.println("Please enter the number of times this creature has failed the hunt since the last time it changed suit:");
                int timesFailed = input.nextInt();
                Monster monster = new Monster(name, suit, monstersInSuit, timesFailed);
                monsters.add(monster);
                for (int j = 0; j < monsters.size(); j++){
                    System.out.println(monsters.get(j).getSuit());
                }
            }
            else if (choice.equalsIgnoreCase("player")){
                System.out.println("Please enter the name of the player:");
                String name = input.nextLine(); 
                System.out.println("Please enter the suit of the player:");
                String suit = input.nextLine();
                System.out.println("Please enter the number on their card:");
                int priotityNumber = input.nextInt();
                Player player = new Player(name, suit, priotityNumber);
                players.add(player);
                for (int j = 0; j < players.size(); j++){
                    System.out.println(players.get(j).getSuit());
                }
            }
            else if (choice.equalsIgnoreCase("hunt")){
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
                    else {
                        System.out.println("No creature with that name");
                    }
                }
            }
            else if (choice.equalsIgnoreCase("suit")){
                for (int j = 0; j < monsters.size(); j++){
                    System.out.println(monsters.get(j).getMonsterInSuit());
                }
            }
            else if (choice.equalsIgnoreCase("stop")){
                break;
            }
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
}
