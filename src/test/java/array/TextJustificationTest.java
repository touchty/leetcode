package array;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TextJustificationTest {
    private TextJustification textJustification = new TextJustification();

    @Test
    public void fullJustify() {
        String[] words = {"Science","is","what","we","understand","well","enough","to","explain",
                "to","a","computer.","Art","is","everything","else","we","do"};
        int L = 32;
        List<String> lines = textJustification.fullJustify(words, L);
        for (String line : lines)
            System.out.println(line);
    }
}