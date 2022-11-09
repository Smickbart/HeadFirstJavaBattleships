package Battleships;

import java.util.ArrayList;

public class Battleship {
    private String name;
    ArrayList<String> location = new ArrayList<String>();

    public String getName() {
        return name;
    }

    public void setName(String text) {
        name = text;
    }

    public void setLocation(String[] ship) {
        for(int i = 0; i < 3; i++) {
            location.add(ship[i].toLowerCase());
        }
    }

    public boolean hit(String guess) {
        boolean hit = location.remove(guess.toLowerCase());
        System.out.println(location);

        if(hit) {
            System.out.printf("You hit the %s ship!  Great job old chap.\n", getName());
            location.remove(guess);
        } else {
            System.out.println("Bad luck old bean, I'm sure you'll get him next time.");
        }   

        return hit;
    }

    public boolean sunk() {
        boolean sunk = location.isEmpty();
        if(sunk) {
            System.out.printf("You've bloody sunk %s old bean, brilliant job.\n", getName());
        } else {
            System.out.printf("That blighter %s's still floating, hit him again and that should do it!\n", getName());
        }
        return sunk;
    }
}