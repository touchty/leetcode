package string;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class InterleavingStringTest {
    InterleavingString interleavingString = new InterleavingString();

    @Test
    public void isInterleave() {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String[] s3 = new String[2];

        s3[0] = "aadbbcbcac"; // true
        s3[1] = "aadbbcbcs"; // false

        boolean[] res = new boolean[2];
        boolean[] expected = new boolean[]{true, false};

        res[0] = interleavingString.isInterleave(s1, s2, s3[0]);
        res[1] = interleavingString.isInterleave(s1, s2, s3[1]);
        Assert.assertArrayEquals(res, expected);
    }
}