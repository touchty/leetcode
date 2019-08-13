package offer;

public class O51InversePairs {
    private long reverse = 0;

    public int InversePairs(int[] nums) {
        mergeSort(nums, new int[nums.length], 0, nums.length - 1);
        return (int) (reverse % 1000000007);
    }

    void mergeSort(int[] nums, int[] aux, int left, int right) {
        if (left >= right)
            return;
        int mid = (left + right) / 2;
        mergeSort(nums, aux, left, mid);
        mergeSort(nums, aux, mid + 1, right);
        merge(nums, aux, left, mid, right);
    }

    void merge(int[] nums, int[] aux, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            aux[i] = nums[i];
        }
        // merge
        int p = left;
        int q = mid + 1;
        int i = left;
        while (p <= mid && q <= right) {
            if (aux[p] > aux[q]) {
                nums[i++] = aux[q++];
                reverse += (mid - p + 1); // 右边的元素比左边的(mid - p + 1)个元素要小

            } else {
                nums[i++] = aux[p++];
            }
        }
        while (p <= mid) {
            nums[i++] = aux[p++];
        }
        while (q <= right)
            nums[i++] = aux[q++];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 0};
        O51InversePairs solution = new O51InversePairs();
        int reverse = solution.InversePairs(nums);
        System.out.println(reverse);
    }
}
