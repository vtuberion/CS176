// Vincent Tuberion
// WebCrawler.java
//

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebCrawler {
    public static String formatName(String rowString){
        /* README:
           Given a fangraphs table row as a String, this method will return the name of the player
           - Vincent Tuberion 2022/12/08 16:51 EST
        */
        //System.out.println(info); // Debugging
        int startSelection = 0; // Hold the starting index (Java Strings start at 0)
        for (int c = 0; c < 5; c++) {
            // Find the first space in the row string (this separates the player position from their first name)
            if (rowString.charAt(c) == ' ') {
                // Once the space is found at a certain index, grab that index and add 1 (to include the space character too)
                startSelection = c+1;
            }
        }
        int endSelection = 50; // Hold the final index to be read (don't bother to read the full row if the player name is more towards the start of each row)
        for (int i = 0; i <= endSelection; i++) { // Iterate through the row, no need to read after position 50 since a name isn't likely that long
            // Read the substring in sets of 3, we are looking for the team name which is in all caps
            // If theres a substring that is 1) all letters and 2) all CAPITAL letters, that is the start of the data we need to scrap
            // We cannot split the row data and take a first and last name only, as some players have Jr. or other features on their name that must be considered
            String lineSubstring = rowString.substring(i, i + 3);
            int LENGTH = lineSubstring.length(); // In case we want to change the substring length to read, this value is fed to the for loop instead
            boolean isValid = true; // The data is valid until we confirm that it isn't
            for (int v = 0; v < LENGTH; v++) { // Read through the substring of 3 characters
                if (!Character.isAlphabetic(lineSubstring.charAt(v))) { // Is the substring all letters? If not, then it isn't valid
                    isValid = false;
                }
            }
            //System.out.println(lineSubstring); // Debugging
            // If we have a valid substring of only letters and the letters are all CAPITALIZED; OR we have a substring of " - "
            // Players without assigned teams on the list have "- - -" in their row, we need to account for that as well
            if ((isValid && (lineSubstring.equals(lineSubstring.toUpperCase()) && (lineSubstring.matches("[a-zA-Z]+"))) || lineSubstring.equals(" - "))) {
                // A capital string of all letters (team name) or "- - -" was found, the end of the name comes before this
                endSelection = i-1; // Subtract the current index by one to account for the space character after the player name
                //System.out.println(info.substring(i, i + 3));
            }
        }
        // Return the substring, starting at the first character of the player first name, to the last character of their full name
        return rowString.substring(startSelection, endSelection);
    }
    public static String[] arrayMaker(String URL){
        String[] finalArray = new String[0];
        boolean loaded = false;
        while (!loaded){
            System.out.println("Grabbing website data, please wait...");
            try {
                StringBuilder concatinateStrings = new StringBuilder();
                Document statsPage = Jsoup.connect(URL).timeout(10000).get();
                loaded = true;
                Elements body = statsPage.select("tbody");
                //System.out.println(body.select("tr").size());
                for (Element e : body.select("tr")) {
                    String info = e.select("td.grid_line_regular").text();
                    if (info.length() > 50) {
                        concatinateStrings.append(formatName(info));
                        concatinateStrings.append("---");
                    }
                }
                //System.out.println(concatinateStrings);
                finalArray = concatinateStrings.toString().split("---");
                /*System.out.println(player2022Array.length);
                for (String a : player2022Array) {
                    System.out.println(a);
                }*/

            }catch(IOException e){
                System.out.println("ERROR: Batting Statistics website failed to respond, retrying...");
            }
        }
        return finalArray;
    }
    public static void main(String[]args) {
        final String PAGE2022URL = "https://www.fangraphs.com/leaders.aspx?pos=all&stats=bat&lg=all&qual=y&type=8&season=2022&month=0&season1=2022&ind=0&team=0&rost=0&age=0&filter=&players=0&startdate=2022-01-01&enddate=2022-12-31&sort=13,d&page=1_200";
        final String PAGE2021URL = "https://www.fangraphs.com/leaders.aspx?pos=all&stats=bat&lg=all&qual=y&type=8&season=2021&month=0&season1=2021&ind=0&team=0&rost=0&age=0&filter=&players=0&startdate=2021-01-01&enddate=2021-12-31&sort=13,d&page=1_200";
        final String PAGE2020URL = "https://www.fangraphs.com/leaders.aspx?pos=all&stats=bat&lg=all&qual=y&type=8&season=2020&month=0&season1=2020&ind=0&team=0&rost=0&age=0&filter=&players=0&startdate=2020-01-01&enddate=2020-12-31&sort=13,d&page=1_200";
        // -------------------2022 PAGE LIST-------------------
        String[] playerList2022 = arrayMaker(PAGE2022URL);
        // -------------------2021 PAGE LIST-------------------
        String[] playerList2021 = arrayMaker(PAGE2021URL);
        // -------------------2020 PAGE LIST-------------------
        String[] playerList2020 = arrayMaker(PAGE2020URL);
        String[] playerList3years = new String[200];
        float[] playerAvg3years = new float[200];
        int threeYearListUse = 0;
        for (int i = 0; i < playerList2022.length; i++){
            boolean isIn2021List = false;
            for (int j = 0; j < playerList2021.length; j++) {
                if (playerList2021[j].equals(playerList2022[i])){
                    isIn2021List = true;
                }
            }
            boolean isIn2020List = false;
            for (int j = 0; j < playerList2020.length; j++) {
                if (playerList2020[j].equals(playerList2022[i])){
                    isIn2020List = true;
                }
            }
            if (isIn2021List && isIn2020List){
                playerList3years[threeYearListUse] = playerList2022[i];
                threeYearListUse +=1;
            }
        }
        for (int i = 0; i < playerList3years.length; i++){
            int positionAverage = 0;
            if (playerList3years[i] != null) {
                for (int j = 0; j < playerList2022.length; j++) {
                    if (playerList2022[j].equals(playerList3years[i])){
                        positionAverage += j;
                    }
                }
                for (int j = 0; j < playerList2021.length; j++) {
                    if (playerList2021[j].equals(playerList3years[i])){
                        positionAverage += j;
                    }
                }
                for (int j = 0; j < playerList2020.length; j++) {
                    if (playerList2020[j].equals(playerList3years[i])){
                        positionAverage += j;
                    }
                }
                positionAverage /= 3;
                playerAvg3years[i] = positionAverage;
                //System.out.println(playerList3years[i] + " " + playerAvg3years[i]);
            }
        }
        for (int i = 0; i < playerAvg3years.length; i++){
            if (!(playerList3years[i] == null || playerAvg3years[i] == 0.0)) {
                for (int j = i + 1; j < playerAvg3years.length; j++) {
                    if (!(playerList3years[j] == null || playerAvg3years[j] == 0.0)) {
                        float tmp = 0;
                        String tmp2 = "";
                        if (playerAvg3years[i] > playerAvg3years[j]) {
                            tmp = playerAvg3years[i];
                            tmp2 = playerList3years[i];
                            playerAvg3years[i] = playerAvg3years[j];
                            playerList3years[i] = playerList3years[j];
                            playerAvg3years[j] = tmp;
                            playerList3years[j] = tmp2;
                        }
                    }
                }
            }
        }
        System.out.println("----TOP 10 BATTERS 2020-2022----");
        for (int i = 0; i < 10; i++){
            System.out.println((i+1) + ": " + playerList3years[i]);
        }
    }
}
