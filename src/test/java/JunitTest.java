import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jiashubing
 * @since 2017/11/2
 */
public class JunitTest {

    private static int num;

    @Before
    public void setNum() {
        num = 1;
    }

    @Test
    public void test1() {
        System.out.println("Hello Junit");
        assertEquals(1, num);
    }
}