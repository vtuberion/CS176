// CS176L-01
// Vincent Tuberion, Jack Kogut, Adnan Hoti
// TwoDimensionArray.java
// Last Modified 10/27/2022 15:49 EST

import java.util.ArrayList;
public class TwoDimensionArray {
    public static void main(String[] args) {
        //ArrayList[][] medalCount = new ArrayList[8][3];
        // Create an Array for the name of each country
        String[] countryName = {"Canada", "Italy", "Germany", "Japan",
                "Kazakhstan", "Russia", "South Korea", "United States"};
        // Create a 2D Array for the medal count of each country
        int[] goldMedalCount = {0, 0, 0, 1, 0, 3, 0, 1,};
        int[] silverMedalCount = {3, 0, 0, 0, 0, 1, 1, 0};
        int[] bronzeMedalCount = {0, 1, 1, 0, 1, 1, 0, 1};
        String output = String.format("%-15s\t\t%s  %s  %s  %s\n","Country", "Gold", "Silver","Bronze","Total");
        //String output = "Country\t\tGold\tSilver\tBronze\tTotal\n";
        int totalGold = 0;
        int totalSilver = 0;
        int totalBronze = 0;
        int totalTotal = 0;
        for (int i = 0; i < countryName.length; i++) {
            int totalPerCountry = goldMedalCount[i] + silverMedalCount[i] + bronzeMedalCount[i];
            totalGold += goldMedalCount[i];
            totalSilver += silverMedalCount[i];
            totalBronze += bronzeMedalCount[i];
            totalTotal += totalPerCountry;
            output += String.format("%-15s\t\t %d       %d       %d      %d\n",countryName[i],goldMedalCount[i],silverMedalCount[i],bronzeMedalCount[i], totalPerCountry);
        }
        output += String.format("Totals         \t\t %d       %d       %d      %d\n",totalGold,totalSilver,totalBronze, totalTotal);
        System.out.println(output);

    }
}
