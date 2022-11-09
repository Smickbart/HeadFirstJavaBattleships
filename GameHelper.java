package Battleships;

import java.io.*;
import java.util.ArrayList;

public class GameHelper {

    public String[][] createLocation() {
        ArrayList<String> allPositions = new ArrayList<String>(); //Keeps track of all positions that exist on the grid
        ArrayList<String> availableVertical = new ArrayList<String>(); //Keeps track of positions where you can start a new vertically aligned ship.
        ArrayList<String> availableHorizontal = new ArrayList<String>();//Keeps track of positions where you can start a new horizontally aligned ship.
        String[][] locations = new String[3][3]; //The three ship's positions on the grid.

        String[] rowLabels = {"A", "B", "C", "D", "E", "F", "G"}; //Used for creating the string to represent one square of a ship.

        //Populates all above arrays with the data necessary for placing ships.
        for(int i = 0; i < 7; i++) {
            for(int j = 0; j < 7; j++) {
                allPositions.add(rowLabels[i] + Integer.toString((j + 1)));
                if(j < 5) {
                    availableHorizontal.add(rowLabels[i] + Integer.toString((j + 1)));
                }                
                if(i < 5) {
                    availableVertical.add(rowLabels[i] + Integer.toString((j + 1)));
                }                
            }
        }

        //Position the ships in unique locations so that they are not overlapping.
        for(int i = 0; i < 3; i++) {
            int orientation = (int) (Math.random()*2);

            if(orientation < 1) {
                int startIndex = (int) (Math.random() * availableHorizontal.size());
                int allPositionsIndex = allPositions.indexOf(availableHorizontal.get(startIndex));
                locations[i][0] = availableHorizontal.get(startIndex); //First square
                locations[i][1] = allPositions.get(allPositionsIndex + 1); //Second square
                locations[i][2] = allPositions.get(allPositionsIndex + 2); // Third square

                //All the below is for removing starting locations which would cause a ship to overlap another.
                availableHorizontal.remove(allPositions.get(allPositionsIndex)); 
                availableHorizontal.remove(allPositions.get(allPositionsIndex + 1));
                availableHorizontal.remove(allPositions.get(allPositionsIndex + 2));
                availableVertical.remove(allPositions.get(allPositionsIndex));
                availableVertical.remove(allPositions.get(allPositionsIndex + 1));
                availableVertical.remove(allPositions.get(allPositionsIndex + 2));

                if(allPositionsIndex - 2 >= 0 && allPositions.get(allPositionsIndex - 2).charAt(0) == (allPositions.get(allPositionsIndex).charAt(0))) {
                    availableHorizontal.remove(allPositions.get(allPositionsIndex - 2));                    
                }

                if(allPositionsIndex - 1 >= 0 && allPositions.get(allPositionsIndex - 1).charAt(0) == (allPositions.get(allPositionsIndex).charAt(0))) {
                    availableHorizontal.remove(allPositions.get(allPositionsIndex - 1));
                }

                if(allPositionsIndex - 14 >= 0) {
                    availableVertical.remove(allPositions.get(allPositionsIndex - 14));
                    availableVertical.remove(allPositions.get(allPositionsIndex - 13));
                    availableVertical.remove(allPositions.get(allPositionsIndex - 12));
                }

                if(allPositionsIndex - 7 >= 0) {
                    availableVertical.remove(allPositions.get(allPositionsIndex - 7));
                    availableVertical.remove(allPositions.get(allPositionsIndex - 6));
                    availableVertical.remove(allPositions.get(allPositionsIndex - 5));
                }                

            } else {
                int startIndex = (int) (Math.random() * availableVertical.size());
                int allPositionsIndex = allPositions.indexOf(availableVertical.get(startIndex));
                locations[i][0] = availableVertical.get(startIndex);
                locations[i][1] = allPositions.get(allPositionsIndex + 7);
                locations[i][2] = allPositions.get(allPositionsIndex + 14);

                availableVertical.remove(allPositions.get(allPositionsIndex));
                availableVertical.remove(allPositions.get(allPositionsIndex + 7));
                availableVertical.remove(allPositions.get(allPositionsIndex + 14));
                availableHorizontal.remove(allPositions.get(allPositionsIndex));
                availableHorizontal.remove(allPositions.get(allPositionsIndex + 7));
                availableHorizontal.remove(allPositions.get(allPositionsIndex + 14));

                if(allPositionsIndex - 14 >= 0) {
                    availableVertical.remove(allPositions.get(allPositionsIndex - 14));                    
                }
                
                if(allPositionsIndex - 7 >= 0) {
                    availableVertical.remove(allPositions.get(allPositionsIndex - 7));                    
                }
                
                if(allPositionsIndex - 2 >= 0 && allPositions.get(allPositionsIndex - 2).charAt(0) == (allPositions.get(allPositionsIndex).charAt(0))) { //First check if out of bounds then check if in the same row by checking first character.
                    availableHorizontal.remove(allPositions.get(allPositionsIndex - 2));
                    availableHorizontal.remove(allPositions.get(allPositionsIndex + 5));
                    availableHorizontal.remove(allPositions.get(allPositionsIndex + 12));
                }

                if(allPositionsIndex - 1 >= 0 && allPositions.get(allPositionsIndex - 1).charAt(0) == (allPositions.get(allPositionsIndex).charAt(0))) {
                    availableHorizontal.remove(allPositions.get(allPositionsIndex - 1));
                    availableHorizontal.remove(allPositions.get(allPositionsIndex + 6));
                    availableHorizontal.remove(allPositions.get(allPositionsIndex + 13));
                }
            }
        }
        return locations;
    }

    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.print(prompt + " ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if(inputLine.length() == 0) return null;
        } catch (IOException e) {
            System.out.println("IOexception: " + e);
        }
        return inputLine;
    }
}
