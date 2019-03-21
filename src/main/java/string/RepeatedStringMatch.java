package string;

/*
686. Repeated String Match
Easy

461

437

Favorite

Share
Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it.
If no such solution, return -1.
For example, with A = "abcd" and B = "cdabcdab".
Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A
repeated two times ("abcdabcd").
 */
public class RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        int[] frequency = new int[26];
        for (char c : A.toCharArray()) {
            frequency[c - 'a'] = 1;
        }
        for (char c : B.toCharArray()) {
            if (frequency[c - 'a'] == 0) return -1;
        }


        int times = ((B.length() + A.length() - 1) / A.length());
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < times; i++) {
            builder.append(A);
        }
        if (builder.toString().contains(B)) return times;
        builder.append(A);
        if (builder.toString().contains(B)) return times + 1;
        return -1;
    }
}

/*
class Solution {
public:
    int repeatedStringMatch(string a, string b) {
    vector<int> prefTable(b.size() + 1); // 1-based to avoid extra checks.
    for (auto sp = 1, pp = 0; sp < b.size(); ) {
      if (b[pp] == b[sp]) prefTable[++sp] = ++pp;
      else if (pp == 0) prefTable[++sp] = pp;
      else pp = prefTable[pp];
    }
    for (auto i = 0, j = 0; i < a.size(); i += max(1, j - prefTable[j]), j = prefTable[j]) {
        while (j < b.size() && a[(i + j) % a.size()] == b[j]) ++j;
        if (j == b.size()) return (i + j) / a.size() + ((i + j) % a.size() != 0 ? 1 : 0);
    }
    return -1;
}
};
 */