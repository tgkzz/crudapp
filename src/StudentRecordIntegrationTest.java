import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class StudentRecordIntegrationTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    StudentRecordManagement management;

    @Before
    public void setUp() {
        management = new StudentRecordManagement();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testAddFindUpdateDelete() {
        Record r1 = new Record("John", 1, 123);
        management.add(r1);
        assertTrue(management.find(1));

        String updateInput = "2\n456\nJane\n";
        InputStream in = new ByteArrayInputStream(updateInput.getBytes());
        Scanner scanner = new Scanner(in);
        management.update(1, scanner);
        assertTrue(management.find(2));

        management.delete(2);
        assertFalse(management.find(2));
    }


    // again this error appeared again, I have a problem to test the output of the program, and i don't know
    // how to test it correctly(
    @Test
    public void testAddDisplay() {
        Record r1 = new Record("John", 1, 123);
        Record r2 = new Record("Jane", 2, 456);

        management.add(r1);
        management.add(r2);

        management.display();

        String expectedOutput = "Records{name=John, idNumber=1, contactNumber=123}\n"
                + "Records{name=Jane, idNumber=2, contactNumber=456}\n";

        assertEquals(expectedOutput, outContent.toString());

    }
}
