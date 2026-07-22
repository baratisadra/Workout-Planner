package model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@ExcludeFromJacocoGeneratedReport
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

    @Test
    void testGetExercisesForMuscleGroupOneMatch() {
        Exercise back = new Exercise("Lat Pulldown", "Back");
        Exercise chest = new Exercise("Bench Press", "Chest");
        testLibrary.addExercise(back);
        testLibrary.addExercise(chest);
        assertEquals(1, testLibrary.getExercisesForMuscleGroup("Back").size());
        assertEquals(back, testLibrary.getExercisesForMuscleGroup("Back").get(0));
    }

    @Test
    void testGetExercisesForMuscleGroupMultipleMatches() {
        Exercise back1 = new Exercise("Lat Pulldown", "Back");
        Exercise back2 = new Exercise("Barbell Row", "Back");
        Exercise chest = new Exercise("Bench Press", "Chest");
        testLibrary.addExercise(back1);
        testLibrary.addExercise(back2);
        testLibrary.addExercise(chest);
        assertEquals(2, testLibrary.getExercisesForMuscleGroup("Back").size());
        assertEquals(back1, testLibrary.getExercisesForMuscleGroup("Back").get(0));
        assertEquals(back2, testLibrary.getExercisesForMuscleGroup("Back").get(1));
    }

}
