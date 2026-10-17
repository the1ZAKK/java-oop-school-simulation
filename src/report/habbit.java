package report;

/**
 * The original habit example, including its spelling and inheritance.
 * The report's demo uses inherited name, not the separate habitName field.
 */
public class habbit extends Person {
    private String habitName;

    public String getHabitName() {
        return habitName;
    }

    public void setHabitName(String habitName) {
        this.habitName = habitName;
    }
}
