import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import java.util.Scanner;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class StudentRecordStressTest {
    StudentRecordManagement management;
    Random random;

    @Before
    public void setUp() {
        management = new StudentRecordManagement();
        random = new Random();
    }

    @Test
    public void stressTest() {
        // add 10000 records
        for (int i = 1; i <= 10000; i++) {
            Record r = new Record("Student" + i, i, random.nextInt(10000));
            management.add(r);
        }

        // check if all 10000 values are correctly outputted
        for (int i = 1; i <= 10000; i++) {
            assertTrue(management.find(i));
        }

        // update 10000 records
        for (int i = 1; i <= 10000; i++) {
            String updateInput = String.format("%d\n%d\n%s\n", i + 10000, random.nextInt(10000), "UpdatedStudent" + i);
            InputStream in = new ByteArrayInputStream(updateInput.getBytes());
            Scanner scanner = new Scanner(in);
            management.update(i, scanner);
        }

        // check if all 10000 records where updated
        for (int i = 10001; i <= 20000; i++) {
            assertTrue(management.find(i));
        }


        // delete all 10000 records
        for (int i = 10001; i <= 20000; i++) {
            management.delete(i);
        }

        // check if all 10000 records were deleted
        for (int i = 10001; i <= 20000; i++) {
            assertFalse(management.find(i));
        }
    }
}


