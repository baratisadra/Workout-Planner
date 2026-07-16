package model;

// Represents an exercise, its name and its target muscle group
public class Exercise {
    private String name;
    private String muscleGroup;

    /*
     * REQUIERS: name and musclegroup are requierd to have non-zero lengths
     * EFFECTS: Constructs an exercise with a given name and a given musclegroup
     */
    public Exercise(String name, String muscleGroup){
        this.name = name;
        this.muscleGroup = muscleGroup;
    }

    // EFFECTS: returns the execises's name 
    public String getName(){
        return name;
    }

    // EFFECTS: returns the musclegroup that the excercise is targeting
    public String getMuscleGroup(){
        return muscleGroup;
    }

}
