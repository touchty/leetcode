package string;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 187. Repeated DNA Sequences
 * Medium
 * <p>
 * 357
 * <p>
 * 142
 * <p>
 * Favorite
 * <p>
 * Share
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * <p>
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * <p>
 * Example:
 * <p>
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * <p>
 * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 */
public class RepeatedDNASequences {
    public static List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i + 9 < s.length(); i++) {
            String str = s.substring(i, i + 10);
            if (!seen.add(str)) {
                set.add(str);
            }
        }
        return new ArrayList(set);
    }

    public static void main(String[] args) {
        String dna = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> res = RepeatedDNASequences.findRepeatedDnaSequences(dna);
        for (String str : res) {
            System.out.println(str);
        }
        String[] expected = {"AAAAACCCCC", "CCCCCAAAAA"};
        String[] real = new String[res.size()];
        res.toArray(real);
        Assert.assertArrayEquals(real, expected);
    }
}
