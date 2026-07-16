package model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExerciseLibraryTest {
    private ExerciseLibrary testLibrary;

    @BeforeEach
    void runBefore(){
        testLibrary = new ExerciseLibrary();
    }
    
    @Test
    void testConstructor(){
        assertTrue(testLibrary.getExercises().isEmpty());
    }

    @Test
    void testAddExercise() {
        Exercise exercise = new Exercise("Lat Pulldown", "Back");
        testLibrary.addExercise(exercise);
        assertEquals(1, testLibrary.getExercises().size());
        assertEquals(exercise, testLibrary.getExercises().get(0));
    }
}
