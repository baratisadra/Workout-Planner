package persistence;

import java.io.IOException;

import model.PersonalExerciseList;

// Represents areader that reads a personal exercise list from the JSON data
// That is store in a file. This code is based on the 
// JsonSerializationDemo that was provided in phase 2 instructions.
public class JsonReader {
    private String source;

    /*
     * EFFECTS: 
     */
    public JsonReader(String source) {
        this.source = source;
    }

    /*
     * EFFECTS: Reads a personal exercise list from a file, then returns it.
     *          Throws IOException if error occurs.
     */
    public PersonalExerciseList read() throws IOException {
        return null;
    }
}
