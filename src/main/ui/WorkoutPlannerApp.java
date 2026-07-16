package ui;

import java.util.Scanner;
import model.ExerciseLibrary;
import model.PersonalExerciseList;

// The Application for the Workout Planner
public class WorkoutPlannerApp {
    private ExerciseLibrary exerciseLibrary;
    private PersonalExerciseList personalExerciseList;
    Private Scanner input;

    /*
     * EFFECTS: runs the application
     */
    public WorkoutPlannerApp() {
        //
    }

    /*
     * MODIFIES: this
     * EFFECTS: initializes the scanner,
     *                      the personal exercise list
     *                      and the exercise library
     */
    private void initialize() {
        exerciseLibrary = new ExerciseLibrary();
        personalExerciseList = new PersonalExerciseList();
        input = new Scanner(System.in);
    }
}
