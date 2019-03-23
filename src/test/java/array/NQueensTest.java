package array;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class NQueensTest {
    NQueens nQueens = new NQueens();

    @Test
    public void solveNQueens() {
        int n = 10;
        List<List<String>> res = nQueens.solveNQueens(n);
        for (List<String> str : res) {
            System.out.println(str);
        }
    }
}