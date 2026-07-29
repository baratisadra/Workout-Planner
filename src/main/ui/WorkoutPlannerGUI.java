package ui;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;
import model.Exercise;
import model.ExerciseLibrary;
import model.PersonalExerciseList;
import persistence.JsonReader;
import persistence.JsonWriter;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

@ExcludeFromJacocoGeneratedReport
public class WorkoutPlannerGUI extends JFrame {
    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    private ExerciseLibrary exerciseLibrary;
    private PersonalExerciseList personalExerciseList;
    private static final String JSON_STORE = "./data/workout.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private JPanel mainPanel;
    private JPanel controlPanel;
    private JButton viewRecommendedButton;
    private JButton viewWorkouButton;
    private JButton addCustomExerciseButton;
    private JButton removeExerciseButton;
    private JButton saveButton;
    private JButton loadButton;
    private JPanel displayPanel;
    private DefaultListModel<String> recommendedExerciseModel;
    private JList<String> recommendedExerciseList; 
    private DefaultListModel<String> personalWorkoutModel;
    private JList<String> personalWorkoutList;

    /*
     * EFFECTS: Constructs the Workout Planner GUI.
     */
    public WorkoutPlannerGUI() {
        initialize();
        setTitle("Workout Planner");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initializeMainPanel();
        initializeControlPanel();
        initializeDisplayPanel();
        initializeRecommendedExerciseList();
        initializePersonalWorkoutList();
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
     * EFFECTS: creates the main pane that is used to hold the components
     */
    private void initializeMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        add(mainPanel);
    }

