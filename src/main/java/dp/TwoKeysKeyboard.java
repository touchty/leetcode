package dp;

public class TwoKeysKeyboard {
    public int minSteps(int n) {
        int res = 0;
        for(int i=2;i<=n;i++){
            while(n%i == 0){
                res+= i;
                n=n/i;
            }
        }
        return res;
    }

    public int minStepsRewrite(int n){
        int result = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0){
                result += i;
                n /= i;
            }
        }
        return result;

    }
}
