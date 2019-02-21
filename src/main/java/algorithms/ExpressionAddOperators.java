package algorithms;

import java.util.*;

/*
Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators
(not unary) +, -, or * between the digits so they evaluate to the target value.
Example 1:

Input: num = "123", target = 6
Output: ["1+2+3", "1*2*3"]
Example 2:

Input: num = "232", target = 8
Output: ["2*3+2", "2+3*2"]
Example 3:

Input: num = "105", target = 5
Output: ["1*0+5","10-5"]
Example 4:

Input: num = "00", target = 0
Output: ["0+0", "0-0", "0*0"]
Example 5:

Input: num = "3456237490", target = 9191
Output: []
 */


/*
Java Standard Backtrace AC Solutoin, short and clear
This problem has a lot of edge cases to be considered:

overflow: we use a long type once it is larger than Integer.MAX_VALUE or minimum, we get over it.
0 sequence: because we can't have numbers with multiple digits started with zero, we have to deal with it too.
a little trick is that we should save the value that is to be multiplied in the next recursion.

 */
public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<String>();
        if (num == null || num.length() == 0) return rst;
        helper(rst, "", num, target, 0, 0, 0);
        return rst;
    }

    public void helper(List<String> rst, String path, String num, int target, int pos, long eval, long multed) {
        if (pos == num.length()) {
            if (target == eval)
                rst.add(path);
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                helper(rst, path + cur, num, target, i + 1, cur, cur);
            } else {
                helper(rst, path + "+" + cur, num, target, i + 1, eval + cur, cur);

                helper(rst, path + "-" + cur, num, target, i + 1, eval - cur, -cur);

                helper(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur);
            }
        }
    }


    class SolutionOpt {
        // check out [227. Basic Calculator II] first before this one
        //   for how to evaluate +-*/ using just the result and the tail variables.
        // this problem needs to evaluate the expression during backtracking.
        // --------------------------------
        // essentially, there are n digits, and n-1 slots to insert operators.
        // all the digits except the first can choose among:
        // 1) insert nothing. 2) insert one of + - *
        // so a 4^n search space.
        // --------------------------------
        // during the backtracking, all the possible numbers starting at the current
        //   position is tried, and one of + - * will be inserted before the number.
        //   e.g., 123 with i = 0, 1, 12, 123 is tried as the current number.
        // note that the insert nothing choice is actually covered in parent level.
        // regarding the evaluation, since the current number and operator is known,
        //   result and tail can be updated before going to the next level.
        //   thus at i == n, the evaluation result can be checked directly with target.
        // since there are several branches at each position,
        //   using char array with index may be better than StringBuilder,
        //   since StringBuilder is stateful, need to use setLength() to reset.
        // --------------------------------
        // !!! tricky cases: empty num; leading 0 of a number; overflow.
        //
        public List<String> addOperators(String num, int target) { // handles empty num.
            List<String> result = new ArrayList<>();
            char[] nums = num.toCharArray();
            int n = nums.length;
            char[] chars = new char[n + n]; // at most n-1 operators to insert.
            // try every possible number starting from 0.
            // since no operator is allowed for this number,
            //   or only a virtual + is allowed,
            // code it separately here.
            long value = 0; // avoid overflow.
            for (int j = 0, i = 0; i < n; ++i) {
                value = value * 10 + nums[i] - '0';
                chars[j++] = nums[i];
                helper(result, nums, n, i + 1, target, chars, j, 0, value); // virtual +.
                if (value == 0) { // if this is a leading 0, cannot follow any digit.
                    break;
                }
            }
            return result;
        }

        // result and tail are for evaluating +-*/ on the fly.

        /**
         *
         * @param results List storing all possible string
         * @param nums initial number sequence
         * @param n length of the nums
         * @param i start point of next number
         * @param target target number
         * @param chars possible res after inserting
         * @param j position of the possible string after inserting
         * @param result existing calculating result
         * @param tail previous number
         */
        void helper(List<String> results, char[] nums, int n, int i, long target,
                    char[] chars, int j, long result, long tail) {
            if (i == n) {
                if (result + tail == target) {
                    results.add(String.valueOf(chars, 0, j));
                }
            } else {
                // after inserting : "result + tail (chars[op]) value"
                long value = 0;
                for (int op = j++, k = i; k < n; ++k) { // save the position for operator.
                    value = value * 10 + nums[k] - '0';
                    chars[j++] = nums[k]; // keep appending.
                    chars[op] = '+';
                    helper(results, nums, n, k + 1, target, chars, j, result + tail, value);
                    chars[op] = '-';
                    helper(results, nums, n, k + 1, target, chars, j, result + tail, -value);
                    chars[op] = '*';
                    helper(results, nums, n, k + 1, target, chars, j, result, tail * value);
                    if (value == 0) { // leading 0
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        String num = "123";
        int target = 6;
        ExpressionAddOperators operators = new ExpressionAddOperators();
        List<String> list = operators.addOperators(num, target);
        System.out.println(list);
    }
}
