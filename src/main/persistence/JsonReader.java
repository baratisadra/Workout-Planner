package persistence;

import java.io.IOException;

import model.Exercise;
import model.PersonalExerciseList;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.JSONArray;
import org.json.JSONObject;

// Represents areader that reads a personal exercise list from the JSON data
// That is store in a file. This code is based on the 
// JsonSerializationDemo that was provided in phase 2 instructions.
public class JsonReader {
    private String source;

    /*
     * EFFECTS: Constructs a reader that reade from the source file
     */
    public JsonReader(String source) {
        this.source = source;
    }

    /*
     * EFFECTS: Reads a personal exercise list from a file, then returns it.
     *          Throws IOException if error occurs.
     */
    public PersonalExerciseList read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parsePersonalExerciseList(jsonObject);
    }

    /*
     * EFFECTS: reads the source file as a String and returns it
     */
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(contentBuilder::append);
        }
        return contentBuilder.toString();
    }

    /*
     * EFFECTS: it parses an exercise list form JSON Object and returns it
     */
    private PersonalExerciseList parsePersonalExerciseList(JSONObject jsonObject) {
        PersonalExerciseList personalList = new PersonalExerciseList();
        addExercises(personalList, jsonObject);
        return personalList;
    }

    /*
     * MODIFIES: personal list
     * EFFECTS: parses hte exercises from JSON object and then adds them the the exrcise list
     */
    private void addExercises(PersonalExerciseList personalList, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("exercises");
        for (Object json : jsonArray) {
            JSONObject nextExercise = (JSONObject) json;
            addExercise(personalList, nextExercise);
        }
    }

    /*
     * MODIFES: personalList
     * EFFECTS: Parses a single exercise from a JSON Object, then adds it to the exrcise list
     */
    private void addExercise(PersonalExerciseList personalList, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String muscleGroup = jsonObject.getString("muscleGroup");
        Exercise exercise = new Exercise(name, muscleGroup);
        personalList.addExercise(exercise);
    }
}
