package model;

import java.util.ArrayList;

// Library of the recommended exercises
public class ExerciseLibrary {
    private ArrayList<Exercise> exercises;

    /*
     * EFFECTS: Constructs an empty library
     */
    public ExerciseLibrary()  {
        exercises = new ArrayList<>();
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    /*
     * MODIFIES: tihs
     * EFFECTS: adding the exercise to the exercise library
     */
    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }

    /*
     * EFFECTS: Returns the exercises in the chosen musclegruop category
     */
    public ArrayList<Exercise> getExercisesForMuscleGroup(String musclegroup) {
        ArrayList<Exercise> matchingExercises = new ArrayList<>();
        for (Exercise exercise : exercises) {
            if (exercise.getMuscleGroup().equals(musclegroup)) {
                matchingExercises.add(exercise);
            }
        }

        return matchingExercises;
    }
}
