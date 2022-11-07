package Battleships;

import java.io.*;
import java.util.ArrayList;

public class GameHelper {
    


    public void createLocation() {
        ArrayList<String> verticalStarts = new ArrayList<String>();
        ArrayList<String> horizontalStarts = new ArrayList<String>();
        ArrayList<ArrayList<String>> locations = new ArrayList<ArrayList<String>>();
        for(int i = 0; i < 7; i++) {
            String verticalCode[] = {"A", "B", "C", "D", "E", "F", "G"};
            for(int j = 0; j < 7; j++) {
                verticalStarts.add(verticalCode[i] + Integer.toString(j + 1));
                horizontalStarts.add(verticalCode[i] + Integer.toString(j + 1));
            }
        }

        for(int i = 0; i < 3; i++) {
            int alignment = (int) (Math.random() * 2);

            if(alignment < 1) {
                System.out.println("alignment = Horizontal");
                int column = (int) (Math.random() * 7);
                int row = (int) (Math.random() * 5);
                int start = (column * 7) + row;
                System.out.println("start = " + start);
                ArrayList<String> location = new ArrayList<String>();
                location.add(horizontalStarts.get(start));
                location.add(horizontalStarts.get(start + 1));
                location.add(horizontalStarts.get(start + 2));
                locations.add(location);
            } else {
                System.out.println("Vertical");
                int start = (int) (Math.random() * 35);
                ArrayList<String> location = new ArrayList<String>();
                location.add(verticalStarts.get(start));
                location.add(verticalStarts.get(start + 7));
                location.add(verticalStarts.get(start + 14));
                locations.add(location);
            }
        }
        System.out.println(locations);
        System.out.println(verticalStarts);
        System.out.println(horizontalStarts);
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
