package model;

import java.util.ArrayList;

// The user's personal list of exercises
public class PersonalExerciseList {
    private ArrayList<Exercise> exercises;

    // EFFECTS: Constructing an empty list of user's personal list of exercises
    public PersonalExerciseList(){
        exercises = new ArrayList<>();
    }

    /*
     * MODIFIES: this
     * EFFECTS: adds an exercise to the personal exercise list
     */
    public void addExercise(Exercise exercise){
        exercises.add(exercise);
    }

    /*
     * EFFECTS: returns all the exercises in the personal list
     */
    public ArrayList<Exercise> getExercises(){
        return exercises;
    }
}
