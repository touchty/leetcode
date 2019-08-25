package ZJTD;

import java.util.Scanner;

public class Main1 {
    static int component(int[][] nums, int n) {
        int components = 0;
        boolean[] v = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!v[i]) {
                components++;
                dfs(nums, v, i);
            }
        }

        return components;
    }

    /*static void dfs(int[][] nums, boolean[][] v, int i, int j) {
        if (i < 0 || i >= nums.length || j < 0 || j >= nums[0].length || v[i][j])
            return;
        v[i][j] = true;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k][j] >= 3)
                dfs(nums, v, k, j);
            else
                v[k][j] = true;
        }

        for (int k = 0; k < nums[0].length; k++) {
            if (nums[i][k] >= 3)
                dfs(nums, v, i, k);
            else
                v[i][k] = true;
        }
    }*/

    /*static void dfs(int[][] nums, boolean[][] v, int i, int j) {
        if (i < 0 || i >= nums.length || j < 0 || j >= nums[0].length || v[i][j])
            return;
        v[i][j] = true;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k][j] >= 3)
                dfs(nums, v, k, j);
        }

        for (int k = 0; k < nums[0].length; k++) {
            if (nums[i][k] >= 3)
                dfs(nums, v, i, k);
        }
    }*/
    static void dfs(int[][] nums, boolean[] v, int i) {
        if (i < 0 || i >= nums.length || v[i])
            return;
        v[i] = true;
        for (int k = 0; k < nums.length; k++) {
            if (!v[k] && nums[i][k] >= 3)
                dfs(nums, v, k);
        }

        for (int k = 0; k < nums.length; k++) {
            if (!v[k] && nums[k][i] >= 3)
                dfs(nums, v, k);
        }


    }

    public static void main(String[] args) {
        /*int[][] nums = {{0, 4, 0}, {4, 0, 0}, {0, 0, 0}};
        int c = component(nums, 3);
        System.out.println(c);*/

        /*int[][] nums1 = {{0, 4, 0}, {4, 0, 6}, {0, 6, 0}};
        int c1 = component(nums1, 3);
        System.out.println(c1);*/

       /* int[][] nums2 = {{0}};
        int c2 = component(nums2, 1);
        System.out.println(c2);*/
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int m = in.nextInt();
            int[][] ns = new int[m][m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    ns[i][j] = in.nextInt();
                }
            }
            int cs = component(ns, m);
            System.out.println(cs);
        }
    }

}
