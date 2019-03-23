package array;

import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray {
    int[] origin;
    int[] shuffled;
    Random random = new Random();

    public ShuffleAnArray(int[] nums) {
        origin = nums;
        shuffled = Arrays.copyOf(nums, nums.length);
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return origin;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {

        for (int i = shuffled.length - 1; i >= 1; i--) {
            int prev = random.nextInt(i + 1);
            //swap
            if (prev == i)
                continue;
            int temp = shuffled[prev];
            shuffled[prev] = shuffled[i];
            shuffled[i] = temp;
        }
        return shuffled;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        ShuffleAnArray shuffleAnArray = new ShuffleAnArray(nums);
        int[] shuffled = shuffleAnArray.shuffle();
        for (int i : shuffled)
            System.out.println(i);
    }
}
