// CS176L-01
// Vincent Tuberion
// InputOutputFiles.java (using base provided by CS176L-01 eCampus)
// Last Modified 12/1/2022 15:53 EST

O
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
   Used to test the BlankLinesRemover class.
*/
public class InputOutputFiles {
   public static void main(String[] args) throws FileNotFoundException{
      final String OUTPUT_FILEPATH = "C:\\Users\\hiPok\\IdeaProjects\\CS176\\src\\outlines.txt";
      Scanner pathInput = new Scanner(System.in);
      String pathName = "";
      Scanner in = new Scanner(System.in); // Holding scanner (changed to scanner for the input file later)
      boolean goodInput = false; // This sentinel value will be used to indicate if the given input has been checked as valid
      while ((!goodInput) && !(pathName.equals("quit"))) { // Continue to prompt for good input until valid input is provided
         System.out.println("Please input the location of the file you would like to read: (enter 'quit' to exit)");
         pathName = pathInput.nextLine();
         if (!pathName.equals("quit")) {
            // Correct path (for my case): C:\Users\hiPok\IdeaProjects\CS176\src\lines.txt
            try { // Attempt to read a file using the user provided directory
               File inputFile = new File(pathName);
               in = new Scanner(inputFile); // If this line is valid, the user provided directory can be read
               goodInput = true; // The user provided directory is valid, we can now read the file
            } catch (FileNotFoundException e) { // If the user provided directory is invalid, output a message
               System.out.println("File directory is not valid, please try again.");
               //goodInput = false; // When the try block is tested, good input may be assigned to true in the case that the condition passes
               // This value must be overridden back to false if the try block is tested, assigns goodInput to true and then returns a FileNotFoundException
            }
         }
      }
      // If the try block passed and the catch block did not execute, goodInput is true, now we can read the file
      // This is separated from the rest of the try block, otherwise the data already present in 'outlines.txt' is cleared if an invalid file path is given
      if (goodInput) {
         // The location of the output file has been pre-specified
         PrintWriter outputFile = new PrintWriter(OUTPUT_FILEPATH);
         while (in.hasNext()) { // While the file has lines to read, read them
            String what = in.nextLine();
            outputFile.println(what);
         }
         // Close both the output file, which is only opened if a valid filepath for the input file is provided.
         outputFile.close();
         System.out.println("The file has been processed.");
      }
      // Close both the input file. (This has been separated from closing the output file, in case an invalid file location is assigned to Scanner in)
      in.close();
      System.out.println("Thanks for using the program, now exiting...");
   }
}
