package dp;

public class NumberofLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, res = 0, max_len = 0;
        int[] len =  new int[n], cnt = new int[n];
        for(int i = 0; i<n; i++){
            len[i] = cnt[i] = 1;
            for(int j = 0; j <i ; j++){
                if(nums[i] > nums[j]){
                    if(len[i] == len[j] + 1)cnt[i] += cnt[j];
                    if(len[i] < len[j] + 1){
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            if(max_len == len[i])res += cnt[i];
            if(max_len < len[i]){
                max_len = len[i];
                res = cnt[i];
            }
        }
        return res;
    }

    public int findNumberOfLISRewrite(int[] nums) {
        int n = nums.length, res= 0, max_len = 0;

        //len[i]: the length of the longest increasing sub sequence ending with nums[i]
        int[] len = new int[n];

        //cnt[i]: the number of the longest increasing sub sequence ending with nums[i]
        int[] cnt= new int[n];

        for (int i = 0; i < n; i++) {
            len[i] = cnt[i] = 1;
            for (int j = 0; j < i ; j++) {
                if (nums[i] > nums[j]){
                    //extend the increasing sub sequence
                    if (len[i] == len[j] + 1){
                        cnt[i] += cnt[j];
                    }

                    if (len[i] < len[j] + 1){
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            if (max_len == len[i]) res += cnt[i];
            else if (max_len < len[i]){
                max_len = len[i];
                res = cnt[i];
            }
        }
        return res;
    }
}