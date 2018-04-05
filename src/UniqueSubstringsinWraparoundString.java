public class UniqueSubstringsinWraparoundString {
    public int findSubstringInWraproundString(String p) {
        // count[i] is the maximum unique substring end with ith letter.
        // 0 - 'a', 1 - 'b', ..., 25 - 'z'.
        int[] count = new int[26];

        // store longest contiguous substring ends at current position.
        int maxLengthCur = 0;

        for (int i = 0; i < p.length(); i++) {
            // ab || za
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || (p.charAt(i - 1) - p.charAt(i) == 25))) {
                maxLengthCur++;
            }
            else {
                maxLengthCur = 1;
            }

            int index = p.charAt(i) - 'a';
            count[index] = Math.max(count[index], maxLengthCur);
        }

        // Sum to get result
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += count[i];
        }
        return sum;
    }

    public int findSubstringInWraproundStringRe(String p) {
        // count[i] is the maximum unique substring end with ith letter.
        // 0 - 'a', 1 - 'b', ..., 25 - 'z'.
        int[] count = new int[26];

        int maxLen = 0;

        for (int i = 0; i < p.length(); i++){
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i - 1) - p.charAt(i) == 25))
                maxLen++;
            else
                maxLen = 1;

            int index = p.charAt(i) - 'a';

            // update longest substring ending with p.charAt(i)
            count[index] = Math.max(maxLen, count[index]);
        }

        // sum the total substring num
        int sum = 0;
        for (int i = 0; i < count.length; i++){
            sum += count[i];
        }
        return sum;
    }
}