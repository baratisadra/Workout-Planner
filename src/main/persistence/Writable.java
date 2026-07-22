package persistence;

import org.json.JSONObject;

// A random thing that could be written as JSON
public interface Writable {
    
    /*
     * EFFECTS: returns ot as an object of JSON
     */
    JSONObject toJson();
}
