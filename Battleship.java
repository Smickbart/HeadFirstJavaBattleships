package Battleships;

import java.util.ArrayList;

public class Battleship {
    ArrayList<String> location = new ArrayList<>();
    int hits;

    public void setLocation(int start) {
        for(int i = 0; i < 3; i++) {
            location.add(String.valueOf(start + i));
        }
    }

    public boolean checkCondition(String guess) {
        boolean shipSunk = false;
        boolean hit = location.remove(guess);

        if(!hit) {
            System.out.println("Bad luck old bean, I'm sure you'll get him next time.");
            return shipSunk;
        } else {
            hits++;
            System.out.println("You hit an enemy ship!  Great job old chap.");
            shipSunk = location.isEmpty();
        }

        if(shipSunk) {
            System.out.println("You've bloody sunk him old bean, brilliant job.");
        } else if(hit) {
            System.out.println("The blighter's still floating, hit him again and that should do it!");
        }       

        return shipSunk;
    }
}