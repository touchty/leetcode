package array;

public class CreateMaximumNumber {
        public int maxNumber(int[] nums1, int[] nums2, int k) {
            // Choose i = 0, 1, 2,..., k digit from nums1 and k - i digit
            // from nums2.
            // Then combining the two results will form the number with k
            // digits.
            int max = Integer.MIN_VALUE;
            int candidate = Integer.MIN_VALUE;

            for (int i = 0; i <= k; i++) {
                if (i > nums1.length || (k - i) > nums2.length)
                    continue;

                int[] sub1 = maxNumberInArray(nums1, i);
                int[] sub2 = maxNumberInArray(nums2, k - i);
                candidate = maxCombining(sub1, sub2);
                max = Math.max(max, candidate);
            }
            return max;
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
        int maxCombining(int[] digits1, int[] digits2) {
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
                    for(int p = i+1, q = j+1; p < digits1.length && q < digits2.length; p++, q++) {
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
                        res[pos++] = digits1[i++]; // or res[pos++] = digits2[j++], no difference
                    }

                }
            }

            while(i < digits1.length)
                res[pos++] = digits1[i++];
            while(j < digits2.length)
                res[pos++] = digits2[j++];

            int number = 0;
            int weight = 1;
            for (int k = 0; k < res.length; k++) {
                number += res[res.length - 1 - k] * weight;
                weight *= 10;
            }

            return number;
        }

    public static void main(String[] args) {
        int[] nums1 = {3, 4, 6, 5};
        int[] nums2 = {9, 1, 2, 5, 8, 3};
        int k = 5;
        CreateMaximumNumber createMaximumNumber =
                new CreateMaximumNumber();
        System.out.println(createMaximumNumber.maxNumber(nums1, nums2, k));

        nums1 = new int[]{6, 7};
        nums2 = new int[]{6, 0, 4};
        k = 5;
        System.out.println(createMaximumNumber.maxNumber(nums1, nums2, k));

        /*int maxCombining = createMaximumNumber.maxCombining(new int[]{6, 7}, new int[]{6, 0, 4});
        System.out.println(maxCombining);*/
    }
}
