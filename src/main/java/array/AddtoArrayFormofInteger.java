package array;

import java.util.LinkedList;
import java.util.List;

/*
989. Add to Array-Form of Integer
Easy

74

12

Favorite

Share
For a non-negative integer X, the array-form of X is an array of its digits in left to right order.  For example, if X = 1231, then the array form is [1,2,3,1].

Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.



Example 1:

Input: A = [1,2,0,0], K = 34
Output: [1,2,3,4]
Explanation: 1200 + 34 = 1234

Example 3:

Input: A = [2,1,5], K = 806
Output: [1,0,2,1]
Explanation: 215 + 806 = 1021
 */
public class AddtoArrayFormofInteger {
    public static List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> list = new LinkedList<>();
        int c = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            int sum = A[i] + K % 10 + c;
            K /= 10;
            c = sum / 10;
            sum %= 10;
            list.addFirst(sum);
        }
        while (K > 0) {
            int sum = K % 10 + c;
            K /= 10;
            c = sum / 10;
            sum %= 10;
            list.addFirst(sum);
        }
        if (c > 0)
            list.addFirst(c);
        return list;
    }

    public static void main(String[] args) {
        int[] A = {2, 1, 5};
        int K = 806;
        List<Integer> result = AddtoArrayFormofInteger.addToArrayForm(A, K);
        System.out.println(result);
    }
}
