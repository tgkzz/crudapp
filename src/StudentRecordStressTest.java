public class StudentRecordStressTest {
    // In the result of the test, it should give no panic, and complete as fast as possible
    public static void main(String[] args) {
        StudentRecordManagement stress = new StudentRecordManagement();

        Record record = new Record();

        // test for high volume of records
        for (int i = 1; i < 10000; i++) {
            // add data into the linked list
            record = new Record("test-name", i, i);
            stress.add(record);
        }

        // test for display a big range of elements
        stress.display();

        // test for updating all elements of elements into 1 name
        for (int i = 1; i < 10000; i++) {
            if(stress.find(i)) {
                Record rec = stress.findRecord(i);
                rec.setIdNumber(i++);
                rec.setContactNumber(i++);
                rec.setName("test-name-for-crud");
            }
        }
        stress.display();

        // test for deleting all record
        for (int i = 1; i < 10000; i++){
            stress.delete(i);
        }
        stress.display();

    }
}
