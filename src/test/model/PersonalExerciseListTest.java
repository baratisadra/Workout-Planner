package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@ExcludeFromJacocoGeneratedReport
public class PersonalExerciseListTest {
    private PersonalExerciseList testList;
    private Exercise exercise1;
    private Exercise exercise2;

    @BeforeEach
    void runBefore(){
        testList = new PersonalExerciseList();
        exercise1 = new Exercise("Lat Pulldown", "Back");
        exercise2 = new Exercise("Shoulder Press", "Shoulders");
    }
    
    @Test
    void testConstructor(){
        assertTrue(testList.getExercises().isEmpty());
    }

    @Test
    void testAddExercise(){
        testList.addExercise(exercise1);
        assertEquals(1, testList.getExercises().size());
        assertEquals(exercise1, testList.getExercises().get(0));
    }

    @Test
    void testAddFewExercises(){
        testList.addExercise(exercise1);
        testList.addExercise(exercise2);
        assertEquals(2, testList.getExercises().size());
        assertEquals(exercise1, testList.getExercises().get(0));
        assertEquals(exercise2, testList.getExercises().get(1));
    }

    @Test
    void testRemoveExercise(){
        testList.addExercise(exercise1);
        testList.addExercise(exercise2);
        testList.removeExercise(exercise1);
        assertEquals(1, testList.getExercises().size());
        assertEquals(exercise2, testList.getExercises().get(0));


    }
}
