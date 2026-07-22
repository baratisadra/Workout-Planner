package model;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

// The user's personal list of exercises
public class PersonalExerciseList implements Writable {
    private ArrayList<Exercise> exercises;

    // EFFECTS: Constructing an empty list of user's personal list of exercises
    public PersonalExerciseList() {
        exercises = new ArrayList<>();
    }

    /*
     * MODIFIES: this
     * EFFECTS: adds an exercise to the personal exercise list
     */
    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }

    /*
     * EFFECTS: returns all the exercises in the personal list
     */
    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    /*
     * MODIFIES: this
     * EFFECTS: removing the exercise from the personal exercise list
     */
    public void removeExercise(Exercise exercise) {
        exercises.remove(exercise);
    }

    /*
     * EFFECTS: returns this below personal exercise list as an object of JSON
     */
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("exercises", exercisesToJson());
        return json;
    }

    /*
     * EFFECTS: Returns the exercises in this personal exercises list as ar array of JSON
     */
    private JSONArray exercisesToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Exercise exercise : exercises) {
            jsonArray.put(exercise.toJson());
        }
        return jsonArray;
    }
}
