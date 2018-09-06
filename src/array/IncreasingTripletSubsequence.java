package array;

public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int c1 = Integer.MAX_VALUE;
        int c2 = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= c1)
                c1 = num;
            else if (num <= c2)
                c2 = num;
            else
                return true;
        }

        return false;
    }
}
