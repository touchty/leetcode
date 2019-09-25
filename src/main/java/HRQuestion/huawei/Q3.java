package HRQuestion.huawei;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Q3 {
    static final int N = 100001;

    static int[] result(int[] nums) {
        int[] arr = new int[N];
        arr[nums[0]]++;
        int prev = 0;
        int max = Integer.MIN_VALUE;
        int temp = prev;
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            int less = 0;
            for (int j = 1; j < val; j++) {
                less += arr[j];
            }
            int more = 0;
            for (int j = val + 1; j < N; j++) {
                more += arr[j];
            }
            temp = prev + less - more;
            max = Math.max(temp, max);
            prev = temp;
            arr[val]++;
        }

        return new int[]{max, prev};
    }

    static int[] resultOpt(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(nums[0], 1);
        int prev = 0;
        int max = Integer.MIN_VALUE;
        int temp = prev;
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            int less = 0;
            Map<Integer, Integer> lmap = map.headMap(val);
            for (int k : lmap.keySet()) {
                less += lmap.get(k);
            }
            int more = i - less - map.getOrDefault(val, 0);
            temp = prev + less - more;
            max = Math.max(temp, max);
            prev = temp;
            int x = map.getOrDefault(val, 0);
            map.put(val, x + 1);
        }
        return new int[]{max, prev};
    }

    static int getEnd(int[] arr, int ss, int ee) {
        int key = arr[ee];
        int max = 0;
        int min = 0;
        for (int i = ss; i < ee; i++) {
            if (arr[i] > key) max++;
            else if (arr[i] < key) min++;
        }
        return min - max;
    }

    static int[] getMMMM(int[] arr, int count) {
        int total = 0;
        int myMax = 0;
        for (int i = 1; i < count; i++) {
            total += getEnd(arr, 0, i);
            myMax = Math.max(myMax, total);
        }
        return new int[]{myMax, total};
    }

    public static void main(String[] args) {
        /*int[] nums = {1, 3, 2};
        int[] res = resultOpt(nums);
        System.out.println(res[0] + " " + res[1]);*/

        /*Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = scanner.nextInt();
            }
            int[] result = result(nums);
            System.out.println(result[0] + " " + result[1]);
        }*/

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = scanner.nextInt();
            }
            int[] result = getMMMM(nums, n);
            System.out.println(result[0] + " " + result[1]);
        }
    }
}

/*
2
3
1 3 2
3
2 1 3
 */
