package bst;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * FallingSquares Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>05/09/2018</pre>
 */
public class FallingSquaresTest {
    FallingSquares fallingSquares = new FallingSquares();

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: fallingSquares(int[][] positions)
     */
    @Test
    public void testFallingSquares() throws Exception {
        int[][] positions = {{1, 2}, {6, 1}};
        int[] result = {2, 5, 5};
        fallingSquares.fallingSquares(positions);
    }


} 
