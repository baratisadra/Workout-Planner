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
        runWorkoutPlanner();
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
        boolean keepGoing = true;
        String command;
        initialize();
        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();
            if (command.equals("5")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }
        System.out.println("Hope to see you later!!");
    }

    /*
     * EFFECTS: displays the menu to users
     */
    private void displayMenu() {
        System.out.println("Workout Planner");
        System.out.println("-----------------------");
        System.out.println("1. View recommended exercises");
        System.out.println("2. View my workout");
        System.out.println("3. Add costum exercise to my workout");
        System.out.println("4. Remove exercise from my workout");
        System.out.println("5. Quit");
    }

    /*
     * MODIFIES: this
     * EFFECTS: processes the user's command
     */
    private void processCommand(String command) {
        if (command.equals("1")) {
            viewRecommendedExercises();
        } else if (command.equals("2")) {
            System.out.println("y");
        } else if (command.equals("3")) {
            System.out.println("z");
        } else if (command.equals("4")) {
            System.out.println("a");
        } else {
            System.out.println("Try to make the right selection.");
        }
    }

    /*
     * EFFECTS: displays the recommended exercises for the chosen muscle group
     */
    private void viewRecommendedExercises() {
        //
    }
}
