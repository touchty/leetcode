package test;

// LC 1089. Duplicate Zeros
// 0 扩展成2份， 其他后移
public class DuplicateZeros {
    public static void duplicateZeros(int[] nums) {
        int[] nZeros = new int[nums.length];
        int total = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == 0)
                total++;
            nZeros[i] = total;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nZeros[i] + i >= nums.length) continue;
            nums[i + nZeros[i]] = nums[i];
            if (nums[i] == 0) {
                if (i + nZeros[i] + 1 >= nums.length) continue;
                nums[i + nZeros[i] + 1] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        DuplicateZeros.duplicateZeros(arr);
        for (int i: arr)
            System.out.println(i);
    }
}
