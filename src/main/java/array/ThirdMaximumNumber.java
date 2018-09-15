package array;

public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;

        for (int num : nums){
            if (num <= third || num == first || num == second)
                continue;
            if (num > first){
                third = second;
                second = first;
                first = num;
            }
            else if (num > second){
                third = second;
                second = num;
            }
            else {
                third = num;
            }
        }

        // there are more than 3 different numbers
        if (third > Long.MIN_VALUE)
            return (int)third;
        else
            return (int)first;
    }
}
