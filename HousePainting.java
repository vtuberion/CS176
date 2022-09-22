// CS176L-01
// Vincent Tuberion
// HousePainting.java
// Last Modified 9/19/2022 14:50 EST

// Utilize Java scanner to accept input
import java.util.Scanner;
public class HousePainting {
    // Considering the reuse of code, a method should be created to handle input
        // The input method should take a string output to tell the user what is being expected
        // The input method would return the input to a variable, said variable will call the method upon creation

    public static double takeInput(Scanner javaScanner, String inputMessage, String expectedType){
        double output = 0.0;

        System.out.println(inputMessage);
        // Optional error handling can be done here
        if (expectedType.equals("double")) {
            double doubleInput = javaScanner.nextDouble();
            output = doubleInput;
        } else if (expectedType.equals("int")) {
            int integerInput = javaScanner.nextInt();
            double convertedInput = integerInput;
            output = convertedInput;
        }
        return output;
    }

    public static void main(String[] args) {

        // Get all inputs from the user needed for computation (preferably using aforementioned input method)
        Scanner jScanner = new Scanner(System.in);
        double cost = takeInput(jScanner, "Please enter the cost per square foot: ", "double");
        double houseLength = takeInput(jScanner,"Please enter the length of the house: ", "double");
        double houseWidth = takeInput(jScanner,"Please enter the width of the house: ", "double");
        double houseHeight = takeInput(jScanner,"Please enter the height of the house: ", "double");
        double numberOfWindows = takeInput(jScanner,"Please enter the number of windows: ", "int");
        double windowLength = takeInput(jScanner,"Please enter the length of a window: ", "double");
        double windowWidth = takeInput(jScanner,"Please enter the the width of a window: ", "double");
        double numberOfDoors = takeInput(jScanner,"Please enter the number of doors: ", "int");
        double doorLength = takeInput(jScanner,"Please enter the length of a door: ", "double");
        double doorWidth = takeInput(jScanner,"Please enter the the width of a door: ", "double");
        jScanner.close();
        // Do calculations
            // Create variables for calculation processing as needed
            // Calculate the total surface area of the walls
            // Calculate the amount of surface area to remove from the initial calculation
            // Subtract non-wall surface area (i.e. doors and windows)
        double peakSide = houseLength*houseWidth + (houseLength * (houseHeight - houseWidth)) / 2;
        double normalSide = houseLength * houseWidth;
        double totalWallSpace = (2 * peakSide) + (2 * normalSide);
        double totalWindowSpace = numberOfWindows * (windowLength * windowWidth);
        double totalDoorSpace = numberOfDoors * (doorLength * doorWidth);
        double totalPaintableArea = totalWallSpace - totalWindowSpace - totalDoorSpace;
        double totalCost = totalPaintableArea * cost;

        // Output results to the user
        //Your total paintable surface area is 2684 square feet.
        //Your estimate is 13420 dollars.
        System.out.println("Your total paintable surface area is " + String.format("%,.2f", totalPaintableArea) + " square feet.");
        System.out.println("Your estimate is $" + String.format("%,.2f", totalCost) + " dollars.");
    }
}
