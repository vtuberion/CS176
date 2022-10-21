// CS176L-01
// Vincent Tuberion
// DonationsTester.java
// Last Modified 10/20/2022 22:21 EST

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DonationsTester {
    public static void main(String[] args) {
        // Create scanner for input
        Scanner userInput = new Scanner(System.in);
        System.out.println("Would you like to process donations now? (enter 'Yes' to continue):");
        // Assign user text input to a value
        String userInputFeed = userInput.nextLine();
        // Compare the input with expected input (I added length for a bit of error handling)
        if (userInputFeed.equals("Yes") && userInputFeed.length() < 4) {
            // The user wants to read the file: begin data processing
            try {
                // Identify file to read
                File inputFile = new File("src/Donations.txt"); // My file is in the same level as this class
                // Create a scanner to read the file
                Scanner fileScanner = new Scanner(inputFile);
                // Create Donations object to use the methods in the Donations class
                Donations giveToMe = new Donations();
                // A loop sentinel to match the EOF sentinel, no time for any misplaced extra lines to be processed for no reason
                boolean sentinelReached = false;
                // While the file has lines to read and the EOF sentinel has not been reached: read the lines
                while (fileScanner.hasNextLine() && !sentinelReached) {
                    String text = fileScanner.nextLine();
                    // System.out.println(text); // debugging
                    if (text.startsWith("<EOF>")){
                        // STOP PROCESSING LOOP (dead stops file read: prevents additional blank lines from being read)
                        sentinelReached = true;
                    } else {
                        // Not an end of file sentinel, try to process the line as donation input
                        giveToMe.processDonation(text);
                    }
                }
                // Don't leave open files, close the file
                fileScanner.close();
                // Output result of file read from Donation class getStatistics method
                giveToMe.getStatistics();
            } catch (FileNotFoundException e) { // somehow it could not find the file
                System.out.println("File experienced an error.");
                e.printStackTrace();
            }
        } else { // User input was not "Yes" so the program ended
            System.out.println("Ending now without processing donations");

        }
    }
}
