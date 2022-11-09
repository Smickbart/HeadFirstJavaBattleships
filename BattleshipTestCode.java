package Battleships;

import java.util.ArrayList;

public class BattleshipTestCode {
    private ArrayList<Battleship> battleships = new ArrayList<Battleship>();
    private String[] rowLabel = {"A", "B", "C", "D", "E", "F", "G"};
    public static void main(String[] args) {
        BattleshipTestCode tester = new BattleshipTestCode();
        GameHelper helper = new GameHelper();
        Battleship shipA = new Battleship();   
        Battleship shipB = new Battleship();   
        Battleship shipC = new Battleship();

        shipA.setName("The Seagull");
        shipB.setName("The Westminster");
        shipC.setName("The Bagshot");

        String[][] locations = helper.createLocation();

        shipA.setLocation(locations[0]);
        shipB.setLocation(locations[1]);
        shipC.setLocation(locations[2]);

        tester.battleships.add(shipA);
        tester.battleships.add(shipB);
        tester.battleships.add(shipC);

        int stop = 0;

        while(tester.battleships.size() > 0 && stop < 10) {
            String guess = tester.rowLabel[(int) (Math.random() * 7)] + String.valueOf((int) (Math.random() * 7 + 1));
            for(int i = 0; i < tester.battleships.size(); i++) {
                System.out.printf("Try coordinates: %s\n", guess);
                if(tester.battleships.get(i).hit(guess)) {
                    if(tester.battleships.get(i).sunk()) {
                        tester.battleships.remove(i);
                    }
                }
            }
            stop++;
        }
        System.out.println("You've sunk them all you genius, by God Nelson would have a tear in his eye!");
    }
}
