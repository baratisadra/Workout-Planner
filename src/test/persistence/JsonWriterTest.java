package persistence;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test; 
import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;
import model.Exercise;
import model.PersonalExerciseList;

// The test for the JsonWriter
@ExcludeFromJacocoGeneratedReport
public class JsonWriterTest extends JsonTest {

    @Test 
    void testWriterInvalidFile() {
        try {
            JsonWriter writer = new JsonWriter("./data/\0illegal:file.json");
            writer.open();
            fail("FileNotFoundExeption was expected");
        } catch (FileNotFoundException e) {
            // expected
        }
    }

    @Test
    void testWriterEmptyPersonalExerciseList() {
        try {
            PersonalExerciseList personalList = new PersonalExerciseList();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyPersonalExerciseList.json");
            writer.open();
            writer.write(personalList);
            writer.close();
            JsonReader reader = new JsonReader("./data/testWriterEmptyPersonalExerciseList.json");
            personalList = reader.read();
            assertEquals(0, personalList.getExercises().size());
        } catch (IOException e) {
            fail("Exeption should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralPersonalExerciseList(){
        try {
            PersonalExerciseList personalList = new PersonalExerciseList();
            personalList.addExercise(new Exercise("Bench Press", "Chest"));
            personalList.addExercise(new Exercise("Lat Pulldown", "Back"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralPersonalExerciseList.json");
            writer.open();
            writer.write(personalList);
            writer.close();
            JsonReader reader = new JsonReader("./data/testWriterGeneralPersonalExerciseList.json");
            personalList = reader.read();
            assertEquals(2, personalList.getExercises().size());
            checkExercise("Bench Press", "Chest", personalList.getExercises().get(0));
            checkExercise("Lat Pulldown", "Back", personalList.getExercises().get(1));
        } catch (IOException e) {
            fail("Exception shoul not have been thrown");
        }
    }
}
