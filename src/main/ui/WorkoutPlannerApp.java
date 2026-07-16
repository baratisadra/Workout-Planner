package ui;

import java.util.Scanner;
import model.ExerciseLibrary;
import model.PersonalExerciseList;
import java.util.ArrayList;
import model.Exercise;
import model.Exercise;

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

        exerciseLibrary.addExercise(new Exercise("Lat Pulldown", "Back"));
        exerciseLibrary.addExercise(new Exercise("Barbell row", "Back"));
        exerciseLibrary.addExercise(new Exercise("T-Row", "Back"));
        exerciseLibrary.addExercise(new Exercise("Pullover", "Back"));

        exerciseLibrary.addExercise(new Exercise("Bench Press", "Chest"));
        exerciseLibrary.addExercise(new Exercise("Incline press", "Chest"));
        exerciseLibrary.addExercise(new Exercise("Decline Press", "Chest"));
        exerciseLibrary.addExercise(new Exercise("Fly", "Chest"));
        
        exerciseLibrary.addExercise(new Exercise("Shoulder Press", "Shoulders"));
        exerciseLibrary.addExercise(new Exercise("Lateral Raise", "Shoulders"));
        exerciseLibrary.addExercise(new Exercise("Reverse Raise", "Shoulders"));
        exerciseLibrary.addExercise(new Exercise("Front Raise", "Shoulders"));

        exerciseLibrary.addExercise(new Exercise("Bicep Curl", "Arms"));
        exerciseLibrary.addExercise(new Exercise("Tricep Extention", "Arms"));
        exerciseLibrary.addExercise(new Exercise("OverHead Extention", "Arms"));
        exerciseLibrary.addExercise(new Exercise("Incline Curl", "Arms"));

        exerciseLibrary.addExercise(new Exercise("Squat", "Legs"));
        exerciseLibrary.addExercise(new Exercise("Leg Press", "Legs"));
        exerciseLibrary.addExercise(new Exercise("Leg Extention", "Legs"));
        exerciseLibrary.addExercise(new Exercise("Leg Curl", "Legs"));

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
        System.out.println("");
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
        System.out.println("Choose a muscle group:");
        System.out.println("1. Back");
        System.out.println("2. Chest");
        System.out.println("3. Shoulders");
        System.out.println("4. Arms");
        System.out.println("5. Legs");
        String choice = input.next();
        if (choice.equals("1")) {
            displayExercisesForMuscleGroup("Back");
        } else if (choice.equals("2")) {
            displayExercisesForMuscleGroup("Chest");
        } else if (choice.equals("3")) {
            displayExercisesForMuscleGroup("Shoulders");
        } else if (choice.equals("4")) {
            displayExercisesForMuscleGroup("Arms");
        } else if (choice.equals("5")) {
            displayExercisesForMuscleGroup("Legs");
        } else {
            System.out.println("Try to make the right selection.");
        }
        
    }

    /*
     * EFFECTS: displays all recommended exercises for the given muscle group 
     */
    private void displayExercisesForMuscleGroup(String muscleGroup) {
        ArrayList<Exercise> matchingExercises = 
                exerciseLibrary.getExercisesForMuscleGroup(muscleGroup);

        if (matchingExercises.isEmpty()) {
            System.out.println("No recommended exercises were found.");
        } else {
            System.out.println("Recommended exercises:");
            for (int i=0; i < matchingExercises.size(); i++) {
                Exercise exercise = matchingExercises.get(i);
                System.out.println((i + 1) + ". " + exercise.getName());
            }

        }
    }
}
