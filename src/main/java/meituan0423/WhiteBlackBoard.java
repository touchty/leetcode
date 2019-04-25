package meituan0423;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
美团1
将二维矩阵调整为两种“颜色”的新矩阵，其中奇数位与偶数位不能相同
例如，
101
010
101
或者
121
212
121
，解法如下：
分别统计奇数位和偶数位出现最多的两种颜色，尽可能的取最大的，当然要考虑奇数和偶数位置是否相同
 */
public class WhiteBlackBoard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        Map<Integer, Integer> whiteMap = new HashMap<>();
        Map<Integer, Integer> blackMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int tmp = sc.nextInt();
                if (((i + j) & 1) == 0) whiteMap.put(tmp, whiteMap.getOrDefault(tmp, 0) + 1);
                else blackMap.put(tmp, blackMap.getOrDefault(tmp, 0) + 1);
            }
        }
        int wMaxK1 = 0, wMaxK2 = 0; //白块第一大和第二大的Key
        int wMaxV1 = 0, wMaxV2 = 0; //白块第一大和第二大的Value
        for (Map.Entry<Integer, Integer> e : whiteMap.entrySet()) {
            if (e.getValue() >= wMaxV1) {
                wMaxK2 = wMaxK1;
                wMaxV2 = wMaxV1;
                wMaxK1 = e.getKey();
                wMaxV1 = e.getValue();
            } else if (e.getValue() > wMaxV2) {
                wMaxK2 = e.getKey();
                wMaxV2 = e.getValue();
            }
        }
        int bMaxK1 = 0, bMaxK2 = 0; //黑块第一大和第二大的Key
        int bMaxV1 = 0, bMaxV2 = 0; //黑块第一大和第二大的Value
        for (Map.Entry<Integer, Integer> e : blackMap.entrySet()) {
            if (e.getValue() >= bMaxV1) {
                bMaxK2 = bMaxK1;
                bMaxV2 = bMaxV1;
                bMaxK1 = e.getKey();
                bMaxV1 = e.getValue();
            } else if (e.getValue() > bMaxV2) {
                bMaxK2 = e.getKey();
                bMaxV2 = e.getValue();
            }
        }

        if (wMaxK1 != bMaxK1) {
            System.out.println(m * n - wMaxV1 - bMaxV1);
        } else {
            System.out.println(m * n - Math.max(wMaxV2 + bMaxV1, bMaxV2 + wMaxV1));
        }
    }

    static int modification(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Map<Integer, Integer> countOdd = new HashMap<>();
        Map<Integer, Integer> countEve = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                if (((i + j) & 1) == 0)
                    countEve.put(temp, countEve.getOrDefault(temp, 0) + 1);
                else
                    countOdd.put(temp, countOdd.getOrDefault(temp, 0) + 1);
            }
        }
        int MaxEveK1 = 0;
        int MaxEveV1 = 0;
        int MaxEveK2 = 0;
        int MaxEveV2 = 0;
        for (Map.Entry<Integer, Integer> e : countEve.entrySet()) {
            if (e.getValue() > MaxEveV1) {
                MaxEveV1 = e.getValue();
                MaxEveK1 = e.getKey();
            } else if (e.getValue() > MaxEveV2) {
                MaxEveV2 = e.getValue();
                MaxEveK2 = e.getKey();
            }
        }

        int MaxOddK1 = 0;
        int MaxOddV1 = 0;
        int MaxOddK2 = 0;
        int MaxOddV2 = 0;
        for (Map.Entry<Integer, Integer> e : countOdd.entrySet()) {
            if (e.getValue() > MaxOddV1) {
                MaxOddV1 = e.getValue();
                MaxOddK1 = e.getKey();
            } else if (e.getValue() > MaxOddV2) {
                MaxOddV2 = e.getValue();
                MaxOddK2 = e.getKey();
            }
        }

        if (MaxEveK1 != MaxOddK1) return (m * n - MaxEveV1 - MaxOddV1);
        else return m * n - Math.max(MaxEveV1 + MaxOddV2, MaxEveV2 + MaxOddV1);
    }

    @Test
    public void testModification() {
        int[][] matrix = {{1, 1, 1}, {1, 5, 1}, {1, 1, 1}};
        int modi = modification(matrix);
        int expected = 4;
        Assert.assertEquals(expected, modi);
    }
}
