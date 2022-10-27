// CS176L-01
// Vincent Tuberion
// ArrayAssignment1.java
// Last Modified 10/27/2022 13:22 EST

public class ArrayAssignment1 {
    public static void main(String[] args) {
        double values[] = {25.3, 100, -10, -1.5, 13, 98.6, 17, 123.145, 125.6, 123.146};
        StringBuilder output = new StringBuilder();
        double highestValue = 0;
        int negativeCount = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > highestValue) {
                highestValue = values[i];
            }
            if (values[i] < 0) {
                negativeCount++;
            }
            output.append(values[i] + " ");
        }
        System.out.println(output);
        System.out.println("The largest element in the array is: " + highestValue);
        System.out.println("There are " + negativeCount + " negative numbers in the array");
    }


}
