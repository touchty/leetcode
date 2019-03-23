package dp;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthofPairChain {
    public int findLongestChain(int[][] pairs) {
        QuickSort(pairs, 0, pairs.length - 1);
        int count = 1;
        int flag = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > flag) {
                count++;
                flag = pairs[i][1];
            }
        }
        return count;
    }

    private static void QuickSort(int[][] array, int start, int end) {
        if (start < end) {
            int key = array[start][1];
            int key0 = array[start][0];//初始化保存基元
            int i = start, j;//初始化i,j
            for (j = start + 1; j <= end; j++) {
                if (array[j][1] < key)//如果此处元素小于基元，则把此元素和i+1处元素交换，并将i加1，如大于或等于基元则继续循环
                {
                    int temp = array[j][1];
                    int temp0 = array[j][0];
                    array[j][1] = array[i + 1][1];
                    array[j][0] = array[i + 1][0];
                    array[i + 1][1] = temp;
                    array[i + 1][0] = temp0;
                    i++;
                }

            }
            array[start][1] = array[i][1];
            array[start][0] = array[i][0];//交换i处元素和基元
            array[i][1] = key;
            array[i][0] = key0;
            QuickSort(array, start, i - 1);//递归调用
            QuickSort(array, i + 1, end);

        }

    }

    class Solution {
        public int findLongestChain(int[][] pairs) {
            Arrays.sort(pairs, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return a[1] - b[1];
                }
            });
            int res = 0;
            for (int i = 0, n = pairs.length; i < n; i++, res++) {
                int prev = pairs[i][1];
                for (; i + 1 < n && pairs[i + 1][0] <= prev; i++) {
                }
            }
            return res;
        }

        public int findLongestChainRewrite(int[][] pairs) {
            // We can make sure pair with min pair[1] is in the first place of
            // the longest chain
            Arrays.sort(pairs, (a, b) -> (a[1] - b[1]));

            int res = 0;
            for (int i = 0; i < pairs.length; i++, res++) {
                int prev = pairs[i][1];
                for (; i + 1 < pairs.length && pairs[i + 1][0] <= prev; i++) {
                }
            }
            return res;
        }

        public int findLongestChainRewrite1(int[][] pairs) {
            // bad idea to sort pairs according to pair[0]
            //cause we cannot assure min is in the longest chain,.
            //but we can make sure pair with min pair[1] is in the first place of
            // the longest chain
            Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));

            int res = 0;
            for (int i = 0; i < pairs.length; i++, res++) {
                int prev = pairs[i][1];
                for (; i + 1 < pairs.length && pairs[i + 1][0] <= prev; i++) {
                }
            }
            return res;
        }
    }
}


