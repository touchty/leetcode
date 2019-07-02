package binarySearch;

// https://www.cnblogs.com/luoxn28/p/5767571.html
public class BinarySearch {
    /**
     * 二分查找，找到该值在数组中的下标，否则为-1
     * 1 首先判断出是返回left，还是返回right
     * 　　因为我们知道最后跳出while (left <= right)循环条件
     * 是right < left，且right = left - 1。最后right和left一定是卡在"边界值"的左右两边，
     * 如果是比较值为key，查找小于等于（或者是小于）key的元素，则边界值就是等于key的所有元素的
     * 最左边那个，其实应该返回left。
     *
     * 　　以数组{1, 2, 3, 3, 4, 5}为例，如果需要查找第一个等于或者小于3的元素下标，我们比较
     *    的key值是3，则最后left和right需要满足以下条件：
     *
     *    1.第一个...返回left
     *     最后一个...返回right
     *    2. 判断大小时判断条件要保证第一条
     */
    static int binarySerach(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == key) {
                return mid;
            } else if (array[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    // 查找第一个相等的元素
    static int findFirstEqual(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] >= key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left < array.length && array[left] == key) {
            return left;
        }

        return -1;
    }

    // 查找最后一个相等的元素
    static int findLastEqual(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] <= key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (right >= 0 && array[right] == key) {
            return right;
        }

        return -1;
    }

    // 查找最后一个等于或者小于key的元素
    static int findLastEqualSmaller(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] > key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    // 查找最后一个小于key的元素
    static int findLastSmaller(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] >= key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    // 查找第一个等于或者大于key的元素
    static int findFirstEqualLarger(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] >= key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 3, 3, 5, 7, 9, 11};
        BinarySearch search = new BinarySearch();
        int indexOf3 = BinarySearch.findFirstEqual(nums, 3);
        System.out.println(indexOf3);
    }
}