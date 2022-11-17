package Interface;

public class Quiz implements Measurable {
    private String name;
    private int score;

    /**
     Construct a Quiz with a score value.
     @param score quiz score
     */
    public Quiz(String name, int score) {
        this.name = name;
        setScore(score);
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        if (score < 0) {
            score = 0;
        } else if (score > 100) {
            score = 100;
        }
        this.score = score;
    }

    /**
     Measurable interface method to retrieve measure.
     @return the measured area
     */
    public double getMeasure()
    {
        return score;
    }
}
