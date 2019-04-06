package algorithms;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/*
753. Cracking the Safe
Hard

236

260

Favorite

Share
There is a box protected by a password. The password is n digits, where each letter can be one of the first k
digits 0, 1, ..., k-1.
You can keep inputting the password, the password will automatically be matched against the last n digits entered.
For example, assuming the password is "345", I can open it when I type "012345", but I enter a total of 6 digits.
Please return any string of minimum length that is guaranteed to open the box after the entire string is inputted.
Example 1:
Input: n = 1, k = 2
Output: "01"
Note: "10" will be accepted too.
Example 2:
Input: n = 2, k = 2
Output: "00110"
Note: "01100", "10011", "11001" will be accepted too.
Note:
n will be in the range [1, 4].
k will be in the range [1, 10].
k^n will be at most 4096.
 */
public class CrackingtheSafe {
    public String crackSafe(int n, int k) {
        // Initialize pwd to n repeated 0's as the start node of DFS.
        String strPwd = String.join("", Collections.nCopies(n, "0"));
        StringBuilder sbPwd = new StringBuilder(strPwd);

        Set<String> visitedComb = new HashSet<>();
        visitedComb.add(strPwd);

        int targetNumVisited = (int) Math.pow(k, n);

        crackSafeAfter(sbPwd, visitedComb, targetNumVisited, n, k);

        return sbPwd.toString();
    }

    private boolean crackSafeAfter(StringBuilder pwd, Set<String> visitedComb, int targetNumVisited, int n, int k) {
        // Base case: all n-length combinations among digits 0..k-1 are visited.
        if (visitedComb.size() == targetNumVisited) {
            return true;
        }

        String lastDigits = pwd.substring(pwd.length() - n + 1); // Last n-1 digits of pwd.
        for (char ch = '0'; ch < '0' + k; ch++) {
            String newComb = lastDigits + ch;
            if (!visitedComb.contains(newComb)) {
                visitedComb.add(newComb);
                pwd.append(ch);
                if (crackSafeAfter(pwd, visitedComb, targetNumVisited, n, k)) {
                    return true;
                }
                visitedComb.remove(newComb);
                pwd.deleteCharAt(pwd.length() - 1);
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        int n = 2;
        int k = 2;
        CrackingtheSafe solution = new CrackingtheSafe();
        String DeBruijnSequence = solution.crackSafe(n, k);
        BufferedWriter writer = new BufferedWriter(new FileWriter("./DeBruijnSequence" + ".txt"));
        writer.write(DeBruijnSequence);
        writer.close();
        System.out.println(DeBruijnSequence);
    }
}
