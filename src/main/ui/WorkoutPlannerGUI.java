package ui;

import javax.swing.JFrame;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;
import model.Exercise;
import model.ExerciseLibrary;
import model.PersonalExerciseList;
import persistence.JsonReader;
import persistence.JsonWriter;

@ExcludeFromJacocoGeneratedReport
public class WorkoutPlannerGUI extends JFrame {
    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    private ExerciseLibrary exerciseLibrary;
    private PersonalExerciseList personalExerciseList;
    private static final String JSON_STORE = "./data/workout.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    /*
     * EFFECTS: Constructs the Workout Planner GUI.
     */
    public WorkoutPlannerGUI() {
        initialize();
        setTitle("Workout Planner");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /*
     * MODIFIES: this
     * EFFECTS: initializes the exercise library,personal exercise list,
     *          both JSON reader and JSON writer, as well as adding the recommended
     *          exercises to the exercise library
     */
    public void initialize() {
        exerciseLibrary = new ExerciseLibrary();
        personalExerciseList = new PersonalExerciseList();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        addBackExercises();
        addChestExercises();
        addShoulderExercises();
        addArmExercises();
        addLegExercises();
    }

    /*
     * MODIFES: this
     * EFFECTS: adds the recommended back exercises to the exercise library
     */
    private void addBackExercises() {
        exerciseLibrary.addExercise(new Exercise("Lat Pulldown", "Back"));
        exerciseLibrary.addExercise(new Exercise("Barbell row", "Back"));
        exerciseLibrary.addExercise(new Exercise("T-Row", "Back"));
        exerciseLibrary.addExercise(new Exercise("Pullover", "Back"));
    }

    /*
     * MODIFES: this
     * EFFECTS: adds the recommended chest exercises to the exercise library
     */
    private void addChestExercises() {
        exerciseLibrary.addExercise(new Exercise("Bench Press", "Chest"));
        exerciseLibrary.addExercise(new Exercise("Incline press", "Chest"));
        exerciseLibrary.addExercise(new Exercise("Decline Press", "Chest"));
        exerciseLibrary.addExercise(new Exercise("Fly", "Chest"));
    }

    /*
     * MODIFES: this
     * EFFECTS: adds the recommended sohulder exercises to the exercise library
     */
    private void addShoulderExercises() {
        exerciseLibrary.addExercise(new Exercise("Shoulder Press", "Shoulders"));
        exerciseLibrary.addExercise(new Exercise("Lateral Raise", "Shoulders"));
        exerciseLibrary.addExercise(new Exercise("Reverse Raise", "Shoulders"));
        exerciseLibrary.addExercise(new Exercise("Front Raise", "Shoulders"));
    }

    /*
     * MODIFES: this
     * EFFECTS: adds the recommended arm exercises to the exercise library
     */
    private void addArmExercises() {
        exerciseLibrary.addExercise(new Exercise("Bicep Curl", "Arms"));
        exerciseLibrary.addExercise(new Exercise("Tricep Extention", "Arms"));
        exerciseLibrary.addExercise(new Exercise("OverHead Extention", "Arms"));
        exerciseLibrary.addExercise(new Exercise("Incline Curl", "Arms"));
    }

    /*
     * MODIFES: this
     * EFFECTS: adds the recommended leg exercises to the exercise library
     */
    private void addLegExercises() {
        exerciseLibrary.addExercise(new Exercise("Squat", "Legs"));
        exerciseLibrary.addExercise(new Exercise("Leg Press", "Legs"));
        exerciseLibrary.addExercise(new Exercise("Leg Extention", "Legs"));
        exerciseLibrary.addExercise(new Exercise("Leg Curl", "Legs"));
    }
}
