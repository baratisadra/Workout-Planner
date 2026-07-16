package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
}
