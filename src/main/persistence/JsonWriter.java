package persistence;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

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
        //s
    }
}
