package persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;
import model.Exercise;

// Containing the helped mehods that are used by the JSON tests
@ExcludeFromJacocoGeneratedReport
public class JsonTest {
    protected void checkExercise(String name, String muscleGroup, Exercise exercise) {
        assertEquals(name, exercise.getName());
        assertEquals(muscleGroup, exercise.getMuscleGroup());
    }
}
