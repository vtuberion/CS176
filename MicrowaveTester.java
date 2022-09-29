// CS176L-01
// Vincent Tuberion
// MicrowaveTester.java
// Last Modified 9/29/2022 15:25 EST

public class MicrowaveTester {
    public static void main(String[] args) {
        // This is a test method for the Microwave class and its functionality.
        // Step 1: Create a microwave object
        Microwave mv1 = new Microwave();
        // Step 2: Test all of the features
        System.out.println(mv1.time());
        System.out.println(mv1.time());
        System.out.println(mv1.power());
        System.out.println(mv1.start());
        System.out.println(mv1.reset());
    }
}
