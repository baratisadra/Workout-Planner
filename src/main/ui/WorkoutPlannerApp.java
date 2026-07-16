package ui;

import java.util.Scanner;
import model.ExerciseLibrary;
import model.PersonalExerciseList;

// The Application for the Workout Planner
public class WorkoutPlannerApp {
    private ExerciseLibrary exerciseLibrary;
    private PersonalExerciseList personalExerciseList;
    private Scanner input;

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

    /*
     * MODIFIES: this
     * EFFECTS: continues processing hte user input until th user quits
     */
    private void runWorkoutPlanner() {
        //
    }

    /*
     * EFFECTS: displays the menu to users
     */
    private void displayMenu() {
        //
    }

    /*
     * MODIFIES: this
     * EFFECTS: processes the user's command
     */
    private void processCommand(String command) {
        //
    }

}
