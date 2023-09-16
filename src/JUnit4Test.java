import org.junit.Assert;
import org.junit.Test;

public class JUnit4Test {
    @Test
    public void Test() {

        String str1 = "Happy";
        String str2 = new String("Happy");
        Assert.assertEquals("String1 and String 2 are equal",str1, str2);

    }
}
