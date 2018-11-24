package array;

/**
 * Given two arrays of length m and n with digits 0-9 representing two numbers. Create the maximum number of length k <= m + n from digits of the two. The relative order of the digits from the same array must be preserved. Return an array of the k digits.
 *
 * Note: You should try to optimize your time and space complexity.
 *
 * Example 1:
 *
 * Input:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * Output:
 * [9, 8, 6, 5, 3]
 * Example 2:
 *
 * Input:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * Output:
 * [6, 7, 6, 0, 4]
 */
public class CreateMaximumNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        // Choose i = 0, 1, 2,..., k digit from nums1 and k - i digit
        // from nums2.
        // Then combining the two results will form the number with k
        // digits.
        int[] max = new int[k];
        int[] candidate;

        for (int i = 0; i <= k; i++) {
            if (i > nums1.length || (k - i) > nums2.length)
                continue;

            int[] sub1 = maxNumberInArray(nums1, i);
            int[] sub2 = maxNumberInArray(nums2, k - i);
            candidate = maxCombining(sub1, sub2);
            if (arrayCom(candidate, max) > 0) {
                max = candidate;
            }
        }
        return max;
    }

    int arrayCom(int[] left, int[] right) {
        int LEN = left.length;
        for (int i = 0; i < LEN; i++) {
            if (left[i] > right[i])
                return 1;
            else if (left[i] < right[i])
                return -1;
            else
                continue;
        }
        return 0;
    }
    // k <= nums.length
    int[] maxNumberInArray(int[] nums, int k) {
        int[] res = new int[k];
        int start = 0;
        for (int i = 0; i < k; i++) {
            int pos = findMax(nums, start, nums.length - (k - i));
            res[i] = nums[pos];
            start =  pos + 1;
        }
        return res;
    }

    int findMax(int[] nums, int start, int end) {
        int res = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[res])
                res = i;
        }
        return res;
    }

    // {6, 7} {6, 0, 4} => {6, 6, 7, 0, 4} or {6, 7, 6, 0, 4}
    int[] maxCombining(int[] digits1, int[] digits2) {
        int i = 0;
        int j = 0;
        int[] res = new int[digits1.length + digits2.length];
        int pos = 0;
        // merge
        while(i < digits1.length && j < digits2.length) {
            if (digits1[i] > digits2[j])
                res[pos++] = digits1[i++];
            else if (digits1[i] < digits2[j])
                res[pos++] = digits2[j++];
            else { // figure out which array's next digit is greater!
                boolean assigned = false;
                int p = i+1, q = j+1;
                while( p < digits1.length && q < digits2.length) {
                    if (digits1[p] > digits2[q]) {
                        res[pos++] = digits1[i++];
                        assigned = true;
                        break;
                    }
                    else if (digits1[p] < digits2[q]) {
                        res[pos++] = digits2[j++];
                        assigned = true;
                        break;
                    }
                    else {
                        p++;
                        q++;
                    }
                }
                if (!assigned) {
                    if (p < digits1.length)
                        res[pos++] = digits1[i++]; // or res[pos++] = digits2[j++], no difference
                    else
                        res[pos++] = digits2[j++];
                }

            }
        }

        while(i < digits1.length)
            res[pos++] = digits1[i++];
        while(j < digits2.length)
            res[pos++] = digits2[j++];
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 4, 6, 5};
        int[] nums2 = {9, 1, 2, 5, 8, 3};
        int k = 5;
        CreateMaximumNumber createMaximumNumber =
                new CreateMaximumNumber();
        /*nums1 = new int[]{2,5,6,4,4,0};
        nums2 = new int[]{7,3,8,0,6,5,7,6,2};
        k = 15;
        int[] maxNumber = createMaximumNumber.maxNumber(nums1, nums2, k);*/

        nums1 = new int[]{2,1,7,8,0,1,7,3,5,8,9,0,0,7,0,2,2,7,3,5,5};
        nums2 = new int[]{2,6,2,0,1,0,5,4,5,5,3,3,3,4};;
        k = 35;
        int[] maxNumber = createMaximumNumber.maxNumber(nums1, nums2, k);

/*        nums1 = new int[]{6, 7};
        nums2 = new int[]{6, 0, 4};
        k = 5;
        System.out.println(createMaximumNumber.maxNumber(nums1, nums2, k));*/

        /*int maxCombining = createMaximumNumber.maxCombining(new int[]{6, 7}, new int[]{6, 0, 4});
        System.out.println(maxCombining);*/
    }
}
