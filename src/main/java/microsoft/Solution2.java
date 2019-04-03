package microsoft;

public class Solution2 {
    int points(int input1, int[] input2) {
        StringBuilder builder = new StringBuilder();
        for (int i : input2) {
            builder.append(i);
        }
        String s = builder.toString();
        minShot = Integer.MAX_VALUE;
        remove(s, 0);
        return minShot;
    }

    public int minShot = Integer.MAX_VALUE;
    void remove(String bottles, int currShot) {
        if (bottles.length() == 0) {
            minShot = Math.min(minShot, currShot);
            return;
        }

        int[] lp = longestPalSubstr(bottles);
        if (lp[1] > 1) {
            remove(bottles.substring(0, lp[0]) + bottles.substring(lp[0] +lp[1]), currShot + 1);
        }
        else {
            for (int i = 0; i < bottles.length(); i++) {
                remove(bottles.substring(0, i) + bottles.substring(i+1, bottles.length()), currShot + 1);
            }
        }
    }



    static int[] longestPalSubstr(String str) {
        int maxLength = 1; // The result (length of LPS)

        int start = 0;
        int len = str.length();

        int low, high;

        // One by one consider every character as center
        // point of even and length palindromes
        for (int i = 1; i < len; ++i)
        {
            // Find the longest even length palindrome with
            // center points as i-1 and i.
            low = i - 1;
            high = i;
            while (low >= 0 && high < len
                    && str.charAt(low) == str.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }

            // Find the longest odd length palindrome with
            // center point as i
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < len
                    && str.charAt(low) == str.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }
        }
        return new int[]{start, maxLength};
    }

    static int[] longestPalSubstr(int[] str) {
        int maxLength = 1; // The result (length of LPS)

        int start = 0;
        int len = str.length;

        int low, high;

        // One by one consider every character as center
        // point of even and length palindromes
        for (int i = 1; i < len; ++i)
        {
            // Find the longest even length palindrome with
            // center points as i-1 and i.
            low = i - 1;
            high = i;
            while (low >= 0 && high < len
                    && str[low] == str[high]) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }

            // Find the longest odd length palindrome with
            // center point as i
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < len
                    && str[low] == str[high]) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }
        }
        return new int[]{start, maxLength};
    }

    void removeOpt(int[] bottles, int currShot) {
        if (bottles.length == 0) {
            minShot = Math.min(minShot, currShot);
            return;
        }

        int[] lp = longestPalSubstr(bottles);
        if (lp[1] > 1) {
            if (lp[1] == bottles.length)
                removeOpt(new int[]{}, currShot + 1);
            else{
                int[] newBottles = new int[bottles.length - lp[1]];
                int i = 0;
                for (i = 0; i < lp[0]; i++) {
                    newBottles[i] = bottles[i];
                }
                for (int j = lp[0] + lp[1]; j < bottles.length; j++) {
                    newBottles[i] = bottles[j];
                    i++;
                }
            }
        }
        else {
            for (int i = 0; i < bottles.length; i++) {
                int[] newBottles = new int[bottles.length - 1];
                for (int j = 0; j < i; j++) {
                    newBottles[j] = bottles[j];
                }
                for (int j = i+1; j < bottles.length; j++) {
                    newBottles[j-1] = bottles[j];
                }
                removeOpt(newBottles, currShot + 1);
            }
        }
    }

    int pointsOpt(int input1, int[] input2) {
        minShot = Integer.MAX_VALUE;
        removeOpt(input2, 0);
        return minShot;
    }
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int bottles = 2;
        int[] row = {1, 2};
        StringBuilder builder = new StringBuilder();
        for (int i : row) {
            builder.append(i);
        }
        /*String s = builder.toString();
        solution.points(2, new int[]{1,2});
        int res1 = solution.minShot;
        System.out.println(res1);


        solution.points(5, new int[]{1,2,3,1,5});
        int res2 = solution.minShot;
        System.out.println(res2);*/

        solution.pointsOpt(5, new int[]{1,2,3,1,5});
        int res3 = solution.minShot;
        System.out.println(res3);
    }
}