    /*
     * MODIFIES: this
     * EFFECTS: initialized the control panel with the controls
     */
    private void initializeControlPanel() {
        controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(0,1));
        viewRecommendedButton = new JButton("View Recommended Exercises");
        viewRecommendedButton.addActionListener(e -> showRecommendedExercises());
        viewWorkouButton = new JButton("View my workout");
        viewWorkouButton.addActionListener(e -> showPersonalWorkout());
        addCustomExerciseButton = new JButton("Add custom exercises");
        addCustomExerciseButton.addActionListener(e -> showAddCustomExercise());
        removeExerciseButton = new JButton("Remove exercise");
        removeExerciseButton.addActionListener(e -> removeSelectedExercise());
        saveButton = new JButton("Save my workout");
        loadButton = new JButton("Load my workout");
        controlPanel.add(loadButton);
        controlPanel.add(viewRecommendedButton);
        controlPanel.add(viewWorkouButton);
        controlPanel.add(addCustomExerciseButton);
        controlPanel.add(removeExerciseButton);
        controlPanel.add(saveButton);
        mainPanel.add(controlPanel, BorderLayout.WEST);
    }

    /*
     * MODIFIES: this
     * EFFECTS: initializes the display panel for the workouts
     */
    private void initializeDisplayPanel() {
        displayPanel = new JPanel();
        displayPanel.setLayout(new BorderLayout());
        JLabel welcomeLabel = new JLabel("Welcome to Workout Planner", JLabel.CENTER);
        displayPanel.add(welcomeLabel, BorderLayout.CENTER);
        mainPanel.add(displayPanel, BorderLayout.CENTER);
    }

    /*
     * MODIFIES: this
     * EFFECTS: initializes the list that displays the recommended exercises
     */
    private void initializeRecommendedExerciseList() {
        recommendedExerciseModel = new DefaultListModel<>();
        recommendedExerciseList = new JList<>(recommendedExerciseModel);
    }

    /*
     * MODIFIES: this
     * EFFECTS: shows the recommended exercise list in the display panel
     */
    private void showRecommendedExerciseList() {
        displayPanel.removeAll();
        JScrollPane scrollPane = new JScrollPane(recommendedExerciseList);
        displayPanel.add(scrollPane, BorderLayout.CENTER);
        displayPanel.revalidate();
        displayPanel.repaint();
    }

    /*
     * MODIFIES: this
     * EFFECTS: displays the recommended exercise list
     */
    private void showRecommendedExercises() {
        displayPanel.removeAll();
        String[] muscleGroups = {"Back", "Chest", "Shoulders", "Arms", "Legs"};
        JComboBox<String> muscleGroupSelector = new JComboBox<>(muscleGroups);
        JButton addRecommendedButton = new JButton("Add selected Exercise");
        addRecommendedButton.addActionListener(
            e -> addRecommendedExercise(muscleGroupSelector));
        muscleGroupSelector.addActionListener(e -> {
            String muscleGroup = (String) muscleGroupSelector.getSelectedItem();
            updateRecommendedExerciseList(muscleGroup);
        });
        displayPanel.add(muscleGroupSelector, BorderLayout.NORTH);
        displayPanel.add(new JScrollPane(recommendedExerciseList), BorderLayout.CENTER);
        displayPanel.add(addRecommendedButton, BorderLayout.SOUTH);
        updateRecommendedExerciseList("Back");
        displayPanel.revalidate();
        displayPanel.repaint();
    }

    /*
     * MODIFIES: this
     * EFFECTS: Updates the recommended list as user changes the muscleGroup
     */
    private void updateRecommendedExerciseList(String muscleGroup) {
        recommendedExerciseModel.clear();
        ArrayList<Exercise> exercises = 
                exerciseLibrary.getExercisesForMuscleGroup(muscleGroup);
        for (Exercise exercise : exercises) {
            recommendedExerciseModel.addElement(exercise.getName());
        }
    }

    /*
     * MODIFIES: this
     * EFFECTS: adds the selected workout hte the personal list
     */
    private void addRecommendedExercise(JComboBox<String> muscleGroupSelector) {
        int selectedIndex = recommendedExerciseList.getSelectedIndex();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Please select as exercise.");
        } else {
            String muscleGroup = (String) muscleGroupSelector.getSelectedItem();
            ArrayList<Exercise> exercises = 
                    exerciseLibrary.getExercisesForMuscleGroup(muscleGroup);
            Exercise selectedExercise = exercises.get(selectedIndex);
            personalExerciseList.addExercise(selectedExercise);
            JOptionPane.showMessageDialog(
                this, selectedExercise.getName() + " was added to your workout.");
        }
    }

    /*
     * MODIFIES: this
     * EFFECTS: initialized the list that is used to display the personal list
     */
    private void initializePersonalWorkoutList() {
        personalWorkoutModel = new DefaultListModel<>();
        personalWorkoutList = new JList<>(personalWorkoutModel);
    }

    /*
     * MODIFIES: this
     * EFFECTS: shows the exercises in the personal list
     */
    private void showPersonalWorkout() {
        personalWorkoutModel.clear();
        for (Exercise exercise : personalExerciseList.getExercises()) {
            personalWorkoutModel.addElement(
                    exercise.getName() + " - " + exercise.getMuscleGroup()
            );
        }
        displayPanel.removeAll();
        displayPanel.add(new JScrollPane(personalWorkoutList), BorderLayout.CENTER);
        displayPanel.revalidate();
        displayPanel.repaint();
    }

    /*
     * MODIFIES: this
     * EFFECTS: showing the panel for adding a custom exercise
     */
    private void showAddCustomExercise() {
        displayPanel.removeAll();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JTextField nameField = new JTextField();
        String[] muscleGroups = {"Back", "Chest", "Shoulders", "Arms", "Legs"};
        JComboBox<String> muscleGroupBox = new JComboBox<>(muscleGroups);
        JButton addButton = new JButton("Add exercise");
        addButton.addActionListener(e -> {
            Exercise exercise = new Exercise(
                nameField.getText(), (String) muscleGroupBox.getSelectedItem());
            personalExerciseList.addExercise(exercise);
            JOptionPane.showMessageDialog(this, "Exercise was added successfully.");
        });
        panel.add(new JLabel("Exercise name"));
        panel.add(nameField);
        panel.add(new JLabel("Muscle group"));
        panel.add(muscleGroupBox);
        panel.add(addButton);
        displayPanel.add(panel, BorderLayout.CENTER);
        displayPanel.revalidate();
        displayPanel.repaint();
    }

    /*
     * MODIFIES: this
     * EFFECTS: removing the selected exercise from the personal list
     */
    private void removeSelectedExercise() {
        int selectedIndex = personalWorkoutList.getSelectedIndex();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Select an exercise to remove.");
            return;
        }
        Exercise exercise = personalExerciseList.getExercises().get(selectedIndex);
        personalExerciseList.removeExercise(exercise);
        showPersonalWorkout();
        JOptionPane.showMessageDialog(this, "Exercise removed successfully.");
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
