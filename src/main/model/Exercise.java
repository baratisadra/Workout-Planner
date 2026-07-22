package model;

import org.json.JSONObject;
import persistence.Writable;

// Represents an exercise, its name and its target muscle group
public class Exercise implements Writable {
    private String name;
    private String muscleGroup;

    /*
     * REQUIRES: name and musclegroup are required to have non-zero lengths
     * EFFECTS: Constructs an exercise with a given name and a given musclegroup
     */
    public Exercise(String name, String muscleGroup) {
        this.name = name;
        this.muscleGroup = muscleGroup;
    }

    // EFFECTS: returns the exercises's name 
    public String getName() {
        return name;
    }

    // EFFECTS: returns the muscle group that the excercise is targeting
    public String getMuscleGroup() {
        return muscleGroup;
    }

    /*
     * EFFECTS: returns this below exercise as an object of JSON
     */
    @Override
    public JSONObject toJson() {
        return null;
    }

}
