package Battleships;

public class BattleshipTestCode {
    
    public static void main(String[] args) {
        Battleship a = new Battleship();
        a.setLocation(3);
        a.checkCondition("3");
        a.checkCondition("4");
        a.checkCondition("5");
    }
}
