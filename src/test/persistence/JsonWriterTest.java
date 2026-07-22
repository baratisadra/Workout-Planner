package persistence;

import java.io.FileNotFoundException;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test; 
import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

// The test for the JsonWriter
@ExcludeFromJacocoGeneratedReport
public class JsonWriterTest extends JsonTest {

    @Test 
    void testWriterInvalidFile() {
        try {
            JsonWriter writer = new JsonWriter("./data/\0illegal:file.jason");
            writer.open();
            fail("FileNotFoundExeption was expected");
        } catch (FileNotFoundException e) {
            // s
        }
    }
}
