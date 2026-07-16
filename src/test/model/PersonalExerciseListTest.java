package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
