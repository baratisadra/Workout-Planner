package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.json.JSONArray;
import org.json.JSONObject;


@ExcludeFromJacocoGeneratedReport
public class PersonalExerciseListTest {
    private PersonalExerciseList testList;
    private Exercise exercise1;
    private Exercise exercise2;

    @BeforeEach
    void runBefore() {
        testList = new PersonalExerciseList();
        exercise1 = new Exercise("Lat Pulldown", "Back");
        exercise2 = new Exercise("Shoulder Press", "Shoulders");
    }
    
    @Test
    void testConstructor() {
        assertTrue(testList.getExercises().isEmpty());
    }

    @Test
    void testAddExercise() {
        testList.addExercise(exercise1);
        assertEquals(1, testList.getExercises().size());
        assertEquals(exercise1, testList.getExercises().get(0));
    }

    @Test
    void testAddFewExercises() {
        testList.addExercise(exercise1);
        testList.addExercise(exercise2);
        assertEquals(2, testList.getExercises().size());
        assertEquals(exercise1, testList.getExercises().get(0));
        assertEquals(exercise2, testList.getExercises().get(1));
    }

    @Test
    void testRemoveExercise() {
        testList.addExercise(exercise1);
        testList.addExercise(exercise2);
        testList.removeExercise(exercise1);
        assertEquals(1, testList.getExercises().size());
        assertEquals(exercise2, testList.getExercises().get(0));


    }

    @Test 
    void testToJson() {
        testList.addExercise(exercise1);
        testList.addExercise(exercise2);
        JSONObject json = testList.toJson();
        JSONArray exercises = json.getJSONArray("exercises");
        assertEquals(2, exercises.length());
        assertEquals("Lat Pulldown", exercises.getJSONObject(0).getString("name"));
        assertEquals("Back", exercises.getJSONObject(0).getString("muscleGroup"));
        assertEquals("Shoulder Press", exercises.getJSONObject(1).getString("name"));
        assertEquals("Shoulders", exercises.getJSONObject(1).getString("muscleGroup"));
    }
}
