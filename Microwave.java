// CS176L-01
// Vincent Tuberion
// Microwave.java
// Last Modified 9/29/2022 15:25 EST

public class Microwave {
    // fields
    private int time = 0;
    private int powerLevel = 1;

    // constructors
    public Microwave(){}

    public Microwave(int t, int l){
        time = t;
        powerLevel = l;
    }

    // methods
    public int getTime() {
        return time;
    }
    public void setTime(int t) {
        time = t;
    }

    public int getPowerLevel(){
        return powerLevel;
    }
    public void setPowerLevel(int l) {
        if (l > 2) {
            l = 1;
        }
        powerLevel = l;

    }

    public String time(){
        time = time + 30;
        return "Time Button was pressed. Time is " + getTime() + " seconds";
    }

    public String power(){
        setPowerLevel(getPowerLevel() + 1);
        return "Power Button was pressed. Power level is " + getPowerLevel();
    }

    public String reset(){
        setTime(0);
        setPowerLevel(1);
        return "Reset Button was pressed. Power level is " + getPowerLevel() + ". Time is " + getTime() + " seconds.";
    }

    public String start(){
        return "Cooking for " + getTime() + " seconds at level " + getPowerLevel() + ".";
    }

    @Override
    public String toString(){
        return "Current Time Setting: " + getTime() + ", Current Power Setting: " + getPowerLevel();
    }
}