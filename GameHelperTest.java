// package Battleships;

// public class GameHelperTest {
//     public static void main(String[] args) {
//         GameHelper helper = new GameHelper();
//         int failures = 0;
//         // helper.createLocation();
//         for(int i = 0; i < 10000; i++) {
//             System.out.println("Run #" + (i+1));
//             String[][] locations = helper.createLocation();
//             boolean match = false;
//             for(int j = 0; j < 2; j++) {
//                 for(int k = 0; k < 3; k++) {
//                     if(j == 0) {
//                         if(locations[j][0] == locations[j + 2][k]) {
//                             match = true;
//                         }
//                         if(locations[j][1] == locations[j + 2][k]) {
//                             match = true;
//                         }
//                         if(locations[j][2] == locations[j + 2][k]) {
//                         }    
//                     }
//                     if(locations[j][0] == locations[j + 1][k]) {
//                         match = true;
//                     }
//                     if(locations[j][1] == locations[j + 1][k]) {
//                         match = true;
//                     }
//                     if(locations[j][2] == locations[j + 1][k]) {
//                         match = true;
//                     }
//                 }
//             }
//             for(int l = 0; l < locations.length; l++) {
//                 for(int m = 0; m < locations[l].length; m++) {
//                     System.out.print(locations[l][m]);
//                     System.out.print(", ");
//                 }
//             }
//             if(match) {
//                 failures++;
//                 return;
//             }
//             System.out.println(match);
//         }
//         System.out.println("Number of failures this run was: " + failures);
        
//     }
    
// }
