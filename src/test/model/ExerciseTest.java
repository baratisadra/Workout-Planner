package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.json.JSONObject;

@ExcludeFromJacocoGeneratedReport
public class ExerciseTest {
    private Exercise testExercise;

    @BeforeEach
    void runBefore() {
        testExercise = new Exercise("Lat Pulldown", "Back");
    }

    @Test
    void testConstructor() {
        assertEquals("Lat Pulldown", testExercise.getName());
        assertEquals("Back", testExercise.getMuscleGroup());
    }

    @Test 
    void testToJson() {
        JSONObject json = testExercise.toJson();
        assertEquals("Lat Pulldown", json.getString("name"));
        assertEquals("Back", json.getString("muscleGroup"));

    }
}