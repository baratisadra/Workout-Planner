package persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.json.JSONObject;

import model.PersonalExerciseList;

// Represents a writer whom writes an exercise list to JSON file
// The following code is enspired by the JsonSerializationDemo
// that was provided in the instruction
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    /*
     * EFFECTS: COnstructs a writer that writes to the destination file
     */
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    /*
     * MODIFIES: this
     * EFFECTS: opens the writer, throws FileNotFoundException if
     *  the destination file is not opening for writing
     */
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    /*
     * MODIFIES: this
     * EFFECTS: writes the JSON representatio of the personalList to a file
     */
    public void write(PersonalExerciseList personalList) {
        JSONObject json = personalList.toJson();
        saveToFile(json.toString(TAB));
    }

    /*
     * MODIFIES: this
     * EFFECTS: has the responsibility to close the writer
     */
    public void close() {
        writer.close();
    }

    /*
     * MODIFIES: this
     * EFFECTS: wrties the give JSON to file
     */
    private void saveToFile(String json) {
        writer.print(json);
    }
}
