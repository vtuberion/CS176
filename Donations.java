// CS176L-01
// Vincent Tuberion
// Donations.java
// Last Modified 10/20/2022 22:17 EST

public class Donations {
    // numIndividual –The number of individual donations
    int numIndividual;
    // amtIndividual – The total of all individual donations
    double amtIndividual;
    // numBusiness –The number of business donations
    int numBusiness;
    // amtBusiness – The total of all business donations
    double amtBusiness;
    // numOther –The number of other donations
    int numOther;
    // amtOther – The total of all other donations
    double amtOther;

    // Constructor Method
    public Donations(){
        // Nothing is really needed here, all number variables will be assigned to their default value 0
    }
    // Donations class will have 2 methods: .processDonation and .getStatistics
    // .processDonation( String cat, double donation) – increment/decrement the num and amt information for the
    // category and print a message: cat  “ donation amount: “ donation
    public void processDonation(String inputText){
        if (inputText.length() > 5) { // Trying to prevent blank lines that might be in the middle of the file somehow
            if (inputText.startsWith("<individual donation>")) {
                // category = individual
                // Remove formatting text to isolate number string, then convert to usable data as a double
                double donationAmount = Double.parseDouble(inputText.replaceAll("[^0-9,^-]",""));
                this.amtIndividual += donationAmount;
                if (donationAmount > 0) { // Project Requirement: Subtract 1 from donation number if negative amount
                    this.numIndividual++;
                } else {
                    this.numIndividual--;
                }
                System.out.println("Number of Individual Donations: " + numIndividual + " Amount: " + amtIndividual);
            } else if (inputText.startsWith("<business donation>")) {
                // category = business
                // Remove formatting text to isolate number string, then convert to usable data as a double
                double donationAmount = Double.parseDouble(inputText.replaceAll("[^0-9,^-]",""));
                this.amtBusiness += donationAmount;
                if (donationAmount > 0) { // Project Requirement: Subtract 1 from donation number if negative amount
                    this.numBusiness++;
                } else {
                    this.numBusiness--;
                }
                System.out.println("Number of Business Donations: " + numBusiness + " Amount: " + amtBusiness);
            } else if (inputText.startsWith("<other donation>")){
                // category = other
                // Remove formatting text to isolate number string, then convert to usable data as a double
                double donationAmount = Double.parseDouble(inputText.replaceAll("[^0-9,^-]",""));
                this.amtOther += donationAmount;
                if (donationAmount > 0) { // Project Requirement: Subtract 1 from donation number if negative amount
                    this.numOther++;
                } else {
                    this.numOther--;
                }
                System.out.println("Number of Other Donations: " + numOther + " Amount: " + amtOther);
            }
        }
    }
    // .getStatistics( ) – Will print the following:
    //		“Number of donations for: “ cat
    //		“Total donations for “ cat “: “ amt
    public void getStatistics(){
        // Using output specified at the bottom of the requirements outline:
        /*Individual: #:7 $1810.0
        Business: #:5 $2560.0
        Other: #:10 $1200.0*/
        System.out.println("Individual: #:" + this.numIndividual + " $" + String.format("%,.2f", amtIndividual));
        System.out.println("Business: #:" + this.numBusiness + " $" + String.format("%,.2f", amtBusiness));
        System.out.println("Other: #:" + this.numOther + " $" + String.format("%,.2f", amtOther));

    }
}
