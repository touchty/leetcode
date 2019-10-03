package segmentTree;

// 树状数组
public class BIT {
    /**
     * Binary Indexed Trees (BIT or Fenwick tree):
     * https://www.topcoder.com/community/data-science/data-science-
     * tutorials/binary-indexed-trees/
     * <p>
     * Example: given an array a[0]...a[7], we use a array BIT[9] to
     * represent a tree, where index [2] is the parent of [1] and [3], [6]
     * is the parent of [5] and [7], [4] is the parent of [2] and [6], and
     * [8] is the parent of [4]. I.e.,
     * <p>
     * BIT[] as a binary tree:
     * ______________*
     * ______*
     * __*     __*
     * *   *   *   *
     * indices: 0 1 2 3 4 5 6 7 8
     * <p>
     * BIT[i] = ([i] is a left child) ? the partial sum from its left most
     * descendant to itself : the partial sum from its parent (exclusive) to
     * itself. (check the range of "__").
     * <p>
     * Eg. BIT[1]=a[0], BIT[2]=a[1]+BIT[1]=a[1]+a[0], BIT[3]=a[2],
     * BIT[4]=a[3]+BIT[3]+BIT[2]=a[3]+a[2]+a[1]+a[0],
     * BIT[6]=a[5]+BIT[5]=a[5]+a[4],
     * BIT[8]=a[7]+BIT[7]+BIT[6]+BIT[4]=a[7]+a[6]+...+a[0], ...
     * <p>
     * Thus, to update a[1]=BIT[2], we shall update BIT[2], BIT[4], BIT[8],
     * i.e., for current [i], the next update [j] is j=i+(i&-i) //double the
     * last 1-bit from [i].
     * <p>
     * Similarly, to get the partial sum up to a[6]=BIT[7], we shall get the
     * sum of BIT[7], BIT[6], BIT[4], i.e., for current [i], the next
     * summand [j] is j=i-(i&-i) // delete the last 1-bit from [i].
     * <p>
     * To obtain the original value of a[7] (corresponding to index [8] of
     * BIT), we have to subtract BIT[7], BIT[6], BIT[4] from BIT[8], i.e.,
     * starting from [idx-1], for current [i], the next subtrahend [j] is
     * j=i-(i&-i), up to j==idx-(idx&-idx) exclusive. (However, a quicker
     * way but using extra space is to store the original array.)
     */

    /*
    树状数组
当想要查询一个SUM(n)(求a[n]的和），可以依据如下算法即可：
step1:　令sum = 0，转第二步；
step2:　假如n <= 0，算法结束，返回sum值，否则sum = sum + Cn，转第三步；
step3: 令n = n – lowbit(n)，转第二步。
可以看出，这个算法就是将这一个个区间的和全部加起来，为什么是效率是log(n)的呢？以下给出证明：
n = n – lowbit(n)这一步实际上等价于将n的二进制的最后一个1减去。而n的二进制里最多有log(n)个1，所以查询效率是log(n)的。
那么修改呢，修改一个节点，必须修改其所有祖先，最坏情况下为修改第一个元素，最多有log(n)的祖先。
所以修改算法如下（给某个结点i加上x）：
step1: 当i > n时，算法结束，否则转第二步；
step2: Ci = Ci + x， i = i + lowbit(i)转第一步。
i = i +lowbit(i)这个过程实际上也只是一个把末尾1补为0的过程。
对于数组求和来说树状数组简直太快了!
注：
求lowbit(x)的建议公式：
lowbit(x):=x and -x;
或lowbit(x):=x and (x xor (x - 1));
lowbit(x)即为2^k的值。
     */
    int[] nums;
    int[] BIT;
    int n;

    public BIT(int[] nums) {
        this.nums = nums;

        n = nums.length;
        BIT = new int[n + 1];
        for (int i = 0; i < n; i++)
            init(i, nums[i]);
    }

    public void init(int i, int val) {
        i++;
        while (i <= n) {
            BIT[i] += val;
            i += (i & -i);
        }
    }

    void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        init(i, diff);
    }

    public int getSum(int i) {
        int sum = 0;
        i++;
        while (i > 0) {
            sum += BIT[i];
            i -= (i & -i);
        }
        return sum;
    }

    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        NumArray solution = new NumArray(nums);
        int sum_0_2 = solution.sumRange(0, 2);
        System.out.println(sum_0_2);
        solution.update(0, nums[0] + 100);
        sum_0_2 = solution.sumRange(0, 2);
        System.out.println(sum_0_2);
    }
}

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);