package unit.com.interview.code;

import static org.junit.Assert.assertTrue;

import com.interview.code.ForBuildTest;
import org.junit.Test;

public class TestForBuildTest {

    @Test
    public void test(){
        int i = ForBuildTest.testR();
        assertTrue(i==1);

    }

}
