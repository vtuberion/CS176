// CS176L-01
// Vincent Tuberion
// HelloJava.java
// Last Modified 9/12/2022 15:11 EST

public class HelloJava {
    public static void main(String[] args) {
        System.out.println("Testing Program, hello again Java World!");
        String Name = "Vincent";
        if (Name.equals("Vincent")) {
            String output = "This program works, welcome back to Java ";
            System.out.println(output + Name + "!");
        } else {
            System.out.println("Somehow Name got changed and I am not sure why nor how, you mind setting it back?");
        }
    }
}
