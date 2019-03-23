package sort;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {
    public String reorganizeString(String S) {
        // Create map of each char to its count
        Map<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray()) {
            int count = map.getOrDefault(c, 0) + 1;
            // Impossible to form a solution
            if (count > (S.length() + 1) / 2) return "";
            map.put(c, count);
        }
        // Greedy: fetch char of max count as next char in the result.
        // Use PriorityQueue to store pairs of (char, count) and sort by count DESC.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (char c : map.keySet()) {
            pq.add(new int[]{c, map.get(c)});
        }
        // Build the result.
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            if (sb.length() == 0 || first[0] != sb.charAt(sb.length() - 1)) {
                sb.append((char) first[0]);
                if (--first[1] > 0) {
                    pq.add(first);
                }
            } else {
                int[] second = pq.poll();
                sb.append((char) second[0]);
                if (--second[1] > 0) {
                    pq.add(second);
                }
                pq.add(first);
            }
        }
        return sb.toString();
    }

    // 6 ms solution
    /*
    public String reorganizeString(String S) {
        int[] data = new int[26];
        int max = 0;
        int maxi = -1;
        for(char c : S.toCharArray()){
            data[c-'a']++;
            if(data[c-'a']>max){
                max=data[c-'a'];
                maxi=c-'a';
            }
            if(max>(1+S.length())/2) return "";
        }
        char[] res = new char[S.length()];
        int index = 0;
        for(int i=0;i<max;i++){
            res[index] = (char)(maxi+'a');
            index+=2;
        }
        data[maxi]=0;
        for(int i=0;i<26;i++){
            int count = data[i];
            for(int j=0;j<count;j++){
                if(index>=S.length()) index=1;
                res[index]=(char)(i+'a');
                index+=2;
            }
        }
        return new String(res);
    }
    */
}
