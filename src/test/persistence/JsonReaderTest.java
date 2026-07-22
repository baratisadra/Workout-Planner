package persistence;

import static org.junit.jupiter.api.Assertions.fail;
import java.io.IOException;
import org.junit.jupiter.api.Test; 
import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;
import model.PersonalExerciseList;

@ExcludeFromJacocoGeneratedReport
public class JsonReaderTest {
    
    @Test 
    void testReaderNonExisentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");

        try {
            PersonalExerciseList personalList = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // expected
        }
    }
}
