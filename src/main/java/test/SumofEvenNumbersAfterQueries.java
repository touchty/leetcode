package test;

// LC 985. Sum of Even Numbers After Queries
// 根据查询情况对偶数的和进行更新

/*
Track sum of all even #s.
There are 4 cases for odd / even property of A[k] and queries[i][0], where k = queries[i][1]:
1). even and odd, lose an even item in A; sum need to deduct A[k];
2). even and even, get a bigger even item in A; sum need to add queries[i][0](same as deduct A[k] first then add both);
3). odd and odd, get a bigger even item in A; sum need to add both;
4). odd and even, no influence on even items in A;

Therefore, we can simplify the above as following procedure:

find sum of all even #s;
for each queries, check the item in A and after-added-up value, if
a) the item in A is even, deduct it from sum; according to 1) & 2).
b) after-added-up we have an even value, then add the new value to sum; according to 2) & 3).
 */
public class SumofEvenNumbersAfterQueries {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sum = 0, i = 0;
        for (int a : A) {
            if (a % 2 == 0) sum += a;
        } // sum of even #s.
        int[] ans = new int[queries.length];
        for (int[] q : queries) {
            if (A[q[1]] % 2 == 0) {
                sum -= A[q[1]]; // 先减掉偶数，后面再判断能否重新加入，减少了讨论
            } // from 1) and 2)
            A[q[1]] += q[0];
            if (A[q[1]] % 2 == 0) {
                sum += A[q[1]];
            } // from 2) and 3)
            ans[i++] = sum;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4};
        int[][] queries = {{1,0},{-3,1},{-4,0},{2,3}};
        SumofEvenNumbersAfterQueries solution = new SumofEvenNumbersAfterQueries();
        int[] oddSums = solution.sumEvenAfterQueries(A, queries);
        for (int sum : oddSums)
            System.out.println(sum);
    }
}
